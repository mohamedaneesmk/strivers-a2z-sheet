package Collections;

// LinkedList Concepts Demo — implements List + Deque + Queue

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {

        // ===================================================================
        // 1. CREATING A LINKEDLIST
        // ===================================================================
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> fromCollection = new LinkedList<>(List.of(1, 2, 3));

        // ===================================================================
        // 2. ADDING ELEMENTS (List-style methods, same as ArrayList)
        // ===================================================================
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15); // insert at index -> [10, 15, 20, 30]
        System.out.println("After add: " + list);

        // ===================================================================
        // 3. LINKEDLIST-SPECIFIC: ADD AT ENDS (O(1) — this is where it shines)
        // ===================================================================
        list.addFirst(5); // insert at head -> [5, 10, 15, 20, 30]
        list.addLast(35); // insert at tail -> [5, 10, 15, 20, 30, 35]
        System.out.println("After addFirst/addLast: " + list);

        // ===================================================================
        // 4. ACCESSING ELEMENTS
        // ===================================================================
        int first = list.getFirst(); // or list.peek() / list.peekFirst()
        int last = list.getLast(); // or list.peekLast()
        int middle = list.get(2); // O(n) — traverses from head or tail, whichever closer
        System.out.println("First: " + first + ", Last: " + last + ", Index 2: " + middle);

        // ===================================================================
        // 5. REMOVING ELEMENTS
        // ===================================================================
        list.removeFirst(); // removes head -> O(1)
        list.removeLast(); // removes tail -> O(1)
        list.remove(1); // remove by index -> O(n) traversal
        list.remove(Integer.valueOf(20)); // remove by value (same int/Integer gotcha as ArrayList)
        System.out.println("After removals: " + list);

        // ===================================================================
        // 6. USING LINKEDLIST AS A STACK (LIFO) — push/pop
        // ===================================================================
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1); // pushes to the HEAD
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushes: " + stack); // [3, 2, 1]
        System.out.println("Popped: " + stack.pop()); // removes & returns head -> 3
        System.out.println("Stack after pop: " + stack); // [2, 1]

        // ===================================================================
        // 7. USING LINKEDLIST AS A QUEUE (FIFO) — offer/poll
        // ===================================================================
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1); // adds to tail (same as add)
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue: " + queue); // [1, 2, 3]
        System.out.println("Polled: " + queue.poll()); // removes & returns head -> 1
        System.out.println("Queue after poll: " + queue); // [2, 3]

        // ===================================================================
        // 8. USING LINKEDLIST AS A DEQUE (Double-Ended Queue)
        // ===================================================================
        LinkedList<Integer> deque = new LinkedList<>();
        deque.offerFirst(10); // add to front
        deque.offerLast(20); // add to back
        deque.offerFirst(5);
        System.out.println("Deque: " + deque); // [5, 10, 20]
        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());
        deque.pollFirst(); // remove from front
        deque.pollLast(); // remove from back
        System.out.println("Deque after polls: " + deque);

        // ===================================================================
        // 9. SAFE vs UNSAFE METHOD PAIRS (important distinction!)
        // ===================================================================
        // peek()/poll() -> return null if empty, NO exception (safe)
        // element()/remove() -> throw NoSuchElementException if empty (unsafe)
        LinkedList<Integer> empty = new LinkedList<>();
        System.out.println("peek() on empty list: " + empty.peek()); // null, no crash
        // empty.element(); // would throw NoSuchElementException
        // empty.remove(); // would throw NoSuchElementException

        // ===================================================================
        // 10. ITERATING
        // ===================================================================

        // a) Enhanced for-loop
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();

        // b) Iterator (forward only)
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // c) ListIterator — LinkedList's real strength: BIDIRECTIONAL traversal
        ListIterator<Integer> listIt = list.listIterator(list.size()); // start at end
        System.out.print("Reverse traversal: ");
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();

        // d) descendingIterator() — built-in reverse iterator
        Iterator<Integer> descIt = list.descendingIterator();
        System.out.print("Via descendingIterator: ");
        while (descIt.hasNext()) {
            System.out.print(descIt.next() + " ");
        }
        System.out.println();

        // ===================================================================
        // 11. SEARCHING & UTILITY (inherited from List — same as ArrayList)
        // ===================================================================
        System.out.println("Contains 15? " + list.contains(15));
        System.out.println("Index of 15: " + list.indexOf(15));
        System.out.println("Size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());

        // ===================================================================
        // 12. WHEN LINKEDLIST WINS: BULK INSERTIONS AT THE FRONT
        // ===================================================================
        LinkedList<Integer> bigList = new LinkedList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            bigList.addFirst(i); // O(1) every time — ArrayList would be O(n) each time
        }
        long end = System.nanoTime();
        System.out.println("LinkedList: 100k addFirst() took " + (end - start) / 1_000_000 + " ms");
    }
}