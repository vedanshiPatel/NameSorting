import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author: Vedanshi Patel
 * Due Date: Tuesday, October 24th 2017
 * 
 * Purpose: Sorting list of names in alphabetic order from an input file using QuickSort and selection method.
 * Also performing searching using binary search, dictionary search, and double hash methods.
 */

public class Sorting_Seaching {
	
	/**
	 * To convert names into Uppercase
	 * TO KEEP UNIFORMITY IN COMPARISON
	 * @param array, String values
	 */
	private static void uppercase(String[] array) 
	{
		for (int i = 0; i < array.length; i++) {
			String s1 = array[i].substring(1, 2).toUpperCase();
			array[i] = s1 + array[i].substring(2);
		}
	}

	/**
	 * To remove any access white space from a string
	 * @param array, an array that contains string values
	 */
	private static void trim(String[] array) 
	{
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i].replaceAll("\\s+", " ").trim();
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		
		File file= new File("C:\\Users\\Ved\\Documents\\Workspace\\Names_Sorting_Searching\\src\\RandomNames.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		Scanner scan = new Scanner(file);    // USING SELECTION SORT ON THIS
		Scanner scan2 = new Scanner(file);   //USING QUICK SORT ON THIS
		
		int ctr=0;
		
		try{
			
			while(br.readLine()!=null){
				ctr++;
		}
	  
	  String[] words= new String[ctr];	// words - array will be sorted using SELECTION SORT
	  String[] words2= new String[ctr];	// words2 - array will be sorted using QUICK SORT
	  
	 // Initializing both arrays
	  for(int i=0; i<ctr; i++){
		  words[i]=scan.nextLine();
		  words2[i]= words[i]; 
	  	  }
	  	
	  uppercase(words);	//CONVERTING ALL INITIAL LETTERS TO CAPITAL TO KEEPING UNIFORMITY IN COMPARISON
	  trim(words);
	  uppercase(words2);
	  trim(words2);
	  
	  long startTime = System.nanoTime();
	  SelectionSort ss = new SelectionSort ();
	  ss.Selection_Sort(words); // Selection Sort method called
	  long endTime = System.nanoTime();
	  long duration = (endTime - startTime); 
	  
	  System.out.println("\n********** Sorted List **********");
	  for(int k = 0; k < ctr; k++){
		  System.out.println(words[k]);  //PRINTING THE SORTED LIST
	  	}
	  
	  System.out.println("\nTotal Number of names = " + ctr);
	  System.out.println("\nTime Taken By Selection Sort = "+ duration +" nano seconds");

	  
	  long quickstartTime = System.nanoTime();
	  QuickSort qs = new QuickSort();
	  qs.sort(words2);     // QUICK SORT FUNCTION CALLED
	  long quickendTime = System.nanoTime();
	  long quickduration = (quickendTime - quickstartTime); 
	  
	  System.out.println("\nTime Taken By Quick Sort = "+ quickduration+" nano seconds");
	  System.out.println("\nQuick Sort is approximtely "+ duration/quickduration +" times faster than Selection Sort");
	  
	  
	  HashFunction theFunc = new HashFunction(2657);

		// Demonstrate how data normally follows patterns and how
		// a non-prime sized array can cause havoc

		theFunc.doubleHashFunc(words, theFunc.theArray);
		
		binarySearch bs = new binarySearch();
		DictionarySearch ds = new DictionarySearch();
		

		// To print entire hash table.
//		theFunc.displayTheStack();
		
//		System.out.println("\n**************************  END OF HASH TABLE (for reference only)  **************************\n");
		
	  
	  // Performing dictionary search and binary search on number of target strings
	  String target [] = {"Azevedo, Ana", "Silva, Rui", "Boussebough, Imane", "Terracina, Giorgio", "Lefebvre, Peter", "Houghten, Sher", "Revesz, Peter"};
			
	  System.out.println("\nBinary Search Vs Dictionary Search \n");
				
	  for (int i=0; i<target.length; i++)
	  {
		  System.out.println((i+1) + ") " + target[i]);
		  bs.binary_Search(words, target[i]);
		  ds.dictionarySearch(words, target[i]);
		  theFunc.findKeyDblHashed(target[i]);

		  
		  System.out.println();
		  
	  }
	  
	  // "Silva, Rui" is repeated 2 times in the list
	  // "Lefebvre, Peter" "Houghten, Sher" - not in the list
	  
	  br.close();
	  scan.close();
	  
	}
		catch (Exception e)
		{
			System.out.println("File Doesn't have any Names");
		}	
	}

}
