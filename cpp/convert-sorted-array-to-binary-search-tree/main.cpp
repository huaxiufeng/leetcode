#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void CreateBinaryTree(TreeNode*& root, const int* arr, int& index)
{
    if (arr[index] == -1) {
        root = NULL;
    } else {
        root = new TreeNode(arr[index]);
        CreateBinaryTree(root->left, arr, ++index);
        CreateBinaryTree(root->right, arr, ++index);
    }
}

void PreOderTraverse(TreeNode* root)
{
    if (root) {
        cout<<root->val<<" ";
        PreOderTraverse(root->left);
        PreOderTraverse(root->right);
    }
}

void InOderTraverse(TreeNode* root)
{
    if (root) {
        InOderTraverse(root->left);
        cout<<root->val<<" ";
        InOderTraverse(root->right);
    }
}

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums, int begin, int end) {
        if (begin > end) {
            return NULL;
        }
        int mid = (begin+end)/2;
        TreeNode *node = new TreeNode(nums[mid]);
        node->left = sortedArrayToBST(nums, begin, mid-1);
        node->right = sortedArrayToBST(nums, mid+1, end);
        return node;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size() == 0) {
            return NULL;
        }
        return sortedArrayToBST(nums, 0, nums.size()-1); 
    }
};

int main() {
    int arr[] = {1,2,3,4,5,6,7};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    Solution s;
    TreeNode *root = s.sortedArrayToBST(nums);
    InOderTraverse(root);
    cout<<endl;
    PreOderTraverse(root);

    return 0;
}

