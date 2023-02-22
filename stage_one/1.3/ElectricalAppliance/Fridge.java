public class Fridge extends ElectricalAppliance{
    private double overalCapacity;

    public double getOveralCapacity() {
        return overalCapacity;
    }

    public void setOveralCapacity(double overalCapacity) {
        this.overalCapacity = overalCapacity;
    }

    public Fridge() {
        super();
        this.overalCapacity = 0;
    }

    public Fridge(String firm) {
        super(firm);
    }

    public Fridge(String firm, String model) {
        super(firm, model);
    }

    public Fridge(String firm, String model, int power) {
        super(firm, model, power);
    }

    public Fridge(String firm, String model, int power, double overalCapacity) {
        super(firm, model, power);
        this.overalCapacity = overalCapacity;
    }
}
