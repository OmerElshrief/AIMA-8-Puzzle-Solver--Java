/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemFormulation;


import assignment1_8puzzle.UI;
import java.util.ArrayList;

/**
 *
 * @author Omar
 */
public class Problem
{

    final private int initialState[][];
    private java.util.ArrayList<Node> expandedNodes ;
   
    final private int goalState[][] =
    {
        {
           0 , 1, 2
        },
        {
            3, 4, 5
        },
        {
            6, 7, 8
        }
    };

    public Problem(int initialState[][])
    {
        this.initialState = initialState;
        expandedNodes = new ArrayList();
        
        
    }

    public ArrayList<Node> getExpandedNodes()
    {
        return expandedNodes;
    }

    public void setExpandedNodes(ArrayList<Node> expandedNodes)
    {
        this.expandedNodes = expandedNodes;
    }

    public int[][] getInitialState()
    {
        return initialState;
    }

    public int[] actions(int state[][])
    {
        /*   
        Return the actions that can be executed in the given
        state. The result would typically be a list, but if there are
        many actions, consider yielding them one at a time in an
        iterator, rather than building them all at once.
         */
 /*
        Actions are:-
        1- going North (represented by 1
        2- going South (represented by 2
        3- going East (represented  by 3
        4- going West (represented  by 4
         */
        int[] position = getZeroPosition(state); //function to get the Zero Position from the 2D Array

        if (position == null)
        {
            return null;
        }

        if (position[0] == 0 && position[1] == 0) //First
        {
            int actions[] =
            {
               2,3
            }; //South and East
            return actions;
        }
        if (position[0] == 0 && position[1] == 1)
        {
            int actions[] =
            {
                2,4,3
            }; //South , West and West
            return actions;
        }
        if (position[0] == 0 && position[1] == 2)
        {
            int actions[] =
            {
                2, 4
            }; //South and West
            return actions;
        }

        if (position[0] == 1 && position[1] == 0)
        {
            int actions[] =
            {
                1, 2, 3
            };  //North,South and East
            return actions;
        }
        if (position[0] == 1 && position[1] == 1)
        {
            int actions[] =
            {
                1, 2, 3,4
            }; //North,South,East and West 
            return actions;
        }
        if (position[0] == 1 && position[1] == 2)
        {
            int actions[] =
            {
                1, 2, 4
            }; //Norht, south and West
            return actions;
        }

        if (position[0] == 2 && position[1] == 0)
        {
            int actions[] =
            {
                1, 3
            }; //North and East
            return actions;
        }
        if (position[0] == 2 && position[1] == 1)
        {
            int actions[] =
            {
                1, 3,4
            }; //North and East and West
            return actions;
        }
        if (position[0] == 2 && position[1] == 2)
        {
            int actions[] =
            {
                1, 4
            }; //North adn West
            return actions;
        }

        return null;
    }

    public int[][] getNewState(int action, int[][] state)
    {
        int[] position = getZeroPosition(state);
        int i = position[0], j = position[1];

        int[][] newState = new int[3][3];

         clone(state,newState);

        switch (action)
        {
            case 1: //Action of the Zero going NORTH
                swap(i, j, i - 1, j, newState); //Swapping the Zero Region with the Upper Region by 
                break;

            case 2: //Action of going SOUTH
                swap(i, j, i + 1, j, newState); //Swapping the Zero Region with the Lower Region by 
                break;
            case 3: //Action of going EAST
                swap(i, j, i, j + 1, newState); //Swapping the Zero Region with the Right Region by 
                break;

            case 4: //Action of going WEST
                swap(i, j, i, j - 1, newState); //Swapping the Zero Region with the Right Region by
                break;
        }
       // System.out.println(newState.equals(state));
        // printState(newState);
        return newState;

    }

    public boolean isGoal(int[][] state) //Function to check wether the given state is goal state or Not 
    {
        int counter = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (state[i][j] != counter)
                {
                    return false;
                } else
                {
                    counter++;
                }
            }
        }
        return true;
    }

    public java.util.ArrayList getSolution(Node node,ArrayList<Node> expanded,ArrayList<Node> frontier,int searchDepth) throws InterruptedException
    {
        
        
        int depth =0;
        java.util.ArrayList<int[][]> solutions = new java.util.ArrayList(); //List that will hold the steps to the Goal state;
        java.util.ArrayList<String> actions = new java.util.ArrayList();   //List that will hold the Actions executed to reach the goal..
        solutions.add(node.getState());
        UI ui = UI.getInstance();
        ui.numberOfExpandedNodes.setText(String.valueOf(expanded.size()));
        ui.pathCost.setText(String.valueOf(node.getCost()));
        
        while (node.getParentNode() != null)
        {   
            
            switch(node.action)
            {
                case 1: actions.add("UP");
                break;
                case 2: actions.add("DOWN");
                break;
                case 3: actions.add("RIGHT");
                break;
                case 4: actions.add("Left");
                break;
            }
            depth++;
            
            node = node.getParentNode();
            solutions.add(node.getState());
        }
        
        String path="";
        for(int i=actions.size()-1;i>=0;i--)
        {
            path +=String.valueOf(actions.get(i))+"-";
        }
        ui.searchDepth.setText(String.valueOf(depth));
        ui.pathToTheGoal.setText(path);
        ui.maxDepth.setText(String.valueOf(searchDepth));
         
        return solutions;
    }

    private void swap(int a, int b, int a1, int b1, int[][] newState)  //In-Place swapping function
    {

        int temp = new Integer(newState[a][b]);
        newState[a][b] = new Integer(newState[a1][b1]);
        newState[a1][b1] = new Integer(temp);

    }

    private int[] getZeroPosition(int state[][]) //Function to get the position of Zero (Where the Empty square is)
    //Return an array[2] {i,j}
    {
       

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (state[i][j] == 0)
                {
                    int[] position =
                    {
                        i, j
                    };
                    return position;
                }
            }
        }

        return null;
    }

    public void printState(int[][] state)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(state[i][j] + " , ");
            }
            System.out.println("");
        }
         System.out.println("\n");
        
    }
    
     public void clone(int[][] state,int[][] newState)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                newState[i][j] = state[i][j];
            }
        }
        
    }
}
