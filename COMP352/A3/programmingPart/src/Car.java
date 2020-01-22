public class Car {
    private int numberOfDoor;
    private String colour;

    public Car() {
        this(4, "Red");
    }

    public Car(int door, String colour) {
        this.numberOfDoor = door;
        this.colour       = colour;
    }

    public int getNumberOfDoor() {
        return numberOfDoor;
    }

    public void setNumberOfDoor(int numberOfDoor) {
        this.numberOfDoor = numberOfDoor;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfDoor=" + numberOfDoor +
                ", colour='" + colour + '\'' +
                '}';
    }
}
