package Collections;

import java.util.*;

/**
 * SortedSetTreeSetAllConcepts.java
 * A single file covering ALL major concepts of:
 * - SortedSet interface (general contract)
 * - NavigableSet interface (extends SortedSet, adds navigation methods)
 * - TreeSet (the only standard implementation of NavigableSet)
 *
 * 1. What is SortedSet/NavigableSet + TreeSet internal working (Red-Black Tree)
 * 2. Natural ordering (Comparable) vs custom ordering (Comparator)
 * 3. SortedSet core methods: first(), last(), headSet(), tailSet(), subSet()
 * 4. NavigableSet navigation methods: floor/ceiling/higher/lower
 * 5. NavigableSet poll methods: pollFirst()/pollLast()
 * 6. Descending views: descendingSet(), descendingIterator()
 * 7. Duplicate detection uses compareTo()/compare() NOT equals()/hashCode()
 * (IMPORTANT gotcha)
 * 8. Null not allowed (throws NPE)
 * 9. Custom objects - Comparable implementation
 * 10. Custom objects - Comparator (multiple sort strategies)
 * 11. Constructors summary
 * 12. TreeSet vs HashSet vs LinkedHashSet comparison
 * 13. Time complexity summary
 * 14. Real use case: Leaderboard / ranking system
 * 15. Real use case: Range queries (finding numbers in a range)
 * 16. Iteration + fail-fast behavior
 * 17. When to use TreeSet
 */
public class SortedSetTreeSetAllConcepts {

    public static void main(String[] args) {
        internalWorkingDemo();
        orderingDemo();
        sortedSetCoreMethodsDemo();
        navigableSetNavigationDemo();
        navigableSetPollDemo();
        descendingViewsDemo();
        duplicateDetectionGotchaDemo();
        nullNotAllowedDemo();
        customComparableDemo();
        customComparatorDemo();
        constructorsDemo();
        comparisonWithOtherSetsDemo();
        leaderboardDemo();
        rangeQueryDemo();
        iterationFailFastDemo();
    }

    // ---------------------------------------------------------
    // 1. WHAT IS SortedSet/NavigableSet + INTERNAL WORKING
    // ---------------------------------------------------------
    static void internalWorkingDemo() {
        System.out.println("\n=== 1. Internal Working Demo ===");
        // Hierarchy: Set -> SortedSet -> NavigableSet -> TreeSet (implementation)
        //
        // TreeSet is backed internally by a TreeMap (specifically, a Red-Black Tree -
        // a self-balancing binary search tree). Elements are stored as KEYS of that
        // TreeMap, with a dummy PRESENT value, exactly like HashSet is backed by
        // HashMap.
        //
        // Red-Black Tree guarantees O(log n) for insert/delete/search by keeping the
        // tree
        // balanced (height stays ~log n) via rotations and node coloring on every
        // update.

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        treeSet.add(30);

        System.out.println("TreeSet (always sorted, backed by Red-Black Tree): " + treeSet);
        System.out.println("Elements are auto-sorted on insertion - no manual sort() ever needed.");
    }

    // ---------------------------------------------------------
    // 2. NATURAL ORDERING VS CUSTOM ORDERING
    // ---------------------------------------------------------
    static void orderingDemo() {
        System.out.println("\n=== 2. Ordering Demo ===");

        // Natural ordering - uses Comparable.compareTo() (Integer, String, etc. already
        // implement it)
        TreeSet<Integer> natural = new TreeSet<>(List.of(5, 2, 8, 1));
        System.out.println("Natural ordering (ascending): " + natural);

        // Custom ordering via Comparator - passed to constructor
        TreeSet<Integer> descending = new TreeSet<>(Comparator.reverseOrder());
        descending.addAll(List.of(5, 2, 8, 1));
        System.out.println("Custom ordering (descending via Comparator): " + descending);
    }

