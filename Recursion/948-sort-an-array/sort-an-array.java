class Solution {
    public int[] sortArray(int[] nums) {

        mergeSort(nums,0,nums.length-1);
        return nums;
        
    }

    public void mergeSort(int[] nums, int low,int high){

        if(low>=high){
            return;
        }

        int mid = (low + high )/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        sort(nums, low,mid,high);
    }

    public void sort(int[] nums, int low, int mid, int high){

        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int[] result = new int[n1+n2];

        for(int i=0;i<n1;i++){
            left[i] = nums[low+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = nums[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=0;

        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                result[k] = left[i];
                i++;
                k++; 
            }
            else if(right[j] < left[i]){
                result[k] = right[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            result[k] = left[i];
            i++;
            k++;
        }
        
        while(j<n2){
            result[k] = right[j];
            j++;
            k++;
        }

        for(int m=0;m<n1+n2;m++){
            nums[low + m] = result[m];
        }

    }
}