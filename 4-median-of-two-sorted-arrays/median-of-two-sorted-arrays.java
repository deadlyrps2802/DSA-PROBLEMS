class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1==0 && n2 == 0) return (double) 0;
     int[] arr = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;
        int indx ;
        double median ;

        while(i<n1 && j<n2){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
    while(i<n1) arr[k++] = nums1[i++];
    while(j<n2) arr[k++] = nums2[j++];

    int n = arr.length;

    if(n % 2 != 0){
         median = (double) (arr[(n/2)]);
    }
    else{
        median = (double) (arr[n/2] + arr[n/2-1])/2;
         
    }
  return median;
    }
}