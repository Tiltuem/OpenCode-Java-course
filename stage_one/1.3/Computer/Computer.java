public class Computer {
    private CPU proc;
    private RAM opera;
    private HDD disk;
    private boolean temp=false;

    public CPU getProc() {
        return proc;
    }
    public RAM getOpera() {
        return opera;
    }
    public HDD getDisk() {
        return disk;
    }
    public void setProc(CPU proc) {
        this.proc = proc;
    }
    public void setOpera(RAM opera) {
        this.opera = opera;
    }
    public void setDisk(HDD disk) {
        this.disk = disk;
    }
    public Computer() {
        this.proc= new CPU();
        this.opera= new RAM();
        this.disk= new HDD();
    }
    public Computer(CPU proc, RAM opera, HDD disk) {
        this.proc = proc;
        this.opera = opera;
        this.disk = disk;
    }
    public boolean power(boolean temp){
        if (temp) {
            this.temp = temp;
            return temp;}
        else {
            this.temp = temp;
            return temp;}
    }
    public int virusCheck () {
        if (power(temp)) {
            int virus = (int)(Math.random()*2);
            return virus;
        }
        else {
            System.out.println("Компьютер должен быть включён.");
            return -1;
        }
    }
    public void getSize() {
        if (temp) System.out.printf("Размер винчестера(ГБ): %d\nОперативной памяти(ГБ): %d\n", disk.getSize(), opera.getSize());
        else System.out.println("Компьютер должен быть включён.");
    }
    public void printVirusCheck() {
        if (virusCheck()==-1) {}
        else if (virusCheck()==0) System.out.println("Вирусов нет");
        else System.out.println("Обнаружены вирусы");
    }
}
