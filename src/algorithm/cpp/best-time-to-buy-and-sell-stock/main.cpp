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
        int profit = 0;
        int min_price = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (i == 0) {
                min_price = prices[i];
                continue;
            }
            if (prices[i]-min_price > profit) {
                profit = prices[i]-min_price;
            }
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
        }
        return profit;
    }
};

int main() {
    int arr[] = {5,3,7,9,4,8};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.maxProfit(nums)<<endl;
    return 0;
}

