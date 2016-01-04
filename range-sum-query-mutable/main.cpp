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

};

typedef struct Node {
    int value;
    int start;
    int end;
    Node():value(0),start(0),end(0){}
} Node;

ostream& operator<<(ostream& out, const Node& node) {
    out<<"["<<node.start<<"-"<<node.end<<":"<<node.value<<"]";
    return out;
}

class SegmentTree {
public:
    SegmentTree(const vector<int>& nums):
    segtree((nums.size()+1)*4, Node()) {
        if (nums.size() > 0) {
            init(1, 0, nums.size()-1, nums);
        }
    }

    void init(int index, int start, int end, const vector<int>& nums) {
        if (index < 0 || index >= segtree.size() || end < start) {
            return;
        }
        segtree[index].start = start;
        segtree[index].end = end;
        if (end > start) {
            int mid = (start+end)/2;
            init(2*index, start, mid, nums);
            init(2*index+1, mid+1, end, nums);
        }

        if (end == start) {
            segtree[index].value = nums[start];
        } else {
            segtree[index].value = segtree[2*index].value + 
                segtree[2*index+1].value;
        }
    }

    void update(int index, int start, int value) {
        if (index < 0 || index >= segtree.size()) {
            return;
        }
        if (segtree[index].start == start && 
            segtree[index].end == start) {
            segtree[index].value = value;
        } else { 
            int mid = (segtree[index].start + 
                    segtree[index].end) / 2; 
            if (start > mid) {
                update(2*index+1, start, value);
            } else if (start <= mid) {
                update(2*index, start, value);
            }
            segtree[index].value = segtree[2*index].value + 
                segtree[2*index+1].value;
        }
    }

    int getValue(int index, int start, int end) {
        if (index < 0 || index >= segtree.size()) {
            return 0;
        }
        int value = segtree[index].value;
        if (segtree[index].start == start &&
            segtree[index].end == end) {
            return value;
        } else {
            int mid = (segtree[index].start + 
                    segtree[index].end) / 2; 
            if (end <= mid) {
                return getValue(2*index, start, end);
            } else if (start > mid) {
                return getValue(2*index+1, start, end);
            } else {
                return getValue(2*index, start, mid) +
                    getValue(2*index+1, mid+1, end);
            }
        }
        return -1;
    }

    void show() {
        for (int i = 0; i < segtree.size(); i++) {
            cout<<segtree[i]<<" ";
        }
        cout<<endl;
    }

    vector<Node> segtree;
};

class NumArray {
public:
    NumArray(vector<int> &nums):
    st(nums) {
    }

    void update(int i, int val) {
        st.update(1, i, val);
        st.show();
    }

    int sumRange(int i, int j) {
        return st.getValue(1, i, j);
    }

    SegmentTree st;
};

int main() {
    //int arr[] = {-2, 0, 3, -5, 2, -1};
    int arr[] = {-28,-39,53,65,11,-56,-65,-39,-43,97};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
/*
    SegmentTree st(nums);
    st.show();
    cout<<st.getValue(1, 1, 4)<<endl;
    st.update(1,3,-4);
    st.show();
    cout<<st.getValue(1, 1, 4)<<endl;
    st.update(1,2,2);
    st.show();
    cout<<st.getValue(1, 1, 4)<<endl;
*/
    NumArray na(nums);
    na.st.show();

    cout<<na.sumRange(5,6)<<endl;
    cout<<na.sumRange(3,4)<<endl;
    cout<<na.sumRange(0,2)<<endl;
    cout<<na.sumRange(2,5)<<endl;
    cout<<na.sumRange(0,5)<<endl;

    na.update(2,4);

    cout<<na.sumRange(0,2)<<endl;
    cout<<na.sumRange(2,5)<<endl;
    cout<<na.sumRange(0,5)<<endl;

    return 0;
}

