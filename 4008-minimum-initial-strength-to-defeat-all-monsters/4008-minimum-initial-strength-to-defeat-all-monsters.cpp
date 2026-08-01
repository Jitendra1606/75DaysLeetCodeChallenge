class Solution {
public:
    using ll = long long;

    long long minInitialStrength(vector<int>& nums, vector<vector<int>>& boosts) {
        int n = nums.size();
        vector<ll> diff(n+1, 0);
        for(auto& it : boosts){
            diff[it[0]] += it[2];
            diff[it[1]+1] -= it[2];
        }
        for(int i=1; i<n; i++){
            diff[i]+=diff[i-1];
        }
        ll lo = 0, hi = accumulate(nums.begin(), nums.end(), 0LL);
        ll ans = 0;
        while(lo<=hi){
            ll mid = lo + (hi-lo)/2;
            if(valid(nums,diff, mid)){
                ans = mid;
                hi = mid-1;
            }else lo = mid+1;
        }
        return ans;
    }
    bool valid(vector<int>& nums,vector<ll>& diff, ll s){
        for(int i =0; i<nums.size(); i++){
            int x = nums[i];
            if(x>s){
                if(x>s+diff[i]) return false;
            }
            s-=x;
            if(s<0) s=0;
        }
        return true;
    }
};