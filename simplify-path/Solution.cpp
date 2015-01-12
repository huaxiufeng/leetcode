/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

class Solution
{
public:
    string simplifyPath(string path) {
        stack<string> path_stack;
        int front = 0;
        while (front < path.length()) {
            int end = front + 1;
            while (end < path.length()) {
                if (path.at(end) == '/') {
                    break;
                }
                end++;
            }
            string folder = path.substr(front+1, end-front-1);
            if (folder == ".") {
            } 
            else
            if (folder == "..") {
                if (path_stack.size()) {
                    path_stack.pop();
                }
            } 
            else {
                if (folder.length()) {
                    path_stack.push(folder);
                }
            }
            if (end == path.length()) {
                break;
            }
            front = end;
        }
        string simple_path;
        while (path_stack.size()) {
            simple_path = "/" + path_stack.top() + simple_path;
            path_stack.pop();
        }
        if (!simple_path.length()) {
            simple_path = "/";
        }
        return simple_path;
    }
};
