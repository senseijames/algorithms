package stanford.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;

public class StanfordUtils
{
	public static int[] get_array_from_file (String filename)
	{
		int num_lines = 0;
		try {
			num_lines = get_num_lines (filename);
		}
		catch (Exception e) { }
		
		int[] return_array = new int[num_lines];
		
		try {
			// Open the file
//			FileInputStream fstream = new FileInputStream (filename);
			// Buffered Reader that shit
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			// Add to an Array
			int i = 0;
			String line;
			while ((line = br.readLine()) != null) {
				return_array[i++] = Integer.valueOf(line);			
			}
			
			br.close();
			
//			return return_array;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return return_array;
		}
	}
	
	// http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	public static int get_num_lines (String filename) throws IOException
	{
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    ++count;
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
	public static void array_swap (int[] array, int one, int two)
	{
		int holder = array[one];
		array[one] = array[two];
		array[two] = holder;
	}

	public static void print_array (int[] array)
	{
		System.out.println ("Length " + array.length + " " + Arrays.toString (array));
	}
}
