import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SmartAR_Sequence<C> extends SmartAR<C> implements Standard_Structure<C>{
    private ArrayList<Entry<C>> sequence;
    private int size = 0;
    private historicalRecord record;
    private int duplicateOperation = 0;

    public SmartAR_Sequence() {
        this(0);

    }

    public SmartAR_Sequence(int n) {
        sequence = new ArrayList<>(n);
        record = new historicalRecord();

    }

    public int getDuplicateOperation() {
        return duplicateOperation;
    }

    public void setDuplicateOperation(int duplicateOperation) {
        this.duplicateOperation = duplicateOperation;
    }

    @Override
    public String[] allKeys() {
        String[] result = new String[size()];
        int ctr = 0;
        for(Entry<C> each : sequence) {
            result[ctr] = each.getKey();
            ctr++;
        }
        insertion_Sort(result);
        return result;
    }

    /**
     * An insertion sort tom sort every key inside an array of String
     * Using this sort technique, because the time complexity is not required to be fast.
     * While the memory complexity is low.
     * @param keys An array of String (key) to be sorted
     */
    public void insertion_Sort(String[] keys) {
        int n = keys.length;
        for(int i = 1; i< n; ++i) {
            String current = keys[i];
            int j = i-1;

            while(j >= 0 && current.compareTo(keys[j]) > 0) {
                keys[j+1] = keys[j];
                j--;

            }
            keys[j+1] = current;

        }
    }

    @Override
    public void add(String key, C value) {
        try {
            this.remove(key); //clear the old key
        } catch(Exception e) {
            sequence.add(new Entry<C>(key, value));
            size++;
            return;
        }
        System.out.println("Found duplicate item at key " + key +
                "\nOverwriting the duplicate item.");
        sequence.add(new Entry<C>(key, value));
        size++;
        duplicateOperation++;

    }

    @Override
    public Entry<C> remove(String key) {
        try {
            int index = search(key);
            Entry<C> temp = sequence.get(index);
            record.addEntry(temp);
            sequence.remove(index);
            size--;
            return temp;

        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public C getValue(String key) {
        try {
            int index = search(key);
            return sequence.get(index).getValue();

        } catch (NoSuchElementException e) {
            System.out.println("No such key exists");
        }

        return null;
    }

    @Override
    public String nextKey(String key) {
        try {
            int index = search(key);
            if(sequence.get(index+1) != null) {
                return sequence.get(index+1).getKey();
            } else {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e) {
            System.out.println("No such key exists");
        }
        return null;
    }

    @Override
    public String prevKey(String key) {
        try {
            int index = search(key);
            if(sequence.get(index-1) != null) {
                return sequence.get(index-1).getKey();
            } else {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e) {
            System.out.println("No such key exists");
        }
        return null;
    }

    /**
     * A support function
     * @param key Enter the search query
     * @return The index of the element inside the sequence
     * @throws NoSuchElementException if the element does not exist
     */
    public int search(String key) throws NoSuchElementException {
        for (int i = 0; i<size; ++i) {
            if(sequence.get(i).getKey().equalsIgnoreCase(key)) {
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public ArrayList<Entry> previousCars(String key) {
        return record.getHistory(key);
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }
}
