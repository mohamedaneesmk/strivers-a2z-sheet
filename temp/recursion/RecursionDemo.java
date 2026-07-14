package recursion;

public class RecursionDemo {
    static int count = 0;

    public static void main(String[] args) {
        printName();
        print();
    }

    private static void printName() {
        if (count == 5)
            return;
        System.out.println("Anees");
        count++;
        printName();
    }

    private static void print() {
        if (count == 5)
            return;
        System.out.println(count);
        count++;
        print();
    }
}
