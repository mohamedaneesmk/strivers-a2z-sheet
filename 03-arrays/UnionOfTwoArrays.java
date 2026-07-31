import java.util.ArrayList;
import java.util.Arrays;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 7};

        System.out.println(Arrays.toString(unionArray(nums1, nums2)));
    }

    private static int[] unionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (list.size() == 0 || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (list.size() == 0 || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (list.size() == 0 || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (list.size() == 0 || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }

        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }

        return ans;
    }
}