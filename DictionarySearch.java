
public class DictionarySearch {
	
	/**
	 * To find a name in a list of names using dictionary search (number of character used in search increments by 1 at each loop)
	 * find index position and number of comparisons
	 * @param a, an array that contains list of names (string values)
	 * @param x, a string value, name to be search
	 */
	public void dictionarySearch(String[] a, String x) {
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		int count = 0;

		while ((a[high].compareTo(a[low]) != 0) && (x.compareTo(a[low]) >= 0) && (x.compareTo(a[high]) <= 0)) 
		{

			double sumofdiff1 = 0, sumofdiff2 = 0;
			double diff1 = 0, diff2 = 0;

			int l = 0;
			int pow = 0;

			while (l < x.length() && l < a[low].length()) // Stop the loop as soon as either strings runs out of characters
			{ 
				
				if (a[low].charAt(l)>122) // low will increment by 1, when there is special character
				{
					low++;
				}
				diff1 = x.charAt(l) - a[low].charAt(l);
				sumofdiff1 = sumofdiff1 + diff1 * Math.pow(27, pow--);
				l++;
			}

			int l1 = 0;
			int pow1 = 0;

			while (l1 < a[high].length() && l1 < a[low].length()) // Stop the loop as soon as either strings runs out of characters
			{ 
				if (a[high].charAt(l1)>122) // high will decrement by 1, when there is a special character
				{
					high--;
				}
				diff2 = a[high].charAt(l1) - a[low].charAt(l1);
				sumofdiff2 = sumofdiff2 + diff2 * Math.pow(27, pow1--);
				l1++;
			}

			mid = (int) (low + ((sumofdiff1 * (high - low)) / sumofdiff2));

			if (mid >= low && mid <= high) 
			{
				if (x.compareTo(a[mid]) == 0) {
					count++;
					break;
				} else if (x.compareTo(a[mid]) > 0) {
					count++;
					low = mid + 1;

				} else if (x.compareTo(a[mid]) < 0) {
					count++;
					high = mid - 1;
				}

			}
		} // ... End of WHILE LOOP

		if (x.compareTo(a[mid]) == 0) 
		{
			System.out.print("\tDICTIONARY SEARCH :: found at position(s) = " + mid);

			int mid1 = mid + 1, mid2 = mid - 1; // ----->In case of Duplicate values

			while (a[mid1].compareTo(x) == 0) 
			{
				if (a[mid + 1].compareTo(x) == 0) {
					System.out.print(", " + mid1);
					mid1++;
					count++;
				}
			}
			
			while (a[mid2].compareTo(x) == 0) 
			{
				if (a[mid2].compareTo(x) == 0) {
					System.out.print(", " + mid2 + " ");
					mid2--;
					count++;
				}
				count++;
			}
			
			System.out.println("; Number of Comparisons = " + count);
			
		} else {
			count++;
			System.out.println("\tDICTIONARY SEARCH :: NOT FOUND; Number of Comparisons = " + count);
		}

		if (low > high) {
			count++;
			System.out.println("\tDICTIONARY SEARCH :: NOT FOUND; Number of Comparisons = " + count);
		}

	}

}
