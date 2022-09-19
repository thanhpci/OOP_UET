public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model,
                     String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     Method.
     */

    public String getInfo() {
        String result = "";
        result += "Motor Bike:" + "\n";
        result += "\tBrand: " + getBrand() + "\n";
        result += "\tModel: " + getModel() + "\n";
        result += "\tRegistration Number: " + getRegistrationNumber() + "\n";
        result += "\tHas Side Car: " + hasSidecar + "\n";
        result += "\tBelongs to " + getOwner().getName() + " - " + getOwner().getAddress() + "\n";

        return result;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

}
