package assign1;

import java.util.*;
import java.io.*;

public class DataGenerator 
{

	
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		String dataSet[] = {"intel", "amd", "corsair", "seagate", "wd", "rgb", "gaming", "kingston", "nvidia", "radeon"};
		String options[] = {"s", "ro", "ra"};
		int dataSize = 0;
		int counter = 0;
		int ap = 0; //Was arrayPointer. Changed it to make the code shorter.
		int os = 0; //Was optionSelector - for the options chosen after the dataSet was completed (a, ro, ra, s, p q)
		int oc = 0; //Option counter. Setting to a hard ceiling of 10, not including the quit entry at the end.

		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the data size you wish to create: ");
		dataSize = input.nextInt();
				
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dataSet" + dataSize + ".txt", true))); //Let's me dynamically name the file
		
		while (counter < dataSize)
		{
			ap = (int) (Math.random() * dataSet.length);

			out.println("a " + dataSet[ap].toString());
					
			counter++;
		}	
		
		
		while (oc < 10)
		{
			
			ap = (int) (Math.random() * dataSet.length);
			os = (int) (Math.random() * options.length);

			out.println(options[os].toString() + " " + dataSet[ap].toString());
					
			oc++;
		}
		out.println("p");
		out.println("q");
		
		
		out.close();
	}

}
