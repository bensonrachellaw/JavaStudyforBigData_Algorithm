package JZoffers;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //在两个正序数组中找第K小以及第K+1小的数；分别对应下标K-1、K。
        int m = nums1.length;
        int n = nums2.length;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        int k1 = (m+n+1)/2;
        int k2 = (m+n+1+1)/2;//注意这里两个的k是第k个，非下标。

        return (findKthInTwoArray(nums1,0,nums2,0,k1) + findKthInTwoArray(nums1,0,nums2,0,k2)) / 2.0;
    }

    private int findKthInTwoArray(int[] nums1,int i,int[] nums2,int j,int k){
        //函数的参数k是数量k，第k个的意思，非下标。
        //当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找第k个数字，直接就可以找出来了。
        if (i > nums1.length-1) return nums2[j+k-1];
        if (j > nums2.length-1) return nums1[i+k-1];
        if (k==1) {
            return Math.min(nums1[i],nums2[j]);//k=1说明要寻找两个数组中第一小的数；也说明找到了中位数，也就是从主方法第一次进入函数的所要求的第k个数。
            ////只要比较nums1和nums2的起始位置i和j上的数字就可以了,在两个有序数组中找第一个数。
        }
        //先在两个数组从起始位置开始取k/2个数的位置，如果越界，则说明该数组A没有这么多数了，不存在从起始位置开始第K/2个数字。则无法判断中位数是否在其中。
        //如果存在就取出来，否则就赋值上一个整型最大值。原因：赋值上一个整型最大值说明在后面将会砍掉另一个数组B的前k/2个数，因为即使另一个数组B的前k/2个数全部都大于A的全部，他们加起来也不会到第k个位置，因此可以砍掉。

        int mid1 = (i+k/2-1 < nums1.length) ? nums1[i+k/2-1]:Integer.MAX_VALUE;
        int mid2 = (j+k/2-1 < nums2.length) ? nums2[j+k/2-1]:Integer.MAX_VALUE;

        //二分砍半，每次都减少一半的数量，砍掉某个数组原来的下标为i，…… ，i+k/2-1的k/2个数；即起始位置往后移动k/2个位置
        //砍完一半后，k也要自减k/2，变成在两个数组剩下的里面找第k/2个数。
        if (mid2>mid1) {
            return findKthInTwoArray(nums1,i+k/2,nums2,j,k-k/2);
        }
        else {
            return findKthInTwoArray(nums1,i,nums2,j+k/2,k-k/2);
        }
    }
}
