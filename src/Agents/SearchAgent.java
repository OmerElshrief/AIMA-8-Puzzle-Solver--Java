/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

import Comparetors.EuclideanComparator;
import Comparetors.ManhattanComparator;
import ProblemFormulation.Node;
import ProblemFormulation.Problem;
import Utils.SearchHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Omar
 */
public class SearchAgent
{

    private Queue<Node> frontier;
    private Stack<Node> sFrontier;
    private java.util.ArrayList<Node> explored;

    private java.util.PriorityQueue<Node> ManhattanPriorityQueue;
    private java.util.PriorityQueue<Node> EuclideanPriorityQueue;
    private SearchHelper searchHelper;
    private HashSet<int[][]> visited;
    public int searchDepth = 0;

    public SearchAgent()
    {
        this.frontier = new java.util.LinkedList<Node>();
        this.explored = new java.util.ArrayList<>();

        searchHelper = SearchHelper.getInstance();
        ManhattanPriorityQueue = new java.util.PriorityQueue<Node>(new ManhattanComparator());
        EuclideanPriorityQueue = new java.util.PriorityQueue<Node>(new EuclideanComparator());
        visited = new HashSet<int[][]>();

    }

    public java.util.ArrayList BFS(Problem p) throws InterruptedException  //BFS algorithm, returns an ArrayList that contains  steps to the Goal state
    {
        Node node = new Node(p.getInitialState(), null, 0, 0);

        frontier.add(node);
        int[] actions;
        System.out.println(explored.size());
        visited.add(node.getState());
        while (!frontier.isEmpty())
        {
            node = new Node(null, null, 1, 0);
            node = frontier.poll();
            checkMaxDepth(node.getCost());
            if (p.isGoal(node.getState()))
            {
                return p.getSolution(node, explored, new ArrayList<Node>(frontier), searchDepth);  //Goal State is found;
            }
            actions = p.actions(node.getState()); //get the possible action can be executed in the current state
            explored.add(node);

            System.out.println(explored.size());
            for (int i = 0; i < actions.length; i++)  //Loop to Explore the children of this States
            {

                Node child = new Node(p.getNewState(actions[i], node.getState()), node, node.getCost() + 1, actions[i]);
                checkMaxDepth(child.getCost());
                

                if (  !searchHelper.contains(explored, child)&&!searchHelper.contains(new ArrayList<Node>(frontier), child))
                {
                    frontier.add(child);
                }

            }

        }

        return null;
    }

    public java.util.ArrayList DFS(Problem p) throws InterruptedException
    {
        Node node = new Node(p.getInitialState(), null, 0, 0);
        sFrontier = new Stack();
        explored = new java.util.ArrayList();
        if (p.isGoal(node.getState()))
        {
            return p.getSolution(node, explored, new ArrayList<Node>(sFrontier), searchDepth);
        }
        sFrontier.push(node);

        while (!sFrontier.isEmpty())
        {

            node = new Node(sFrontier.pop());
            checkMaxDepth(node.getCost());
            if (p.isGoal(node.getState()))
            {
                return p.getSolution(node, explored, new ArrayList<Node>(sFrontier), searchDepth);
            }

            explored.add(node);
            int[] action = p.actions(node.getState());

            for (int i = action.length - 1; i >= 0; i--)
            {
                Node child = new Node(p.getNewState(action[i], node.getState()), node, node.getCost() + 1, action[i]);
                checkMaxDepth(child.getCost());
                // System.out.println(action[i]);

                if (!searchHelper.contains(sFrontier, child) && !searchHelper.contains(explored, child))
                {
                    sFrontier.push(child);
                }
            }

        }

        return null;
    }

    public java.util.ArrayList A_Manhattan(Problem p) throws InterruptedException  //A* using Manhattan method as Heuristic function algorithm, returns an ArrayList that contains  steps to the Goal state
    {
        Node node = new Node(p.getInitialState(), null, 0, 0);

        ManhattanPriorityQueue.add(node);

        int[] actions;

        while (!ManhattanPriorityQueue.isEmpty())
        {
            node = new Node(ManhattanPriorityQueue.poll());

            checkMaxDepth(node.getCost());
            if (p.isGoal(node.getState()))
            {
                return p.getSolution(node, explored, new ArrayList<Node>(ManhattanPriorityQueue), searchDepth);  //Goal State is found;
            }
            actions = p.actions(node.getState()); //get the possible action can be executed in the current state
            explored.add(node);
            for (int i = 0; i < actions.length; i++)  //Loop to Explore the children of this States
            {

                Node child = new Node(p.getNewState(actions[i], node.getState()), node, node.getCost() + 1, actions[i]);

                if (!searchHelper.contains(new ArrayList<Node>(ManhattanPriorityQueue), child) && !searchHelper.contains(explored, child))
                {
                    ManhattanPriorityQueue.add(child);

                }

            }

        }

        return null;
    }

    public java.util.ArrayList A_EuclideanPriorityQueue(Problem p) throws InterruptedException  //A* using Manhattan method as Heuristic function algorithm, returns an ArrayList that contains  steps to the Goal state
    {
        Node node = new Node(p.getInitialState(), null, 0, 0);

        EuclideanPriorityQueue.add(node);

        int[] actions;

        while (!EuclideanPriorityQueue.isEmpty())
        {
            node = new Node(EuclideanPriorityQueue.poll());

            if (p.isGoal(node.getState()))
            {
                return p.getSolution(node, explored, new ArrayList<Node>(EuclideanPriorityQueue), searchDepth);  //Goal State is found;
            }
            actions = p.actions(node.getState()); //get the possible action can be executed in the current state
            explored.add(node);
            for (int i = 0; i < actions.length; i++)  //Loop to Explore the children of this States
            {

                Node child = new Node(p.getNewState(actions[i], node.getState()), node, node.getCost() + 1, actions[i]);
                checkMaxDepth(child.getCost());
                if (!searchHelper.contains(new ArrayList<Node>(EuclideanPriorityQueue), child) && !searchHelper.contains(explored, child))
                {
                    EuclideanPriorityQueue.add(child);

                }

            }

        }

        return null;
    }

    public void checkMaxDepth(int depth)
    {
        if (searchDepth < depth)
        {
            searchDepth = depth;
        }
    }

}
