import java.util.Scanner;
import graph.Graph;

public class Main {
    public static void main(String[] args ) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Graph g = new Graph(n);

        for (int i = 0; i < n; i++) {
            int from = s.nextInt();
            int to = -1;
            do {
                to = s.nextInt();
                if (to != 0) {
                    g.addVertice(from, to);
                }
            } while (to != 0);
        }
        s.close();
        System.out.println(g);
    }
}