/**
 * 
 * This class is for the grpahing of the speed of each Fib method
 *  
 * @author Raunak Sandhu
 * id - 30117897
 */

package application;

import javafx.scene.chart.XYChart;

public class Grapher {	// class Grapher
	public static void run(int[] vals){		// method run to create graph from array
		int start_time;		// declare start time
		int end_time;		// declare end time
		int runtime;		// declare run time
		XYChart.Series fib1 = new XYChart.Series<>();	// fib1 object
		FibAlgorithms tester = new FibAlgorithms();		// tester object
		for (int i = 0; i< vals.length; i++) {		// for loop for Fib1
			start_time = (int) System.nanoTime();	// start time
			tester.Fib1(vals[i]);		// rub Fib1
			end_time = (int) System.nanoTime();		// end time
			runtime = end_time - start_time;		// calculate run time
			fib1.getData().add(new XYChart.Data<>(vals[i], runtime));		// add data for fib1 object
		}
		
		XYChart.Series fib2 = new XYChart.Series<>();	// fib2 object
		for (int i = 0; i< vals.length; i++) {	// for loop for Fib2
			start_time = (int) System.nanoTime();	// start time
			tester.Fib2(vals[i]);		// run Fib2
			end_time = (int) System.nanoTime();		// end time
			runtime = end_time - start_time;		// calculate runtime
			fib2.getData().add(new XYChart.Data<>(vals[i], runtime));		// add data to fib2 object
		}
		XYChart.Series fib3 = new XYChart.Series<>();		// fib 3 object
		for (int i = 0; i< vals.length; i++) {		// for loop for Fib3
			start_time = (int) System.nanoTime();	// start time
			tester.Fib3(vals[i]);		// run Fib3
			end_time = (int) System.nanoTime();		// end time
			runtime = end_time - start_time;		//calculate runtime
			fib3.getData().add(new XYChart.Data<>(vals[i], runtime));		// add data to fib3 object
		}
		fib1.setName("Fib1");	// line title
		fib2.setName("Fib2");	// line title
		fib3.setName("Fib3");	// line title
		fibonacciChart lineChart = new fibonacciChart();	// lineChart object
		lineChart.setVals(fib1, fib2, fib3);		// set vals for lineChart
		fibonacciChart.launch(lineChart.getClass());	// launch method
		
	}
	public static void main(String[] args) {
		int[] array = new int[40];	// declare int array
		for (int i = 0; i< array.length; i++) {	// enter values into array
			array[i] = i + 1;
		}
		run(array);	// method run on array
	
	}
}
