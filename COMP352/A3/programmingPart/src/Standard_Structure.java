/**
 * An interface of all required methods in smart AR data structure
 */
import java.util.ArrayList;

public interface Standard_Structure<C> {
    /**
     * @return a sorted sequence of all keys in data structure
     */
    String[] allKeys();

    /**
     * Add new entry into the current data structure
     * @param key: The license plate of a car
     * @param value: The value could be varied. But must in the same type with every node in the data structure
     */
    void add(String key, C value);

    /**
     * Remove the entry which holding the requested key.
     * Additionally, the method update the historical record with the newly removed entry.
     * @param key: the key to the requested to remove entry
     * @return the removed entry
     */
    Entry<C> remove(String key);

    /**
     * @param key: the requested key
     * @return the value object of the entry
     */
    C getValue(String key);

    /**
     * @param key: the requested key
     * @return the key of next member inside the data structure
     */
    String nextKey(String key);

    /**
     * @param key: requested key
     * @return the key of previous member inside the data structure
     */
    String prevKey(String key);

    /**
     * Every removed entries will be put into a sequence
     * @param key: the requested key
     * @return a sequence of the historical record of the license in the system
     */
    ArrayList<Entry> previousCars(String key);


}
