public class TV extends ElectricalAppliance{
    private double diagonal;

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public TV() {
        super();
        this.diagonal = 0;
    }

    public TV(String firm) {
        super(firm);
    }

    public TV(String firm, String model) {
        super(firm, model);
    }

    public TV(String firm, String model, int power) {
        super(firm, model, power);
    }

    public TV(String firm, String model, int power, double diagonal) {
        super(firm, model, power);
        this.diagonal = diagonal;
    }
}
