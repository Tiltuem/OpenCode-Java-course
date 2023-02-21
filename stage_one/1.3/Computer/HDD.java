public class HDD {
    private String firm;
    private String model;
    private double inch;
    private int size;

    public String getFirm() {
        return firm;
    }
    public String getModel() {
        return model;
    }
    public double getInch() {
        return inch;
    }
    public int getSize() {
        return size;
    }
    public void setFirm(String firm) {
        this.firm=firm;
    }
    public void setModel(String model) {
        this.model=model;
    }
    public void setInch(double inch) {
        this.inch=inch;
    }
    public void setSize(int size) {
        this.size=size;
    }
    public HDD() {
        this.firm="None";
        this.model="None";
        this.inch=0.0;
        this.size=0;
    }
    public HDD(String firm) {
        this.firm=firm;
    }
    public HDD(String firm, String model) {
        this.firm=firm;
        this.model=model;
    }
    public HDD(String firm, String model, double inch, int size) {
        this.firm=firm;
        this.model=model;
        this.inch=inch;
        this.size=size;
    }
}
