
public class SelectionSort {
	
	/**
	 * To sort list of names in alphabetic order by Selection Sort
	 * @param arr, String array
	 */
	public void Selection_Sort(String[] arr){
        
	       for (int i = 0; i < arr.length - 1; i++)
	       {
	           int index = i;
	           for (int j = i + 1; j < arr.length; j++)
	               if (arr[index].compareTo(arr[j])>0) 
	                   index = j;
	     
	           String smallerNumber = arr[i];  
	           arr[i] = arr[index];
	           arr[index] = smallerNumber;
	       }
	   }

}
