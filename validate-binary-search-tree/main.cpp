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
    bool isValidBST(TreeNode* root) {
        if (!root) {
            return true;
        }
        if (root->left) {
            if (root->val <= root->left->val) {
                return false;
            }
            TreeNode* max_node = root->left;
            while (max_node) {
                if (max_node->val >= root->val) {
                    return false;
                }
                max_node = max_node->right;
            }
        }
        if (root->right) {
            if (root->val >= root->right->val) {
                return false;
            }
            TreeNode* min_node = root->right;
            while (min_node) {
                if (min_node->val <= root->val) {
                    return false;
                }
                min_node = min_node->left;
            }
        }

        return isValidBST(root->left) && isValidBST(root->right);
    }
};

/*
        10
    5        15
  1   9    8    18
*/

int main() {
    int arr[] = {10,5,1,-1,-1,9,-1,-1,15,8,-1,-1,18,-1,-1};
    //int arr[] = {1,2,4,-1,-1,5,-1,-1,2,5,-1,-1,4,-1,-1};
    TreeNode* root = 0;
    int index = 0;
    CreateBinaryTree(root, arr, index);
    PreOderTraverse(root);
    cout<<endl;

    Solution s;
    cout<<s.isValidBST(root);

    return 0;
}

