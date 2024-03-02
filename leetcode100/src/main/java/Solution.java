class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            if (area > res) {
                res = area;
            } else {
                if (height[left] >= height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(heights));
    }
}