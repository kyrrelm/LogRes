package oving4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator {
	
	private BufferedReader reader;
	
	public static void main(String[]args) {
		//TODO
	}
	
	/**
	 * Support class for reading an int
	 * @param reader	The BufferedReader that'll be used.
	 * @return			Returning the read value.
	 */
	public static int readInt(BufferedReader reader) {
		try {
			return Integer.parseInt(reader.readLine());
		} catch (IOException ioe) {
			return 100; 
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public Simulator() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		//Read shit
		System.out.print("Input the number of rows: ");
		int rows = readInt(reader);
		System.out.println();
		
		System.out.print("Input the number of columns: ");
		int columns = readInt(reader);
		System.out.println();
		
		System.out.print("Maximum number of eggs per row/column/diagonal: ");
		int max = readInt(reader);
		System.out.println();
		
		boolean[][] array = new boolean[rows][columns];
		
		//Close the bufferedreader
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Skal vi gidde? kanskje?
	 */
	public void guiPrint(Board solution) {
		//TODO
	}
	
	public void lamePrint(Board solution) {
		//TODO
	}

}
