#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

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

class Solution {
public:
    bool checkBalanced(TreeNode* root, int& depth) {
        if (!root) {
            depth = 0;
            return true;
        }
        int leftdepth = 0, rightdepth = 0;
        bool leftbalance = checkBalanced(root->left, leftdepth);
        bool rightbalance = checkBalanced(root->right, rightdepth);

        depth = max(leftdepth, rightdepth) + 1;

        if (leftbalance && rightbalance) {
            if (abs(leftdepth - rightdepth) <= 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    bool isBalanced(TreeNode* root) {
        int depth = 0;
        return checkBalanced(root, depth);
    }
};

/*
        1
    2       3
  4   5   6   7
*/

int main() {
    //int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    //int arr[] = {1,2,4,-1,-1,5,-1,-1,2,5,-1,-1,4,-1,-1};
    int arr[] = {1,2,3,-1,-1,-1,-1};
    TreeNode* root = 0;
    int index = 0;
    CreateBinaryTree(root, arr, index);
    PreOderTraverse(root);
    cout<<endl;

    Solution s;
    cout<<s.isBalanced(root);

    return 0;
}

