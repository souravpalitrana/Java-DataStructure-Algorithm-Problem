/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validipaddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity: O(1) Space Complexity O(1) because IP address part could not
 * be more than 255 so we can generate maximum 2^32 IP addresses. So it will not
 * increase with the input size and input is here maximum 12 character at most.
 * Thats why it is constant time and constant space 
 * @author souravpalit
 */
public class ValidIpAddresses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String addressString = "1921680";
        List<String> validIpAddreses = generateValidIpAddresses(addressString);
        
        for (String ip : validIpAddreses) {
            System.out.println(ip);
        }
    }
    
    public static List<String> generateValidIpAddresses(String string) {
        List<String> validIpAddresses = new ArrayList<String>();
        
        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String [] ipAddressParts = new String[4];
            ipAddressParts[0] = string.substring(0, i);
            
            if (!isValidIpPart(ipAddressParts[0])) {
                continue;
            }
            
            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                ipAddressParts[1] = string.substring(i, j);
                
                if (!isValidIpPart(ipAddressParts[1])) {
                    continue;
                }
                
                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    ipAddressParts[2] = string.substring(j, k); // Will count before k
                    ipAddressParts[3] = string.substring(k); // Will start from k to last
                    
                    if (isValidIpPart(ipAddressParts[2]) && isValidIpPart(ipAddressParts[3])) {
                        validIpAddresses.add(mergeIpParts(ipAddressParts));
                    }
                }
            }
        }
        
        return validIpAddresses;
    }
    
    public static boolean isValidIpPart(String addressPart) {
        int address = Integer.parseInt(addressPart);
        return address < 256 && 
                Integer.toString(address).length() == addressPart.length();
    }
    
    public static String mergeIpParts(String [] parts) {
        StringBuilder ipBuilder = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            ipBuilder.append(parts[i]);
            if (i != parts.length - 1) {
                ipBuilder.append(".");
            }
        }
        
        return ipBuilder.toString();
    } 
    
}
