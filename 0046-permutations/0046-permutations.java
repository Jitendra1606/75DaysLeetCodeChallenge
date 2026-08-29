class Solution{
    
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums){
    
        List<List<Integer>> result = new ArrayList<>();

        solve(nums, new ArrayList<>(), result);

        return result;
    }

    public void solve(int[] nums, List<Integer> list, List<List<Integer>> result){
    
        if(list.size() == nums.length){
    
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){

            if(!set.contains(nums[i])){
               
                set.add(nums[i]);
                list.add(nums[i]);

                solve(nums, list, result);

                set.remove(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}


// class Solution{
//     Set<Integer> set = new HashSet<>();
//     public List<List<Integer>> permute(int[] nums){
//         List<List<Integer>> result = new ArrayList<>();
//         solve(nums, new ArrayList<>(), result);
//         return result;
//     }

//     public void solve(int[] nums, List<Integer> list, List<List<Integer>> result){
//         if(list.size() == nums.length){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         for(int i = 0 ; i < nums.length ; i++){

//             if(!set.contains(nums[i])){
// //we need another data structure to keep track of which element is already or which one not
//                 set.add(nums[i]);
//                 list.add(nums[i]);
//                 solve(nums, list, result);

//                 set.remove(nums[i]);
//                 list.remove(list.size() - 1);
//             }
//         }
//     }
// }
//t.c = O(n.n!)
//s.c = O(n.n!)