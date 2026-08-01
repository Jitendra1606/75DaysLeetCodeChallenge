class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> list = new ArrayList<>();

        int n = series1.length;
        int m = series2.length;

        int i = 0, j = 0;
        while(i < n && j < m){
            int first = series1[i][0];
            int second = series2[j][0];

            if(first < second){
                list.add(List.of(first, series1[i][1] + series2[j][1]));
                i++;
            }else if(first > second){
                list.add(List.of(second, series1[i][1] + series2[j][1]));;
                j++;
            }else{
                list.add(List.of(first, series1[i][1] + series2[j][1]));
                i++;
                j++;
            }
        }

        while(i < n){
            list.add(List.of(series1[i][0], series1[i][1]));
            i++;
        }

        while(j < m){
            list.add(List.of(series2[j][0], series2[j][1]));
            j++;
        }

        return list;
    }
}