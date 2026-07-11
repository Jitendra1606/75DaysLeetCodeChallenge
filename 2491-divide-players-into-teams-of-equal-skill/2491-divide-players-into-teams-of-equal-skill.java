class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int size = n / 2;

        if (n == 2)
            return skill[0] * skill[1];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += skill[i];
        }

        if (sum % size != 0)
            return -1;

        Arrays.sort(skill);
        long target = sum / size;

        long result = 0;

        int i = 0, j = n - 1;

        while (i < j) {
            if (skill[i] + skill[j] != target)
                return -1;

            result += (long) skill[i] * skill[j];

            i++;
            j--;
        }
        return result;
    }

}