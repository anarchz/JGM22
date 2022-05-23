package simpleJava.service;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CacheService cacheService = new CacheService(5);
        cacheService.put(1, "entry1");
        cacheService.put(2, "entry2");
        cacheService.put(3, "entry3");
        cacheService.put(4, "entry4");
        cacheService.put(5, "entry5");
        cacheService.put(6, "entry6");
        cacheService.put(6, "entry6");
        cacheService.put(6, "entry6");
        cacheService.put(6, "entry6");
        cacheService.put(6, "entry6");

        System.out.println(cacheService.getCache());

        cacheService.getStatistic();
    }
}
