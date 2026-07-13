package Collections;

import java.util.*;

/**
 * PriorityQueueAllConcepts.java
 * A single file covering ALL major PriorityQueue concepts in Java:
 * 1. Basic min-heap behavior
 * 2. add/offer/poll/peek/remove/element + failure behavior
 * 3. Max-heap using Comparator
 * 4. Custom objects with Comparator (lambda)
 * 5. Custom objects with Comparable (natural ordering)
 * 6. Comparator chaining (multiple sort criteria)
 * 7. Time complexity notes (in comments)
 * 8. Kth Largest Element use case
 * 9. Merge K Sorted Lists (Dijkstra-style) use case
 * 10. Null not allowed
 * 11. Iteration order not guaranteed vs poll() order
 * 12. Constructors summary
 */
public class PriorityQueueAllConcepts {

    public static void main(String[] args) {
        basicMinHeapDemo();
        basicOperationsDemo();
        maxHeapDemo();
        customObjectComparatorDemo();
        customObjectComparableDemo();
        comparatorChainingDemo();
        kthLargestDemo();
        mergeKSortedListsDemo();
        nullNotAllowedDemo();
        iterationVsPollDemo();
        constructorsDemo();
    }

    // ---------------------------------------------------------
    // 1. BASIC MIN-HEAP BEHAVIOR
    // ---------------------------------------------------------
    static void basicMinHeapDemo() {
        System.out.println("\n=== 1. Basic Min-Heap Demo ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        // toString() does NOT guarantee sorted order - it shows internal heap array
        System.out.println("Internal order (not fully sorted): " + pq);

        // poll() always returns the smallest element first
        System.out.println("poll() -> " + pq.poll()); // 10
        System.out.println("poll() -> " + pq.poll()); // 20
    }

    // ---------------------------------------------------------
    // 2. BASIC OPERATIONS + FAILURE BEHAVIOR
    // ---------------------------------------------------------
    static void basicOperationsDemo() {
        System.out.println("\n=== 2. Basic Operations Demo ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(40); // preferred over add() - returns false instead of throwing on failure
        pq.add(20);
        pq.offer(60);

        System.out.println("peek() -> " + pq.peek()); // 20 (view only)
        System.out.println("poll() -> " + pq.poll()); // 20 (remove + return)
        System.out.println("size() -> " + pq.size()); // 2

        pq.remove(60); // remove specific element - O(n)
        System.out.println("isEmpty() -> " + pq.isEmpty()); // false

        // Failure behavior comparison
        PriorityQueue<Integer> empty = new PriorityQueue<>();
        System.out.println("poll() on empty -> " + empty.poll()); // null
        System.out.println("peek() on empty -> " + empty.peek()); // null
        try {
            empty.element(); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("element() on empty -> threw NoSuchElementException");
        }
        try {
            empty.remove(); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("remove() on empty -> threw NoSuchElementException");
        }
    }

    // ---------------------------------------------------------
    // 3. MAX-HEAP USING COMPARATOR
    // ---------------------------------------------------------
    static void maxHeapDemo() {
        System.out.println("\n=== 3. Max-Heap Demo ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Alternative: new PriorityQueue<>((a, b) -> b - a);

        maxHeap.add(10);
        maxHeap.add(50);
        maxHeap.add(30);

        System.out.println("poll() -> " + maxHeap.poll()); // 50 (largest first)
        System.out.println("poll() -> " + maxHeap.poll()); // 30
    }

    // ---------------------------------------------------------
    // 4. CUSTOM OBJECTS WITH COMPARATOR
    // ---------------------------------------------------------
    static class Task {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String toString() {
            return name + "(" + priority + ")";
        }
    }

    static void customObjectComparatorDemo() {
        System.out.println("\n=== 4. Custom Object with Comparator Demo ===");
        // Lower priority number = executed first
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t1.priority - t2.priority);

        taskQueue.add(new Task("Email", 3));
        taskQueue.add(new Task("Deploy", 1));
        taskQueue.add(new Task("Meeting", 2));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll()); // Deploy(1), Meeting(2), Email(3)
        }
    }

    // ---------------------------------------------------------
    // 5. CUSTOM OBJECTS WITH COMPARABLE (NATURAL ORDERING)
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

