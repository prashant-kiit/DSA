package Graph;

import java.util.ArrayList;
import java.util.Objects;

public class DFSGraph {
    public static void main(String[] args) {
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0));
        vertices.add(new Vertex(1));
        vertices.add(new Vertex(2));
        vertices.add(new Vertex(3));
        vertices.add(new Vertex(4));
        vertices.add(new Vertex(5));
        vertices.add(new Vertex(6));
        vertices.add(new Vertex(7));

        vertices.get(0).ref = new Vertex(1);
        vertices.get(0).ref.ref = new Vertex(2);

        vertices.get(1).ref = new Vertex(0);
        vertices.get(1).ref.ref = new Vertex(3);
        vertices.get(1).ref.ref.ref = new Vertex(4);

        vertices.get(2).ref = new Vertex(0);
        vertices.get(2).ref.ref = new Vertex(3);

        vertices.get(3).ref = new Vertex(1);
        vertices.get(3).ref.ref = new Vertex(2);
        vertices.get(3).ref.ref.ref = new Vertex(4);

        vertices.get(4).ref = new Vertex(1);
        vertices.get(4).ref.ref = new Vertex(3);

        vertices.get(5).ref = new Vertex(6);
        vertices.get(5).ref.ref = new Vertex(7);

        vertices.get(6).ref = new Vertex(5);
        vertices.get(6).ref.ref = new Vertex(7);

        vertices.get(7).ref = new Vertex(5);
        vertices.get(7).ref.ref = new Vertex(6);

        boolean[] visited = new boolean[vertices.size()];
        new Solution().dfsSearchDisconnected(vertices, visited);
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
    void dfsSearch(ArrayList<Vertex> vertices, int start, boolean[] visited) {
        if(start == -1) {
            return;
        }
        Vertex currVertex = vertices.get(start);
        System.out.println(currVertex.data);
        visited[vertices.get(start).data] = true;
        // System.out.println();
        while (currVertex.ref!=null) {
            int nextStartIndex = -1;
            for (int i = 0; i < vertices.size(); i++) {
                if (Objects.equals(vertices.get(i).data, currVertex.ref.data) && !visited[vertices.get(i).data]) {
                    nextStartIndex = i;
                    break;
                }
            }
            dfsSearch(vertices, nextStartIndex, visited);
            currVertex = currVertex.ref;
        }
    } // 0(v + e + v^2)

    void dfsSearchDisconnected(ArrayList<Vertex> vertices, boolean[] visited ) {
        int count = 0;
        for(int start = 0; start < vertices.size(); start++) {
            if(!visited[start]) {
                dfsSearch(vertices, start, visited);
                count++;
            }
        }
        System.out.println("No of Islands = " + count);
    } // 0(v + e + v1^2 + v2^2) 
}