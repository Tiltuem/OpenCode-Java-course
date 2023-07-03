public class ElectricKettle extends ElectricalAppliance {
    private double capacity;

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public ElectricKettle() {
        super();
        this.capacity = 0;
    }

    public ElectricKettle(String firm) {
        super(firm);
    }

    public ElectricKettle(String firm, String model) {
        super(firm, model);
    }

    public ElectricKettle(String firm, String model, int power) {
        super(firm, model, power);
    }

    public ElectricKettle(String firm, String model, int power, double capacity) {
        super(firm, model, power);
        this.capacity = capacity;
    }
}
