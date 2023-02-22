public class Microwave extends ElectricalAppliance {
    private double intervalCapacity;

    public double getIntervalCapacity() {
        return intervalCapacity;
    }

    public void setIntervalCapacity(double intervalCapacity) {
        this.intervalCapacity = intervalCapacity;
    }

    public Microwave() {
        super();
        this.intervalCapacity = 0;
    }

    public Microwave(String firm) {
        super(firm);
    }

    public Microwave(String firm, String model) {
        super(firm, model);
    }

    public Microwave(String firm, String model, int power) {
        super(firm, model, power);
    }

    public Microwave(String firm, String model, int power, double intervalCapacity) {
        super(firm, model, power);
        this.intervalCapacity = intervalCapacity;
    }
}