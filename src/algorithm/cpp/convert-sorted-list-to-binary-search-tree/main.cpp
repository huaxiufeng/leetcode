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

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

void AddList(ListNode* &head, int value)
{
    if (!head) {
        head = new ListNode(value);
    } else {
        ListNode* p = head;
        while (p->next) {
            p = p->next;
        }
        ListNode* tail = new ListNode(value);
        p->next = tail;
    }
}

void DisplayList(ListNode* head)
{
    ListNode* p = head;
    while (p) {
        cout<<p->val<<" ";
        p = p->next;
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
    TreeNode* sortedListToBST(ListNode* head) {
        if (head == NULL) {
            return NULL;
        }
        ListNode *faster = head, *slow = head, *slow0 = head;
        while (faster) {
            faster = faster->next;
            if (faster) {
                faster = faster->next;
            } else {
                break;
            }
            slow0 = slow;
            slow = slow->next;
        }
        slow0->next = NULL;
        TreeNode *node = new TreeNode(slow->val);
        node->left = head == slow ? NULL : sortedListToBST(head);
        node->right = sortedListToBST(slow->next);
        return node;

    }
};

int main() {
    ListNode* head = 0;
    AddList(head, 1);
    AddList(head, 2);
    AddList(head, 3);
    AddList(head, 4);
    AddList(head, 5);
    AddList(head, 6);
    //AddList(head, 7);
    DisplayList(head);

    Solution s;
    TreeNode *root = s.sortedListToBST(head);
    InOderTraverse(root);

    return 0;
}

