package inversions;

import java.util.Arrays;

public class Inversions 
{
	static int output[];
	static long inver;

	
	public static void sort(int input[])
	{
		output = split(input);		
		System.out.print(inver);
	}
	
	public static int[] split(int input[])
	{
		if(input.length > 1)
		{
			int middle = input.length/2; 
			
			int left[] = Arrays.copyOfRange(input, 0, middle);
			int right[] = Arrays.copyOfRange(input,middle, input.length);			
			
			int sortedLeft[] = split(left);
			int sortedRight[] = split(right);
			int sorted[] = mergeCountInver(sortedLeft, sortedRight);
			return sorted;
		}
		else
			return input;
	}

	public static int[] mergeCountInver(int left[], int right[])
	{			
		int temp[] = new int[left.length + right.length];
		
		int i = 0;
		int j = 0;
				
		while ((i < left.length) && (j < right.length))
		{
			if(left[i]<right[j])
			{
				temp[i+j] = left[i++];
			}
			else
			{
				temp[i+j] = right[j++];
				inver += left.length - i;
			}
		}
		
		while (i < left.length)
			temp[i+j] = left[i++];
		while (j < right.length)
			temp[i+j] = right[j++];
					
		return temp;		
	}
}
