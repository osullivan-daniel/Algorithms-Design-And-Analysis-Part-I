package inversions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test 
{
	public static void main(String args[])
	{
		long total=0;
		Scanner scan = null;
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		try
		{
			scan = new Scanner(new File("IntegerArray.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. Missing File");
			System.exit(0);
		}
		
		while(scan.hasNextInt())
		{
			input.add(scan.nextInt());
		}
		
		int num[] = new int[input.size()];

		for (int i=0; i < num.length; i++)
		{
			num[i] = input.get(i).intValue();
		}
		
		for(int i: num)
		{
			total += i;
			System.out.println(i);
		}
		
		System.out.println(total);
		
		Inversions.sort(num);
	}
}
