public class ElectricalAppliance {
    private String firm;
    private String model;
    private int power;
    private int onOrOff;

    public int getOnOrOff() {
        return onOrOff;
    }

    public String getFirm() {
        return firm;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setOnOrOff(int onOrOff) {
        this.onOrOff = onOrOff;
    }

    public ElectricalAppliance() {
        this.firm = "";
        this.model = "";
        this.power = 0;
    }

    public ElectricalAppliance(String firm) {
        this.firm = firm;
    }

    public ElectricalAppliance(String firm, String model) {
        this.firm = firm;
        this.model = model;
    }

    public ElectricalAppliance(String firm, String model, int power) {
        this.firm = firm;
        this.model = model;
        this.power = power;
    }

    public void powerSupply(int temp) {
        if (temp == 1) {
            this.onOrOff = temp;
            System.out.println("Прибор включен");
        } else {
            this.onOrOff = temp;
            System.out.println("Прибор выключен");
        }
    }
}
