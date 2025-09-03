class Solution {
public:

    bool checker(int mid, vector<int> &piles, int h) {
        long long hours = 0;
        for (int i = 0; i < piles.size(); i++) {
            hours += (ceil(piles[i] * 1.0 / mid));
        }
        return hours <= h;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int l = 1;
        int r = INT_MIN;
        for (int i = 0; i < piles.size(); i++) {
            r = max(r, piles[i]);
        }
        int ans;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (checker(mid, piles, h)) {
                ans = mid;
                r = mid-1;
            }else {
                l = mid + 1;
            }
        }
        return ans;
    }
};