package graph;

import java.util.ArrayList;

public class Node {
    int _index;
    ArrayList<Integer> _adj; // Adjacency list of the node
    Color _color = Color.RED; // Color of the node

    public Node(int index) {
        _index = index;
        _adj = new ArrayList<>();
    }

    public int getIndex() {
        return _index;
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

    public ArrayList<Integer> getAdj() {
        return _adj;
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
