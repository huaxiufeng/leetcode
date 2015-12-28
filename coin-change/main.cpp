#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<"\t";
    }
    cout<<endl;
}

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
    cout<<endl;
}

class Solution {
public:
    /*
    int coinChange(vector<int>& coins, int amount) {
        int sz = coins.size();
        if (amount == 0) {
            return 0;
        }
        if (sz == 0) {
            return -1;
        }
        if (sz == 1) {
            if (amount % coins[0] != 0) {
                return -1;
            } else {
                return amount / coins[0];
            }
        }
        int last_coin = coins[sz-1];
        vector<int> coins0 = coins;
        coins0.erase(coins0.end()-1);
        int min_count = -1;
        for (int n = 0; n <= amount / last_coin; n++) {
            if (min_count > 0 && n >= min_count) {
                break;
            }
            int left_count = coinChange(coins0, amount-n*last_coin);
            if (left_count < 0) {
                continue;
            }
            int count = n + left_count;
            if (count < min_count || min_count < 0) {
                min_count = count;
            }
        }
        return min_count;
    }
    */
    /*
    int coinChange(vector<int>& coins, int amount) {
        if (amount <= 0) {
            return -1;
        }
        int sz = coins.size();
        sort(coins.begin(), coins.end());
        vector<int> line(sz, -1);
        vector<vector<int>> table(amount, line);
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < amount; j++) {
                if (i == 0) {
                    if ((j+1)%coins[i] == 0) {
                        table[j][i] = (j+1)/coins[i];
                    }
                } else {
                    table[j][i] = table[j][i-1];
                    int max_cnt = (j+1)/coins[i];
                    if ((j+1)%coins[i] == 0) {
                        table[j][i] = max_cnt;
                        continue;
                    }
                    for (int k = 1; k <= max_cnt; k++) {
                        int left_coins = (j+1) - k*coins[i];
                        int pre_cnt = table[left_coins-1][i-1];
                        if (pre_cnt < 0) {
                            continue;
                        }
                        if (k+pre_cnt < table[j][i]) {
                            table[j][i] = k+pre_cnt;
                        }
                    }
                }
            }
            //display(table);
            //getchar();
        }
        return table[amount-1][sz-1];
    }
    */
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, amount+1);
        dp[0] = 0;
        display(dp);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        display(dp);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};

int main() {
    int amount = 11;
    int arr[] = {1,2,5};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.coinChange(nums, amount)<<endl;
    return 0;
}

