package javaoopproject.utils;

import java.math.BigInteger;
import java.util.Random;

import javaoopproject.algorithm.bubbleSorter;
import javaoopproject.exception.DataTypeException;
import javaoopproject.exception.NullException;
import javaoopproject.exception.OutOfBoundException;

public class StringUtils {
	private static int WEIGHT = 300;
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static int[] parseString(String str, int qtBound, int valueBound) 
    		throws DataTypeException, OutOfBoundException, NullException {
        str = str.replaceAll(" ","");
        String[] tokens = str.split(",");
        if (tokens.length == 1) {
            tokens = str.split(" ");
        }
        int[] inputArray = new int[tokens.length];
        if (isNullOrEmpty(str)) {
            throw new NullException("None of array was passed. Please pass an array.");
        }

        if (tokens.length > qtBound) {
            throw new OutOfBoundException("A valid array only contains up to " + qtBound + " elements");
        }

        try {
            for (int i = 0; i < tokens.length; i++) {
                if (new BigInteger(tokens[i]).compareTo(new BigInteger(valueBound + "")) > 0) {
                	throw new OutOfBoundException("A valid array only has max value smaller than " + valueBound);
                }
                inputArray[i] = Integer.parseInt(tokens[i]);
                if (inputArray[i] < 0) {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException e) {
            throw new DataTypeException("A valid array only contains positive integers");
        }

        return inputArray;
    }
    
    public static int[]generateListNumbers(){
        int[] list = new int[20];

        Random random = new Random();
        for(int i = 0; i < list.length; i++){
            list[i] = random.nextInt(WEIGHT);
        }

        return list;
    }
}
