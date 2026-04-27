class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();

        for(Integer num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        List<Map.Entry<Integer , Integer>> list = new ArrayList<>(map.entrySet());

        list.sort( (a,b) -> Integer.compare(b.getValue() , a.getValue()));

        List<Integer> temp = new ArrayList<>();

        for(int i = 0 ; i < k ; ++i ){
            temp.add(list.get(i).getKey());
        }

        int[] res = new int[temp.size()];

        for(int i = 0 ; i < temp.size() ; ++i){
            res[i] = temp.get(i);
        }

        return res;
    }
}