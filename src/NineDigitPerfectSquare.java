import java.util.Arrays;

/**
 * CS2010 (Hilary Term) - Assignment 1
 *
 * Nine Digit Perfect Square
 *
 * A natural number, p, is a perfect square if for some natural number k, k^2=p.
 * For example, 16 is a perfect square, as 4^2=16. The number 20 is not a
 * perfect square as there is no natural number k such that k^2=20.
 *
 * Problem: Develop an algorithm that will find all nine-digit perfect squares
 * that use all nine digits exactly once. For example, 139,854,276 is a solution
 * (the first) as 11,826^2=139,854,276.
 *
 * 1) Fill in the implementation of the methods described in this file.
 *
 * 2) Test your implementation by developing suitable test suite in the
 * NineDigitPerfectSquareTest JUnit test case.
 *
 * @author:Auxa
 * Assignment 1 solution for Algos 31-1-16
 *
 */

public class NineDigitPerfectSquare {

    /**
     * A method to return an array containing all squares between low and high
     *
     * @param low: lowest perfect square
     * @param high: largest perfect square
     *
     * @return an array containing all the perfect squares between low and high
     */
    public int[] perfectSquaresBetween(int low, int high){
    	
    	int[] allSquares = floor_sqrt(low, high);
       return allSquares;
    }
    int[] floor_sqrt(int min, int x){
    	int odd, s, r; 
    	odd=1;
    	s=1;
    	r=0;
    	int[] perfectSqrz = new int [x/80];
    	while(s<=x){
    	//	r++;
    		odd+=2;
    		s=s+odd;
        	
        	if(s>min && s< x){
        		perfectSqrz[r++]= s;
        		//r++;
        		//System.out.println("S " +s + " " + r);
        	}

    	}
    	return perfectSqrz;
    }
    public int countNineDigitPerfectSquares(){
        return getNineDigitPerfectSquares().length;
    }

    /**
     * A method to determine if the number specified in parameter "number"
     * contains all 9 digits exactly once.
     *
     * @param number
     *            : A number to be tested
     * @return whether the number contains all 9 digits exactly once
     */
    public boolean containsAllDigitsOnce(int number) {
    	
    	int[] check = {1,2,3,4,5,6,7,8,9};
    	for(int i =0; i< check.length; i++){
    		int temp = number %10;
    		number = number/10;
    		if(temp == 0){
    			return false;
    		}
    		else if(check[temp-1]!=0){
    			check[temp-1]=0;
    		}else{
    			return false;
    		}
    	}
    	
      return true;
    }


    /**
     * A method to return an array containing all the squares discovered
     *
     * @return an array containing all of the perfect squares which
     * contain all digits 1..9 exactly once.
     */
    public int[] getNineDigitPerfectSquares() {
    	
    	int[] perfectSqrtNonFormat = perfectSquaresBetween(123456789, 987654321);
    	int numPossible = perfectSqrtNonFormat.length;
    	for(int i =0; i< perfectSqrtNonFormat.length; i++){
    		if(containsAllDigitsOnce(perfectSqrtNonFormat[i]) == false){
    			perfectSqrtNonFormat[i] =0;
    			numPossible--;
    		}
    	}
    	int[] nineDigit = new int[numPossible];
    	int j=0;
    	for(int i = 0; i< perfectSqrtNonFormat.length;i++){
    		if(perfectSqrtNonFormat[i]!=0){
    			nineDigit[j] = perfectSqrtNonFormat[i];
    			j++;
    		}
    	}
    	
        return nineDigit;

    }
}