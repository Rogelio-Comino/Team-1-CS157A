import java.util.Random;
import java.util.HashSet;
public class ID_generator {
    private static HashSet<Integer> list = new HashSet<Integer>();

    public static int generateID() {
        Random random = new Random();
        int ID = random.nextInt(999999);
        boolean result = checkIDdataBase(ID);
        if (result == false) {
            generateID();
        }
        else {
            list.add(ID);
        }
        return ID;
    }
    public static boolean checkIDdataBase(int id) {
        for (int num : list) {
            if (id == num) {
                return false;
            }
        }
        return true;
    }
}
