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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
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
    void pathSum0(TreeNode* root, int sum, vector<int>& line, vector<vector<int>>& result) {
        if (!root) {
            return;
        }
        line.push_back(root->val);
        if (root->val == sum && root->left == NULL && root->right == NULL) {
            result.push_back(line);
        } else {
            if (root->left) {
                pathSum0(root->left, sum-root->val, line, result);
            }
            if (root->right) {
                pathSum0(root->right, sum-root->val, line, result);
            }
        }
        line.pop_back();
    }

    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> result;
        if (!root) {
            return result;
        } 
        vector<int> line;
        pathSum0(root, sum, line, result);
        return result;
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
    
    vector<vector<int>> result;
    result = s.pathSum(root, 8);
    display(result);

    return 0;
}

