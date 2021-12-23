package graph;

import java.util.ArrayList;

public class Graph {
    private int _n; // Nombre de vertices
    private ArrayList<Node> _nodes; // Noeuds du graphe

    public Graph(int n) {
        _n = n;
        // Initialise la liste de noeuds
        _nodes = new ArrayList<>(_n);
        for (int i = 0; i < _n; i++) {
            _nodes.add(new Node());
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
        String res = _n + "\n";
        for (int i = 0; i < _n; i++) {

            res += (i + 1) + " " + _nodes.get(i) + "\n";
        }
        return res;
    }
}
