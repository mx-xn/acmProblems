import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class SquawkVirus {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextInt()) {
      int n = sc.nextInt();   //num vertices
      int m = sc.nextInt();   //num edges
      int start = sc.nextInt();   //start number
      int t = sc.nextInt();

      ArrayList<Vertex> vertices = new ArrayList<Vertex>();
      for (int i = 0; i < n; i++) {
        Vertex v = new Vertex();
        vertices.add(v);
      }

      for (int i = 0; i < m; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        vertices.get(a).neighbors.add(vertices.get(b));
        vertices.get(b).neighbors.add(vertices.get(a));
      }

      computeSquawks(vertices, start, t);
    }
  }

  public static void computeSquawks(ArrayList<Vertex> vertices, 
      int start, int t) {
    Stack<Vertex> st = new Stack<Vertex>();
    Vertex ver = vertices.get(start);
    ver.before = 1;
    for (int i = 0; i < t; i++) {
      for (Vertex v : vertices) {
        if (v.before != 0)
          st.push(v);
      }

      while(!st.empty()) {
        Vertex v = st.pop();
        for(Vertex w : v.neighbors) {
          w.after += v.before;
        }
      }
      for (Vertex v : vertices) {
        v.before = v.after;
        v.after = 0;
      }
    }

    long count = 0;
    for (Vertex v : vertices) {
      count += v.before;
    }
    System.out.println(count);

  }

  public static class Vertex {
    //fields
    public ArrayList<Vertex> neighbors;
    public long before = 0;
    public long after = 0;

    public Vertex() {
      neighbors = new ArrayList<Vertex>();
    }
  }


}
