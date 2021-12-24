import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import graph.Graph;

public class Main {
    public static void main(String[] args ) throws FileNotFoundException {
        Scanner s;
        if (args.length > 0) {
            s = new Scanner(new File("data/graph-10" + args[0] + ".alists"));
        } else {
            s = new Scanner(System.in);
        }

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

        System.out.println(g.topologicalSort());
    }
}