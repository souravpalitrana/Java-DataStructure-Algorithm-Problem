/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floodfill;

/**
 * Implement a function that one might see on many image editing programs. This
 * is, given a screen (represented by a two-dimensional array of colors), a point,
 * and a new color, fill in the surrounding area until the color changes from the
 * original color
 * @author souravpalit
 */
public class FloodFill {

    /* Considering we have a two dimensional array as an image where each value
     * is like an image pixel. Where Consider three color. 0 means black, 1 means
     * white and 2 means blue. Consider the array has only black and white color 
     * and we want to replace black color with blue.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [][] image = { 
            {0,0,0,0,0}, 
            {0,1,1,1,0}, 
            {0,1,0,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0}};
        
        // Select a point to start coloring
        int rowPos = 0;
        int colPos = 2;
        int oldColor = 0;
        int newColor = 2;
        floodFill(image, rowPos, colPos, oldColor, newColor);
        
        System.out.println();
        printImage(image);
    }
    
    public static void floodFill(int [][] image, int row, 
            int col, int oldColor, int newColor) {
        
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        } else {
            // If the position has target color then we will work
            if (image[row][col] == oldColor) { 
                image[row][col] = newColor;
                
                printImage(image);
                
                floodFill(image, row - 1, col, oldColor, newColor); // Top
                floodFill(image, row + 1, col, oldColor, newColor); // Bottom
                floodFill(image, row, col - 1, oldColor, newColor); // Left
                floodFill(image, row, col + 1, oldColor, newColor); // Right
                
                
            }
            
            return;
        }
    }
    
    public static void printImage(int [][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }
    }
    
}
