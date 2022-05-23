package service;

import dto.CacheItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class CacheService {
    private Logger logger = Logger.getLogger(CacheService.class.getName());
    private static int capacity;
    private static Map<Integer, CacheItem> cacheMap;
    private static ArrayList<Long> insertTime;
    public CleanerThread cleanerThread;

    private int cacheEvictions;
    private int expirationTime = 500;

    public CacheService(int capacity) {
        this.capacity = capacity;
        this.cacheMap =  new ConcurrentHashMap<>(capacity);
        this.cacheEvictions = 0;
        insertTime = new ArrayList<>();
        cleanerThread = new CleanerThread();
        cleanerThread.start();
    }

    public void removeEntry() {
        int entryKeyToBeRemoved = getLFUKey();
        cacheMap.remove(entryKeyToBeRemoved);
        cacheEvictions++;
        logger.info("entry removed:" + entryKeyToBeRemoved);
    }

    public void put(int key, String entry){
        long startInsert = new Date().getTime();
        if(isFull()) {
            removeEntry();
        }
        CacheItem temp;

        if(cacheMap.containsKey(key)){
            temp = cacheMap.get(key);
            temp.setValue(entry);
            temp.setFrequency(temp.getFrequency()+1);
        } else {
            temp = new CacheItem();
            temp.setValue(entry);
            temp.setFrequency(0);
            insertTime.add(startInsert - temp.getAvailableFrom());
        }
        logger.info("entry added:" + temp);
        cacheMap.put(key, temp);
    }

    public String get(int key) {
        if(cacheMap.containsKey(key)) {
            CacheItem temp = cacheMap.get(key);
            temp.setFrequency(temp.getFrequency()+1);
            cacheMap.put(key, temp);
            return temp.getValue();
        }
        return null;
    }

    public int getLFUKey(){
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CacheItem> entry : cacheMap.entrySet()) {
            if(minFreq > entry.getValue().getFrequency()) {
                key = entry.getKey();
                minFreq = entry.getValue().getFrequency();
            }
        }
        return key;
    }

    public static boolean isFull() {
        if(cacheMap.size() == capacity)
            return true;
        return false;
    }

    public void getStatistic() {
        int avarageTime = (int) insertTime.stream().mapToLong(l -> l).average().orElse(0l);
        System.out.println("Average time spent for putting new values into the cache: " + avarageTime);
        System.out.println("Number of cache evictions: " + cacheEvictions);
    }

    public Map<Integer, CacheItem> getCache() {
        return cacheMap;
    }

    class CleanerThread extends Thread {
        @Override
        public void run() {
            logger.info("Initialize cleaner cache");
            while (true) {
                cleanMap();
                try {
                    Thread.sleep(expirationTime / 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void cleanMap() {
            long currentTime = new Date().getTime();
            for (int key : cacheMap.keySet()) {
                if (currentTime > (cacheMap.get(key).getAvailableFrom() + expirationTime)) {
                    cacheMap.remove(key);
                    cacheEvictions++;
                    logger.info("Removing : " + key);
                }
            }
        }
    }
}
