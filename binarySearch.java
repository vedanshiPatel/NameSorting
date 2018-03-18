
public class binarySearch {
	
	/**
	 * To find a name in a list of names using binary search
	 * find index position and number of comparisons
	 * @param a, an array that contains list of names (string values)
	 * @param x, a string value, name to be search
	 */
	public void binary_Search(String[] a, String x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		int count = 0;
		while (low <= high) {
			mid = (low + high) / 2;

			if (a[mid].compareTo(x) == 0) {
				System.out.print("\tBINARY SEARCH :: found at position(s) = " + mid);

				int mid1 = mid + 1, mid2 = mid - 1; // ----->In case of Duplicate Values

				while (a[mid1].compareTo(x) == 0) {
					if (a[mid1].compareTo(x) == 0) {
						System.out.print(", " + mid1 + " ");
						mid1++;
						count++;
					}
				}

				while (a[mid2].compareTo(x) == 0) {
					if (a[mid2].compareTo(x) == 0) {
						System.out.print(", " + mid2 + " ");
						mid2--;
						count++;
					}
				}

				System.out.println("; Number of Comparisons = " + count);

				break;
			}

			else if (a[mid].compareTo(x) < 0) {
				low = mid + 1;
				count++;
			}

			else if (a[mid].compareTo(x) > 0) {
				high = mid - 1;
				count++;
			}
		}

		if (low > high) {
			System.out.println("\tBINARY SEARCH :: NOT FOUND; Number of Comparisons = " + count);
		}

	}

}
