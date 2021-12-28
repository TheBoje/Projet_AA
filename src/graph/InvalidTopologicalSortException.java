package graph;

public class InvalidTopologicalSortException extends Exception {
    private static final long serialVersionUID = 0L;
    public final int _index;

    public InvalidTopologicalSortException(int index) {
        super();
        _index = index;
    }
}
