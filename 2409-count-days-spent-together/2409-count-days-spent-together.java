class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int astart = convert(arriveAlice);
        int aend = convert(leaveAlice);
        int bstart = convert(arriveBob);
        int bend = convert(leaveBob);

        int start = Math.max(astart, bstart);
        int end = Math.min(aend, bend);

        return Math.max(0, end - start + 1);
    }

    public int convert(String s){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};

        int month = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int day = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        int totalDays = day;

        for(int i = 0 ; i < month - 1 ; i++){
            totalDays += days[i];
        }

        return totalDays;
    }

    // public int convert(String s){
    //     int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};

    //     int month = Integer.parseInt(s.substring(0, 2));
    //     int day = Integer.parseInt(s.substring(3));

    //     int totalDays = day;

    //     for(int i = 0 ; i < month - 1 ; i++){
    //         totalDays += days[i];
    //     }

    //     return totalDays;
    // }
}