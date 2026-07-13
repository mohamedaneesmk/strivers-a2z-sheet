package Collections;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * DequeAllConcepts.java
 * A single file covering ALL major Deque concepts in Java:
 * 1. What is Deque + implementations (ArrayDeque vs LinkedList)
 * 2. Insertion methods (both ends) + failure behavior
 * 3. Removal methods (both ends) + failure behavior
 * 4. Examination methods (peek both ends) + failure behavior
 * 5. Using Deque as a Stack (LIFO) - push/pop
 * 6. Using Deque as a Queue (FIFO) - offer/poll
 * 7. Legacy Stack class vs ArrayDeque comparison
 * 8. Iteration - forward and reverse (descendingIterator)
 * 9. Time complexity notes
 * 10. Null not allowed
 * 11. Sliding Window Maximum use case (classic Deque problem)
 * 12. Palindrome Check use case
 * 13. Undo/Redo simulation use case (two stacks via Deque)
 * 14. Thread-safe Deques (ConcurrentLinkedDeque, LinkedBlockingDeque)
 * 15. Constructors summary
 */
public class DequeAllConcepts {

    public static void main(String[] args) throws InterruptedException {
        implementationsDemo();
        insertionMethodsDemo();
        removalMethodsDemo();
        examinationMethodsDemo();
        stackUsageDemo();
        queueUsageDemo();
        legacyStackComparisonDemo();
        iterationDemo();
        nullNotAllowedDemo();
        slidingWindowMaxDemo();
        palindromeCheckDemo();
        undoRedoDemo();
        threadSafeDequeDemo();
        constructorsDemo();
    }

    // ---------------------------------------------------------
    // 1. WHAT IS DEQUE + IMPLEMENTATIONS
    // ---------------------------------------------------------
    static void implementationsDemo() {
        System.out.println("\n=== 1. Deque Implementations Demo ===");
        // Deque = Double Ended Queue -> insert/remove from BOTH ends

        Deque<Integer> arrayDeque = new ArrayDeque<>(); // resizable array, NO nulls, faster, no capacity limit by
                                                        // default
        Deque<Integer> linkedDeque = new LinkedList<>(); // doubly linked list, allows nulls (avoid using this way)

        arrayDeque.add(1);
        linkedDeque.add(1);

        System.out.println("ArrayDeque (recommended for Stack/Queue use): " + arrayDeque);
        System.out.println("LinkedList as Deque: " + linkedDeque);
        System.out.println("ArrayDeque implements: Deque, Queue, Cloneable, Serializable (NOT List)");
        System.out.println("LinkedList implements: List, Deque, Queue, Cloneable, Serializable");
    }

    // ---------------------------------------------------------
    // 2. INSERTION METHODS + FAILURE BEHAVIOR
    // ---------------------------------------------------------
    static void insertionMethodsDemo() {
        System.out.println("\n=== 2. Insertion Methods Demo ===");
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10); // throws exception on capacity-restricted deque failure
        deque.addLast(20);
        deque.offerFirst(5); // returns false instead of throwing
        deque.offerLast(25);

        System.out.println("After insertions: " + deque); // [5, 10, 20, 25]

