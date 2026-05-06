class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
         unordered_map<int, int> freq;

        for (int num : nums) {

            freq[num]++;

        }

        // Step 2: Bucket array (index = frequency)

        vector<vector<int>> bucket(nums.size() + 1);

        for (auto& [num, count] : freq) {

            bucket[count].push_back(num);

        }

        // Step 3: Collect top k elements

        vector<int> result;

        for (int i = bucket.size() - 1; i >= 0 && result.size() < k; i--) {

            for (int num : bucket[i]) {

                result.push_back(num);

                if (result.size() == k) {

                    break;

                }

            }

        }

        return result;
    }
};
