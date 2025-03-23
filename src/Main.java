// Main.java
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.EmptyStackException;

public class Main {

    // Wildcard Usage in Methods
    public static void printCollection(Collection<?> collection) {
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    public static double sumOfNumberList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        // Part 1: Implementing Complex Data Structures

        // Multi-Type Generic Pair
        Pair<String, Integer> pair1 = new Pair<>("One", 1);
        System.out.println(pair1); // Output: Pair{key=One, value=1}

        Pair<Integer, String> pair2 = new Pair<>(2, "Two");
        System.out.println(pair2); // Output: Pair{key=2, value=Two}

        // Generic Stack
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        System.out.println(intStack.pop()); // Output: 3
        System.out.println(intStack.pop()); // Output: 2
        System.out.println(intStack.pop()); // Output: 1
        try {
            intStack.pop(); // This will throw an EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException: " + e.getMessage()); // Output: Caught EmptyStackException
        }

        // Part 2: Using Generics in Collections

        // Generic Sort Utility
        ArrayList<Integer> intList = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6));
        SortUtility.sort(intList);
        System.out.println(intList); // Output: [1, 1, 2, 3, 4, 5, 6, 9]

        ArrayList<String> stringList = new ArrayList<>(List.of("banana", "apple", "orange"));
        SortUtility.sort(stringList);
        System.out.println(stringList); // Output: [apple, banana, orange]

        ArrayList<Person> personList = new ArrayList<>(List.of(
                new Person("Charlie", 30),
                new Person("Alice", 25),
                new Person("Bob", 35)
        ));
        SortUtility.sort(personList);
        System.out.println(personList); // Output: [Person{name='Alice', age=25}, Person{name='Bob', age=35}, Person{name='Charlie', age=30}]

        // Wildcard Usage in Methods
        printCollection(intList); // Output: 1, 1, 2, 3, 4, 5, 6, 9
        printCollection(stringList); // Output: apple, banana, orange

        List<Number> numberList = new ArrayList<>(List.of(1, 2.5, 3, 4.7));
        System.out.println("Sum of numbers: " + sumOfNumberList(numberList)); // Output: Sum of numbers: 11.2

        // Part 3: Complex Generic Scenarios

        // Generic Cache Implementation
        Cache<String> stringCache = new Cache<>();
        stringCache.addItem("key1", "value1");
        stringCache.addItem("key2", "value2");
        System.out.println(stringCache.getItem("key1")); // Output: value1

        Cache<Integer> intCache = new Cache<>();
        intCache.addItem("key3", 10);
        intCache.addItem("key4", 20);

        stringCache.addAll(intCache); // This is allowed because Integer is a subtype of Object
        System.out.println(stringCache.getItem("key3")); // Output: 10

        stringCache.clear();
        System.out.println(stringCache.getItem("key1")); // Output: null
    }
}