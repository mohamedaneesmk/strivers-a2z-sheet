package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * SetHashSetLinkedHashSetAllConcepts.java
 * A single file covering ALL major concepts of:
 * - Set interface (general contract)
 * - HashSet (unordered, hash-table backed)
 * - LinkedHashSet (insertion-order preserving)
 *
 * 1. Set interface basics - no duplicates, no index access
 * 2. HashSet internal working (backed by HashMap)
 * 3. HashSet - no order guarantee demo
 * 4. LinkedHashSet internal working (backed by LinkedHashMap)
 * 5. LinkedHashSet - insertion order preserved demo
 * 6. HashSet vs LinkedHashSet vs TreeSet ordering comparison
 * 7. Capacity, load factor, resizing (shared HashMap-based mechanism)
 * 8. Null handling
 * 9. Custom objects - equals()/hashCode() contract (CRITICAL)
 * 10. Set algebra: union, intersection, difference, symmetric difference
 * 11. Removing duplicates from a List using Set (classic use case)
 * 12. Iteration + fail-fast behavior
 * 13. Immutable Sets (Set.of())
 * 14. Thread-safe alternatives
 * 15. Converting between Set types
 * 16. Time complexity summary
 * 17. When to use which
 */
public class SetHashSetLinkedHashSetAllConcepts {

    public static void main(String[] args) {
        setBasicsDemo();
        hashSetInternalWorkingDemo();
        hashSetNoOrderDemo();
        linkedHashSetInternalWorkingDemo();
        linkedHashSetOrderDemo();
        orderingComparisonDemo();
        capacityLoadFactorDemo();
        nullHandlingDemo();
        customObjectEqualsHashCodeDemo();
        setAlgebraDemo();
        removeDuplicatesFromListDemo();
        iterationFailFastDemo();
        immutableSetDemo();
        threadSafeAlternativesDemo();
        convertingBetweenTypesDemo();
    }

    // ---------------------------------------------------------
    // 1. SET INTERFACE BASICS
    // ---------------------------------------------------------
    static void setBasicsDemo() {
        System.out.println("\n=== 1. Set Interface Basics Demo ===");
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(10); // duplicate - ignored silently, add() returns false
        boolean added = set.add(10);

        System.out.println("Set: " + set); // [10, 20] - duplicates rejected
        System.out.println("add(10) again returned -> " + added); // false
        System.out.println("Set has no get(index) method - no positional access like List.");
        System.out.println("contains(20) -> " + set.contains(20));
        System.out.println("size() -> " + set.size());
    }

    // ---------------------------------------------------------
    // 2. HASHSET INTERNAL WORKING
    // ---------------------------------------------------------
    static void hashSetInternalWorkingDemo() {
        System.out.println("\n=== 2. HashSet Internal Working Demo ===");
        // HashSet is internally backed by a HashMap.
        // Every element you add becomes a KEY in that HashMap.
        // The VALUE is always a dummy constant object: private static final Object
        // PRESENT = new Object();
        // So: hashSet.add(x) internally does map.put(x, PRESENT);
        // hashSet.contains(x) internally does map.containsKey(x);
        // hashSet.remove(x) internally does map.remove(x);
        //
        // This means HashSet inherits ALL of HashMap's internal mechanics:
        // - bucket array indexed by hashCode()
        // - collision handling via linked list (or red-black tree if a bucket exceeds 8
        // entries)
        // - resizing when load factor threshold is exceeded

        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println("HashSet (elements are really HashMap keys under the hood): " + set);
    }

    // ---------------------------------------------------------
    // 3. HASHSET - NO ORDER GUARANTEE
    // ---------------------------------------------------------
    static void hashSetNoOrderDemo() {
        System.out.println("\n=== 3. HashSet No Order Guarantee Demo ===");
        Set<Integer> set = new HashSet<>();
        for (int i = 10; i >= 1; i--) {
            set.add(i);
        }
        System.out.println("Inserted 10 down to 1, but iteration order -> " + set);
        System.out.println("Order depends on hashCode() and bucket placement, NOT insertion order.");
    }

    // ---------------------------------------------------------
    // 4. LINKEDHASHSET INTERNAL WORKING
    // ---------------------------------------------------------
    static void linkedHashSetInternalWorkingDemo() {
        System.out.println("\n=== 4. LinkedHashSet Internal Working Demo ===");
        // LinkedHashSet extends HashSet, but is backed by a LinkedHashMap instead of a
        // plain HashMap.
        // LinkedHashMap maintains an additional doubly-linked list running through all
        // entries,
        // which records INSERTION order. So iteration order == insertion order, always.
        // Slightly more memory per entry (extra before/after pointers) but predictable
        // iteration.

        Set<String> set = new LinkedHashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println("LinkedHashSet (HashSet + doubly-linked list for order): " + set);
    }

    // ---------------------------------------------------------
    // 5. LINKEDHASHSET - INSERTION ORDER PRESERVED
    // ---------------------------------------------------------
    static void linkedHashSetOrderDemo() {
        System.out.println("\n=== 5. LinkedHashSet Insertion Order Demo ===");
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 10; i >= 1; i--) {
            set.add(i);
        }
        System.out.println("Inserted 10 down to 1, iteration order -> " + set);
        System.out.println("Matches insertion order exactly, unlike HashSet.");

