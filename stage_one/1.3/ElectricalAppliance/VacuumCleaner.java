public class VacuumCleaner extends ElectricalAppliance{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VacuumCleaner() {
        super();
        this.type = "";
    }

    public VacuumCleaner(String firm) {
        super(firm);
    }

    public VacuumCleaner(String firm, String model) {
        super(firm, model);
    }

    public VacuumCleaner(String firm, String model, int power) {
        super(firm, model, power);
    }

    public VacuumCleaner(String firm, String model, int power, String type) {
        super(firm, model, power);
        this.type = type;
    }
}
