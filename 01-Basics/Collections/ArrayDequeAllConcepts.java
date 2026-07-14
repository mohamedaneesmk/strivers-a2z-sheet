package collections;

import java.util.*;

/**
 * ArrayDequeAllConcepts.java
 * A single file covering ALL major ArrayDeque-SPECIFIC concepts in Java
 * (concepts shared with Deque interface in general are kept brief here -
 * see DequeAllConcepts.java for the interface-level deep dive).
 *
 * 1. What is ArrayDeque + internal working (circular/resizable array)
 * 2. Capacity growth mechanism (doubling)
 * 3. Constructors summary
 * 4. Core operations recap (insert/remove/examine - both ends)
 * 5. ArrayDeque as Stack (faster than java.util.Stack)
 * 6. ArrayDeque as Queue (faster than LinkedList)
 * 7. No capacity restriction (unbounded, unlike ArrayBlockingQueue)
 * 8. Null not allowed (why - ambiguity with poll()/peek() returning null)
 * 9. Not thread-safe (no synchronization)
 * 10. removeFirstOccurrence / removeLastOccurrence / contains
 * 11. Performance comparison: ArrayDeque vs LinkedList vs Stack
 * 12. toArray(), clone(), clear(), size()
 * 13. equals()/hashCode() behavior (identity-based, NOT content-based)
 * 14. Iteration + fail-fast behavior (ConcurrentModificationException)
 * 15. Real use case: Browser history (back/forward using two ArrayDeques)
 * 16. Time complexity summary
 */
public class ArrayDequeAllConcepts {

    public static void main(String[] args) {
        internalWorkingDemo();
        capacityGrowthDemo();
        constructorsDemo();
        coreOperationsDemo();
        stackUsageDemo();
        queueUsageDemo();
        noCapacityRestrictionDemo();
        nullNotAllowedDemo();
        notThreadSafeDemo();
        occurrenceMethodsDemo();
        performanceComparisonDemo();
        utilityMethodsDemo();
        equalsHashCodeDemo();
        iterationFailFastDemo();
        browserHistoryDemo();
    }

