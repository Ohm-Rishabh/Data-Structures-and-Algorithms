package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //String a = args[0];
        //String b = args[1];
        //String c = args[2];
        Graph G = new Graph();
        Scanner scanNode = new Scanner(new File("nodes.csv"));
        scanNode.useDelimiter(",");
        scanNode.nextLine();
        Scanner scanEdge = new Scanner(new File("edges.csv"));
        scanEdge.useDelimiter(",");
        scanEdge.nextLine();
        /*String line1 = scanNode.nextLine();
        String[] name = line1.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println(name[0] + "///" + name[1]);
        String line2 = scanEdge.nextLine();
        String[] edges = line2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println(edges[0] + "///" + edges[1] + "///" + Integer.parseInt(edges[2]));*/
        int c1 = 0;
        while (scanNode.hasNext()) {
            String line = scanNode.nextLine();
            String[] name = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            G.addVertex(name[1]);
            c1++;
            //System.out.println(c1++ + "///" + "Vertex insertion " + name[1]);
        }
        while (scanEdge.hasNext()) {
            String line = scanEdge.nextLine();
            String[] edges = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            //System.out.println(edges[0] + "*///*" + edges[1] + "*///*" + Integer.parseInt(edges[2]));
            G.addEdge(edges[0], edges[1], Integer.parseInt(edges[2]));
            //System.out.println(c1++ + "///" + "Edge insertion");
        }
        //System.out.println(c1);
        /*String c = "rank";
        if (c.equals("average"))
            G.average();
        else if (c.equals("rank"))
            G.rank();
        else
            System.out.println("No Command");*/
        //System.out.println(G.numberOfNodesInserted);
        G.independent_storyline_dfs();
        //String s1 = "Go";
        //String s2 = "So";
        //System.out.println(s1.compareTo(s2));
    }
}



    /*Graph G = new Graph(7);
//First Disjoint sub-graph
	    G.addVertex("CapAmer");
                G.addVertex("IronMan");
                G.addVertex("BlackPanther");
                G.addVertex("AntMan");
                G.addEdge("CapAmer","IronMan",5);
                G.addEdge("CapAmer","AntMan",2);
                G.addEdge("IronMan", "BlackPanther",5);
                G.addEdge("BlackPanther", "AntMan", 5);
                G.addEdge("AntMan", "IronMan",2);
                //Second Disjoint sub-graph
        /*G.addVertex("BlackWidow");
        G.addVertex("Wanda");
        G.addVertex("Vision");
        G.addEdge("Wanda", "BlackWidow", 1);
        G.addEdge("Vision", "BlackWidow", 3);
        G.addEdge("Vision", "Wanda", 4);*/
                //G.average();
                //G.rank();
                //G.independent_storyline_dfs();
        /*for (int i = 0; i<4; ++i) {
            System.out.print(G.Vertices[i].label + " ");
            for (int j = 0; j<G.Vertices[i].adjacencyList.size(); ++j) {
                System.out.print(G.Vertices[i].adjacencyList.get(j).x.label + " " +
                        G.Vertices[i].adjacencyList.get(j).x.pos + " " +
                        G.Vertices[i].adjacencyList.get(j).length + "/// ");
            }
            System.out.println("End of loop j");
        }*/


//////////A4 implementation

/*
public class A4_2019EE10499 {
        public static void main(String[] args) throws FileNotFoundException{
        String a = args[0];
        String b = args[1];
        String c = args[2];
        Graph G = new Graph();
        Scanner scanNode = new Scanner(new File(a));
        scanNode.useDelimiter(",");
        scanNode.nextLine();
        Scanner scanEdge = new Scanner(new File(b));
        scanEdge.useDelimiter(",");
        scanEdge.nextLine();
        while (scanNode.hasNext()) {
            String line = scanNode.nextLine();
            String[] name = line.split(",");
            G.addVertex(name[1]);
        }
        while(scanEdge.hasNext()) {
            String line = scanEdge.nextLine();
            String[] edges = line.split(",");
            G.addEdge(edges[0],edges[1],Integer.parseInt(edges[2]));
        }
        if(c.equals("average"))
            G.average();
        else if(c.equals("rank"))
            G.rank();
        else
            System.out.println("No Command");
    }
}
 */