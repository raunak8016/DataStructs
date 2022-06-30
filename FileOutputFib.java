/**
 * 
 * This class is for the file output with the speed of the Fib method
 *  
 * @author Raunak Sandhu
 * id - 30117897
 */

package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.chart.XYChart;

public class FileOutputFib {	// FileOutputFib class
	public static void fileOut(int[] vals){		// fileOut method
		try {	// error checking for file writing
		      FileWriter myWriter = new FileWriter("output.txt");	// declare new file
		      
				int start_time;		// declare start time
				
				int end_time;		// declare end time
				
				int runtime;		// declare run time
				
				FibAlgorithms tester = new FibAlgorithms();		// FibAlgorithms object
				for (int i = 0; i< vals.length; i++) {		// for loop for Fib1 on array
					start_time = (int) System.nanoTime();	// start time
					tester.Fib1(vals[i]);		// run Fib1
					end_time = (int) System.nanoTime();	// end time
					runtime = end_time - start_time;	// calculate runtime
				    myWriter.write("Fib1 computes F" + vals[i] + "  in " + runtime + " nanoseconds.\n");	// write to file
				}
				
			    myWriter.write("\n");		// new line
				for (int i = 0; i< vals.length; i++) {		// for loop for Fib2 on array
					start_time = (int) System.nanoTime();	// start time
					tester.Fib2(vals[i]);		// run Fib2
					end_time = (int) System.nanoTime();		// end time
					runtime = end_time - start_time;		// calculate run time
				    myWriter.write("Fib2 computes F" + vals[i] + "  in " + runtime + " nanoseconds.\n");	// write to file
				}
			    myWriter.write("\n");		// new line
				for (int i = 0; i< vals.length; i++) {		// for loop for Fib3 on array
					start_time = (int) System.nanoTime();	// start time
					tester.Fib3(vals[i]);		// run Fib3
					end_time = (int) System.nanoTime();		// end time
					runtime = end_time - start_time;		// calculate runtime
				    myWriter.write("Fib3 computes F" + vals[i] + "  in " + runtime + " nanoseconds.\n");	// write to file
				}
 		      myWriter.close();		//close writer
		      System.out.println("File written");		// confirm file is written to
		    } catch (IOException e) {	// catch error
		      System.out.println("Error");		// print error
		      e.printStackTrace();		// print stack trace
		    }

	}
	public static void main(String[] args) {	// testing
		int[] array = new int[40];	// declare array of a certain size
		for (int i = 0; i< array.length; i++) {		// enter values into array using loop
			array[i] = i + 1;
		}
		fileOut(array);		// run fileOut method
	
	}
}

