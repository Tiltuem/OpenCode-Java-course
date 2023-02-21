public class CPU {
    private String firm;
    private String model;

    public String getFirm() {
        return firm;
    }
    public String getModel() {
        return model;
    }
    public void setFirm(String firm) {
        this.firm = firm;
    }
    public void setModel(String model) {
        this.model=model;
    }
    public CPU() {
        this.firm="None";
        this.model="None";
    }
    public CPU(String firm){
        this.firm=firm;
    }
    public CPU(String firm, String model) {
        this.firm=firm;
        this.model=model;
    }
}