        public String toString() {
            return name + ":" + marks;
        }
    }

    static void customObjectComparableDemo() {
        System.out.println("\n=== 5. Custom Object with Comparable Demo ===");
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Alice", 85));
        pq.add(new Student("Bob", 60));
        pq.add(new Student("Charlie", 95));

        System.out.println("poll() -> " + pq.poll()); // Bob:60 (lowest marks first)
    }

    // ---------------------------------------------------------
    // 6. COMPARATOR CHAINING (MULTIPLE SORT CRITERIA)
    // ---------------------------------------------------------
    static void comparatorChainingDemo() {
        System.out.println("\n=== 6. Comparator Chaining Demo ===");
        // Sort by priority first, then by name if priority is equal
        PriorityQueue<Task> pq = new PriorityQueue<>(
                Comparator.comparingInt((Task t) -> t.priority)
                        .thenComparing(t -> t.name));

        pq.add(new Task("Zeta", 1));
        pq.add(new Task("Alpha", 1));
        pq.add(new Task("Beta", 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Alpha(1), Zeta(1), Beta(2)
        }
    }

    // ---------------------------------------------------------
    // 7 & Time Complexity Notes:
    // offer/add -> O(log n)
    // poll/remove -> O(log n)
    // peek -> O(1)
    // contains/remove(Object) -> O(n)
    // size/isEmpty -> O(1)
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // 8. KTH LARGEST ELEMENT USE CASE
    // ---------------------------------------------------------
    static void kthLargestDemo() {
        System.out.println("\n=== 8. Kth Largest Element Demo ===");
        int[] arr = { 3, 2, 1, 5, 6, 4 };
        System.out.println("2nd largest -> " + findKthLargest(arr, 2)); // 5
    }

    static int findKthLargest(int[] nums, int k) {
        // Min-heap of size k -> top of heap is the kth largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest, keep only k largest
            }
        }
        return minHeap.peek();
    }

    // ---------------------------------------------------------
    // 9. MERGE K SORTED LISTS (DIJKSTRA-STYLE) USE CASE
    // ---------------------------------------------------------
    static class HeapNode {
        int value, listIndex, elementIndex;

        HeapNode(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    static void mergeKSortedListsDemo() {
        System.out.println("\n=== 9. Merge K Sorted Lists Demo ===");
        int[][] lists = {
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 3, 6, 9 }
        };

        PriorityQueue<HeapNode> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Push the first element of each list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].length > 0) {
                pq.offer(new HeapNode(lists[i][0], i, 0));
            }
        }

        List<Integer> merged = new ArrayList<>();
        while (!pq.isEmpty()) {
            HeapNode node = pq.poll();
            merged.add(node.value);

            int nextIndex = node.elementIndex + 1;
            if (nextIndex < lists[node.listIndex].length) {
                pq.offer(new HeapNode(lists[node.listIndex][nextIndex], node.listIndex, nextIndex));
            }
        }

        System.out.println("Merged sorted result -> " + merged); // [1,2,3,4,5,6,7,8,9]
    }

    // ---------------------------------------------------------
    // 10. NULL NOT ALLOWED
    // ---------------------------------------------------------
    static void nullNotAllowedDemo() {
        System.out.println("\n=== 10. Null Not Allowed Demo ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        try {
            pq.add(null); // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Adding null -> threw NullPointerException");
        }
    }

    // ---------------------------------------------------------
    // 11. ITERATION ORDER vs POLL ORDER
    // ---------------------------------------------------------
    static void iterationVsPollDemo() {
        System.out.println("\n=== 11. Iteration vs Poll Order Demo ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(5, 1, 4, 2, 3));

        System.out.print("Iteration order (NOT guaranteed sorted): ");
        for (int val : pq) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.print("Poll order (guaranteed sorted): ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    // 12. CONSTRUCTORS SUMMARY
    // ---------------------------------------------------------
    static void constructorsDemo() {
        System.out.println("\n=== 12. Constructors Summary Demo ===");

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // natural ordering, default capacity 11
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(20); // initial capacity 20
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(Comparator.reverseOrder()); // custom comparator
        PriorityQueue<Integer> pq4 = new PriorityQueue<>(List.of(3, 1, 2)); // build from a collection
        PriorityQueue<Integer> pq5 = new PriorityQueue<>(pq4); // copy constructor

        System.out.println("pq1 (default): " + pq1);
        System.out.println("pq2 (capacity 20): " + pq2);
        System.out.println("pq3 (reverse order): " + pq3);
        System.out.println("pq4 (from collection): " + pq4);
        System.out.println("pq5 (copy of pq4): " + pq5);
    }
}