//Darren Zhu
//Period 2
import java.util.Arrays;

public class ArrayMethod3 
{

	public static void main(String[] args) 
	{
		String [] test1 = { "apple", "cucumber", "microsoft", "zorro", "banana", "cherry", "mahogany", "oreos", "pinata"};
		int [] test2 = {2,5,1,7,3,8,21,11,13,43,4};
		int n = test2.length;
		
		long start = System.nanoTime();
		String [] mergeResult = mergeSort(test1);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Mergesort test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		long start1 = System.nanoTime();
		quicksort(test2, 0, n-1);
		long end1 = System.nanoTime();
		long time1 = end1 - start1;
		System.out.println("Quicksort test took: " + time1 + " nanoseconds");
        printArray(test2);

	}
	
	public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
	
	public static String[] mergeSort(String[] list)
	{
		//Base Case
		if(list.length <= 1)
		{
			return list;
		}

		String [] left = Arrays.copyOfRange(list, 0, (list.length / 2));
		String [] right = Arrays.copyOfRange(list, list.length / 2, list.length);
				
		return (merge(mergeSort(left), mergeSort(right)));
	}
	
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] list3 = new String[list1.length + list2.length];//Creates a new array with the combine length of the two arrays being merged
	    int i = 0, j = 0, k = 0;//declare variables
	    while (i < list1.length && j < list2.length)//run following as long as i < array 1's length and j is < array 2's length
	    {
	         if (list1[i].compareTo(list2[j]) <= 0) // use compareto to find correct letter order if it is <= 0 then it is in correct order
	         {
	             list3[k] = list1[i];//fill the new array
	             i++;
	         } 
	         else //if not in correct order that the value in the second array to fill the new array
	         {
	             list3[k] = list2[j];
	             j++;
	         }
	         k++;//index increase on new array
	    }
	    while(i < list1.length)//prevents index out of bound
	    {
	    	list3[k] = list1[i];
	        k++;
	        i++;
	    }
	    while(j < list2.length)//prevents index out of bound
	    {
	    	list3[k] = list2[j];
	        k++;
	        j++;
	    }
	    return list3;
	}
	
	public static int partition(int [] list1, int front, int back)
	{
		int pivot = list1[back];
		int i = (front - 1);
		for(int j = front; j < back; j++)
		{
			if(list1[j] <= pivot)
			{
				i++;
				//swaps value at index i with index j
				int temp = list1[i];
				list1[i] = list1[j];
				list1[j] = temp;
			}
		}
		//swap list[i+1] with list1[back]
		int temp = list1[i + 1];
		list1[i+1] = list1[back];
		list1[back] = temp;
		return i + 1;
	}
	
	public static void quicksort(int [] list1, int front, int back)
	{
		if(front < back)
		{
			int pivotPos = partition(list1, front, back); //call partition
			
			quicksort(list1, front, pivotPos - 1); //divides array in half and call quick sort on it
			quicksort(list1, pivotPos + 1, back);
		}
	}
}
