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
    void binaryTreePaths(TreeNode* root, vector<int> &npath, vector<vector<int>> &result) {
        if (!root) {
            return;
        }
        
        npath.push_back(root->val);
        
        if (!root->left && !root->right) {
            // this is leaf
            result.push_back(npath);
        } else {
            binaryTreePaths(root->left, npath, result);
            binaryTreePaths(root->right, npath, result);
        }
        npath.pop_back();
    }

    vector<string> binaryTreePaths(TreeNode* root) {
        vector<int> npath;
        vector<vector<int>> result;
        vector<string> result_str;
        binaryTreePaths(root, npath, result);
        for (int i = 0; i < result.size(); i++) {
            string str;
            char buf[16];
            for (int j = 0; j < result[i].size(); j++) {
                if (j == 0) {
                    sprintf(buf, "%d", result[i][j]);
                } else {
                    sprintf(buf, "->%d", result[i][j]);
                }
                str += buf;
            }
            result_str.push_back(str);
        }
        return result_str;
    }
};

/*
        1
    2       3
  4   5   6   7
*/

int main() {
    int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    //int arr[] = {1,2,4,-1,-1,5,-1,-1,2,5,-1,-1,4,-1,-1};
    //int arr[] = {1,2,3,-1,-1,-1,-1};
    TreeNode* root = 0;
    int index = 0;
    CreateBinaryTree(root, arr, index);
    PreOderTraverse(root);
    cout<<endl;

    Solution s;
    s.binaryTreePaths(root);

    return 0;
}

