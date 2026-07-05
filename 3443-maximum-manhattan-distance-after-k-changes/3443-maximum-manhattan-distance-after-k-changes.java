//is ques m hmko atmost k changes krke dis ko max krna h, agar 'N' aur 'S' h to ye obviously hmare distance ko km krenge ese hi agar 'W' aur 'E' saath h to ye bhi km krenge, agar hm log kisi 'S' ko 'N' m bdle ya ulta to hmare distance m +2 ho jayega original string ke data ke comparison m
// to hm yha bs itna kr lenege checks lga kr kitne max char ham bdl skte h
//uske baad cnt fun m uska possible ans calc kr lenge, aur usme bhi hm basically bs y kr rhe h ki agar ori string hoti to uska ans kya ata aur usme changes ke baad kitna change ata uska *2 krke add kr diya 


class Solution {
    public int maxDistance(String s, int k) {
        int x = s.length();
        int ans = 0;

        int n = 0, d = 0, e = 0, w = 0;
        for (int i = 0; i < x; i++) {
            char ch = s.charAt(i);

            if (ch == 'N')
                n++;
            else if (ch == 'E')
                e++;
            else if (ch == 'W')
                w++;
            else
                d++;

            int times1 = Math.min(Math.min(n, d), k);
            int times2 = Math.min(Math.min(e, w), k - times1);

            ans = Math.max(ans, cnt(n, d, times1) + cnt(e, w, times2));
        }

        return ans;
    }

    public int cnt(int dif1, int dif2, int ori) {
        return Math.abs(dif1 - dif2) + 2 * ori;
    }
}