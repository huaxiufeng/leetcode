/*
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
["ate", "eat","tea"],
["nat","tan"],
["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
Update (2015-08-09):
The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here. If you still see your function signature return a list<string>, please click the reload button  to reset your code definition.
*/

#include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

class Solution {
public:
    bool isAnagram(const string& str1, const string& str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int stat1[256], stat2[256];
        memset(stat1, 0, sizeof(stat1));
        memset(stat2, 0, sizeof(stat2));
        for (int i = 0; i < str1.length(); i++) {
            stat1[str1.at(i)]++;
            stat2[str2.at(i)]++;
        }

        return memcmp(stat1, stat2, sizeof(stat1)) == 0;
    }

    unsigned long strSum(const string& str) {
        unsigned long res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += str.at(i);
        }
        return res;
    }

    vector< vector<string> > groupAnagrams(vector<string>& strs) {            
        vector< vector<string> > res;
        map< unsigned long, vector<int> > tab;

        for (int i = 0; i < strs.size(); i++) {
            string word = strs[i];
            unsigned long sum = strSum(word);
            if (tab.find(sum) == tab.end()) {
                res.push_back(vector<string>(1, word));
                int index = res.size()-1;
                tab[sum] = vector<int>(1, index);
            } else {
                bool found = false;
                vector<int>& idx_list = tab[sum];
                for (int j = 0; j < idx_list.size(); j++) {
                    int k = idx_list[j];
                    vector<string>& list = res[k];
                    if (isAnagram(word, list[0])) {
                        list.push_back(word);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    res.push_back(vector<string>(1, word));
                    int index = res.size()-1;
                    tab[sum].push_back(index);
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            sort(res[i].begin(), res[i].end());
        }

        return res;
    }
};

int main() {
    const char *array[] = {"eat", "eat", "fas", "fas"};
    //const char *array[] = {"tho","tin","erg","end","pug","ton","alb","mes","job","ads","soy","toe","tap","sen","ape","led","rig","rig","con","wac","gog","zen","hay","lie","pay","kid","oaf","arc","hay","vet","sat","gap","hop","ben","gem","dem","pie","eco","cub","coy","pep","wot","wee"};
    vector<string> strs(array, array+sizeof(array)/sizeof(void*));

    Solution s;
    vector< vector<string> > res = s.groupAnagrams(strs);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

