/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youngestcommonanchestor;

/**
 * Time Complexity O(d) and Space O(1)
 * @author souravpalit
 */
public class YoungestCommonAnchestor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AncestralTree topAncestor = new AncestralTree('A');
        AncestralTree ancestorB = new AncestralTree('B', topAncestor);
        AncestralTree ancestorC = new AncestralTree('C', topAncestor);
        
        AncestralTree ancestorD = new AncestralTree('D', ancestorB);
        AncestralTree ancestorE = new AncestralTree('E', ancestorB);
        
        AncestralTree ancestorF = new AncestralTree('F', ancestorC);
        AncestralTree ancestorG = new AncestralTree('G', ancestorC);
        
        AncestralTree ancestorH = new AncestralTree('H', ancestorD);
        AncestralTree ancestorI = new AncestralTree('I', ancestorD);
        
        AncestralTree youngestCommonAncestor = 
                getYoungestCommonAncestor(topAncestor, ancestorE, ancestorI);
        System.out.println("Youngest common ancestor is : " + 
                youngestCommonAncestor.name);
    }
    
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, 
            AncestralTree descendantOne, AncestralTree descendantTwo) {
        int descendantOneLevel = getLevel(topAncestor, descendantOne);
        int descendantTwoLevel = getLevel(topAncestor, descendantTwo);
        
        if (descendantOneLevel > descendantTwoLevel) {
            descendantOne = moveUpByLevel(descendantOne, descendantOneLevel - descendantTwoLevel);
        } else {
            descendantTwo = moveUpByLevel(descendantTwo, descendantTwoLevel - descendantOneLevel);
        }
        
        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        
        return descendantOne;
    }
    
    public static int getLevel(AncestralTree topAncestor, AncestralTree descendant) {
        int levelCount = 0;
        
        while (descendant != topAncestor) {
            descendant = descendant.ancestor;
            levelCount++;
        }
        
        return levelCount;
    }
    
    public static AncestralTree moveUpByLevel(AncestralTree descendant, int levelToMoveUP) {
        for (int i = levelToMoveUP; i > 0; i--) {
            descendant = descendant.ancestor;
        }
        
        return descendant;
    }
}
