class Solution{
    public int longestConsecutive(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
        }

        int longest = 1;

        for(int it : set){
            
// If there is no number before 'it', it’s the start of a sequence
            if(!set.contains(it - 1)){
                int cnt = 1;
                int x = it;

// Keep checking for the next consecutive number
                while(set.contains(x + 1)){
                    x = x + 1; // Move to the next number in sequence
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
//t.c ~ O(3n)
//s.c = O(n)


// class Solution{
//     public int longestConsecutive(int[] nums){
//         int n = nums.length;
//         if(n == 0) return 0;
//         Arrays.sort(nums);
//         int longest = 1, curcnt = 0, lastSmallest = Integer.MIN_VALUE;

//         for(int i = 0 ; i < n ; i++){
//             if(nums[i] - 1 == lastSmallest){
//                 curcnt++;
//                 lastSmallest = nums[i];
//             }else if(lastSmallest != nums[i]){
//                 curcnt = 1;
//                 lastSmallest = nums[i];
//             }
//             longest = Math.max(longest, curcnt);
//         }
//         return longest;
//     }
// }
//t.c = O(n) + O(nlogn)(sorting)
//s.c = O(1)

// class Solution{
//     public int longestConsecutive(int[] nums){

//         int n = nums.length;
//         if(n == 0) return 0;

//         HashSet<Integer> set = new HashSet<>();
//         for(int i = 0 ; i < n ; i++){
//             set.add(nums[i]);
//         }

//         List<Integer> list = new ArrayList<>(set);

//         Collections.sort(list);

//         int cnt = 1, max = 1;

//         for(int i = 1 ; i < list.size() ; i++){
//             if(list.get(i) - list.get(i - 1) == 1){
//                 cnt++;
//                 max = Math.max(max, cnt);
//             }else{
//                 cnt = 1;
//             }
//         }
//         return max;
//     }
// }
//t.c = O(n)(hashset) + O(nlogn)(sorting) + O(n)(traversing)
//s.c = O(n)(hashset) + O(n)(arraylist)


//only good for positive numbers
// class Solution{
//     public int longestConsecutive(int[] nums){
//         int n = nums.length;
//         int[] hash = new int[10001];
//         for(int i = 0 ; i < n ; i++){
//             hash[nums[i]]++;
//         }
//         int cnt = 0, max = 0;
//         for(int i = 0 ; i < 10001 ; i++){
//             if(hash[i] == 0) cnt = 0;
//             else{
//                 cnt++;
//                 max = Math.max(max, cnt);
//             }
//         }
//         return max;
//     }
// }
//t.c = O(n) + O(10001) = O(n)
//s.c = O(10001) ,to store hash values