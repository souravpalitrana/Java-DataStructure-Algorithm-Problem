/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentattendancerecordii;

/**
 *
 * @author souravpalit
 */
public class StudentAttendanceRecordII {

    /**
     * @param args the command line arguments
     */
    static int count = 0;
    public static void main(String[] args) {
        checkRecord(4);
        System.out.println(count);
    }
    
    public static int checkRecord(int n) {
        return generate("", 0, n, new Info(n));
    }
    
    private static int generate(String s, int position, int n, Info info) {
        /*if (position == n - 1 && info.isAnyLeft()) {
            return info.leftCount();
        }*/
        
        if (position == n && checkRecord(s)) {
            count++;
            return 1;
        }
        
        int ways = 0;
        if (info.remainingA > 0) {
            Info newInfo = new Info(info.remainingA - 1, info.remainingL, info.remainingP); 
            ways += generate(s + "A", position + 1, n, newInfo);
        }
        
        if (info.remainingL > 0) {
            Info newInfo = new Info(info.remainingA, info.remainingL - 1, info.remainingP); 
            ways += generate(s + "L", position + 1, n, newInfo);
        }
        
        if (info.remainingP > 0) {
            Info newInfo = new Info(info.remainingA, info.remainingL, info.remainingP - 1); 
            ways += generate(s + "P", position + 1, n, newInfo);
        }
        
        return ways;
    }
    
    public static boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
    }
    
    static class Info {
        int remainingL = 2;
        int remainingA = 1;
        int remainingP = 3;
        
        public Info(int remainingP) {
            this.remainingP = remainingP;
        }
        
        
        public Info(int remainingA, int remainingL, int remainingP) {
            this.remainingA = remainingA;
            this.remainingL = remainingL;
            this.remainingP = remainingP;
        }
        
        public boolean isAnyLeft() {
            return remainingL != 0 || remainingA != 0 || remainingP != 0;
        }
        
        public int leftCount() {
            int count = 0;
            if (remainingA != 0) {
                count++;
            }
            
            if (remainingL != 0) {
                count++;
            }
            
            if (remainingP != 0) {
                count++;
            }
            
            return count;
        }
        
    }
    
}
