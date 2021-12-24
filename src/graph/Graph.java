package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private int _order; // Nombre de vertices
    private ArrayList<Node> _nodes; // Noeuds du graphe

    public Graph(int n) {
        _order = n;
        // Initialise la liste de noeuds
        _nodes = new ArrayList<>(_order);
        for (int i = 0; i < _order; i++) {
            _nodes.add(new Node(i));
        }
    }

    // Ajoute un arc à un noeud.
    // Note: from et to sont le numéros des noeuds, 
    // en sachant que le noeud n°3 est stocké en tant que _nodes.get(2)
    public void addVertice(int from, int to) {
        _nodes.get(from - 1).addNeighbor(to);
    }

    // Affichage
    @Override
    public String toString() {
        String res = _order + "\n";
        for (int i = 0; i < _order; i++) {

            res += (i + 1) + " " + _nodes.get(i) + "\n";
        }
        return res;
    }

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

    public String topologicalSort() {
        Stack<Node> stack = new Stack<>();

        // Initialise tous les noeuds à non-visité
        for (Node n : _nodes) {
            n.setColor(Color.RED);
        }

        for (Node n : _nodes) {
            if (n.getColor() == Color.RED) {
                topologicalAux(n, stack);
            }
        }
        
        String res = "";
        while (!stack.empty()) {
            res += (stack.pop().getIndex() + 1) + " ";
        }
        return res;
    }
}
