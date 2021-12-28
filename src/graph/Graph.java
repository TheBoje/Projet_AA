package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private int _order; 
    private ArrayList<Node> _nodes;

    
    /**
     * A graph contains a number of nodes linked with each other.
     * In this case, this Graph is an oriented graph.
     * @param n
     */
    public Graph(int n) {
        _order = n;
        // Initialise la liste de noeuds
        _nodes = new ArrayList<>(_order);
        for (int i = 0; i < _order; i++) {
            _nodes.add(new Node(i));
        }
    }

    
    /** 
     * Add an arc between two nodes called by their index. For example, 
     * node "3" refers to the 3rd node in _nodes, which is _nodes.get(2).
     * @param from index of origin
     * @param to index of destination
     */
    public void addVertice(int from, int to) {
        _nodes.get(from - 1).addNeighbor(to);
        /* As java"s ArrayList<> are 0-indexed, but user input is 1-indexed,
            we need to take care of the in .get(). However, for abstraction
            Node.addNeighbor(index) is still 1-indexed as it is still user 
            input 
        */
    }

    
    @Override
    public String toString() {
        String res = _order + "\n";
        for (int i = 0; i < _order; i++) {
            res += (i + 1) + " " + _nodes.get(i) + "\n";
        }
        return res;
    }

    
    /** 
     * Private method for topological sorting. Visit the node and check
     * for cyclic pattern. 
     * @param n Visited node
     * @param s Stack of visited nodes
     */
    private void topologicalAux(Node n, Stack<Node> s) {
        if (n.getColor() == Color.YELLOW) {
            throw new CyclicGraphException();
        } else if (n.getColor() == Color.RED) {   
            n.setColor(Color.YELLOW);
            
            ArrayList<Integer> n_adj = n.getAdj();
            for (int i = 0; i < n_adj.size(); i++) {
                topologicalAux(_nodes.get(n_adj.get(i) - 1), s);
            }
            
            s.push(n);
            n.setColor(Color.GREEN);
        }
    }

    
    /** 
     * Perform topological sort. If the graph contains a cycle, 
     * `CyclicGraphException` is thrown.
     * @return String topological sort sequence
     */
    public String topologicalSort() {
        Stack<Node> stack = new Stack<>();

        // Init all nodes to unvisited
        for (Node n : _nodes) {
            n.setColor(Color.RED);
        }

        // Launch sorting
        for (Node n : _nodes) {
            if (n.getColor() == Color.RED) {
                topologicalAux(n, stack);
            }
        }
        
        // Compute result
        String res = "";
        while (!stack.empty()) {
            res += (stack.pop().getIndex() + 1) + " ";
        }
        return res;
    }

    
    /** 
     * Private method for checking if a topological sort is valid. If a visited
     * Node is unreachable, sort is invalid, exception is thrown to stop process.
     * @param g Graph on which the sorting verification is performed
     * @param index Index of the visited Node. 0-indexed
     * @throws InvalidTopologicalSortException when the sorting is invalid
     */
    private static void isValidTopologicalSortAux(Graph g, int index) throws InvalidTopologicalSortException {
        if (g._nodes.get(index).getColor() != Color.YELLOW) {
            throw new InvalidTopologicalSortException(index);
        }
        g._nodes.get(index).setColor(Color.GREEN); 

        for (int i : g._nodes.get(index).getAdj()) {
            g._nodes.get(i - 1).setColor(Color.YELLOW);
        }
    }

    
    /** 
     * Check is the provided topological sort is valid.
     * @param ts space-separated node indexes (1-indexed) list for topological sorting. Provided by Graph.topologicalSort()
     * @param g Graph onto which is the check is performed
     * @return boolean
     */
    public static boolean isValidTopologicalSort(String ts, Graph g) {
        ArrayList<Integer> topo_indexes = new ArrayList<>();
        
        // Read user input. Space-separated node indexes (1-indexed) list
        for (String s : ts.split(" ")) {
            topo_indexes.add(Integer.parseInt(s) - 1);
        }

        // Set parent less nodes to Color.YELLOW, as visitable        
        for (Node n : g._nodes) {
            n.setColor(Color.YELLOW);
        }
        // Set nodes with parents to Color.RED, as not visitable (yet)
        for (Node n : g._nodes) {
            for (int i : n.getAdj()) {
                g._nodes.get(i - 1).setColor(Color.RED);
            }
        }
        
        // Launch verification. If fails, it will return InvalidTopologicalSortException
        try {
            for (int index : topo_indexes) {
                isValidTopologicalSortAux(g, index);
            }
        } catch (InvalidTopologicalSortException e) {
            return false;
        }
        return true;
    }
}
