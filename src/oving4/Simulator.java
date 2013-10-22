package oving4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class Simulator {
			
	public Simulator() {}

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
	
	public static void main(String[]args) {
		
//		JFrame window = new JFrame();		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//Read shit the shit
		System.out.print("Input the number of rows and columns: ");
		int sides = readInt(reader);
		
		System.out.print("Maximum number of eggs per row/column/diagonal: ");
		int max = readInt(reader);
		System.out.println();
/*
		window.setSize(sides*50, sides*50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
*/	
		//Close the bufferedreader
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Logic logic = new Logic(sides, max);
		Board solution = logic.saAlgorithm();
		lamePrint(solution);
	}
	
	public static void guiPrint(Board solution) {
		//TODO
	}
	
	public static void lamePrint(Board solution) {
		boolean[][] s = solution.getArray();
		for(int y=0; y<s.length; y++){
			System.out.print("|");
			for(int x=0; x<s.length; x++) {
				if(s[y][x])
					System.out.print("O|");
				else
					System.out.print(" |");
			}
			System.out.println();
		}
	}
}