    // ---------------------------------------------------------
    // 3. SORTEDSET CORE METHODS: first(), last(), headSet(), tailSet(), subSet()
    // ---------------------------------------------------------
    static void sortedSetCoreMethodsDemo() {
        System.out.println("\n=== 3. SortedSet Core Methods Demo ===");
        TreeSet<Integer> set = new TreeSet<>(List.of(10, 20, 30, 40, 50));
        System.out.println("Set: " + set);

        System.out.println("first() -> " + set.first()); // 10 (smallest)
        System.out.println("last()  -> " + set.last()); // 50 (largest)

        // headSet(x) -> all elements STRICTLY LESS than x
        System.out.println("headSet(30) -> " + set.headSet(30)); // [10, 20]

        // tailSet(x) -> all elements >= x (inclusive)
        System.out.println("tailSet(30) -> " + set.tailSet(30)); // [30, 40, 50]

        // subSet(from, to) -> from inclusive, to EXCLUSIVE
        System.out.println("subSet(20, 50) -> " + set.subSet(20, 50)); // [20, 30, 40]

        // NavigableSet overloads allow explicit inclusive/exclusive control (Java 6+)
        System.out.println("headSet(30, true) [inclusive] -> " + set.headSet(30, true)); // [10, 20, 30]
        System.out.println("subSet(20, true, 40, true) [both inclusive] -> "
                + set.subSet(20, true, 40, true)); // [20, 30, 40]
    }

    // ---------------------------------------------------------
    // 4. NAVIGABLESET NAVIGATION METHODS: floor/ceiling/higher/lower
    // ---------------------------------------------------------
    static void navigableSetNavigationDemo() {
        System.out.println("\n=== 4. NavigableSet Navigation Methods Demo ===");
        TreeSet<Integer> set = new TreeSet<>(List.of(10, 20, 30, 40, 50));
        System.out.println("Set: " + set);

        // floor(x) -> largest element <= x
        System.out.println("floor(35)   -> " + set.floor(35)); // 30
        System.out.println("floor(30)   -> " + set.floor(30)); // 30 (inclusive)

        // ceiling(x) -> smallest element >= x
        System.out.println("ceiling(35) -> " + set.ceiling(35)); // 40
        System.out.println("ceiling(30) -> " + set.ceiling(30)); // 30 (inclusive)

        // lower(x) -> largest element STRICTLY < x
        System.out.println("lower(30)   -> " + set.lower(30)); // 20

        // higher(x) -> smallest element STRICTLY > x
        System.out.println("higher(30)  -> " + set.higher(30)); // 40

        System.out.println("Returns null if no such element exists, e.g. lower(10) -> " + set.lower(10));
    }

    // ---------------------------------------------------------
    // 5. NAVIGABLESET POLL METHODS
    // ---------------------------------------------------------
    static void navigableSetPollDemo() {
        System.out.println("\n=== 5. NavigableSet Poll Methods Demo ===");
        TreeSet<Integer> set = new TreeSet<>(List.of(10, 20, 30, 40, 50));
        System.out.println("Set: " + set);

        System.out.println("pollFirst() -> " + set.pollFirst()); // removes & returns 10
        System.out.println("pollLast()  -> " + set.pollLast()); // removes & returns 50
        System.out.println("Set after polls: " + set); // [20, 30, 40]
        System.out.println("Useful for repeatedly consuming min/max, e.g. priority-like processing.");
    }

    // ---------------------------------------------------------
    // 6. DESCENDING VIEWS
    // ---------------------------------------------------------
    static void descendingViewsDemo() {
        System.out.println("\n=== 6. Descending Views Demo ===");
        TreeSet<Integer> set = new TreeSet<>(List.of(10, 20, 30, 40, 50));

        // descendingSet() returns a REVERSE-ORDER VIEW (backed by same data, changes
        // reflect both ways)
        NavigableSet<Integer> descendingSet = set.descendingSet();
        System.out.println("Original set:   " + set);
        System.out.println("descendingSet(): " + descendingSet); // [50, 40, 30, 20, 10]

        System.out.print("descendingIterator(): ");
        Iterator<Integer> it = set.descendingIterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }

    // ---------------------------------------------------------
    // 7. DUPLICATE DETECTION GOTCHA: compareTo()/compare(), NOT equals()/hashCode()
    // ---------------------------------------------------------
    static class Employee {
        String name;
        int id;

        Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }

