public class SmartAR<E> {

    protected int Threhold;
    protected int keyLength;
    protected boolean isFixedKeyLength = false;
    protected int size;

    //CONSTRUCTOR
    public SmartAR() {
        this(50000);

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

    public int getThrehold() {
        return Threhold;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(int keyLength) {
        isFixedKeyLength = true;
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

}
