public class TaskSeven {
    public static void main(String[] args) {
        for (int i = 100; i>0; i--) {
            if (i%10==1) System.out.println(i + " бутылка стояла на столе, одна из них упала и разбилась.");
            else if (i%10>4||(i>9&&i<20)||i%10==0) System.out.println(i + " бутылок стояло на столе, одна из них упала и разбилась.");
            else System.out.println(i + " бутылки стояли на столе, одна из них упала и разбилась.");
        }
    }
}
