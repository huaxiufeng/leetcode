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

void InOderTraverse(TreeNode* root)
{
    if (root) {
        InOderTraverse(root->left);
        cout<<root->val<<" ";
        InOderTraverse(root->right);
    }
}

void PostOderTraverse(TreeNode* root)
{
    if (root) {
        PostOderTraverse(root->left);
        PostOderTraverse(root->right);
        cout<<root->val<<" ";
    }
}



class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, int prebegin, int preend, vector<int>& inorder, int inbegin, int inend) {
        if (prebegin > preend) {
            return NULL;
        }

        TreeNode* node = new TreeNode(preorder[prebegin]);

        int inindex = 0;
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == preorder[prebegin]) {
                inindex = i;
                break;
            }
        }
        int left_cnt = inindex - inbegin;
        int right_cnt = inend - inindex;

        node->left = buildTree(preorder, prebegin+1, prebegin+left_cnt, inorder, inbegin, inindex-1);
        node->right = buildTree(preorder, prebegin+left_cnt+1, preend, inorder, inindex+1, inend);
        
        return node;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (!preorder.size() || !inorder.size()) {
            return NULL;
        }
        return buildTree(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
    }
};

/*
        10
    5        15
  1   9    8    18
*/
int main() {
    int pre_arr[] = {10,5,1,9,15,8,18};
    int in_arr[] =  {1,5,9,10,8,15,18};

    vector<int> preorder(pre_arr, pre_arr+sizeof(pre_arr)/sizeof(int));
    vector<int> inorder(in_arr, in_arr+sizeof(in_arr)/sizeof(int));

    Solution s;
    TreeNode* root = s.buildTree(preorder, inorder);
    
    PreOderTraverse(root);
    cout<<endl;
    InOderTraverse(root);
    cout<<endl;
    PostOderTraverse(root);

    return 0;
}

