/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowestcommonmanager;

/**
 * Time Complexity: O(n) and Space Complexity: O(d)
 * @author souravpalit
 */
public class LowestCommonManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrgChart orgChartH = new OrgChart('H');
        OrgChart orgChartI = new OrgChart('I');
        OrgChart orgChartD = new OrgChart('D');
        orgChartD.addDirectReports(new OrgChart [] {orgChartH, orgChartI});
        
        OrgChart orgChartB = new OrgChart('B');
        OrgChart orgChartE = new OrgChart('E');
        orgChartB.addDirectReports(new OrgChart [] {orgChartD, orgChartE});  
        
        OrgChart orgChartF = new OrgChart('F');
        OrgChart orgChartG = new OrgChart('G');
        OrgChart orgChartC = new OrgChart('C');
        orgChartC.addDirectReports(new OrgChart [] {orgChartF, orgChartG});
        
        OrgChart orgChartA = new OrgChart('A');
        orgChartA.addDirectReports(new OrgChart [] {orgChartB, orgChartC});
        
        OrgChart orgChart = getLowestCommonManager(orgChartA, orgChartE, orgChartI);
        System.out.println(orgChart.name);
    }
    
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager; 
    }
    
    public static OrgInfo getOrgInfo(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        if (topManager == null) {
            return new OrgInfo(0, null);
        }
         
        int count = 0;
        if (topManager == reportOne || topManager == reportTwo) {
            count++;
        }
        
        for (OrgChart orgChart : topManager.directReports) {
            OrgInfo orgInfo = getOrgInfo(orgChart, reportOne, reportTwo);
            if (orgInfo.reportingNodeCount == 2) {
                return orgInfo;
            } else {
                count += orgInfo.reportingNodeCount;
            }
        }
        
        if (count == 2) {
            return new OrgInfo(count, topManager);
        } else {
            return new OrgInfo(count, null);
        }
    }
}
