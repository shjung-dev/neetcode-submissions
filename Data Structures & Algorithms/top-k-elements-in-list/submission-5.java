class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> freq_map = new HashMap<>();

        for(Integer num : nums){
            freq_map.put(num , freq_map.getOrDefault(num , 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer,Integer> entry : freq_map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] res = new int[k];

        int index = 0;

        for(int i = bucket.length - 1 ; i >= 0 ; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[index++] = num;
                    
                    if(index == k){
                        return res;
                    }
                }
            }
        }
        
        return res;
    }
}