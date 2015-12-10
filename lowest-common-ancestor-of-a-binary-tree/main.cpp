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
    void getNodePath(TreeNode* root, TreeNode* target, vector<TreeNode*>& path) {
        if (!root) {
            return;
        }
        path.push_back(root);
        if (root == target) {
            return;
        }
        getNodePath(root->left, target, path);
        if (path[path.size()-1] == target) {
            return;
        }
        getNodePath(root->right, target, path);
        if (path[path.size()-1] == target) {
            return;
        }
        path.pop_back();
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root) {
            return NULL;
        }
        if (root == p || root == q) {
            return root;
        }
        vector<TreeNode*> ppath, qpath;
        getNodePath(root, p, ppath);
        getNodePath(root, q, qpath);

        TreeNode* lowest = root;
        for (auto pitor = ppath.begin(), qitor = qpath.begin();
             pitor != ppath.end() && qitor != qpath.end();
             pitor++, qitor++) {
            if (*pitor != *qitor) {
                return lowest;
            } else {
                lowest = *pitor;
            }
        }
        return lowest;
    }
};

/*
        1
    2       3
  4   5   6   7
*/

int main() {
    int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    TreeNode* root = 0;
    int index = 0;
    CreateBinaryTree(root, arr, index);
    PreOderTraverse(root);
    cout<<endl;

    Solution s;

    return 0;
}

