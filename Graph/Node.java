package com.company;

import java.util.ArrayList;

public class Node {
    public String Id;
    public String label;
    public ArrayList<Edge> adjacencyList;
    public int pos;
    int totalNumberOfCo_Occurences;

    public Node(String id, int c) {
        Id = id;
        label = id;
        adjacencyList = new ArrayList<Edge>();
        pos = c;
        totalNumberOfCo_Occurences = 0;
    }

    public void addEdge(int length, Node x){
        Edge e = new Edge(length,x);
        adjacencyList.add(e);
        totalNumberOfCo_Occurences +=length;
    }
}
