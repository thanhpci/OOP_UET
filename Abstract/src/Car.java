import javax.xml.namespace.QName;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, String registrationNumber,
               Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
    Method.
    */

    public String getInfo() {
        String result = "";
        result += "Car:" + "\n";
        result += "\tBrand: " + getBrand() + "\n";
        result += "\tModel: " + getModel() + "\n";
        result += "\tRegistration Number: " + getRegistrationNumber() + "\n";
        result += "\tNumber of Doors: " + numberOfDoors + "\n";
        result += "\tBelongs to " + getOwner().getName() + " - " + getOwner().getAddress() + "\n";

        return result;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }


}
