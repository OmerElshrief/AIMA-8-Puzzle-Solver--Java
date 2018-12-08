/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemFormulation;

import Utils.SearchHelper;

/**
 *
 * @author Omar
 */
public class Node
{
    private int state[][];
    private Node parentNode;
    private int path;
    private SearchHelper helper;
    public  int action;
    int manhattan_distance=0;
    int euclidean_distance=0;

    public int getManhattan_distance()
    {
        return manhattan_distance;
    }

    public void setManhattan_distance(int manhattan_distance)
    {
        this.manhattan_distance = manhattan_distance;
    }

    public int getEuclidean_distance()
    {
        return euclidean_distance;
    }

    public void setEuclidean_distance(int euclidean_distance)
    {
        this.euclidean_distance = euclidean_distance;
    }
   

    public Node(int[][] state, Node parentNode, int path,int action)
    {
        this.state = state;
        this.parentNode = parentNode;
        this.path = path;
        this.action=action;
        helper = SearchHelper.getInstance();
       
    }
    
    public Node(Node node)
    {
        this.state = node.state;
        this.parentNode = node.parentNode;
        this.path = node.path;
        this.action = node.action;
         helper = SearchHelper.getInstance();
       
    }

    public int[][] getState()
    {
        return state;
    }

    public void setState(int[][] state)
    {
        this.state = state;
    }

    public Node getParentNode()
    {
        return parentNode;
    }

    public void setParentNode(Node parentNode)
    {
        this.parentNode = parentNode;
    }

    public int getCost()
    {
        return path;
    }

    public void setStepCost(int path)
    {
        this.path = path;
    }
    
    
    
    //////Heuristics
    
    
    /*
    Manhattan Distance
     It is the sum of absolute values of dierences in the goal's x and y coordinates and the
     current cell's x and y coordinates respectively,
    */
    public int getHeuristicManhattan()
    {
        int manhattan_distance=0;
        int block;
        int goalBlock;
        int index[];
        int x, y;
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                if(i==0&&j==0) //We don't need the Epty block
                {
                    
                }
                    else
                {
                    block = 3*i +j;
                    index = helper.getindex(state, block);
                    x = helper.getAbsDifference(index[0], i);
                    y= helper.getAbsDifference(index[1], j);
                    
                    manhattan_distance=manhattan_distance+x+y;
                    
                    
                }
                    
            } 
               this.manhattan_distance = manhattan_distance;
        
        return manhattan_distance;
    }
    
    public int getHeuristicEuclidean()
    {
        
        int euclidean_distance=0;
        int block;
        
        int index[];
        int x, y;
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                if(i==0&&j==0) //We don't need the Epty block
                {
                    
                }
                    else
                {
                    block = 3*i +j;
                    index = helper.getindex(state, block);
                    x = helper.getDifferenceSquare(index[0], i);
                    y= helper.getDifferenceSquare(index[1], j);
                    
                    euclidean_distance=euclidean_distance+x+y;
                    
                 }
                    
            } 
               this.euclidean_distance = euclidean_distance;
        
        return euclidean_distance;
    }
    
    
}
