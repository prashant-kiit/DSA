package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BFSGraph {
    public static void main(String[] args) {
        // Vertices
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0));
        vertices.add(new Vertex(1));
        vertices.add(new Vertex(2));
        vertices.add(new Vertex(3));
        vertices.add(new Vertex(4));

        // Edges
        vertices.get(0).ref = new Vertex(1);
        vertices.get(0).ref.ref = new Vertex(2);

        vertices.get(1).ref = new Vertex(0);
        vertices.get(1).ref.ref = new Vertex(2);
        vertices.get(1).ref.ref.ref = new Vertex(3);

        vertices.get(2).ref = new Vertex(0);
        vertices.get(2).ref.ref = new Vertex(2);
        vertices.get(2).ref.ref.ref = new Vertex(3);
        vertices.get(2).ref.ref.ref.ref = new Vertex(4);

        vertices.get(3).ref = new Vertex(1);
        vertices.get(3).ref.ref = new Vertex(2);
        vertices.get(3).ref.ref.ref = new Vertex(4);

        vertices.get(4).ref = new Vertex(2);
        vertices.get(4).ref.ref = new Vertex(3);

        // vertices
        ArrayList<Vertex> vertices2 = new ArrayList<>();
        vertices2.add(new Vertex(0));
        vertices2.add(new Vertex(1));
        vertices2.add(new Vertex(2));
        vertices2.add(new Vertex(3));
        vertices2.add(new Vertex(4));
        vertices2.add(new Vertex(5));
        vertices2.add(new Vertex(6));

        // edges
        vertices2.get(0).ref = new Vertex(1);
        vertices2.get(0).ref.ref = new Vertex(2);
        
        vertices2.get(1).ref = new Vertex(0);
        vertices2.get(1).ref.ref = new Vertex(3);

        vertices2.get(2).ref = new Vertex(0);
        vertices2.get(2).ref.ref = new Vertex(3);

        vertices2.get(3).ref = new Vertex(1);
        vertices2.get(3).ref.ref = new Vertex(2);

        vertices2.get(4).ref = new Vertex(5);
        vertices2.get(4).ref.ref = new Vertex(6);

        vertices2.get(5).ref = new Vertex(4);
        vertices2.get(5).ref.ref = new Vertex(6);

        vertices2.get(6).ref = new Vertex(4);
        vertices2.get(6).ref.ref = new Vertex(5);

        // Run
        boolean[] visited = new boolean[vertices2.size()];
        // new Solution().bfsSearch(vertices, 4, visited);
        new Solution().bfsSearchDisconnected(vertices2, visited);
    }
}

class Vertex {
    Integer data;
    Vertex ref;

    Vertex(int data1) {
        data = data1;
        ref = null;
    }
}

class Solution {
    void bfsSearch(ArrayList<Vertex> vertices, int start, boolean[] visited1) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = visited1;

        queue.add(vertices.get(start).data);
        visited[vertices.get(start).data] = true;

        while (!queue.isEmpty()) {
            Integer currRemovedData = queue.poll();
            System.out.println("data = " + currRemovedData);

            // find all adjacent vertices
            Vertex currVertex = null;
            for (Vertex vertex : vertices) {
                if (Objects.equals(vertex.data, currRemovedData)) {
                    currVertex = vertex;
                }
            }
            while (currVertex.ref != null) {

                if (!visited[currVertex.ref.data]) {

                    queue.add(currVertex.ref.data);
                    visited[currVertex.ref.data] = true;

                }
                currVertex = currVertex.ref;
            }

        }
    } // 0(v + e + v^2)

    void bfsSearchDisconnected(ArrayList<Vertex> vertices, boolean[] visited ) {
        int count = 0;
        for(int start = 0; start < vertices.size(); start++) {
            if(visited[start] == false) {
                bfsSearch(vertices, start, visited);
                count++;
            }
        }
        System.out.println("No of Islands = " + count);
    } // 0(v + e + v1^2 + v2^2) 
}