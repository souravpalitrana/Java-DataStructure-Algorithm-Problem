package validipaddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(1) Space Complexity O(1) because the input could not be
 * greater than 12 character
 * @author souravpalit
 */
public class ValidIPAddresses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "1921680";
        List<String> validIPAddresses = findValidIPAddresses(str);
        
        for (String ip : validIPAddresses) {
            System.out.println(ip);
        }
    }
    
    public static List<String> findValidIPAddresses(String str) {
        List<String> validAddresses = new ArrayList<String>();
        
        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String [] ipAddressParts = new String[4];
            ipAddressParts[0] = str.substring(0, i);
            if (!isValidAddressPart(ipAddressParts[0])) {
                continue;
            }
            
            // first part is valid. now find out second part
            for (int j = i + 1; j < i + Math.min(str.length() - i, 4); j++) {
                ipAddressParts[1] = str.substring(i, j);
                if (!isValidAddressPart(ipAddressParts[1])) {
                    continue;
                }
                
                for (int k = j + 1; k < j + Math.min(str.length() - j, 4); k++) {
                     ipAddressParts[2] = str.substring(j, k);
                     ipAddressParts[3] = str.substring(k);
                     
                     if (isValidAddressPart(ipAddressParts[2]) && isValidAddressPart(ipAddressParts[3])) {
                         validAddresses.add(mergeIPParts(ipAddressParts));
                     }
                }
            }
            
        }
        
        return validAddresses;
    }
    
    public static boolean isValidAddressPart(String str) {
        int part = Integer.parseInt(str);
        return (part < 256 && str.length() == Integer.toString(part).length());
    }
    
    public static String mergeIPParts(String [] parts) {
        StringBuilder ipStringBuilder = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            ipStringBuilder.append(parts[i]);
            if (i != parts.length - 1) {
                ipStringBuilder.append(".");
            }
        }
        
        return ipStringBuilder.toString();
    }
    
}
