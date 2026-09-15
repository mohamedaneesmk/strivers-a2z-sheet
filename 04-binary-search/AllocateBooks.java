class AllocateBooks {

    public static void main(String[] args) {

        int[] pages = {12, 34, 67, 90};
        int studentCount = 2;

        System.out.println(findMinimumPages(pages, studentCount));
    }

    public static int findMinimumPages(int[] pages, int studentsCount) {

        // Minimum possible answer = maximum pages in a single book
        // Maximum possible answer = total pages of all books
        int low = Integer.MIN_VALUE;
        int high = 0;

        // Find the search space: [maximum book pages, total pages]
        for (int page : pages) {

            low = Math.max(low, page);
            high += page;
        }

        // Binary search for the minimum possible maximum pages
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find how many students are needed if
            // each student can get at most 'mid' pages
            int reqStudents = findStudentsCount(pages, mid);

            if (reqStudents > studentsCount) {

                // 'mid' is too small because we need more students
                // Increase the allowed pages
                low = mid + 1;

            } else {

                // 'mid' is possible, but try to find a smaller answer
                high = mid - 1;
            }
        }

        // 'low' is the minimum valid maximum page allocation
        return low;
    }

    public static int findStudentsCount(int[] pages, int mid) {

        // Start with the first student
        int studentsCount = 1;
        int currentPages = 0;

        for (int page : pages) {

            if (currentPages + page <= mid) {

                // Give the current book to the same student
                currentPages += page;

            } else {

                // Current student cannot take this book
                // Assign the book to a new student
                studentsCount++;
                currentPages = page;
            }
        }

        return studentsCount;
    }
}