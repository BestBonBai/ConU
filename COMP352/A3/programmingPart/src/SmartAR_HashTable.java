import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class SmartAR_HashTable<C> extends SmartAR<C> implements Standard_Structure<C>{
    private Hashtable<String, Entry<C>> table;
    private historicalRecord record;
    private int collision = 0;

    public SmartAR_HashTable() {
        this(1000);

    }

    public SmartAR_HashTable(int n) {
        super();
        table = new Hashtable<>(n);
        record = new historicalRecord();
    }

    public void setCollision(int collision) {
        this.collision = collision;
    }

    public int getCollision() {
        return collision;
    }

    public historicalRecord getRecord() {
        return record;
    }

    public void setRecord(historicalRecord record) {
        this.record = record;
    }

    @Override
    public String[] allKeys() {
        //Extract keys out from the table
        Set<String> keys = table.keySet();
        String[] arr = keys.toArray(new String[keys.size()]);
        sort(arr, 0, arr.length-1); //Call Merge sort

        return arr;

    }

    // MERGE SORT
    /**
     * Merge sort for huge data set
     * @param arr The array of key to be sorted
     * @param l Start of the first subarray
     * @param m End of the first subarray
     * @param r End of second sub array
     */
    public void merge(String[] arr, int l, int m, int r) {
        //Size of 2 sub array
        int s1 = m - l + 1;
        int s2 = r -m ;

        //Setup 2 sub arrays
        String[] L = new String[s1];
        String[] R = new String[s2];

        System.arraycopy(arr, l, L, 0, s1);
        System.arraycopy(arr, m+1, R, 0, s2);

        /**
         * i: index of 1st subarray
         * j: index of 2nd subarray
         * k: index of the merged subarray
         */
        int i = 0, j = 0, k = 0;

        while(i< s1 && j< s2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;

        }

        //COPY THE REMAINING ELEMENTS IN SUBARRAY TO THE ARRAY
        while (i < s1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < s2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public void sort(String[] arr, int l, int r) {
        if(l < r) {
            //Mid point to divide
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            //Conquer
            merge(arr, l, m , r);
        }
    }
    /////////////////////////////////////

    @Override
    public void add(String key, C value) {
        if(isFixedKeyLength && key.length() != keyLength) {
            System.out.println("Error: Length is not sufficient");
            return;
        }

        Entry<C> entry = new Entry<>(key, value);
        if(table.containsKey(key)) {
            record.addEntry(table.get(key));
            System.out.println("Found duplicate item at key " + key +
                    "\nOverwriting.\n");
            collision++;
            table.replace(key, entry);
            return;
        }
        table.put(key, entry);
        size++;

    }

    @Override
    public Entry<C> remove(String key) {
        try {
            Entry<C> temp = table.remove(key);
            size--;
            record.addEntry(temp.clone());
            return temp;
        } catch (NullPointerException e) {
            System.out.println("Key " + key + " does not exist");
        }
        return null;

    }

    @Override
    public C getValue(String key) {
        try {
            return table.get(key).getValue();
        } catch (NullPointerException e)  {
            System.out.println("Key " + key + " does not exist");
        }
        return null;
    }

    @Override
    public String nextKey(String key) {
        Set<String> keySet = table.keySet();
        String[] allKeys = keySet.toArray(new String[keySet.size()]);

        for(int i = 0; i<allKeys.length; ++i) {
            if(allKeys[i].equalsIgnoreCase(key)) {
                if(i < allKeys.length - 1) {
                    return allKeys[i+1];
                } else {
                    System.out.println("Next key of " + key + " does not exist.");
                    return null;
                }

            }
        }

        System.out.println("Next key of " + key + " does not exist.");
        return null;

    }

    @Override
    public String prevKey(String key) {
        //CONVERT KEY SET INTO ARRAY
        Set<String> keys = table.keySet();
        String[] allKeys = keys.toArray(new String[keys.size()]);

        for(int i = 0; i<allKeys.length; ++i) {
            if(allKeys[i].equalsIgnoreCase(key)) {
                if(i>=1) {
                    return allKeys[i-1];
                } else {
                    System.out.println("Prev key of " + key + " does not exist.");
                    return null;
                }

            }

        }

        System.out.println("Prev key of " + key + " does not exist.");
        return null;

    }

    @Override
    public ArrayList<Entry> previousCars(String key) {
        ArrayList<Entry> result = record.getHistory(key);
        if(result.size() == 0) {
            System.out.println("Key " + key + " does not exist in historical record.");
        }
        return result;
    }

    /**
     * A function to restructure and transfer all elements to a new sequence
     * @return a new sequence containing every element in the current hashtable
     */
    public SmartAR_Sequence<C> restructure() {
        SmartAR_Sequence<C> sequence = new SmartAR_Sequence<>(this.getSize());
        System.out.println("Restructuring data to SEQUENCE");

        table.forEach((k, v) -> {
            sequence.add(k, v.getValue());

        });
        sequence.setRecord(this.record);
        sequence.setCollision(this.getCollision());
        sequence.setThrehold(this.getThrehold());
        return sequence;
    }
}
