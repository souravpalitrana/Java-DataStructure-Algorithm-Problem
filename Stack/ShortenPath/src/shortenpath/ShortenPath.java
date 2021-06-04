/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortenpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Time Complexity: O(n) Space Complexity: O(n)
 * @author souravpalit
 */
public class ShortenPath {
    static String EMPTY = "";
    static String PATH_BACK = "..";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "../../../foo/../test/../test/../foo/bar//./baz";
        System.out.println(shortenPath(path));
    }
    
    public static String shortenPath(String path) {
        
        boolean isAbsolutePath = path.charAt(0) == '/';
        List<String> filteredPaths = filterPath(path.split("/"));
        Stack<String> stack = new Stack<String>();
        if (isAbsolutePath) stack.add("");
        
        for (String filteredPath : filteredPaths) {
            if (filteredPath.equals(PATH_BACK)) {
                if (stack.empty() || stack.peek().equals(PATH_BACK)) {
                    stack.push(filteredPath);
                } else if (!stack.peek().equals(EMPTY)) {
                    // It is not empty and not root so remove
                    stack.pop();
                }
            } else {  
                stack.push(filteredPath);
            } 
        }
        
        // When stack has only empty string which denotes only root
        // directory then we can return that directly
        if (stack.size() == 1 && stack.peek().length() == 0) {
            return "/";
        }
        
        return constructPath(stack);
    }
    
    public static List<String> filterPath(String [] paths) {
        List<String> filteredPaths = new ArrayList<String>();
        
        for (String path : paths) {
            if (path.length() > 0 && !path.equals(".")) {
                filteredPaths.add(path);
            }
        }
        
        return filteredPaths;
    }
    
    public static String constructPath(Stack<String> pathStack) {
        List<String> paths = new ArrayList<String>();
        while (!pathStack.isEmpty()) {
            String path = pathStack.pop();
            paths.add(path);
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = paths.size() - 1; i >=0; i--) {
            builder.append(paths.get(i));
            if (i != 0) {
                builder.append("/");
            }
        }
        
        return builder.toString();
    }
    
}
