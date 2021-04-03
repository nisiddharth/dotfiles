class UpperLowerBound {
    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true), ans[] = {-1, -1};
        if(left == nums.length || nums[left] != target)
            return ans;
        ans[0] = left;
        ans[1] = search(nums, target, false) - 1;
        return ans;
    }
    
    private int search(int nums[], int target, boolean left) {
        int start = 0, end = nums.length, mid;
        while(start < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] > target || (left && target == nums[mid]))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
