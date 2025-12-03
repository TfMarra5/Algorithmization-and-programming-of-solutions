import java.util.*;

public class RemoveDuplicates {

    public static Set<Integer> removeDuplicates(List<Integer> nums) {
        Set<Integer> out = new HashSet<>();
        out.addAll(nums);
        return out;
    }
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 3, 2, 5, 3, 4, 1, 4);
        Set<Integer> cleaned = removeDuplicates(data);
        System.out.println("list: " + data);
        System.out.println("unique: " + cleaned);
    }
}
