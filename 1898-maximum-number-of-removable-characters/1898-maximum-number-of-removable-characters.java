class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
    
        int low = 0, high = n, res = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(s, p, removable, mid)){
                res = mid;
                low = mid + 1; //try removing more chars
            }else{
                high = mid - 1; //remove few char
            }
        }
        return res;
    }

    public boolean isPossible(String s, String p, int[] arr, int tar){
        boolean[] removed = new boolean[s.length()];

        //mark the first k indices as removed
        for(int i = 0 ; i < tar ; i++){
            removed[arr[i]] = true; //means we are removing these char from s
        }

        //initially all the elements of boolean array is false, so we explicitly mark them true, to compare for subsequence

        int j = 0;
        for(int i = 0 ; i < s.length() && j < p.length() ; i++){

            if(removed[i]) continue;

            if(s.charAt(i) == p.charAt(j)){
                j++;
            }
        }

        return j == p.length();
    }
}