        // add() / offer() add to the TAIL by default (Queue behavior)
        deque.add(30); // same as addLast
        deque.offer(35); // same as offerLast
        System.out.println("After add()/offer(): " + deque); // [5, 10, 20, 25, 30, 35]
    }

    // ---------------------------------------------------------
    // 3. REMOVAL METHODS + FAILURE BEHAVIOR
    // ---------------------------------------------------------
    static void removalMethodsDemo() {
        System.out.println("\n=== 3. Removal Methods Demo ===");
        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));

        System.out.println("removeFirst() -> " + deque.removeFirst()); // 1
        System.out.println("removeLast()  -> " + deque.removeLast()); // 5
        System.out.println("pollFirst()   -> " + deque.pollFirst()); // 2
        System.out.println("pollLast()    -> " + deque.pollLast()); // 4
        System.out.println("Remaining: " + deque); // [3]

        Deque<Integer> empty = new ArrayDeque<>();
        System.out.println("pollFirst() on empty -> " + empty.pollFirst()); // null (safe)
        try {
            empty.removeFirst(); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("removeFirst() on empty -> threw NoSuchElementException");
        }
    }

    // ---------------------------------------------------------
    // 4. EXAMINATION METHODS + FAILURE BEHAVIOR
    // ---------------------------------------------------------
    static void examinationMethodsDemo() {
        System.out.println("\n=== 4. Examination Methods Demo ===");
        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3));

        System.out.println("peekFirst() -> " + deque.peekFirst()); // 1
        System.out.println("peekLast()  -> " + deque.peekLast()); // 3
        System.out.println("getFirst()  -> " + deque.getFirst()); // 1
        System.out.println("getLast()   -> " + deque.getLast()); // 3

        Deque<Integer> empty = new ArrayDeque<>();
        System.out.println("peekFirst() on empty -> " + empty.peekFirst()); // null (safe)
        try {
            empty.getFirst(); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("getFirst() on empty -> threw NoSuchElementException");
        }
    }

    // ---------------------------------------------------------
    // Method Family Summary (comment-only reference table):
    // Throws Exception Returns Special Value
    // Insert Head: addFirst(e) offerFirst(e) -> false
    // Insert Tail: addLast(e) offerLast(e) -> false
    // Remove Head: removeFirst() pollFirst() -> null
    // Remove Tail: removeLast() pollLast() -> null
    // Examine Head: getFirst() peekFirst() -> null
    // Examine Tail: getLast() peekLast() -> null
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // 5. USING DEQUE AS A STACK (LIFO)
    // ---------------------------------------------------------
    static void stackUsageDemo() {
        System.out.println("\n=== 5. Deque as Stack (LIFO) Demo ===");
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1); // inserts at head (same as addFirst)
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushes: " + stack); // [3, 2, 1]

        System.out.println("pop() -> " + stack.pop()); // 3 (removes from head)
        System.out.println("peek() -> " + stack.peek()); // 2 (views head)
        System.out.println("Stack now: " + stack); // [2, 1]
    }

    // ---------------------------------------------------------
    // 6. USING DEQUE AS A QUEUE (FIFO)
    // ---------------------------------------------------------
    static void queueUsageDemo() {
        System.out.println("\n=== 6. Deque as Queue (FIFO) Demo ===");
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1); // inserts at tail (same as offerLast)
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue after offers: " + queue); // [1, 2, 3]

        System.out.println("poll() -> " + queue.poll()); // 1 (removes from head)
        System.out.println("peek() -> " + queue.peek()); // 2 (views head)
        System.out.println("Queue now: " + queue); // [2, 3]
    }

    // ---------------------------------------------------------
    // 7. LEGACY STACK VS ARRAYDEQUE
    // ---------------------------------------------------------
    @SuppressWarnings("deprecation")
    static void legacyStackComparisonDemo() {
        System.out.println("\n=== 7. Legacy Stack vs ArrayDeque Demo ===");

        // Old way (java.util.Stack extends Vector -> synchronized, slower, legacy)
        Stack<Integer> legacyStack = new Stack<>();
        legacyStack.push(1);
        legacyStack.push(2);
        System.out.println("Legacy Stack: " + legacyStack + " | pop() -> " + legacyStack.pop());

        // Modern recommended way (faster, not synchronized, resizable array)
        Deque<Integer> modernStack = new ArrayDeque<>();
        modernStack.push(1);
        modernStack.push(2);
        System.out.println("ArrayDeque as Stack: " + modernStack + " | pop() -> " + modernStack.pop());

        System.out.println("Java docs explicitly recommend ArrayDeque over Stack for stack operations.");
    }

    // ---------------------------------------------------------
    // 8. ITERATION - FORWARD AND REVERSE
    // ---------------------------------------------------------
    static void iterationDemo() {
        System.out.println("\n=== 8. Iteration Demo ===");
        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));

        System.out.print("Forward (iterator, head to tail): ");
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();

        System.out.print("Reverse (descendingIterator, tail to head): ");
        Iterator<Integer> dit = deque.descendingIterator();
        while (dit.hasNext())
            System.out.print(dit.next() + " ");
        System.out.println();
    }

    // ---------------------------------------------------------
    // 9. Time Complexity Notes:
    // addFirst/addLast/offerFirst/offerLast -> O(1)
    // removeFirst/removeLast/pollFirst/pollLast -> O(1)
    // peekFirst/peekLast/getFirst/getLast -> O(1)
    // contains/remove(Object) -> O(n)
    // ArrayDeque generally faster than LinkedList (better cache locality, less
    // memory overhead)
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // 10. NULL NOT ALLOWED (in ArrayDeque)
    // ---------------------------------------------------------
    static void nullNotAllowedDemo() {
        System.out.println("\n=== 10. Null Not Allowed Demo ===");
        Deque<Integer> deque = new ArrayDeque<>();
        try {
            deque.add(null); // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Adding null to ArrayDeque -> threw NullPointerException");
        }
        // Note: LinkedList (as Deque) DOES allow null - one more reason to prefer
        // ArrayDeque
    }

    // ---------------------------------------------------------
    // 11. SLIDING WINDOW MAXIMUM (classic Deque interview problem)
    // ---------------------------------------------------------
    static void slidingWindowMaxDemo() {
        System.out.println("\n=== 11. Sliding Window Maximum Demo ===");
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println("Result -> " + Arrays.toString(maxSlidingWindow(nums, k))); // [3,3,5,5,6,7]
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // stores INDICES, values kept in decreasing order
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIdx = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // Remove smaller elements from the back - they can never be the max
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[resIdx++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // ---------------------------------------------------------
    // 12. PALINDROME CHECK USE CASE
    // ---------------------------------------------------------
    static void palindromeCheckDemo() {
        System.out.println("\n=== 12. Palindrome Check Demo ===");
        System.out.println("\"madam\" is palindrome -> " + isPalindrome("madam"));
        System.out.println("\"hello\" is palindrome -> " + isPalindrome("hello"));
    }

    static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    // ---------------------------------------------------------
    // 13. UNDO/REDO SIMULATION (two Deques used as stacks)
    // ---------------------------------------------------------
    static void undoRedoDemo() {
        System.out.println("\n=== 13. Undo/Redo Simulation Demo ===");
        Deque<String> undoStack = new ArrayDeque<>();
        Deque<String> redoStack = new ArrayDeque<>();

        // Simulate typing actions
        undoStack.push("Type A");
        undoStack.push("Type B");
        undoStack.push("Type C");
        System.out.println("After actions, undo stack: " + undoStack);

        // Undo last action
        String undone = undoStack.pop();
        redoStack.push(undone);
        System.out.println("Undid: " + undone + " | undo stack: " + undoStack + " | redo stack: " + redoStack);

        // Redo it back
        String redone = redoStack.pop();
        undoStack.push(redone);
        System.out.println("Redid: " + redone + " | undo stack: " + undoStack);
    }

    // ---------------------------------------------------------
    // 14. THREAD-SAFE DEQUES
    // ---------------------------------------------------------
    static void threadSafeDequeDemo() throws InterruptedException {
        System.out.println("\n=== 14. Thread-Safe Deque Demo ===");

        // ConcurrentLinkedDeque - lock-free, unbounded, non-blocking
        Deque<Integer> concurrentDeque = new ConcurrentLinkedDeque<>();
        concurrentDeque.add(1);
        concurrentDeque.add(2);
        System.out.println("ConcurrentLinkedDeque: " + concurrentDeque);

        // LinkedBlockingDeque - supports blocking put/take, useful for
        // producer-consumer
        LinkedBlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(5); // bounded capacity
        blockingDeque.putFirst(10); // blocks if full
        blockingDeque.putLast(20);
        System.out.println("LinkedBlockingDeque: " + blockingDeque);
        System.out.println("takeFirst() -> " + blockingDeque.takeFirst()); // blocks if empty
    }

    // ---------------------------------------------------------
    // 15. CONSTRUCTORS SUMMARY
    // ---------------------------------------------------------
    static void constructorsDemo() {
        System.out.println("\n=== 15. Constructors Summary Demo ===");

        Deque<Integer> d1 = new ArrayDeque<>(); // default initial capacity 16
        Deque<Integer> d2 = new ArrayDeque<>(50); // initial capacity 50
        Deque<Integer> d3 = new ArrayDeque<>(List.of(1, 2, 3)); // build from a collection

        System.out.println("d1 (default): " + d1);
        System.out.println("d2 (capacity 50): " + d2);
        System.out.println("d3 (from collection): " + d3);
    }
}