
public class HashFunction {

		String[] theArray;
		int arraySize = 2657;
		int itemsInArray = 0;
		
		// Constructor
		HashFunction(int size) 
		{
			arraySize = size;
			theArray = new String[size];

			// Fill Array with -1 for each empty space
			fillArrayWithNeg1();
		}

		/**
		 * To fill Array with -1 for each empty space
		 */
		public void fillArrayWithNeg1() 
		{
			for (int n = 0; n < arraySize; n++) {
				theArray[n] = "-1";
			}
		}

		public void doubleHashFunc(String[] stringsForArray, String[] theArray) throws Exception 
		{
			for (int n = 0; n < stringsForArray.length; n++) 
			{
				// Store value in array index
				String newElementVal = stringsForArray[n];

				int UTFcode = UTF(newElementVal);

				int arrayIndexHash = UTFcode % arraySize;

				// Get the distance to skip down in the array after a collision occurs. 
				// We are doing this rather than just going to the next index to avoid creating clusters

				int stepDistance = 2047 - (UTFcode % 2047);

				// Create an index to store the value in by taking the modulus

				// System.out.println("step distance: " + stepDistance);
				// System.out.println("Modulus Index= " + arrayIndex + " for value"+ newElementVal);

				// Cycle through the array until we find an empty space
				while (theArray[arrayIndexHash] != "-1") {

					arrayIndexHash += stepDistance;

					// System.out.println("Collision Try " + arrayIndex + " Instead");
					// If we get to the end of the array go back to index 0

					arrayIndexHash %= arraySize;
				}

				theArray[arrayIndexHash] = newElementVal;
			}

		}

		/**
		 * For a string value: get the sum of the UTF codes for the "FOLDING METHOD"
		 * @param arr, a string name
		 * @return an integer value, UTF value
		 * @throws Exception
		 */
		public int UTF(String arr) throws Exception 
		{
			String s = arr;
			byte ptext[] = s.getBytes("UTF8");
			int sum = 0;

			for (int k = 0; k < ptext.length; k++) {
				int i = ptext[k];
				sum = sum + i; // ----->Sum of the UTF codes for the "FOLDING METHOD"
			}
			return sum;
		}

		/** 
		 * Returns the value stored in the Double Hashed Hash Table
		 * calculates number of probes to find a key, and its location index in a double hash table
		 * @param key, a string value, name to be search
		 * @throws Exception
		 */
		public String findKeyDblHashed(String key) throws Exception 
		{
			// Find the keys original hash key
			int count = 0;
			int UTFcode = UTF(key);
			int arrayIndexHash = UTFcode % arraySize;

			// Find the keys original step distance 
			int stepDistance = 2047 - (UTFcode % 2047);

			while (theArray[arrayIndexHash] != "-1") 
			{
				if (theArray[arrayIndexHash].compareTo(key) == 0) {
					count++;
					System.out.println("\tDOUBLE HASH FUNCTION :: Found; Number of Probes = " + count);
//					System.out.println("\tDOUBLE HASH FUNCTION :: Found at index " + arrayIndexHash + "; Number of Probes = " + count);

					// return arrayIndexHash;
					break;
				}
				arrayIndexHash += stepDistance;
				count++;

				arrayIndexHash %= arraySize;
			}

			if (theArray[arrayIndexHash] == "-1") {
				System.out.println("\tDOUBLE HASH FUNCTION :: NOT FOUND; Number of Probes = " + count);
			}
			return null;
			
			// Couldn't locate the key

		} // Returns the value stored in the Hash Table

		/** 
		 * To print the entire array (hash table) with list of names and index number
		 */
		public void displayTheStack() 
		{
			int increment = 0;
			int numberOfRows = (arraySize / 10) + 1;
			for (int m = 0; m < numberOfRows; m++) 
			{
				increment += 10;
				for (int n = 0; n < 71; n++)
					System.out.print("-");

				System.out.println();

				for (int n = increment - 10; n < increment; n++) {
					System.out.format("| %3s " + " ", n);
				}

				System.out.println("|");

				for (int n = 0; n < 71; n++)
					System.out.print("-");

				System.out.println();

				for (int n = increment - 10; n < increment; n++) 
				{
					if (n >= arraySize)
						System.out.print("|      ");

					else if (theArray[n].equals("-1"))
						System.out.print("|      ");

					else
						System.out.print(String.format("| %3s " + " ", theArray[n]));
				}

				System.out.println("|");

				for (int n = 0; n < 71; n++)
					System.out.print("-");

				System.out.println();

			}

		}

}
