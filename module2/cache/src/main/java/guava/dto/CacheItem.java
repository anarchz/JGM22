package guava.dto;

public class CacheItem {
    private String value;

    public CacheItem() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CacheItem{" +
                "value='" + value +
                '}';
    }
}
