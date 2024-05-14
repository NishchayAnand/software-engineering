import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Without Generics, arrayList can contain hetergenous elements
        List list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add(1);

        System.out.println(list);

        String firstElement = (String) list.get(0); // type-casting is required. Otherwise, it will throw "Object
                                                    // cannote be converted to String" error.
        System.out.println(firstElement);

        // With Generics
        List<String> list2 = new ArrayList<String>();
        list2.add("Apple");
        list2.add("banana");
        // list2.add(1); // will throw "int cannot be converted to String" error.

        System.out.println(list2);

        String firstElement2 = list2.get(0);
        System.out.println(firstElement2);

    }

}
