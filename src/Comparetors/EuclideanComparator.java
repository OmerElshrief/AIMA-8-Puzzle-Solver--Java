/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparetors;

import ProblemFormulation.Node;
import java.util.Comparator;

/**
 *
 * @author Omar
 */
public class EuclideanComparator implements Comparator<Node> 
{

    @Override
    public int compare(Node o1, Node o2)
    {
        if(o1.getCost()+o1.getHeuristicEuclidean()< o2.getCost()+o2.getHeuristicEuclidean())
        {
            return -1;
        }
        
         else if(o1.getCost()+o1.getHeuristicManhattan() == o2.getCost()+o2.getHeuristicManhattan())
            {
                if(o1.action < o2.action)
                    return -1;
                else return 1;
                
            }
         
          else return 1;
            
        }
    
    }
    