    // ---------------------------------------------------------
    // 1. INTERNAL WORKING (CIRCULAR RESIZABLE ARRAY)
    // ---------------------------------------------------------
    static void internalWorkingDemo() {
        System.out.println("\n=== 1. Internal Working Demo ===");
        // ArrayDeque is backed by a resizable, circular array (NOT a linked list).
        // It maintains two pointers: 'head' and 'tail'.
        // addFirst() -> decrements head (wraps around), places element there
        // addLast() -> places element at tail, increments tail (wraps around)
        // This circular design lets BOTH ends grow in O(1) without shifting elements.

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1); // tail moves right
        deque.addLast(2);
        deque.addFirst(0); // head moves left (wraps to end of array if needed)
        System.out.println("Deque after mixed insertions: " + deque); // [0, 1, 2]
        System.out.println("No shifting of existing elements happens on either end - O(1) amortized.");
    }

    // ---------------------------------------------------------
    // 2. CAPACITY GROWTH MECHANISM (DOUBLING)
    // ---------------------------------------------------------
    static void capacityGrowthDemo() {
        System.out.println("\n=== 2. Capacity Growth Demo ===");
        // Default initial capacity is 16 (actual usable slots = 16, one slot always
        // kept free
        // internally to distinguish empty vs full circular buffer state).
        // When the array is full, capacity DOUBLES (unlike ArrayList's 1.5x growth).

        Deque<Integer> deque = new ArrayDeque<>(2); // small initial capacity hint
        for (int i = 1; i <= 10; i++) {
            deque.addLast(i);
        }
        System.out.println("Deque after 10 additions (started with tiny capacity): " + deque);
        System.out.println("Internally resized/doubled multiple times behind the scenes.");
    }

    // ---------------------------------------------------------
    // 3. CONSTRUCTORS SUMMARY
    // ---------------------------------------------------------
    static void constructorsDemo() {
        System.out.println("\n=== 3. Constructors Summary Demo ===");

        Deque<Integer> d1 = new ArrayDeque<>(); // default capacity 16
        Deque<Integer> d2 = new ArrayDeque<>(100); // initial capacity hint 100
        Deque<Integer> d3 = new ArrayDeque<>(List.of(1, 2, 3)); // build from existing collection

        System.out.println("d1 (default): " + d1);
        System.out.println("d2 (capacity hint 100): " + d2);
        System.out.println("d3 (from collection): " + d3);
    }

    // ---------------------------------------------------------
    // 4. CORE OPERATIONS RECAP (INSERT / REMOVE / EXAMINE)
    // ---------------------------------------------------------
    static void coreOperationsDemo() {
        System.out.println("\n=== 4. Core Operations Recap ===");
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25);
        System.out.println("After insertions: " + deque); // [5, 10, 20, 25]

        System.out.println("peekFirst() -> " + deque.peekFirst()); // 5
        System.out.println("peekLast()  -> " + deque.peekLast()); // 25

        System.out.println("pollFirst() -> " + deque.pollFirst()); // 5
        System.out.println("pollLast()  -> " + deque.pollLast()); // 25
        System.out.println("Remaining: " + deque); // [10, 20]
    }

    // ---------------------------------------------------------
    // 5. ARRAYDEQUE AS STACK (RECOMMENDED OVER java.util.Stack)
    // ---------------------------------------------------------
    static void stackUsageDemo() {
        System.out.println("\n=== 5. ArrayDeque as Stack Demo ===");
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1); // addFirst
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack); // [3, 2, 1]
        System.out.println("pop() -> " + stack.pop()); // 3
        System.out.println("Java docs officially recommend ArrayDeque over Stack: faster, no legacy sync overhead.");
    }

    // ---------------------------------------------------------
    // 6. ARRAYDEQUE AS QUEUE (RECOMMENDED OVER LinkedList)
    // ---------------------------------------------------------
    static void queueUsageDemo() {
        System.out.println("\n=== 6. ArrayDeque as Queue Demo ===");
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1); // addLast
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue: " + queue); // [1, 2, 3]
        System.out.println("poll() -> " + queue.poll()); // 1
        System.out.println("Better cache locality & less per-element memory overhead than LinkedList.");
    }

    // ---------------------------------------------------------
    // 7. NO CAPACITY RESTRICTION (UNBOUNDED)
    // ---------------------------------------------------------
    static void noCapacityRestrictionDemo() {
        System.out.println("\n=== 7. No Capacity Restriction Demo ===");
        // Unlike ArrayBlockingQueue, ArrayDeque has NO fixed max size - it just keeps
        // growing.
        Deque<Integer> deque = new ArrayDeque<>(1);
        for (int i = 0; i < 1000; i++) {
            deque.add(i);
        }
        System.out.println("Added 1000 elements without any capacity exception. Final size -> " + deque.size());
    }

    // ---------------------------------------------------------
    // 8. NULL NOT ALLOWED (WHY)
    // ---------------------------------------------------------
    static void nullNotAllowedDemo() {
        System.out.println("\n=== 8. Null Not Allowed Demo ===");
        // Reason: poll()/peek() use null as a sentinel value meaning "deque is empty".
        // If null elements were allowed, you couldn't distinguish "empty deque" from
        // "deque contains a null element" -> so ArrayDeque forbids null entirely.
        Deque<Integer> deque = new ArrayDeque<>();
        try {
            deque.addFirst(null);
        } catch (NullPointerException e) {
            System.out.println("addFirst(null) -> threw NullPointerException (by design)");
        }
    }

    // ---------------------------------------------------------
    // 9. NOT THREAD-SAFE
    // ---------------------------------------------------------
    static void notThreadSafeDemo() {
        System.out.println("\n=== 9. Not Thread-Safe Demo ===");
        System.out.println("ArrayDeque has NO internal synchronization.");
        System.out.println("For concurrent access, use ConcurrentLinkedDeque or LinkedBlockingDeque instead,");
        System.out.println("or wrap manually - though there is no Collections.synchronizedDeque() helper.");
    }

    // ---------------------------------------------------------
    // 10. removeFirstOccurrence / removeLastOccurrence / contains
    // ---------------------------------------------------------
    static void occurrenceMethodsDemo() {
        System.out.println("\n=== 10. Occurrence Methods Demo ===");
        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3, 2, 1));

        System.out.println("Deque: " + deque);
        System.out.println("contains(3) -> " + deque.contains(3)); // true

        deque.removeFirstOccurrence(2); // removes first "2" found from head side
        System.out.println("After removeFirstOccurrence(2): " + deque); // [1, 3, 2, 1]

        deque.removeLastOccurrence(1); // removes last "1" found from tail side
        System.out.println("After removeLastOccurrence(1): " + deque); // [1, 3, 2]
    }

    // ---------------------------------------------------------
    // 11. PERFORMANCE COMPARISON: ArrayDeque vs LinkedList vs Stack
    // ---------------------------------------------------------
    static void performanceComparisonDemo() {
        System.out.println("\n=== 11. Performance Comparison Demo ===");
        int n = 2_000_000;

        long start = System.nanoTime();
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            arrayDeque.push(i);
        for (int i = 0; i < n; i++)
            arrayDeque.pop();
        long arrayDequeTime = System.nanoTime() - start;

        start = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++)
            linkedList.push(i);
        for (int i = 0; i < n; i++)
            linkedList.pop();
        long linkedListTime = System.nanoTime() - start;

        start = System.nanoTime();
        Stack<Integer> legacyStack = new Stack<>();
        for (int i = 0; i < n; i++)
            legacyStack.push(i);
        for (int i = 0; i < n; i++)
            legacyStack.pop();
        long stackTime = System.nanoTime() - start;

        System.out.println("ArrayDeque push+pop  (" + n + " ops) -> " + (arrayDequeTime / 1_000_000) + " ms");
        System.out.println("LinkedList push+pop  (" + n + " ops) -> " + (linkedListTime / 1_000_000) + " ms");
        System.out.println("Legacy Stack push+pop(" + n + " ops) -> " + (stackTime / 1_000_000) + " ms");
        System.out.println("(ArrayDeque is typically fastest due to array locality & no sync overhead.)");
    }

    // ---------------------------------------------------------
    // 12. toArray(), clone(), clear(), size()
    // ---------------------------------------------------------
    static void utilityMethodsDemo() {
        System.out.println("\n=== 12. Utility Methods Demo ===");
        ArrayDeque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3));

        Object[] arr = deque.toArray();
        System.out.println("toArray() -> " + Arrays.toString(arr));

        ArrayDeque<Integer> cloned = deque.clone(); // shallow copy
        cloned.add(4);
        System.out.println("Original after clone+modify: " + deque); // unaffected -> [1, 2, 3]
        System.out.println("Cloned deque: " + cloned); // [1, 2, 3, 4]

        System.out.println("size() -> " + deque.size());
        deque.clear();
        System.out.println("After clear() -> " + deque + " | isEmpty() -> " + deque.isEmpty());
    }

    // ---------------------------------------------------------
    // 13. equals() / hashCode() BEHAVIOR
    // ---------------------------------------------------------
    static void equalsHashCodeDemo() {
        System.out.println("\n=== 13. equals()/hashCode() Behavior Demo ===");
        // ArrayDeque does NOT override equals()/hashCode() from AbstractCollection in a
        // content-based way (unlike List, which compares element-by-element).
        // Two ArrayDeques with identical elements are considered "equal" only if they
        // are
        // the SAME reference (default Object identity), since Deque doesn't mandate
        // value equality.

        ArrayDeque<Integer> d1 = new ArrayDeque<>(List.of(1, 2, 3));
        ArrayDeque<Integer> d2 = new ArrayDeque<>(List.of(1, 2, 3));

        System.out.println("d1.equals(d2) -> " + d1.equals(d2)); // false! (identity-based)
        System.out.println("d1.equals(d1) -> " + d1.equals(d1)); // true

        // Compare with ArrayList, which DOES do content-based equality:
        List<Integer> l1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(List.of(1, 2, 3));
        System.out.println("ArrayList l1.equals(l2) -> " + l1.equals(l2)); // true (content-based)
    }

    // ---------------------------------------------------------
    // 14. ITERATION + FAIL-FAST BEHAVIOR
    // ---------------------------------------------------------
    static void iterationFailFastDemo() {
        System.out.println("\n=== 14. Iteration + Fail-Fast Demo ===");
        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3));

        System.out.print("Normal iteration: ");
        for (int val : deque)
            System.out.print(val + " ");
        System.out.println();

        try {
            for (int val : deque) {
                if (val == 2) {
                    deque.add(99); // structural modification during iteration
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Modifying deque during iteration -> threw ConcurrentModificationException");
        }
    }

    // ---------------------------------------------------------
    // 15. REAL USE CASE: BROWSER HISTORY (BACK/FORWARD)
    // ---------------------------------------------------------
    static void browserHistoryDemo() {
        System.out.println("\n=== 15. Browser History (Back/Forward) Demo ===");
        Deque<String> backStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();
        String current = "home.com";

        // Visit pages
        for (String page : List.of("news.com", "shop.com", "mail.com")) {
            backStack.push(current);
            current = page;
        }
        System.out.println("Current page: " + current + " | Back stack: " + backStack);

        // Go back
        forwardStack.push(current);
        current = backStack.pop();
        System.out.println("Went back -> Current: " + current + " | Forward stack: " + forwardStack);

        // Go forward
        backStack.push(current);
        current = forwardStack.pop();
        System.out.println("Went forward -> Current: " + current);
    }

    // ---------------------------------------------------------
    // 16. Time Complexity Summary (comment-only reference):
    // addFirst/addLast/offerFirst/offerLast -> O(1) amortized
    // removeFirst/removeLast/pollFirst/pollLast -> O(1) amortized
    // peekFirst/peekLast/getFirst/getLast -> O(1)
    // push/pop/offer/poll/peek (stack/queue use)-> O(1) amortized
    // contains/remove(Object)/removeXOccurrence -> O(n)
    // size/isEmpty/clear -> O(1) / O(n) for clear
    // toArray() -> O(n)
    // ---------------------------------------------------------
}