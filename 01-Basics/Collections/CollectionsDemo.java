// Collections - Helps in storing and Processing of Data Efficiently

package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionsDemo {
    public static void main(String[] args) {

        // ===================================================================
        // 1. CREATING AN ARRAYLIST
        // ===================================================================
        List<Integer> list = new ArrayList<>(); // recommended: code to interface
        ArrayList<String> names = new ArrayList<>(); // direct ArrayList reference
        ArrayList<Integer> withCapacity = new ArrayList<>(20); // initial capacity (not size!)
        List<Integer> fromCollection = new ArrayList<>(list); // copy constructor

        // ===================================================================
        // 2. ADDING ELEMENTS
        // ===================================================================
        list.add(10); // add at end
        list.add(20);
        list.add(30);
        list.add(1, 15); // add at specific index -> [10, 15, 20, 30]

        names.add("Zara");
        names.add("Amit");
        names.add("Neha");
        names.addAll(List.of("John", "Priya")); // add multiple elements at once

        System.out.println("After adding: " + list);
        System.out.println("Names: " + names);

        // ===================================================================
        // 3. ACCESSING ELEMENTS
        // ===================================================================
        int first = list.get(0); // O(1) random access
        int lastIndex = list.size() - 1;
        int last = list.get(lastIndex);
        System.out.println("First: " + first + ", Last: " + last);

        // ===================================================================
        // 4. UPDATING ELEMENTS
        // ===================================================================
        list.set(0, 100); // replaces element at index 0
        System.out.println("After update: " + list);

        // ===================================================================
        // 5. REMOVING ELEMENTS
        // ===================================================================
        list.remove(0); // removes BY INDEX (int overload)
        list.remove(Integer.valueOf(30)); // removes BY VALUE (Object overload) - tricky with int!
        names.remove("Amit"); // removes by value directly (String is Object type)
        System.out.println("After removal: " + list);
        System.out.println("Names after removal: " + names);

        // ===================================================================
        // 6. SEARCHING
        // ===================================================================
        boolean hasValue = list.contains(15);
        int index = list.indexOf(15);
        int lastOccurrence = list.lastIndexOf(15);
        boolean isEmpty = list.isEmpty();
        System.out.println("Contains 15? " + hasValue + " at index " + index);

        // ===================================================================
        // 7. SIZE & CAPACITY
        // ===================================================================
        System.out.println("Size: " + list.size());
        withCapacity.ensureCapacity(50); // hint to grow backing array upfront
        withCapacity.trimToSize(); // shrink backing array to actual size (memory optimization)

        // ===================================================================
        // 8. ITERATING - 4 COMMON WAYS
        // ===================================================================

        // a) Classic for loop (index-based)
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // b) Enhanced for-each loop
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();

        // c) Iterator (safe removal during iteration)
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (val == 100) {
                iterator.remove(); // safe way to remove while iterating
            }
        }
        System.out.println("After iterator removal: " + list);

        // d) ListIterator (bidirectional traversal + in-place modification)
        ListIterator<Integer> listIt = list.listIterator();
        while (listIt.hasNext()) {
            int val = listIt.next();
            listIt.set(val * 2); // modify element during traversal
        }
        System.out.println("Doubled values: " + list);

        // e) forEach with lambda (Java 8+)
        list.forEach(val -> System.out.print(val + " "));
        System.out.println();

        // ===================================================================
        // 9. SORTING
        // ===================================================================
        ArrayList<Integer> unsorted = new ArrayList<>(List.of(5, 3, 8, 1, 9));
        Collections.sort(unsorted); // ascending
        System.out.println("Sorted ascending: " + unsorted);

        Collections.sort(unsorted, Collections.reverseOrder()); // descending
        System.out.println("Sorted descending: " + unsorted);

        unsorted.sort((a, b) -> a - b); // sort using lambda comparator
        System.out.println("Sorted via lambda: " + unsorted);

        // ===================================================================
        // 10. OTHER USEFUL COLLECTIONS UTILITY METHODS
        // ===================================================================
        System.out.println("Max: " + Collections.max(unsorted));
        System.out.println("Min: " + Collections.min(unsorted));
        Collections.reverse(unsorted);
        System.out.println("Reversed: " + unsorted);
        Collections.shuffle(unsorted);
        System.out.println("Shuffled: " + unsorted);
        Collections.fill(unsorted, 0); // replaces every element
        System.out.println("Filled with 0: " + unsorted);

        // ===================================================================
        // 11. CONVERTING ARRAYLIST <-> ARRAY
        // ===================================================================
        Integer[] arrFromList = list.toArray(new Integer[0]);
        List<Integer> listFromArr = new ArrayList<>(List.of(arrFromList));
        System.out.println("Array length: " + arrFromList.length);

        // ===================================================================
        // 12. CLEARING / CHECKING EMPTY
        // ===================================================================
        ArrayList<Integer> temp = new ArrayList<>(List.of(1, 2, 3));
        temp.clear();
        System.out.println("Temp empty after clear? " + temp.isEmpty());

        // ===================================================================
        // 13. 2D ARRAYLIST (ArrayList of ArrayLists)
        // ===================================================================
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(i * 3 + j);
            }
            matrix.add(row);
        }
        System.out.println("2D ArrayList: " + matrix);

        // ===================================================================
        // 14. STORING CUSTOM OBJECTS
        // ===================================================================
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ravi", 22));
        students.add(new Student("Meera", 20));
        students.sort((s1, s2) -> s1.age - s2.age); // sort by age
        System.out.println("Students sorted by age:");
        for (Student s : students) {
            System.out.println("  " + s.name + " - " + s.age);
        }

        // ===================================================================
        // 15. SUBLIST (VIEW, not a copy!)
        // ===================================================================
        List<Integer> range = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        List<Integer> sub = range.subList(1, 4); // [20, 30, 40] -> backed by 'range'
        System.out.println("Sublist: " + sub);

        // ===================================================================
        // 16. removeIf() and replaceAll() - Java 8+
        // ===================================================================
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        nums.removeIf(n -> n % 2 == 0); // removes all even numbers
        System.out.println("After removeIf (evens removed): " + nums);

        List<Integer> nums2 = new ArrayList<>(List.of(1, 2, 3));
        nums2.replaceAll(n -> n * n); // squares every element in place
        System.out.println("After replaceAll (squared): " + nums2);
    }

    // Simple class to demonstrate storing custom objects in ArrayList
    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}