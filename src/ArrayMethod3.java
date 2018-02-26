import java.util.Arrays;

public class ArrayMethod3 
{

	public static void main(String[] args) 
	{
		String [] test1 = { "apple", "cucumber", "microsoft", "zorro", "banana", "cherry", "mahogany", "oreos", "pinata"};
		int [] test2 = {2,5,1,7,3,8,21,11,13,43,4};
		
		long start = System.nanoTime();
		String [] mergeResult = mergeSort(test1);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Mergesort test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		long start1 = System.nanoTime();
		quicksort(test2, 0, 10);
		long end1 = System.nanoTime();
		long time1 = end1 - start1;
		System.out.println("Quicksort test took: " + time1 + " nanoseconds");
		System.out.println(Arrays.toString(test2));

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
		String[] list3 = new String[list1.length + list2.length];
	    int i = 0, j = 0, k = 0;
	    while (i < list1.length && j < list2.length)
	    {
	         if (list1[i].compareTo(list2[j]) <= 0) 
	         {
	             list3[k] = list1[i];
	             i++;
	         } 
	         else 
	         {
	             list3[k] = list2[j];
	             j++;
	         }
	         k++;
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
			
		}
		return i + 1;
	}
	
	public static void quicksort(int [] list1, int front, int back)
	{
		if(back < front)
		{
			int pivotPos = partition(list1, front, back);
			
			quicksort(list1, front, pivotPos - 1);
			quicksort(list1, pivotPos + 1, back);
		}
	}

}
