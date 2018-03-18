
/**
 * @author: Vedanshi Patel
 * Due Date: Tuesday, October 24th 2017
 * 
 * Purpose: QuickSort class is created to perform the Quick Sort in question 6. Sorts list of names in alphabetic order.
 */

public class QuickSort {
	
	private String[] array;
    private int length;
 
    public void sort(String[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        
        Sort(0, length - 1); //Sorting array by Quick Sort
    }
 
    private void Sort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        
        // taking pivot as middle index number
        String pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        
        // Divide into two arrays
        while (i <= j) {
            while (array[i].compareTo(pivot)<0) {
                i++; 
            }
            while (array[j].compareTo(pivot)>0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }   
        }
       
        // call quickSort() method recursively
        if (lowerIndex < j)
            Sort(lowerIndex, j);
        if (i < higherIndex)
            Sort(i, higherIndex);
    }
    
     
    private void exchangeNumbers(int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
