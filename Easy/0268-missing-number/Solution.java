class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length+1;i++){
            map.put(i,0);
        }
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i] , 1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()==0){
                return e.getKey();
            }
        }
        return 1;
    }
}