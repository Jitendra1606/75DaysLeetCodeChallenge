class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;

        Integer[] arr = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        return 100000L * (long) Math.abs(arr[0]) * (long) Math.abs(arr[1]);
    }
}