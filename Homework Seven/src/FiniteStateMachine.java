
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Class that models a Finite State Machine.
 * @author Owen McGrath (building on code by Dave Reed)
 * @version 4/15/2024
 */
public class FiniteStateMachine<StateLabel, EdgeLabel> 
{
    private HashMap<StateLabel, HashMap<EdgeLabel, StateLabel>> fsm;

    /**
     * Creates an empty finite state machine (with no states or edges).
     */
    public FiniteStateMachine() 
    {
        this.fsm = new HashMap<>(); //intialzing the fsm as an empty hashmap.
    }

    /**
     * Adds an edge to the finite state machine.
     *   @param start the label of the starting state
     *   @param edge the label of the edge
     *   @param end the label of the ending state
     */
    public void addEdge(StateLabel start, EdgeLabel edge, StateLabel end) //edge is the transition state
    {
        if (!this.fsm.containsKey(start)) // if the fsm does not contain a key at the start, then create one.
        {
            this.fsm.put(start, new HashMap<EdgeLabel, StateLabel>()); //putting a new hashmap as the starting key, with the edgelabel as the key, statelabel as the value
        }

        HashMap<EdgeLabel, StateLabel> edgeMap = this.fsm.get(start); //setting the hashmap at the beginning to edgeMap
        
        edgeMap.put(edge, end); 
    }
    /**
     * Returns a String representation of the finite state machine.
     *   @return the String representation
     */
    public String toString() 
    {
        return this.fsm.toString();
    }
    
    /**
     * Gets the adjacent state given the start state and edge labels. 
     *   @param startState the label of the start state
     *   @param edge the label of the edge
     *   @return the label of the ending state for that edge (or null if it doesn't exist)
     */
    public StateLabel getAdjacentState(StateLabel startState, EdgeLabel edge) 
    {

        Map<EdgeLabel, StateLabel> edges = this.fsm.get(startState); // getting the edges of the map via each start state and putting them into a reference map.

        if (this.fsm.get(startState) != null) //if there is a startState
        {
            if (edges != null)  //if there are edges
            {
                return edges.get(edge); // then get the edge in the edges map!
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
  
    /**
     * Returns a Set of all states labels that are adjacent to a given state.
     * @param startState the label of the start state
     * @return a Set of all state labels adjacent to startState
     */
    public Set<StateLabel> getAllAdjacentStates(StateLabel startState) 
    {

        Set<StateLabel> newSet = new HashSet<StateLabel>();
        
        HashMap<EdgeLabel, StateLabel> innerMap = this.fsm.get(startState); //creating an inner map

        if (innerMap != null) 
        {
            for (EdgeLabel edge : innerMap.keySet()) 
            {
                newSet.add(innerMap.get(edge));
            } 
        }
        return newSet;
    }
        
    /**
     * Finds the ending state from a start state, given a sequence of edges.
     *   @param startState the label of the start state
     *   @param edgeSeq a list of edges to be followed from the start state
     *   @return the ending state after following the edge sequence
     */
    public StateLabel findEndState(StateLabel startState, List<EdgeLabel> edgeSeq) 
    {
        StateLabel stepper = startState;

        for (EdgeLabel step : edgeSeq) 
        {
            stepper = this.getAdjacentState(stepper, step); //stepper is the current state and steps is the edge

            if (stepper == null) 
            {
                return null;
            }
        }
        return stepper;
    }

    public List<StateLabel> findPath(StateLabel startState, StateLabel endState) 
    {
        List<StateLabel> startPath = new ArrayList<StateLabel>();
        startPath.add(startState);
        
        Queue<List<StateLabel>> paths = new LinkedList<List<StateLabel>>();
        paths.add(startPath);
        
        while (!paths.isEmpty()) 
        {
            List<StateLabel> shortestPath = paths.remove();
            StateLabel current = shortestPath.get(shortestPath.size()-1);
            if (current.equals(endState)) 
            {
                return shortestPath;
            }
            else 
            {
                for (StateLabel s : this.getAllAdjacentStates(current)) 
                {
                    if (!shortestPath.contains(s)) 
                    {
                        List<StateLabel> copy = new ArrayList<StateLabel>(shortestPath);
                        copy.add(s);
                        paths.add(copy);
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Finds an edge between a startState and endState
     * @param startState
     * @param endState
     * @return a singlular edge or null
     */
    public EdgeLabel getEdge(StateLabel startState, StateLabel endState)
    {
        HashMap<EdgeLabel, StateLabel> innerMap = (this.fsm.get(startState));

        Set<EdgeLabel> innerEdges = innerMap.keySet();

        for (EdgeLabel edge : innerEdges)
        { 
            if (innerMap.get(edge).equals(endState)) 
            return edge;
        } 
        return null;
    }

    /**
     * Finds all of the edges within a shortest path
     * @param shortestPath
     * @return all of the edges along the shortest path
     */
    public List<EdgeLabel> getEdgePath (List<StateLabel> shortestPath)
    {
        List<EdgeLabel> edgesInShortestPath = new ArrayList<EdgeLabel>();

        for (int i = 0; i < shortestPath.size()-1; i++)
        {   
            EdgeLabel edge = this.getEdge(shortestPath.get(i), shortestPath.get(i+1));
            edgesInShortestPath.add(edge);
        }
        return edgesInShortestPath;
    }
}