package com.company;


import java.util.ArrayList;

public class Graph {
    Node[] Vertices;
    int numberOfNodesInserted;
    //ArrayList<Edge> adjacency_list[];

    public Graph() {
        Vertices = new Node[1000];
        numberOfNodesInserted =0;
        //for (int i = 0; i<numberOfNodesInserted; ++i)
          //  adjacency_list[i] = new ArrayList<Edge>();
    }

    public void addVertex(String name) {
        Node temp = new Node(name, numberOfNodesInserted);
        Vertices[numberOfNodesInserted] = temp;
        numberOfNodesInserted++;
    }

    public void addEdge(String name1, String name2, int length) {
        //System.out.println("Inside addEdge()");
        Node temp1 = findNode(name1);
        Node temp2 = findNode(name2);
        //System.out.println(temp1.label + "*///*" + temp2.label);
        //System.out.println(temp1.label);
        //System.out.println(temp2.label);
        //Edge e1 = new Edge(length,temp2);
        //adjacency_list[temp1.pos].add(e1);
        //Edge e2 = new Edge(length,temp1);
        //adjacency_list[temp2.pos].add(e2);
        temp1.addEdge(length,temp2);
        temp2.addEdge(length,temp1);
    }

    private Node findNode(String x){
        //System.out.println("Inside findNode()*///*" + x);
        if (x == null)
            return null;
        for (int i = 0; i< numberOfNodesInserted; ++i) {
            //System.out.println(Vertices[i].label + "    *///*Loop inside the findNode()");
            if (x.equals(Vertices[i].label))
                return Vertices[i];
        }
        return null;
    }

    public void average() {
        float sum = 0;
        for (int i=0; i<numberOfNodesInserted; ++i) {
            sum+=Vertices[i].adjacencyList.size();
        }
        //System.out.println(sum);
        sum = (float) sum;
        float f = (float) sum/numberOfNodesInserted;
        float roundedFloat = (float)Math.round(f * 100) / 100;
        System.out.println(String.format("%.2f",roundedFloat));
    }

    public void rank() {
        ForSorting[] sortByRank = new ForSorting[numberOfNodesInserted];
        for (int i = 0; i<numberOfNodesInserted; ++i) {
            //System.out.println(Vertices[i].totalNumberOfCo_Occurences + "    " + Vertices[i].label);
            ForSorting temp = new ForSorting(Vertices[i].totalNumberOfCo_Occurences, Vertices[i].label);
            sortByRank[i] = temp;
        }
        sort(sortByRank,0,numberOfNodesInserted-1);
        for (int i =numberOfNodesInserted-1; i>0; --i) {
            if (sortByRank[i].name.charAt(0) == '"') {
                String temp = "";
                for (int j = 1; j<sortByRank[i].name.length()-1; ++j) {
                    temp += sortByRank[i].name.charAt(j);
                }
                System.out.print(temp + ",");
            } else
                System.out.print(sortByRank[i].name + ",");
        }
        if (sortByRank[0].name.charAt(0) == '"') {
            String temp = "";
            for (int j = 1; j<sortByRank[0].name.length()-1; ++j) {
                temp += sortByRank[0].name.charAt(j);
            }
            System.out.print(temp);
        } else
            System.out.print(sortByRank[0].name);
    }

    /*
    * for (int i =numberOfNodesInserted-1; i>0; --i)
            System.out.print(sortByRank[i].name + ",");
        System.out.print(sortByRank[0].name);*/

