package Oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_3sum_경혜안 {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			if(i > 0 && nums[i] == nums[i-1]) continue;
			
			int start = i + 1;
			int end = len - 1;
			
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				
				if(sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
					
					while(nums[start] == nums[start-1] && start < end) start++;
					while(nums[end] == nums[end+1] && start < end) end--;
				} else if (sum > 0) {
					end--;
				} else {
					start++;
				}
						 
			}
		}
		
		
	}
	
	

}
