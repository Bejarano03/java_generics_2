// SortUtility.java
import java.util.ArrayList;
import java.util.Collections;

public class SortUtility {
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        Collections.sort(list);
    }
}