 
class AllocateBooks {

    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int studentCount = 2;

        System.out.println(findMinimumPages(pages, studentCount));
    }

    public static int findMinimumPages(int[] pages, int studentsCount) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int page : pages) {
            if (page > low) {
                low = Math.max(low, page);
            }
            high += page;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int reqStudents = findStudentsCount(pages, mid);

            if (reqStudents > studentsCount) {
                low = mid + 1; 
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int findStudentsCount(int[] pages, int mid) {
        int studentsCount = 1, currentPages = 0;

        for (int page : pages) {
            if (page + currentPages <= mid) {
                currentPages += page;
            } else {
                studentsCount++;
                currentPages = page;
            }
        }

        return studentsCount;
    }
}