        // Duplicates still don't change position
        set.add(5); // already exists - position stays the same, NOT moved to end
        System.out.println("Re-adding existing element 5 (LinkedHashSet keeps original position): " + set);
    }

    // ---------------------------------------------------------
    // 6. ORDERING COMPARISON: HashSet vs LinkedHashSet vs TreeSet
    // ---------------------------------------------------------
    static void orderingComparisonDemo() {
        System.out.println("\n=== 6. Ordering Comparison Demo ===");
        List<Integer> input = List.of(50, 10, 40, 20, 30);

        Set<Integer> hashSet = new HashSet<>(input);
        Set<Integer> linkedHashSet = new LinkedHashSet<>(input);
        Set<Integer> treeSet = new TreeSet<>(input);

        System.out.println("Input order:      " + input);
        System.out.println("HashSet:           " + hashSet + "  (hash-bucket order, unpredictable)");
        System.out.println("LinkedHashSet:     " + linkedHashSet + "  (insertion order preserved)");
        System.out.println("TreeSet:           " + treeSet + "  (sorted order, red-black tree)");
    }

    // ---------------------------------------------------------
    // 7. CAPACITY, LOAD FACTOR, RESIZING
    // ---------------------------------------------------------
    static void capacityLoadFactorDemo() {
        System.out.println("\n=== 7. Capacity & Load Factor Demo ===");
        // Same rules as HashMap since both HashSet/LinkedHashSet are Map-backed:
        // - default initial capacity = 16 buckets
        // - default load factor = 0.75
        // - resize (double capacity + rehash) triggers when size > capacity *
        // loadFactor
        // - You can hint initial capacity to avoid repeated resizing:
        Set<Integer> preSized = new HashSet<>(100); // capacity hint for ~100 elements
        Set<Integer> customLoadFactor = new HashSet<>(50, 0.9f); // capacity=50, loadFactor=0.9

        System.out.println("Pre-sized HashSet created with capacity hint 100 (reduces rehash operations).");
        System.out.println("Custom load factor HashSet created with capacity 50, loadFactor 0.9.");
        preSized.add(1);
        customLoadFactor.add(1);
        System.out.println("Both usable normally: " + preSized + ", " + customLoadFactor);
    }

    // ---------------------------------------------------------
    // 8. NULL HANDLING
    // ---------------------------------------------------------
    static void nullHandlingDemo() {
        System.out.println("\n=== 8. Null Handling Demo ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add(null); // allowed - exactly ONE null (since it's a Set, duplicates rejected anyway)
        hashSet.add(null); // silently ignored (already present)
        System.out.println("HashSet with null: " + hashSet + " | size -> " + hashSet.size());

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        System.out.println("LinkedHashSet also allows one null: " + linkedHashSet);

        System.out.println("(Note: TreeSet does NOT allow null - it throws NullPointerException on comparison.)");
    }

    // ---------------------------------------------------------
    // 9. CUSTOM OBJECTS - equals()/hashCode() CONTRACT
    // ---------------------------------------------------------
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Point))
                return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // Deliberately broken class WITHOUT overriding equals/hashCode, for comparison
    static class BrokenPoint {
        int x, y;

        BrokenPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        // no equals()/hashCode() override -> uses Object's identity-based versions
    }

    static void customObjectEqualsHashCodeDemo() {
        System.out.println("\n=== 9. Custom Object equals()/hashCode() Demo ===");

        // CORRECT: with proper equals()/hashCode() override
        Set<Point> points = new HashSet<>();
        points.add(new Point(1, 2));
        points.add(new Point(1, 2)); // logically "equal" -> should be rejected as duplicate
        System.out.println("Point set (with equals/hashCode overridden): " + points + " | size -> " + points.size());

        // BROKEN: without override, two "equal-looking" objects are treated as
        // DIFFERENT
        Set<BrokenPoint> brokenPoints = new HashSet<>();
        brokenPoints.add(new BrokenPoint(1, 2));
        brokenPoints.add(new BrokenPoint(1, 2)); // NOT rejected - different object identity
        System.out.println(
                "BrokenPoint set (no equals/hashCode override): " + brokenPoints + " | size -> " + brokenPoints.size());
        System.out
                .println("Lesson: ALWAYS override both equals() AND hashCode() together for custom objects in a Set.");
    }

    // ---------------------------------------------------------
    // 10. SET ALGEBRA: UNION, INTERSECTION, DIFFERENCE, SYMMETRIC DIFFERENCE
    // ---------------------------------------------------------
    static void setAlgebraDemo() {
        System.out.println("\n=== 10. Set Algebra Demo ===");
        Set<Integer> a = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(List.of(4, 5, 6, 7, 8));
        System.out.println("A = " + a + ", B = " + b);

        // Union: A UNION B
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union (A UNION B) -> " + union);

        // Intersection: A INTERSECT B
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection (A INTERSECT B) -> " + intersection);

        // Difference: A - B
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference (A - B) -> " + difference);

        // Symmetric Difference: (A UNION B) - (A INTERSECT B)
        Set<Integer> symmetricDiff = new HashSet<>(union);
        symmetricDiff.removeAll(intersection);
        System.out.println("Symmetric Difference -> " + symmetricDiff);

        // Subset check
        Set<Integer> subset = new HashSet<>(List.of(1, 2));
        System.out.println("Is {1,2} a subset of A? -> " + a.containsAll(subset));
    }

    // ---------------------------------------------------------
    // 11. REMOVING DUPLICATES FROM A LIST (CLASSIC USE CASE)
    // ---------------------------------------------------------
    static void removeDuplicatesFromListDemo() {
        System.out.println("\n=== 11. Remove Duplicates from List Demo ===");
        List<Integer> listWithDuplicates = List.of(1, 3, 2, 3, 1, 5, 4, 2);

        // Using HashSet - fast but loses order
        List<Integer> uniqueUnordered = new ArrayList<>(new HashSet<>(listWithDuplicates));
        System.out.println("Original list: " + listWithDuplicates);
        System.out.println("Unique via HashSet (order lost): " + uniqueUnordered);

        // Using LinkedHashSet - removes duplicates AND preserves first-seen order
        List<Integer> uniqueOrdered = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));
        System.out.println("Unique via LinkedHashSet (order preserved): " + uniqueOrdered);
    }

    // ---------------------------------------------------------
    // 12. ITERATION + FAIL-FAST BEHAVIOR
    // ---------------------------------------------------------
    static void iterationFailFastDemo() {
        System.out.println("\n=== 12. Iteration + Fail-Fast Demo ===");
        Set<Integer> set = new HashSet<>(List.of(1, 2, 3));

        System.out.print("Normal iteration: ");
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

        // Safe removal during iteration - use Iterator.remove()
        Set<Integer> set2 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> it = set2.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove(); // safe - does not throw
            }
        }
        System.out.println("After safe removal of evens via Iterator.remove(): " + set2);
    }

    // ---------------------------------------------------------
    // 13. IMMUTABLE SETS
    // ---------------------------------------------------------
    static void immutableSetDemo() {
        System.out.println("\n=== 13. Immutable Set Demo ===");
        Set<Integer> immutable = Set.of(1, 2, 3); // Java 9+ factory method
        System.out.println("Immutable set: " + immutable);
        try {
            immutable.add(4);
        } catch (UnsupportedOperationException e) {
            System.out.println("Adding to Set.of() -> threw UnsupportedOperationException");
        }

        // Collections.unmodifiableSet -> a VIEW (backing set can still change
        // underneath)
        Set<Integer> backing = new HashSet<>(List.of(1, 2, 3));
        Set<Integer> unmodifiableView = Collections.unmodifiableSet(backing);
        backing.add(4); // this IS reflected in the view
        System.out.println("Unmodifiable view after modifying backing set: " + unmodifiableView);
    }

    // ---------------------------------------------------------
    // 14. THREAD-SAFE ALTERNATIVES
    // ---------------------------------------------------------
    static void threadSafeAlternativesDemo() {
        System.out.println("\n=== 14. Thread-Safe Alternatives Demo ===");

        Set<Integer> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        synchronizedSet.add(1);
        System.out.println("Collections.synchronizedSet(HashSet) -> " + synchronizedSet
                + " (must manually synchronize when iterating!)");

        Set<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();
        copyOnWriteSet.add(1);
        copyOnWriteSet.add(2);
        System.out.println("CopyOnWriteArraySet -> " + copyOnWriteSet
                + " (best for read-heavy, rarely-modified concurrent sets)");
    }

    // ---------------------------------------------------------
    // 15. CONVERTING BETWEEN SET TYPES
    // ---------------------------------------------------------
    static void convertingBetweenTypesDemo() {
        System.out.println("\n=== 15. Converting Between Set Types Demo ===");
        Set<Integer> hashSet = new HashSet<>(List.of(3, 1, 2));

        Set<Integer> toLinkedHashSet = new LinkedHashSet<>(hashSet);
        Set<Integer> toTreeSet = new TreeSet<>(hashSet); // sorts automatically

        System.out.println("Original HashSet: " + hashSet);
        System.out.println("Converted to LinkedHashSet: " + toLinkedHashSet);
        System.out.println("Converted to TreeSet (sorted): " + toTreeSet);
    }

    // ---------------------------------------------------------
    // 16. Time Complexity Summary (comment-only reference):
    // HashSet LinkedHashSet
    // add/remove/contains O(1) avg O(1) avg (slightly more constant overhead)
    // iteration O(capacity) O(size) <- LinkedHashSet iterates faster
    // since it doesn't scan empty buckets
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // 17. WHEN TO USE WHICH (comment-only reference):
    // HashSet -> fastest general-purpose Set, order doesn't matter
    // LinkedHashSet -> need uniqueness + predictable insertion-order iteration
    // TreeSet -> need elements sorted automatically (natural order or Comparator)
    // ---------------------------------------------------------
}