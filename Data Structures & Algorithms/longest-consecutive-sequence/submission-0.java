class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;

        Map<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int max_counter = 0;

        for(Integer key : map.keySet()){
            int counter = 1;
            if(!map.containsKey(key-1)){
                while(map.containsKey(key+1)){
                    ++counter;
                    ++key;
                }
                max_counter = Math.max(max_counter , counter);
            }
        }

        return max_counter;
    }
}
