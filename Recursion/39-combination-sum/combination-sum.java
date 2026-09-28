class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        combination(candidates, 0,new ArrayList<>(), 0, target);  

        return result;
    }

    public void combination(int[] candidates, int index, List<Integer> nums, int sum, int target){
        
        //  we found a combination
        if(sum == target){
            result.add (new ArrayList<>(nums));
            return;
        }

        if(sum > target || index==candidates.length){
            return;
        }
        
        // PICK
        nums.add(candidates[index]);
        combination(candidates,index,nums, sum + candidates[index], target);

        // sum -= candidates[index];
        nums.remove(nums.size()-1);
        combination(candidates, index+1,nums, sum, target);


    }
}