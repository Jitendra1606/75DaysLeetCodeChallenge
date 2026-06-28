class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n = occupiedIntervals.length;

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : occupiedIntervals){
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] + 1 < interval[0]){
                merged.add(new int[]{interval[0], interval[1]});
            }
            else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            } 
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int[] interval : merged){
            int start = interval[0];
            int end = interval[1];

            if(end < freeStart || start > freeEnd){
                ans.add(Arrays.asList(start, end));
                continue;
            }

            if(start < freeStart){
                ans.add(Arrays.asList(start, freeStart - 1));
            }

            if(end > freeEnd){
                ans.add(Arrays.asList(freeEnd + 1, end));
            }
        }
        return ans;
    }
}


// Suppose
// merged
//  |
//  +-------> [2, 5]
// After executing
// merged.get(0)[1] = 9;
// Memory becomes
// merged
//  |
//  +-------> [2, 9]
// Notice the array didn't change.
// Only one value inside it changed.