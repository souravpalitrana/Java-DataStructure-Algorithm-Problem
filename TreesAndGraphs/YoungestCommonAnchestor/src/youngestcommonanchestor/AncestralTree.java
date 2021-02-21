/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youngestcommonanchestor;

/**
 *
 * @author souravpalit
 */
public class AncestralTree {
    
    public char name;
    public AncestralTree ancestor;
    
    public AncestralTree(char name) {
        this.name = name;
    }
    
    public AncestralTree(char name, AncestralTree ancestor) {
        this.name = name;
        addAncestor(ancestor);
    } 
    
    public void addAncestor(AncestralTree ancestor) {
        this.ancestor = ancestor;
    }
}
