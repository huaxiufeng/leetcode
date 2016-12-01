/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

#include <iostream>
#include <string>
#include <vector>
using namespace std;

double findKth(int* nums1, int nums1Size, int* nums2, int nums2Size, int k) {
    if (nums1Size > nums2Size) {
        return findKth(nums2, nums2Size, nums1, nums1Size, k);
    }
    if (nums1Size == 0) {
        return nums2[k-1];
    }
   
    if (k == 1) {
        return nums1[0] < nums2[0] ? nums1[0] : nums2[0];
    }

    int idx1 = k/2;
    if (idx1 > nums1Size) {
        idx1 = nums1Size;
    }
    int idx2 = k - idx1;

    if (nums1[idx1-1] < nums2[idx2-1]) {
        return findKth(nums1+idx1, nums1Size-idx1, nums2, nums2Size, k-idx1);
    } else if (nums1[idx1-1] > nums2[idx2-1]) {
        return findKth(nums1, nums1Size, nums2+idx2, nums2Size-idx2, k-idx2);
    } else {
        return nums1[idx1-1];
    }
}

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int total = nums1Size + nums2Size;
    double res = findKth(nums1, nums1Size, nums2, nums2Size, total/2 + 1);
    if (total % 2 == 0) {
        double res0 = findKth(nums1, nums1Size, nums2, nums2Size, total/2);
        res = (res + res0) / 2.0;
    }
    return res;
}

int main() {
/*
    int c[] = {3,4};
    int d[] = {0};
    cout<<findMedianSortedArrays(c, 2, d, 0)<<endl;
*/
/*
    int e[] = {3};
    int f[] = {4};
    cout<<findMedianSortedArrays(e, 1, f, 1)<<endl;
*/
    int g[] = {1,3};
    int h[] = {2,4};
    cout<<findMedianSortedArrays(g, 2, h, 2)<<endl;


    int a[] = {1,3,5,7,9,11};
    int b[] = {2,4,6,8,10};

    cout<<findMedianSortedArrays(a, 6, b, 5)<<endl;

    cout<<"Hello World"<<endl;
    return 0;
}

