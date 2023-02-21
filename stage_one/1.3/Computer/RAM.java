public class RAM {
    private String firm;
    private String model;
    private String type;
    private int size;

    public String getFirm() {
        return firm;
    }
    public String getModel() {
        return model;
    }
    public String getType() {
        return type;
    }
    public int getSize () {
        return size;
    }
    public void setFirm (String firm) {
        this.firm=firm;
    }
    public void setModel (String model) {
        this.model=model;
    }
    public void setType (String type) {
        this.type=type;
    }
    public void setSize (int size) {
        this.size=size;
    }
    public RAM() {
        this.firm="None";
        this.model="None";
        this.type="None";
        this.size=0;
    }
    public RAM(String firm) {
        this.firm=firm;
    }
    public RAM(String firm, String model) {
        this.firm=firm;
        this.model=model;
    }
    public RAM(String firm, String model, String type) {
        this.firm=firm;
        this.model=model;
        this.type=type;
    }
    public RAM(String firm, String model, String type, int size) {
        this.firm=firm;
        this.model=model;
        this.type=type;
        this.size=size;
    }
}
