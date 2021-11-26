public class merge{
    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 3, 9, 4, 1, 7, 10, 6};
        print(MergeSort(arr));
    }

    public static int[] MergeSort(int[] arr){
        if (arr.length == 1) 
            return arr;
        
        int mid = arr.length / 2;
        int rem = arr.length % 2;

        int[] left = Copy(arr, 0, mid, mid);
        int[] right = Copy(arr, mid, arr.length, mid + rem);

        left = MergeSort(left);
        right = MergeSort(right);

        return Merge(left, right);
    }

    public static int[] Copy(int[] arr, int start, int end, int size){
        int[] copy = new int[size];
        int index = 0;
        for (int i = start; i < end; i++){
            copy[index] = arr[i];
            index++;
        }
        return copy;
    }
    
    public static int[] Merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0; int index = 0;
        while (i < left.length || j < right.length){
            if (i == left.length){
                merged[index] = right[j];
                index++;
                j++;
            }
            
            else if (j == right.length){
                merged[index] = left[i];
                index++;
                i++;
            }
            
            else if (left[i] < right[j]){
                merged[index] = left[i];
                index++;
                i++;
            }
            else if (left[i] > right[j]){
                merged[index] = right[j];
                index++;
                j++;
            }
        }
        return merged;
    }
    
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
