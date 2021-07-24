/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowestcommonmanager;

/**
 *
 * @author souravpalit
 */
public class OrgInfo {
    
    int reportingNodeCount = 0;
    OrgChart lowestCommonManager;
    
    public OrgInfo(int reportingNodeCount, OrgChart lowestCommonManager) {
        this.reportingNodeCount = reportingNodeCount;
        this.lowestCommonManager = lowestCommonManager;
    }
    
}
