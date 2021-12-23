package graph;

import java.util.ArrayList;

public class Node {
    ArrayList<Integer> _adj; // Liste d'adjacence du noeud
    Color _color = Color.RED; // Couleur du noeud

    public Node() {
        _adj = new ArrayList<>();
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color c) {
        _color = c;
    }

    // Ajoute un voisin i au noeud 
    public void addNeighbor(int i) {
        _adj.add(i);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i : _adj) {
            res += i + " ";   
        }
        res += 0;
        return res;
    }
}
