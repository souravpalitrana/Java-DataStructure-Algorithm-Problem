/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanevaluation;

/**
 * Given a boolean expression consisting of the symbols 0 (false), 1 (true) & (AND)
 * | (OR) and ^ (XOR) and a desired boolean result value result. Implement a 
 * function to count the number of ways of parenthesizing the expression such that
 * it evaluates to result. The expression should be fully parenthesized (e.g (0)^(1))
 * but not extraneously (e.g. (((0))^(1)))
 * @author souravpalit
 */
public class BooleanEvaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String expression = "1^0|0|1";
        //String expression = "0&0&0&1^1|0";
        String expression = "0|1^1&0";
        boolean result = true;
        System.out.println(countEval(expression, result));
    }
    
    public static int countEval(String s, boolean result) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1: 0;
        
        int ways = 0;
        
        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1, s.length());
            
            // Evaluate each side for each result
            int leftTrue = countEval(left, true);
            int rightTrue = countEval(right, true);
            int leftFalse = countEval(left, false);
            int rightFalse = countEval(right, false);
            
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            
            int totalTrue = 0;
            
            if (c == '^') { // required 1 true and 1 false
                totalTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
            }
            
            int subWays = result ? totalTrue : total - totalTrue;
            
            ways+= subWays;
        }
        
        return ways;
    }
    
    public static boolean stringToBool(String c) {
        return c.equals("1") ? true : false;
    }
    
}
