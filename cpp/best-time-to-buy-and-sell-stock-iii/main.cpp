#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }
        vector<int> profit(prices.size(), 0);
        vector<int> rprofit(prices.size(), 0);
        int min_price = 0;
        int pft = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (i == 0) {
                min_price = prices[i];
                profit[i] = 0;
                continue;
            }
            if (prices[i] - min_price > pft) {
                pft = prices[i] - min_price;
            }
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            profit[i] = pft;
        }
        int max_price = 0;
        pft = 0;
        for (int i = prices.size()-1; i >= 0; i--) {
            if (i == prices.size()-1) {
                max_price = prices[i];
                rprofit[i] = 0;
                continue;
            }
            if (max_price - prices[i] > pft) {
                pft = max_price - prices[i];
            }
            if (prices[i] > max_price) {
                max_price = prices[i];
            }
            rprofit[i] = pft;
        }

        int result = 0;
        for (int i = 0; i < profit.size(); i++) {
            int val = profit[i] + rprofit[i];
            if (val > result) {
                result = val;
            }
        }
        return result;
    }
};

int main() {
    int arr[] = {1,2,3,2,5,7,2,4,9,0}; // expect 13
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.maxProfit(nums)<<endl;
    return 0;
}

