package firstproject;

import java.util.Arrays;
import java.util.Random;

public class firstclass {
	private static final float GRAVITY = 9.8f;

	public static void main(String[] args) {
		
		//------------------------------ 0. uzd. ---------------------------------
		
		System.out.println("//------------------------------ 0. uzd. ---------------------------------");
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
				"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
				"Kate"};
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
				299, 343, 317, 265};
		
		int howManyElements = names.length;
		if(names.length >= times.length) {
			howManyElements = times.length;
		}
		
		for(int i = 0; i < howManyElements; i++) {
			System.out.println(names[i]+ " " + times[i] + "sec");
		}
		
		
		//------------------------------ 1. uzd. ---------------------------------
		
		System.out.println("//------------------------------ 1. uzd. ---------------------------------");
		try {
			double res1 = positionCalc(10, 5, 20);
			System.out.println("Bumbinas pozicija ir " + res1 + " m");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//------------------------------ 2. uzd. ---------------------------------
		
		System.out.println("//------------------------------ 2. uzd. ---------------------------------");
		
		try {
			int fact1 = factorialForLoop(5);
			System.out.println("Factorial is " + fact1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//------------------------------ 3. uzd. ---------------------------------
		
		System.out.println("//------------------------------ 3. uzd. ---------------------------------");
		try {
			double[] mas = generateArray(10, 3, 10);
			System.out.println(Arrays.toString(mas));
			double meanValue = getMean(mas);
			System.out.println("Videja vertiba ir " + meanValue);
			
			double[] testarr = arraySort(mas);
			System.out.println("Bubble sorted array " + Arrays.toString(testarr));
			
			double min = getMin(mas);
			double max = getMax(mas);
			
			System.out.println("Min: " + min);
			System.out.println("Max: " + max);
			
			//------------------------------ 4. uzd. ---------------------------------
			
			System.out.println("//------------------------------ 4. uzd. ---------------------------------");
			double[][] matrix = generateMatrix(4);
			System.out.println(Arrays.deepToString(matrix));
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	static double positionCalc(double initialVelocity, double
			initialPosition, double fallingTime) throws Exception {

		if(initialVelocity >= 0 && initialPosition >= 0 && fallingTime >= 0){
			
			double result = 0.5 * GRAVITY * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;

			return result;
		}else {
			throw new Exception("Nevar aprekinat, jo kads no ievades datiem nav korekts");
		}
	}
	
	private static int factorialForLoop(int N) throws Exception{
		if(N > 0) {
			int res = 1;
			for(int i = 1; i <= N; i++) {
				res *= i;
			}
			return res;
		}else {
			throw new Exception("Ievades dati negativi");
		}
	}
	
	private static double[] generateArray(int N, double lower, double upper) throws Exception{
		
		if(N<=0) {
			throw new Exception("Nevar izveidot masivu, kura garums ir negativs");
		}
		
		double result[] = new double[N];
		Random rand = new Random();
		
		for(int i = 0; i < result.length; i++) {
			result[i] = rand.nextDouble(lower, upper);
		}
		return result;
	}
	private static double getMean(double[] array) throws Exception{
		if(array == null) { // ienakosais masivs ir bez references jeb nav notikusi inicializacija
			throw new Exception("Ienakosais masivs nav inicializets");
		}
		if(array.length == 0) {
			throw new Exception("nevar aprekinat videjo vertibu, jo masiva nav elementu");
		}
		double sum = 0;
		/*
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		*/
		
		// for each
		for(double tempA : array) {
			sum += tempA;
		}
		
		double meanValue = sum/array.length;
		return meanValue;
		
	}
	
	
	private static double[] arraySort(double[] array) throws Exception{
		if(array == null || array.length == 0) {
			throw new Exception("probllems with array");
		}else {
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array.length-1; j++) {
					if(array[i] < array[j]) {
						double temp = array[j];
						array[j] = array[i];
						array[i] = temp;
					}
				}
			}
			return array;
		}
	}

	private static double getMin(double[] array) throws Exception{
		if(array == null || array.length == 0) {
			throw new Exception("problems with array");
		}else {
			double[] sortedarr = arraySort(array);
			return sortedarr[0];
		}
	}
	
	private static double getMax(double[] array) throws Exception{
		if(array == null || array.length == 0) {
			throw new Exception("problems with array");
		}else {
			double[] sortedarr = arraySort(array);
			return sortedarr[array.length-1];
		}
	}
	
	private static double[][] generateMatrix(int N) throws Exception{
		if(N <= 0) {
			throw new Exception("Mevar izveidot masivu, kura garums ir negativs");
		}
		
		double[][] array = new double[N][N];
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = rand.nextDouble();
			}
		}
		
		return array;
 	}

//	double getMax(double[] array)


}