        // Deliberately NOT overriding equals()/hashCode() to prove the point below
    }

    static void duplicateDetectionGotchaDemo() {
        System.out.println("\n=== 7. Duplicate Detection Gotcha Demo ===");
        // CRITICAL: TreeSet/TreeMap determine "duplicate" and ordering using
        // compareTo()
        // (or the supplied Comparator's compare()) - NEVER equals()/hashCode().
        // If compareTo() returns 0 for two different objects, TreeSet treats them as
        // DUPLICATES and keeps only the FIRST one inserted - even if equals() would say
        // false!

        TreeSet<Employee> employees = new TreeSet<>(Comparator.comparingInt(e -> e.id));
        employees.add(new Employee("Alice", 1));
        employees.add(new Employee("Bob", 1)); // same id=1 -> compare() returns 0 -> treated as duplicate!

        System.out.println("TreeSet sorted/deduped by id only: " + employees);
        System.out.println("Bob was silently REJECTED because compare(Alice, Bob) == 0, even though");
        System.out.println("Alice.equals(Bob) would be false (different objects, different names).");
        System.out.println("Contract requirement: compareTo()/compare() should be CONSISTENT WITH equals()");
        System.out.println("to avoid this kind of surprising behavior.");
    }

    // ---------------------------------------------------------
    // 8. NULL NOT ALLOWED
    // ---------------------------------------------------------
    static void nullNotAllowedDemo() {
        System.out.println("\n=== 8. Null Not Allowed Demo ===");
        TreeSet<Integer> set = new TreeSet<>();
        try {
            set.add(null); // throws NullPointerException - can't compare null to anything
        } catch (NullPointerException e) {
            System.out.println("add(null) -> threw NullPointerException (can't be compared/ordered)");
        }
    }

    // ---------------------------------------------------------
    // 9. CUSTOM OBJECTS - COMPARABLE IMPLEMENTATION
    // ---------------------------------------------------------
    static class Student implements Comparable<Student> {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student other) {
            return this.marks - other.marks; // ascending by marks
        }

        @Override
        public String toString() {
            return name + ":" + marks;
        }
    }

    static void customComparableDemo() {
        System.out.println("\n=== 9. Custom Comparable Demo ===");
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 60));
        students.add(new Student("Charlie", 95));

        System.out.println("Students sorted by marks (Comparable): " + students);
        System.out.println("Top scorer -> " + students.last());
    }

    // ---------------------------------------------------------
    // 10. CUSTOM OBJECTS - COMPARATOR (MULTIPLE SORT STRATEGIES)
    // ---------------------------------------------------------
    static void customComparatorDemo() {
        System.out.println("\n=== 10. Custom Comparator Demo ===");

        // Sort the SAME Student class by name instead, without touching compareTo()
        TreeSet<Student> byName = new TreeSet<>(Comparator.comparing(s -> s.name));
        byName.add(new Student("Charlie", 95));
        byName.add(new Student("Alice", 85));
        byName.add(new Student("Bob", 60));
        System.out.println("Students sorted by name (Comparator): " + byName);

        // Comparator chaining: sort by marks descending, then by name ascending for
        // ties
        TreeSet<Student> chained = new TreeSet<>(
                Comparator.comparingInt((Student s) -> s.marks).reversed()
                        .thenComparing(s -> s.name));
        chained.addAll(List.of(
                new Student("Dave", 70),
                new Student("Eve", 90),
                new Student("Frank", 70)));
        System.out.println("Sorted by marks desc, then name asc: " + chained);
    }

    // ---------------------------------------------------------
    // 11. CONSTRUCTORS SUMMARY
    // ---------------------------------------------------------
    static void constructorsDemo() {
        System.out.println("\n=== 11. Constructors Summary Demo ===");

        TreeSet<Integer> t1 = new TreeSet<>(); // natural ordering
        TreeSet<Integer> t2 = new TreeSet<>(Comparator.reverseOrder()); // custom comparator
        TreeSet<Integer> t3 = new TreeSet<>(List.of(3, 1, 2)); // from a collection
        TreeSet<Integer> t4 = new TreeSet<>(t3); // copy constructor (from SortedSet, retains ordering)

        System.out.println("t1 (natural): " + t1);
        System.out.println("t2 (reverse comparator): " + t2);
        System.out.println("t3 (from collection): " + t3);
        System.out.println("t4 (copy of t3): " + t4);
    }

    // ---------------------------------------------------------
    // 12. TREESET VS HASHSET VS LINKEDHASHSET
    // ---------------------------------------------------------
    static void comparisonWithOtherSetsDemo() {
        System.out.println("\n=== 12. TreeSet vs HashSet vs LinkedHashSet Demo ===");
        List<Integer> input = List.of(50, 10, 40, 20, 30);

        Set<Integer> hashSet = new HashSet<>(input);
        Set<Integer> linkedHashSet = new LinkedHashSet<>(input);
        Set<Integer> treeSet = new TreeSet<>(input);

        System.out.println("HashSet:       " + hashSet + "  (no order guarantee, O(1) ops)");
        System.out.println("LinkedHashSet: " + linkedHashSet + "  (insertion order, O(1) ops)");
        System.out.println("TreeSet:       " + treeSet + "  (sorted order, O(log n) ops)");
    }

    // ---------------------------------------------------------
    // 13. Time Complexity Summary (comment-only reference):
    // add/remove/contains -> O(log n)
    // first/last/pollFirst/pollLast -> O(log n) (O(1) is a common misconception -
    // tree traversal to leftmost/rightmost node)
    // floor/ceiling/higher/lower -> O(log n)
    // headSet/tailSet/subSet -> O(log n) to create the view (view itself is backed,
    // not copied)
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // 14. REAL USE CASE: LEADERBOARD / RANKING SYSTEM
    // ---------------------------------------------------------
    static class Score implements Comparable<Score> {
        String player;
        int points;

        Score(String player, int points) {
            this.player = player;
            this.points = points;
        }

        @Override
        public int compareTo(Score other) {
            // Higher points first (descending); tie-break by name for stability
            if (this.points != other.points)
                return other.points - this.points;
            return this.player.compareTo(other.player);
        }

        @Override
        public String toString() {
            return player + "=" + points;
        }
    }

    static void leaderboardDemo() {
        System.out.println("\n=== 14. Leaderboard / Ranking System Demo ===");
        TreeSet<Score> leaderboard = new TreeSet<>();
        leaderboard.add(new Score("Alice", 1500));
        leaderboard.add(new Score("Bob", 2200));
        leaderboard.add(new Score("Charlie", 1800));

        System.out.println("Leaderboard (highest first, always sorted): " + leaderboard);
        System.out.println("Current champion -> " + leaderboard.first());

        // A new score comes in - just add it, order updates automatically
        leaderboard.add(new Score("Dave", 2500));
        System.out.println("After Dave scores 2500: " + leaderboard);
        System.out.println("New champion -> " + leaderboard.first());
    }

    // ---------------------------------------------------------
    // 15. REAL USE CASE: RANGE QUERIES
    // ---------------------------------------------------------
    static void rangeQueryDemo() {
        System.out.println("\n=== 15. Range Query Demo ===");
        TreeSet<Integer> timestamps = new TreeSet<>(List.of(100, 250, 375, 480, 600, 725, 900));
        System.out.println("All event timestamps: " + timestamps);

        // Find all events between 300 and 700 (inclusive)
        Set<Integer> inRange = timestamps.subSet(300, true, 700, true);
        System.out.println("Events between 300 and 700 (inclusive) -> " + inRange);

        // Find the nearest event at or before 500
        System.out.println("Nearest event at/before 500 -> " + timestamps.floor(500));

        // Find the nearest event strictly after 500
        System.out.println("Nearest event strictly after 500 -> " + timestamps.higher(500));
    }

    // ---------------------------------------------------------
    // 16. ITERATION + FAIL-FAST BEHAVIOR
    // ---------------------------------------------------------
    static void iterationFailFastDemo() {
        System.out.println("\n=== 16. Iteration + Fail-Fast Demo ===");
        TreeSet<Integer> set = new TreeSet<>(List.of(1, 2, 3));

        System.out.print("Iteration (always in sorted order): ");
        for (int val : set)
            System.out.print(val + " ");
        System.out.println();

        try {
            for (int val : set) {
                if (val == 2) {
                    set.add(99); // structural modification during iteration
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Modifying set during iteration -> threw ConcurrentModificationException");
        }
    }

    // ---------------------------------------------------------
    // 17. WHEN TO USE TreeSet (comment-only reference):
    // - Need elements always sorted (natural order or custom Comparator)
    // - Need range queries: headSet/tailSet/subSet
    // - Need "closest match" lookups: floor/ceiling/higher/lower
    // - Need min/max access with removal: first/last/pollFirst/pollLast
    // - Willing to trade O(1) HashSet speed for O(log n) sorted guarantees
    // ---------------------------------------------------------
}