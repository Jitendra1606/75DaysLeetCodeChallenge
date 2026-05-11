//observation = only at max 2 elements will be there not more than 2
class Solution{
    public List<Integer> majorityElement(int[] nums){
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1; el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1; el2 = nums[i];
            }
            else if(el1 == nums[i]) cnt1++;
            else if(el2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++; 
            if (nums[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
    }
}

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int n = nums.length, k = n / 3;
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i = 0 ; i < n ; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>();
//         for(Integer it : map.keySet()){
//             if(map.get(it) > k){
//                 list.add(it);
//             }
//         }
//         //or
//         // Iterator<Integer> it = map.keySet().iterator();
//         // while (it.hasNext()) {
//         //     int key = it.next();
//         //     if (map.get(key) > k) {
//         //         list.add(key);
//         //     }
//         // }
//         return list;
//     }
// }
//t.c = O(n) + O(n)
//s.c = O(n) + O(n)

//brute force
// class Solution{
//     public List<Integer> majorityElement(int[] nums){
//         int n = nums.length;
//         ArrayList<Integer> list = new ArrayList<>();

//         for(int i = 0 ; i < n ; i++){
//             if(list.size() == 0 || !list.contains(nums[i])){
//                 int cnt = 0;
//                 for(int j = 0 ; j < n ; j++){
//                     if(nums[i] == nums[j]) cnt++;
                    
//                 }
//                 if(cnt > n / 3) list.add(nums[i]);
//             }
//             if(list.size() == 2) break;
//         }
//         return list;
//     }
// }