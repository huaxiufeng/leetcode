/*
Compare two version numbers version1 and version1.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

*/

class Solution
{
public:
    int compareVersion(string version1, string version2) {
         while (version1.length() ||
                version2.length()) 
         {
             int v1 = firstLevel(version1);
             int v2 = firstLevel(version2);
             if (v1 > v2) {
                return 1;
             }
             if (v1 < v2) {
                return -1;
             }
         }
         return 0;
    }
private:
    int firstLevel(string& version) {
        int res = 0;
        int index = 0;
        while (index < version.length()) {
            if (version[index] == '.') {
                break;
            }
            res = res*10 + version[index] - '0';
            index++;
        }
        if (index == version.length()) {
            version = "";
        } else {
            version = version.substr(index+1);
        }
        return res;
    }
};
