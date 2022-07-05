/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiontorecurringdecimal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class FractionToRecurringDecimal {

    // Confused about time complexity
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        // If both value anyone of the value is negative then the result
        // will be negative. If both value is negative in that case the
        // result is positive thats why we are inserting "" string
        result.append((numerator < 0 ^ denominator < 0) ? "-" : "");
        // Now we can eliminate negative sign from the number
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        
        // now we can do the division part
        result.append(String.valueOf(dividend / divisor));
        long reminder = dividend % divisor;
        
        if (reminder == 0) {
            // That means we have result without fraction
            return result.toString();
        }
        
        // We have reminder that means we have fraction. So adds decimal to result
        result.append(".");
        // Now we have to track reminder because if same reminder comes we need
        // to place brackets instead of processing it. Now we have remainder so 
        // in a map we put reminder and the length of current result. Why? Suppose
        // current length is 2 as our result has "0." and our remainder is 4. So if 
        // we get 4 later again then we check 4 is present in the map or not. If present
        // that means when we started processing reminder we need to give a starting bracket
        // there which is 2. As same result will produce so we will stop here by adding end           // bracket at last
        Map<Long, Integer> seenReminder = new HashMap<>();
        seenReminder.put(reminder, result.length());
        while (reminder != 0) {
            // Now what we do in the real math. As reminder is small we need to add zero to
            // the right of the reminder. So multiply reminder with 10
            reminder *= 10;
            // Calculate result again
            result.append(reminder / divisor);
            // now caclulate reminder again
            reminder %= divisor;
            
            if (seenReminder.containsKey(reminder)) {
                result.insert(seenReminder.get(reminder), "(");
                result.append(")");
                break;
            } else {
                // We have to store the reminder
                seenReminder.put(reminder, result.length());
            }
        }
        
        return result.toString();
    }
    
}
