
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Class that models a Finite State Machine.
 * @author Owen McGrath (building on code by Dave Reed)
 * @version 4/15/2024
 */
public class FiniteStateMachine<StateLabel, EdgeLabel> {
    private HashMap<StateLabel, HashMap<EdgeLabel, StateLabel>> fsm;

    /**
     * Creates an empty finite state machine (with no states or edges).
     */
    public FiniteStateMachine() {
        // TO BE COMPLETED
    }

    /**
     * Adds an edge to the finite state machine.
     *   @param start the label of the starting state
     *   @param edge the label of the edge
     *   @param end the label of the ending state
     */
    public void addEdge(StateLabel start, EdgeLabel edge, StateLabel end) {
        // TO BE COMPLETED
    }

    /**
     * Returns a String representation of the finite state machine.
     *   @return the String representation
     */
    public String toString() {
        return this.fsm.toString();
    }
    
    /**
     * Gets the adjacent state given the start state and edge labels. 
     *   @param startState the label of the start state
     *   @param edge the label of the edge
     *   @return the label of the ending state for that edge (or null if it doesn't exist)
     */
    public StateLabel getAdjacentState(StateLabel startState, EdgeLabel edge) {
        // TO BE COMPLETED
    }
  
    /**
     * Returns a Set of all states labels that are adjacent to a given state.
     * @param startState the label of the start state
     * @return a Set of all state labels adjacent to startState
     */
    public Set<StateLabel> getAllAdjacentStates(StateLabel startState) {
        // TO BE COMPLETED
    }
        
    /**
     * Finds the ending state from a start state, given a sequence of edges.
     *   @param startState the label of the start state
     *   @param edgeSeq a list of edges to be followed from the start state
     *   @return the ending state after following the edge sequence
     */
    public StateLabel findEndState(StateLabel startState, List<EdgeLabel> edgeSeq) {
        // TO BE COMPLETED
    }


    ///////////////////////////////////////////////////////////////////////////

    public List<StateLabel> findPath(StateLabel startState, StateLabel endState) {
        List<StateLabel> startPath = new ArrayList<StateLabel>();
        startPath.add(startState);
        
        Queue<List<StateLabel>> paths = new LinkedList<List<StateLabel>>();
        paths.add(startPath);
        
        while (!paths.isEmpty()) {
            List<StateLabel> shortestPath = paths.remove();
            StateLabel current = shortestPath.get(shortestPath.size()-1);
            if (current.equals(endState)) {
                return shortestPath;
            }
            else {
                for (StateLabel s : this.getAllAdjacentStates(current)) {
                    if (!shortestPath.contains(s)) {
                        List<StateLabel> copy = new ArrayList<StateLabel>(shortestPath);
                        copy.add(s);
                        paths.add(copy);
                    }
                }
            }
        }
        return null;
    }
}