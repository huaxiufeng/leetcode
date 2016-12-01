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
    bool isOpposite(TreeNode* tree1, TreeNode* tree2) {
        if (!tree1 && !tree2) {
            return true;
        } else if ((!tree1 && tree2) || (tree1 && !tree2)) {
            return false;
        } else {
            if (tree1->val != tree2->val) {
                return false;
            } else {
                return isOpposite(tree1->left, tree2->right) &&
                       isOpposite(tree1->right, tree2->left);
            }
        }
    }

    bool isSymmetric(TreeNode* root) {
        if (!root) {
            return true;
        }
        return isOpposite(root->left, root->right);
    }
};

/*
        1
    2       3
  4   5   6   7
*/

int main() {
    //int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    int arr[] = {1,2,4,-1,-1,5,-1,-1,2,5,-1,-1,4,-1,-1};
    TreeNode* root = 0;
    int index = 0;
    CreateBinaryTree(root, arr, index);
    PreOderTraverse(root);
    cout<<endl;

    Solution s;
    cout<<s.isSymmetric(root);

    return 0;
}

