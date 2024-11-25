import java.util.Comparator;

public class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int lengthDifference = Integer.compare(s1.length(), s2.length());
        if (lengthDifference == 0) {
            return s1.compareTo(s2);
        }
        return lengthDifference;
    }

    public static void main(String[] args) {
        String s1 = "Nishchay";
        String s2 = "Vridhi";

        System.out.println(s1.compareTo(s2));

        CustomComparator comparator = new CustomComparator();
        System.out.println(comparator.compare(s1, s2));
    }
}