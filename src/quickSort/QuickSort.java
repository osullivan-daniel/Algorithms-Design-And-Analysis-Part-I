package quickSort;

public class QuickSort 
{
	static int output[];
	static int total = 0;
	
	public static void sort(int input[])
	{
		System.out.print("Test");
		System.out.print(input.length);
		
		//partion1(input, 0, input.length - 1);
		//partion2(input, 0, input.length - 1);
		partion3(input, 0, input.length - 1);

		
		System.out.println("\n*****");
		for(int x : input)
			System.out.println(x);
		System.out.println("\n*****");
		
		System.out.println(total);

	}

	//Quick Sort using the left most element as the pivot
	private static void partion1(int[] input, int left, int right) 
	{
		if (left <= right)
		{		
			int pivit = input[left];
			int i = left + 1;
			
			for(int j = left+1; j<input.length; j++ )
			{
				if(input[j]<pivit)
				{
					swap(input, i, j);
					i++;
				}
			}

			swap(input, i-1,left);
			partion1(input,left, i-2);
			partion1(input,i, right);
			total += right - left;
		}
	}
	
	//Quick Sort using the right most element as the pivot
	private static void partion2(int[] input, int left, int right)
	{
		if(left<=right)
		{	
			swap(input, left, right);
			int pivot = input[left];
			int i = left + 1;
	
			for (int j= left + 1; j<=right; j++)
			{
				if(input[j]<=pivot)
				{
					swap(input, i, j);
					i++;
				}		
			}
		
			swap(input, i-1,left);
			partion2(input,left, i-2);
			partion2(input,i, right);
			total += right - left;	
		}
	}
	
	//Quick Sort using the median of three as the pivot
	private static void partion3(int[] input, int left, int right) 
	{			
		if(left<=right)
		{	
			int mid = (left + right)/2;
			median(input[left], input[mid], input[right], left,mid,right,input);
			
			int pivot = input[left];
			int i = left + 1;
	
			for (int j= left + 1; j<=right; j++)
			{
				if(input[j]<=pivot)
				{
					swap(input, i, j);
					i++;
				}		
			}
		
			swap(input, i-1,left);
			partion3(input,left, i-2);
			partion3(input,i, right);
			total += right - left;
		}
	}
		
	private static void median(int a, int b, int c, int l, int m, int r, int[] input) 
	{
	    if ( (a - b) * (c - a) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
	    {}
	    else if ( (b - a) * (c - b) >= 0 ) // b >= a and b <= c OR b <= a and b >= c
	    	swap(input, l, m);
	    else
	    	swap(input, l, r);
	}
	
	private static void swap(int[] input, int i, int j) 
	{
		int temp = input[j];
		input[j] = input[i];
		input[i] = temp;
	}
	
}