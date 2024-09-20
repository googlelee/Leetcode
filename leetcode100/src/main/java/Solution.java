import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortArray(int[] nums) {

        // mergeSort(nums, 0, nums.length - 1);

        // quickSort(nums, 0, nums.length - 1);

        // 非递归快排 用队列保存数组边界
        List<int[]> range = new ArrayList<>();
        range.add(new int[]{0, nums.length - 1});

        while (!range.isEmpty()) {
            int l = range.getFirst()[0];
            int r = range.getFirst()[1];
            range.removeFirst();
            int i = l, j = r, p = nums[l];
            int k = i;
            while (k <= j) {
                if (nums[k] < p) {
                    swap(nums, k++, i++);
                } else if (nums[k] > p) {
                    swap(nums, k, j--);
                } else k++;
            }
            if (i - 1 > l) range.add(new int[]{l, i - 1});
            if (r - 1 > j) range.add(new int[]{j + 1, r});
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = nums[(l + r) >> 1];
        int i = l, j = r;
        while (i < j) {
            while (nums[i] < p) {
                i++;
            }
            while (nums[j] > p) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int[] temp = new int[r - l + 1];
        int i = 0, j = l, k = mid + 1;
        for (; i < r - l + 1 && j < mid + 1 && k <= r; i++) {
            if (nums[j] < nums[k]) {
                temp[i] = nums[j];
                j++;
            } else {
                temp[i] = nums[k];
                k++;
            }
        }
        while (j < mid + 1) {
            temp[i] = nums[j];
            j++;
            i++;
        }
        while (k <= r) {
            temp[i] = nums[k];
            k++;
            i++;
        }
        for (int m = 0; m <= r - l; m++) {
            nums[l + m] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        Solution solution = new Solution();
        int[] result = solution.sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}