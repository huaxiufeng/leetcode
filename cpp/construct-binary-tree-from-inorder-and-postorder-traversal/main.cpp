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
    TreeNode* buildTree(vector<int>& inorder, int inbegin, int inend, vector<int>& postorder, int postbegin, int postend) {
        if (inbegin > inend) {
            return NULL;
        }

        TreeNode* node = new TreeNode(postorder[postend]);

        int inindex = 0;
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == postorder[postend]) {
                inindex = i;
                break;
            }
        }
        int left_cnt = inindex - inbegin;
        int right_cnt = inend - inindex;

        node->left = buildTree(inorder, inbegin, inindex-1, postorder, postbegin, postbegin+left_cnt-1);
        node->right = buildTree(inorder, inindex+1, inend, postorder, postbegin+left_cnt, postend-1);
        
        return node;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (!postorder.size() || !inorder.size()) {
            return NULL;
        }
        return buildTree(inorder, 0, inorder.size()-1, postorder, 0, postorder.size()-1);
    }
};

/*
        10
    5        15
  1   9    8    18
*/
int main() {
    int in_arr[] =  {1,5,9,10,8,15,18};
    int post_arr[] = {1,9,5,8,18,15,10};

    vector<int> inorder(in_arr, in_arr+sizeof(in_arr)/sizeof(int));
    vector<int> postorder(post_arr, post_arr+sizeof(post_arr)/sizeof(int));

    Solution s;
    TreeNode* root = s.buildTree(inorder, postorder);
    
    PreOderTraverse(root);
    cout<<endl;
    InOderTraverse(root);
    cout<<endl;
    PostOderTraverse(root);

    return 0;
}

