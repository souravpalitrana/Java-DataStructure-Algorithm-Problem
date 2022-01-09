/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareofzeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n^3) Space Complexity: O(2)
 * @author souravpalit
 */
public class SquareOfZerosIterationOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 1, 1, 0, 1, 0})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        
        System.out.println("Is square matrix : " + squareOfZeroes(matrix));
    }
    
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        List<List<ZeroInfo>> infoMatrix = precomputeNumberOfZeros(matrix);
        int n = matrix.size();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int squareLength = 2;
                while (squareLength <= n - col && squareLength <= n - row) {
                    if (isSquareOfZeros(infoMatrix, row, col, squareLength)) {
                        return true;
                    }
                    squareLength++;
                }
                
            }
        }
        
        return false;
    }
    
    public static List<List<ZeroInfo>> precomputeNumberOfZeros(List<List<Integer>> matrix) {
        List<List<ZeroInfo>> infoMatrix = new ArrayList<List<ZeroInfo>>();
        int lastIdx = matrix.size() - 1;
        
        for (int row = 0; row <= lastIdx; row++) {
            List<ZeroInfo> inner = new ArrayList<ZeroInfo>();
            for (int col = 0; col <= lastIdx; col++) {
                int zeros = matrix.get(row).get(col) == 0 ? 1 : 0;
                inner.add(new ZeroInfo(zeros, zeros));
            }
            
            infoMatrix.add(inner);
        }
        
        
        for (int row = lastIdx; row >= 0; row--) {
            for (int col = lastIdx; col >= 0; col--) {
                if (matrix.get(row).get(col) == 1) continue;
                if (row < lastIdx) {
                    infoMatrix.get(row).get(col).zerosBelow += infoMatrix.get(row + 1).get(col).zerosBelow ;
                }
                
                if (col < lastIdx) {
                    infoMatrix.get(row).get(col).zerosRight += infoMatrix.get(row).get(col + 1).zerosRight ;
                }
            }
        }
        
        
        return infoMatrix;
    }
    
    public static boolean isSquareOfZeros(List<List<ZeroInfo>> zeroInfo, int rowIdx, int colIdx, int squareSize) { 
        ZeroInfo topLeft = zeroInfo.get(rowIdx).get(colIdx);
        ZeroInfo topRight = zeroInfo.get(rowIdx).get(colIdx + squareSize - 1);
        ZeroInfo bottomLeft = zeroInfo.get(rowIdx + squareSize - 1).get(colIdx);
        
        boolean isTopBorderZero = topLeft.zerosRight >= squareSize;
        boolean isLeftBorderZero = topLeft.zerosBelow >= squareSize;
        boolean isBottomBorderZero = bottomLeft.zerosRight >= squareSize;
        boolean isRightBorderZero = topRight.zerosBelow >= squareSize;
        
        return isTopBorderZero && isLeftBorderZero && isBottomBorderZero && isRightBorderZero;
    }
    
    public static class ZeroInfo {
        public int zerosBelow;
        public int zerosRight;
        
        public ZeroInfo(int zerosBelow, int zerosRight) {
            this.zerosBelow = zerosBelow;
            this.zerosRight = zerosRight;
        }
    }
    
}
