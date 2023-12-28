package test;


public class BinarySearch {

    public static void main(String[] args) {
        binarySearch();
    }

    static void binarySearch(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int item = 6;
        int index = 0;
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high)/2;
        while(low <= high){
            if(arr[mid] == item){
                System.out.println("Item found at index " + mid);
                break;
            }
            else if(arr[mid] < item){
                low = mid + 1;
            }
            else if(arr[mid] > item){
                high = mid - 1;
            }
            mid = (low + high)/2;
        }
        if(low > high){
            System.out.println("Item not found");
        }
    }
}
