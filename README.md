# AIMA 8-Puzzle Solver -Java

## I. Introduction
An instance of the n-puzzle game consists of a board holding n^2-1 distinct movable tiles, plus an empty space. The tiles are numbers from the set 1,..,n^2-1. For any such board, the empty space may be legally swapped with any tile horizontally or vertically adjacent to it. In this assignment, the blank space is going to be represented with the number 0. Given an initial state of the board, the combinatorial search problem is to find a sequence of moves that transitions this state to the goal state; that is, the configuration with all tiles arranged in ascending order 0,1,… ,n^2−1. The search space is the set of all possible states reachable from the initial state. The blank space may be swapped with a component in one of the four directions {‘Up’, ‘Down’, ‘Left’, ‘Right’}, one move at a time. The cost of moving from one configuration of the board to another is the same and equal to one. Thus, the total cost of path is equal to the number of moves made from the initial state to the goal state.

## II. Algorithm Review
The searches begin by visiting the root node of the search tree, given by the initial state. Among other book-keeping details, three major things happen in sequence in order to visit a node:
1.	First, we remove a node from the frontier set.
2.	Second, we check the state against the goal state to determine if a solution has been found.
3.	Finally, if the result of the check is negative, we then expand the node. To expand a given node, we generate successor nodes adjacent to the current node, and add them to the frontier set. Note that if these successor nodes are already in the frontier, or have already been visited, then they should not be added to the frontier again.
This describes the life-cycle of a visit, and is the basic order of operations for search agents in this assignment—(1) remove, (2) check, and (3) expand. In this assignment, we will implement algorithms as described here.
 ## III. What The Program Need to Output

Supose the program is executed for breadth-first search starting from the initial state 1,2,5,3,4,0,6,7,8 
The output file should contain exactly the following lines:
path_to_goal: [‘Up’, ‘Left’, ‘Left’]
cost_of_path: 3
nodes_expanded: 10
search_depth: 3
max_search_depth: 4
running_time: 0.00188088

 
## Code Description:
The Application is coded in JAVA and contains the Following Packages:-
•	Agents:
Contains the SearchAgent Class that is responsible for the Searching, in this class all the 3 Algorithms are implemented as stated before.
•	Comparators:
Contains two Comparator classes for the Priority Queue used in A* Algorithm
•	ProblemFormulation:
	Class Node:
A node in a search tree. Contains a pointer to the parent (the node  that this is a successor of) and to the actual state for this node. Note  that if a state is arrived at by two paths, then there are two nodes with
 the same state.  Also includes the action that got us to this state, and    the total path_cost (also known as g) to reach the node.
	Class Problem:
The abstract class for a formal problem. It contains the InitialState of the Problem, the Goal State, Path cost of the goal, GetActions(STATE), GetNewState(state,Action);
•	Utils:-
Contains some classes to Help in the Searching Process.


 
## Project Description:
The Application is a GUI Based that enable the user to enter the initial state of the problem (8 digits separated by a comma) in a textArea and determine to solve by which Algorith (DFS,BFS,A*_ECU,A*_MAC), then the application shall solve the problem and show an Animation for the problem solving in a 8x8 board.
The Solver output the information and details of the operation
•	path_to_goal.
•	cost_of_path.
•	nodes_expanded.
•	search_depth.
•	max_search_depth.
•	running_time.
  

Some Test Cases:-
•	Initial State: 1,2,5,3,4,0,7,8,9
•	Using BFS:-

 
 
•	Initial State: 1,2,5,3,4,0,6,7,8
•	A* Searching Algorithm using Euclidean distance as heuristic:












 
•	Initial State: 8,6,4,2,1,3,5,7,0;
•	A* Searching Algorithm using Manhattan Distance
 

•	A* Algorithm using Euclidean as Heuristic
  


