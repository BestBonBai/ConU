import java.util.ArrayList;
/**
 * A class uses to keep track of the historical record of every the element was removed from the data structure
 * @author Duc Nguyen
 */

public class historicalRecord {
    private ArrayList<Entry> record;

    public historicalRecord() {
        record = new ArrayList<>(0);
    }

    public void addEntry(Entry entry) {
        record.add(entry);
    }

    /**
     * Get historical record of a license plate.
     * @param key
     * @return
     */
    public ArrayList<Entry> getHistory(String key) {
        ArrayList<Entry> result = new ArrayList<>(0);
        for(Entry each : record) {
            if(each.getKey().equalsIgnoreCase(key)) {
                result.add(each);
            }
        }
        return result;

    }

    public ArrayList<Entry> getRecord() {
        return record;
    }
}
