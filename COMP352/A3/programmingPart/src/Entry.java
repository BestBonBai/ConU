import java.util.ArrayList;

public class Entry<C> implements Comparable<Entry>{
    private String key;
    private C value;
    private boolean isFixedKeyLength;

    public Entry(String key, C value) {
        this.key = key;
        this.value = value;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public C getValue() {
        return value;
    }

    public void setValue(C value) {
        this.value = value;
    }

    /**
     * Setup comparable for entry
     * @param o Another entry
     * @return an integer indicates the status of the comparision between 2 entries
     */
    @Override
    public int compareTo(Entry o) {
        return this.getKey().compareTo(o.getKey());

    }

    public Entry<C> clone() {
        return new Entry<C>(this.key, this.value);
    }
}
