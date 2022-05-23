package dto;

import java.util.Date;

public class CacheItem {
    private String value;
    private int frequency;
    private long availableFrom;

    public CacheItem() {
        availableFrom = new Date().getTime();
    }

    public long getAvailableFrom() {
        return availableFrom;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CacheItem{" +
                "value='" + value + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
