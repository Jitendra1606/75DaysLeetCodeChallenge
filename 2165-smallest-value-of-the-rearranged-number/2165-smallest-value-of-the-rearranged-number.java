class Solution {
    public long smallestNumber(long num) {
        if(num == 0) return 0;

        if (num < 0) {
            // char[] nums = String.valueOf(num).toCharArray();
            String s = String.valueOf(num).substring(1);

            char[] nums = s.toCharArray();

            Arrays.sort(nums);

            StringBuilder sb = new StringBuilder();

            for (int i = nums.length - 1; i >= 0; i--) {
                sb.append(nums[i]);
            }

            long ans = -Long.parseLong(sb.toString());
            return ans;
        } else {
            char[] nums = String.valueOf(num).toCharArray();

            Arrays.sort(nums);

            StringBuilder sb = new StringBuilder();

            int zeroCnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == '0')
                    zeroCnt++;
            }

            if (zeroCnt == 0) {
                for (int i = 0; i < nums.length; i++) {
                    sb.append(nums[i]);
                }

                Long ans = Long.parseLong(sb.toString());
                return ans;
            }

            else {
                int i = 0;
                while (nums[i] == '0')
                    i++;

                char temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;

                for (int k = 0; k < nums.length; k++) {
                    sb.append(nums[k]);
                }

                Long ans = Long.parseLong(sb.toString());
                return ans;
            }
        }
    }
}