public class SmartAR<E> {

    private int Threhold;
    protected int keyLength;
    protected boolean isFixedKeyLength = false;
    protected int size;
    protected boolean initStructure = false;

    //CONSTRUCTOR
    public SmartAR() {
        this(1000);

    }

    public SmartAR(int threhold) {
        this.Threhold = threhold;
    }

    public SmartAR(int threhold, int keyLength) {
        this.Threhold = threhold;
        this.keyLength = keyLength;
        isFixedKeyLength = true;

    }
    //---------------

    public void setThrehold(int threhold) {
        this.Threhold = threhold;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }

    public boolean isFixedKeyLength() {
        return isFixedKeyLength;
    }

    public void setFixedKeyLength(boolean fixedKeyLength) {
        isFixedKeyLength = fixedKeyLength;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isLarge() {
        return (size >= Threhold);
    }

    public SmartAR<E> setup() {
        initStructure = true;
        if(isLarge()) {
            return new SmartAR_HashTable<E>();
        }
        return new SmartAR_Sequence<E>();
    }

    //A FUNCTION TO RE EVALUATE THE STRUCTURE WITH THE CHANGE IN SIZE
    // OR A CHANGE IN THREHOLD HAPPENS
    public void calibrateStructure() {

    }
}
