/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_8puzzle;

import Agents.SearchAgent;
import ProblemFormulation.Problem;

/**
 *
 * @author Omar
 */
public class Assignment1_8Puzzle
{

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) throws InterruptedException
    {
       java.util.HashSet<int[][]> set = new   java.util.HashSet<int[][]>();
        int[][] initialCondition = {{6,1,8},{4,0,2},{7,3,5}};
        
        
        set.add(initialCondition);
        int[][] hello = {{6,1,8},{4,0,2},{7,3,5}};
        
        
        System.out.println(set.contains(initialCondition));
        
        /*
        
      Problem p=new Problem(initialCondition);
      SearchAgent searchAgent = new SearchAgent();
      java.util.ArrayList<int[][]> solution = searchAgent.A_Manhattan(p);
      
      for(int i=0;i<solution.size();i++)
      {
          p.printState(solution.get(i));
          
      }
*/
        
    }
    
}