    private void sort(ForSorting arr[], int left, int right)
    {
        //System.out.println("Inside the sort() function");
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(ForSorting arr[], int low, int mid, int right)
    {
        //System.out.println("Inside the merge function top");
        int n1 = mid - low + 1;
        int n2 = right - mid;

        ForSorting L[] = new ForSorting[n1];
        ForSorting R[] = new ForSorting[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = low;
        //System.out.println(n1 + "   " + n2);
        while (i < n1 && j < n2) {
            if (L[i].totalNumberOfCo_Occureses < R[j].totalNumberOfCo_Occureses) {
                arr[k] = L[i];
                i++;
                //System.out.println("Inside the merge function 1st if(condition)");
            }
            else if (L[i].totalNumberOfCo_Occureses > R[j].totalNumberOfCo_Occureses){
                arr[k] = R[j];
                j++;
                //System.out.println("Inside the merge function 2nd if(condition)");
            } else if(L[i].totalNumberOfCo_Occureses == R[j].totalNumberOfCo_Occureses)  {
                //System.out.println("Inside the merge function 3rd if(condition)");
                String name1 = L[i].name;
                String name2 = R[j].name;
                //System.out.println(name1 + "   " + name2);
                //System.out.println(name1.charAt(0) + "   " + name2.charAt(0));
                //System.out.println(name1.charAt(1) + "   " + name2.charAt(1));
                //System.out.println(name1.charAt(2) + "   " + name2.charAt(2));
                //System.out.println(name1.charAt(3) + "   " + name2.charAt(3));
                //System.out.println(name1.charAt(4) + "   " + name2.charAt(4));
                //if (name1.charAt(1) > name2.charAt(1))
                  //  System.out.println("Should return true");
                for (int z = 0; z<name1.length() && z<name2.length(); ++z) {

                    if (name1.charAt(0) == '"' && name2.charAt(0) != '"') {
                        if (name1.charAt(z+1) != name2.charAt(z)) {
                            if (name1.charAt(z+1) > name2.charAt(z)) {
                                arr[k] = R[j];
                                j++;
                            } else {
                                arr[k] = L[i];
                                i++;
                            }
                            break;
                        }
                    } else if (name2.charAt(0) == '"' && name1.charAt(0) != '"') {
                        if (name2.charAt(z+1) != name1.charAt(z)) {
                            if (name1.charAt(z) > name2.charAt(z+1)) {
                                arr[k] = R[j];
                                j++;
                            } else {
                                arr[k] = L[i];
                                i++;
                            }
                            break;
                        }
                    } else if (name2.charAt(0) == '"' && name1.charAt(0) == '"') {
                        if (name2.charAt(z+1) != name1.charAt(z+1)) {
                            if (name1.charAt(z+1) > name2.charAt(z+1)) {
                                arr[k] = R[j];
                                j++;
                            } else {
                                arr[k] = L[i];
                                i++;
                            }
                            break;
                        }
                    } else if (name1.charAt(z) != name2.charAt(z)) {
                        if (name1.charAt(z) > name2.charAt(z)) {
                            arr[k] = R[j];
                            j++;
                        } else {
                            arr[k] = L[i];
                            i++;
                        }
                        break;
                    }
                }
            } else
                return;
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }



    public void independent_storyline_dfs() {
        Boolean[] visited = new Boolean[numberOfNodesInserted];
        for (int k = 0; k<numberOfNodesInserted; ++k)
            visited[k] = false;
        int k = 0;
        ArrayList<String>[] usedForDFS = new ArrayList[numberOfNodesInserted];
        for (int i = 0; i<numberOfNodesInserted; ++i)
            usedForDFS[i] = new ArrayList<String>();
        ArrayList<String>[] toBePrinted = new ArrayList[numberOfNodesInserted];
        for (int i = 0; i<numberOfNodesInserted; ++i)
            toBePrinted[i] = new ArrayList<String>();
        //System.out.println(toBePrinted[0].size());
        int[] sizeOfEachIndpComp = new int[numberOfNodesInserted];
        int numberOfIndpComp = 0;
        while (k<numberOfNodesInserted) {
            DFS(Vertices[k], visited, numberOfIndpComp,usedForDFS);
            sizeOfEachIndpComp[numberOfIndpComp] = usedForDFS[numberOfIndpComp].size();
            String[] temp = new String[sizeOfEachIndpComp[numberOfIndpComp]];
            for (int z = 0; z<sizeOfEachIndpComp[numberOfIndpComp]; ++z)
                temp[z] = usedForDFS[numberOfIndpComp].get(z);
            sortLex(temp, 0, sizeOfEachIndpComp[numberOfIndpComp]-1);
            //System.out.println("Sorting done");
            for (int z = 0; z<sizeOfEachIndpComp[numberOfIndpComp]; ++z)
                toBePrinted[numberOfIndpComp].add(temp[z]);
            for (int z=k; z<numberOfNodesInserted; ++z)
                if (!visited[z]) {
                    k = z;
                    break;
                } else if (z == numberOfNodesInserted-1)
                    k = z+1;
            //System.out.println(k);
            numberOfIndpComp++;
        }
        //System.out.println("all done");
        //System.out.println();
        for (int i = 0; i<numberOfIndpComp; ++i) {
            int max = sizeOfEachIndpComp[i];
            int temp = i;
            for (int j = 0; j<numberOfIndpComp; ++j) {
                if (sizeOfEachIndpComp[j]>max) {
                    max = sizeOfEachIndpComp[j];
                    temp = j;
                } else if (sizeOfEachIndpComp[j] == max && max != -1) {
                    if (toBePrinted[j].get(max-1).charAt(0) > toBePrinted[temp].get(max-1).charAt(0)) {
                        temp = j;
                    }
                }
            }
            for (int j = max-1; j>0; --j) {
                if (toBePrinted[temp].get(j).charAt(0) == '"') {
                    String temp1 = "";
                    for (int cc = 1; cc<toBePrinted[temp].get(j).length()-1; ++cc) {
                        temp1 += toBePrinted[temp].get(j).charAt(cc);
                    }
                    System.out.print(temp1 + ",");
                } else
                    System.out.print(toBePrinted[temp].get(j) + ",");
            }
            if (toBePrinted[temp].get(0).charAt(0) == '"') {
                String temp1 = "";
                for (int j = 1; j<toBePrinted[temp].get(0).length()-1; ++j) {
                    temp1 += toBePrinted[temp].get(0).charAt(j);
                }
                System.out.print(temp);
            } else
                System.out.print(toBePrinted[temp].get(0));
            sizeOfEachIndpComp[temp] = -1;
            System.out.println();
        }
        //for (int i = 0;i<toBePrinted[0].size(); ++i)
            //System.out.println(toBePrinted[0].get(i));
        //System.out.println(toBePrinted[0].size());
    }

    private void DFS(Node n, Boolean[] visited, int row, ArrayList<String>[] toBePrinted) {
        if (visited[n.pos])
            return;
        visited[n.pos] = true;
        //System.out.println(n.label + "   " + toBePrinted[row].size());
        toBePrinted[row].add(n.label);
        for (int i = 0; i<n.adjacencyList.size(); ++i) {
            if (!visited[n.adjacencyList.get(i).x.pos]) {
                DFS(n.adjacencyList.get(i).x, visited, row, toBePrinted);
            }
        }
    }

    private void sortLex(String arr[], int low, int right)
    {
        if (low < right) {
            // Find the middle point
            int m = (low + right) / 2;

            // Sort first and second halves
            sortLex(arr, low, m);
            sortLex(arr, m + 1, right);

            // Merge the sorted halves
            mergeLex(arr, low, m, right);
        }
    }

    private void mergeLex(String arr[], int low, int mid, int right) {
        int n1 = mid - low + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        String Lft[] = new String[n1];
        String Rgt[] = new String[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            Lft[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            Rgt[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = low;
        while (i < n1 && j < n2) {
            Boolean cornerCase = true;
            String name1 = Lft[i];
            String name2 = Rgt[j];
            //System.out.println(name1 + "///" + name2);
            //System.out.println("Inside while");
            for (int z = 0; z<name1.length() && z<name2.length(); ++z) {
                //System.out.println("Value of z  " + z);
                if (name1.charAt(0) != '"' && name2.charAt(0) != '"') {
                    if (name1.charAt(z) != name2.charAt(z)) {
                        if (name1.charAt(z) > name2.charAt(z)) {
                            arr[k] = Rgt[j];
                            j++;
                            cornerCase = false;
                            //System.out.println("First if");
                            break;
                        } else if (name1.charAt(z) < name2.charAt(z)){
                            arr[k] = Lft[i];
                            i++;
                            cornerCase = false;
                            //System.out.println("Second if");
                            break;
                        }
                    }
                } else if (name1.charAt(0) != '"' && name2.charAt(0) == '"') {
                    if (name1.charAt(z) != name2.charAt(z+1)) {
                        if (name1.charAt(z) > name2.charAt(z+1)) {
                            arr[k] = Rgt[j];
                            j++;
                            cornerCase = false;
                            break;
                        } else if (name1.charAt(z) < name2.charAt(z+1)){
                            arr[k] = Lft[i];
                            i++;
                            cornerCase = false;
                            break;
                        }
                    }
                } else if (name1.charAt(0) == '"' && name2.charAt(0) != '"') {
                    if (name1.charAt(z+1) != name2.charAt(z)) {
                        if (name1.charAt(z+1) > name2.charAt(z)) {
                            arr[k] = Rgt[j];
                            j++;
                            cornerCase = false;
                            //System.out.println("First if");
                            break;
                        } else if (name1.charAt(z+1) < name2.charAt(z)){
                            arr[k] = Lft[i];
                            i++;
                            cornerCase = false;
                            break;
                        }
                    }
                } else if (name1.charAt(0) == '"' && name2.charAt(0) == '"') {
                    if (name1.charAt(z+1) != name2.charAt(z+1)) {
                        if (name1.charAt(z+1) > name2.charAt(z+1)) {
                            arr[k] = Rgt[j];
                            j++;
                            cornerCase = false;
                            break;
                        } else if (name1.charAt(z+1) < name2.charAt(z+1)){
                            arr[k] = Lft[i];
                            i++;
                            cornerCase = false;
                            break;
                        }
                    }
                }
            }
            if (cornerCase) {
                if (name1.length()>name2.length()) {
                    arr[k] = Rgt[j];
                    j++;
                } else {
                    arr[k] = Lft[i];
                    i++;
                }
            }
            ++k;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = Lft[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = Rgt[j];
            j++;
            k++;
        }
    }


}
///////////

/*
        public void independent_storyline_dfs() {
        int i = 0;
        Boolean[] visited = new Boolean[numberOfNodesInserted];
        for (int k = 0; k<numberOfNodesInserted; ++k)
            visited[k] = false;
        while (i<numberOfNodesInserted) {
            ArrayList<String> queue = new ArrayList<String>();
            queue.add(Vertices[i].label);
            visited[Vertices[i].pos] = true; //INV: visited[i]=true
            DFS(Vertices[i], visited, queue);
            ForSorting[] sortQueueByRank = new ForSorting[queue.size()];
            for (int j = 0; j<queue.size(); ++j) {
                ForSorting temp = new ForSorting(Vertices[i].totalNumberOfCo_Occurences, Vertices[i].label);
                sortQueueByRank[j] = temp;
            }
            sort(sortQueueByRank,0,queue.size()-1); //Ignoring the size of the connected component
            for (int j=0; j<queue.size(); ++j) {
                System.out.print(sortQueueByRank[j].name + ",");
            }
            System.out.println("");
            for (int j = i+1; j<numberOfNodesInserted; ++j)
                if (!visited[j])
                    i=j;
        }
    }


    private void DFS(Node n, Boolean[] visited, ArrayList<String> queue) {
        if (n==null)
            return;
        for (int i =0; i<n.adjacencyList.size(); ++i) {
            if (!visited[n.adjacencyList.get(i).x.pos])
                queue.add(n.adjacencyList.get(i).x.label);
        }
        for (int i =0; i<n.adjacencyList.size(); ++i) {
            if (!visited[n.adjacencyList.get(i).x.pos]) {
                visited[n.pos] = true;
                DFS(n.adjacencyList.get(i).x, visited, queue);
            }
        }
    }*/

///////////
/*
*     public void independent_storyline_dfs() {
        Boolean[] visited = new Boolean[numberOfNodesInserted];
        for (int k = 0; k<numberOfNodesInserted; ++k)
            visited[k] = false;
        int k = 0;
        int noOfIndpComp = 0;
        String[][] toBePrinted = new String[numberOfNodesInserted][numberOfNodesInserted];
        int[] numberOfNodesPresentPerComponent = new int[numberOfNodesInserted];
        while (k<numberOfNodesInserted) {
            numberOfNodesPresentPerComponent[noOfIndpComp] = DFS(Vertices[k],visited,toBePrinted,0, noOfIndpComp);
            //System.out.println("Statement");
            //sortingForDFS(toBePrinted,toBePrinted.length);
            //for (int i = 0; i<toBePrinted.length; ++i) {
              //  System.out.print(toBePrinted[i] + ",");
            //}
            //sortDFS(toBePrinted,0, numberOfNodesPresentPerComponent[noOfIndpComp] - 1,noOfIndpComp);
            for (int i = k; i<numberOfNodesInserted; ++i)
                if (!visited[i] || i==numberOfNodesInserted-1) {
                    if (i==numberOfNodesInserted-1 && visited[i]) {
                        k=i+1;
                        //System.out.println("Inside loop");
                    } else
                        k=i;
                    //System.out.println("Change k" + k);
                    break;
                }
            //System.out.println(k + "k");
            noOfIndpComp++;
            //System.out.println();
        }
        int cc = 0;
        System.out.println("Ex" + numberOfNodesPresentPerComponent[1]);
        System.out.println(noOfIndpComp + "///" + numberOfNodesPresentPerComponent[0]);
        for (int i = 0; i<noOfIndpComp; ++i) {
            for (int j = 0; j<numberOfNodesInserted && toBePrinted[i][j] != null; ++j) {
                System.out.println(toBePrinted[i][j] + "," + cc++);

            }
        }
    }

    private int DFS(Node n, Boolean[] visited,String[][] toBePrinted, int counter, int row) {
        visited[n.pos] = true;
        //System.out.println(n.label + "   ///////   " + counter);
        toBePrinted[row][counter] = n.label;
        counter++;
        //System.out.println(counter);
        for (int i = 0; i<n.adjacencyList.size(); ++i) {
            if (!visited[n.adjacencyList.get(i).x.pos]) {
                DFS(n.adjacencyList.get(i).x, visited,toBePrinted,counter,row);
                //System.out.println("DFS Loop iteration");;
            }
        }
        //System.out.println(counter);
        return counter;
    }*/

/*
* private void sortDFS(ArrayList<String>[] arr, int left, int right, int row)
    {
        System.out.println("Inside the sortDFS() function");
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            sortDFS(arr, left, mid, row);
            sortDFS(arr, mid + 1, right,row);

            // Merge the sorted halves
            mergeDFS(arr, left, mid, right, row);
        }
    }

    private void mergeDFS(ArrayList<String>[] arr, int low, int mid, int right, int row)
    {
        System.out.println("Inside the merge function top");
        int n1 = mid - low + 1;
        int n2 = right - mid;

        String L[] = new String[n1];
        String R[] = new String[n2];
        System.out.println(low + "  " + mid);
        for (int i = 0; i < n1; ++i)
            L[i] = arr[row].get(low + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[row].get(mid + 1 + j);
        System.out.println(arr[row].get(0) + "  " + arr[row].get(1));
        System.out.println(L[0] + "   " + R[0] + "  Checking");
        int i = 0, j = 0;
        int k = low;
        //System.out.println(n1 + "   " + n2);
        while (i < n1 && j < n2) {
            //System.out.println(L[i] + "   " + R[j]);
            //System.out.println("Checking infinite loop " + i + "   " + j);
            //System.out.println(L[i] + "   " + R[j] + "Where is the change??");
            String name1 = L[i];
            String name2 = R[j];
            //System.out.println("name1 " + name1 + " name2 " + name2);
            for (int z = 0; z<name1.length() && z<name2.length(); ++z) {
                if (name1.charAt(0) == '"' && name2.charAt(0) != '"') {
                    if (name1.charAt(z+1) != name2.charAt(z)) {
                        if (name1.charAt(z+1) > name2.charAt(z)) {
                            arr[row].add(k,R[j]);
                            //arr[row][k] = R[j];
                            j++;
                        } else {
                            arr[row].add(k,L[i]);
                            //arr[row][k] = L[i];
                            i++;
                        }
                        break;
                    }
                } else if (name2.charAt(0) == '"' && name1.charAt(0) != '"') {
                    if (name2.charAt(z+1) != name1.charAt(z)) {
                        if (name1.charAt(z) > name2.charAt(z+1)) {
                            arr[row].add(k,R[j]);
                            //arr[row][k] = R[j];
                            j++;
                        } else {
                            arr[row].add(k,L[i]);
                            //arr[row][k] = L[i];
                            i++;
                        }
                        break;
                    }
                } else if (name2.charAt(0) == '"' && name1.charAt(0) == '"') {
                    if (name2.charAt(z+1) != name1.charAt(z+1)) {
                        if (name1.charAt(z+1) > name2.charAt(z+1)) {
                            arr[row].add(k,R[j]);
                            //arr[row][k] = R[j];
                            j++;
                        } else {
                            arr[row].add(k,L[i]);
                            //arr[row][k] = L[i];
                            i++;
                        }
                        break;
                    }
                } else if (name1.charAt(z) != name2.charAt(z)) {
                    if (name1.charAt(z) > name2.charAt(z)) {
                        arr[row].add(k,R[j]);
                        //arr[row][k] = R[j];
                        j++;
                    } else {
                        arr[row].add(k,L[i]);
                        //arr[row][k] = L[i];
                        i++;
                    }
                    break;
                }
            }
            k++;
        }

        while (i < n1) {
            arr[row].add(k,L[i]);
            //arr[row][k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[row].add(k,R[j]);
            //arr[row][k] = R[j];
            j++;
            k++;
        }
    }
*/