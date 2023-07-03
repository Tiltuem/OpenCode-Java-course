import java.util.ArrayList;
import java.util.List;

public class TaskSix {
    public static void main(String[] args) {
        String str = " Hello World! ";
        
        char[] arr = str.toCharArray();
        List list = new ArrayList();
        
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                    list.remove(j);
                }
            }
            if (count > 1) System.out.println(list.get(i) + " " + count);
            count = 1;
        }
    }
}
