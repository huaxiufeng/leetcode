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

class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) {
            return root;
        }

        TreeNode* left = root->left;
        TreeNode* right = root->right;

        if (left) {
            left = invertTree(left);
        }
        if (right) {
            right = invertTree(right);
        }

        root->left = right;
        root->right = left;
        return root;
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
    vector<int> result = s.inorderTraversal(root);
    display(result);

    return 0;
}

