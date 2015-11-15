#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <unordered_set>
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

class Solution {
public:
    bool isOneDiff(const string& lstr, const string& rstr) {
        if (lstr.length() != rstr.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < lstr.length(); i++) {
            if (lstr[i] - rstr[i]) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
/*
    int ladderLength0(string beginWord, string endWord, unordered_set<string>& wordList, unordered_set<string>& used) {
        cout<<"matching "<<beginWord<<" "<<endWord<<endl;
        if (isOneDiff(beginWord, endWord) == 1) {
            cout<<"got!"<<endl;
            return 1;
        }

        int res = 0;
        for (auto itor=wordList.begin(); itor != wordList.end(); itor++) {
            if (used.find(*itor) != used.end()) {
                cout<<*itor<<" already used"<<endl;
                continue;
            }
            if (isOneDiff(beginWord, *itor) != 1) {
                cout<<*itor<<" do not match"<<endl;
                continue;
            }
            used.insert(*itor);
            int len = ladderLength0(*itor, endWord, wordList, used);
            used.erase(*itor);

            if (!len) {
                cout<<"cut!"<<endl;
                continue;
            }

            if (res == 0) {
                res = len + 1;
            } else if (len+1 < res) {
                res = len + 1;
            }
            cout<<"--------- "<<res<<endl;
        }
        return res;
    }
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        unordered_set<string> used;
        return 1+ladderLength0(beginWord, endWord, wordList, used);
    }
    */
    int ladderLength(string beginWord, string endWord, unordered_set<string>& dict) {
        if (dict.count(beginWord) == 0 || dict.count(endWord) == 0)
            return 0;

        queue<pair<string, int> > que;
        que.push(make_pair(beginWord, 1));
        dict.erase(beginWord);

        while (!que.empty()) {
            pair<string, int> cur = que.front(); que.pop();
            cout<<"# pop front "<<cur.first<<endl;
            cout<<"# dict size "<<dict.size()<<endl;
            for (auto it = dict.begin(); it != dict.end(); ) {
                cout<<"\tchecking "<<*it<<endl;
                if (isOneDiff(cur.first, *it)) {
                    cout<<"\t\tdiff is 1"<<endl;
                    if (*it == endWord) return cur.second + 1;
                    que.push(make_pair(*it, cur.second + 1));
                    cout<<"\t\tpush to queue and erase from dict"<<endl;
                    it = dict.erase(it);
                } else ++it;
            }
        }
        return 0;
    }
};

int main() {
    string beginWord = "hit";
    string endWord = "cog";

    unordered_set<string> wordList;
    wordList.insert("hot");
    wordList.insert("dot");
    wordList.insert("dog");
    wordList.insert("lot");
    wordList.insert("log");
    wordList.insert("hit");
    wordList.insert("cog");

    Solution s;
    cout<<s.ladderLength(beginWord, endWord, wordList)<<endl;
    return 0;
}

