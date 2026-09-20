class Solution {
    public int ss(int[] nums, int target, int si, int ei){        // si - starting index, ei - ending index
          if(si>ei){
            return -1;
          }
          int mid = si + (ei - si)/2;
          if(nums[mid] == target){
            return mid;
          }
          //LINE 1
          if(nums[si]<= nums[mid]){
            if(nums[si]<=target && target<=nums[mid]){    //left of line 1
                return ss(nums, target, si, mid-1);
            }
            else{
                return ss(nums, target, mid+1, ei);        //right of line 1
            }
          }
          //LINE 2
          else{
            if(target <= nums[ei] && target >= nums[mid]){
                return ss(nums, target, mid+1, ei);       //right of line 2
            }
            else{
                return ss(nums, target, si, mid-1);       //left of line 2
            }
          }
    }

    public int search(int[] nums, int target) {
        int result = ss(nums, target, 0, nums.length-1);
        return result;
    }
}