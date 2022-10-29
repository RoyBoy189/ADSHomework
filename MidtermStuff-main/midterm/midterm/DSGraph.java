package midterm;

import java.util.LinkedList;

import javax.management.NotificationBroadcaster;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.TreeUI;

import midterm.DSArrayList;

/**
 * This is a class to hold a graph.
 */

public class DSGraph {
  // Our graph is a DSHashMap, mapping strings to a DSArrayList of neighbors
  DSHashMap<DSArrayList<String>> graph;
  static int WHITE = 0, GRAY = 1, BLACK = 2;

  public DSGraph() {
    this.graph = new DSHashMap<>();
  }

  /**
   * Adds a vertex to the graph, if it is not already there.
   * 
   * @param v The String that represents the new vertex
   */
  public void addVertex(String v) {
    // Make sure v1 exists as a vertex
    if (!graph.containsKey(v)) {
      graph.put(v, new DSArrayList<String>());
    }
  }

  /**
   * Add an edge between vertices v1 and v2.
   * If v1 and/or v2 do not already exist, create them.
   * 
   * @param v1 The first vertex
   * @param v2 The second vertex
   */
  public void addEdge(String v1, String v2) {
    // Make sure v1 exists as a vertex
    if (!graph.containsKey(v1)) {
      graph.put(v1, new DSArrayList<String>());
    }
    // Make sure v2 exists as a vertex
    if (!graph.containsKey(v2)) {
      graph.put(v2, new DSArrayList<String>());
    }
    // Add v1 and v2 to each others' neighbor lists
    graph.get(v1).add(v2);
    graph.get(v2).add(v1);
  }

  

  // //System.out.printf("The component containing %s has size %d\n", start,
  // componentSize);
  // }
  // return count;
  // }
  public int numVerticles() {
    DSHashMap<String> visited = new DSHashMap<>();
    DSHashMap<String> parent = new DSHashMap<>();
    LinkedList<String> q = new LinkedList<>();
    for (String k : graph) {
      q.add(k);
    }
    return q.size();
  }

  public int numEdges() {
    LinkedList<String> q = new LinkedList<>();
    // visited keeps track of vertices we've seen before
    DSHashMap<String> visited = new DSHashMap<>();
    int componentSize = 1;
    int count = 0;
    count++;
    // Loop over all vertices of the graph
    for (String start : graph) {
      if (visited.containsKey(start)) continue;

      // New, unseen vertex. Do a BFS from v
      q.clear();
      q.add(start); // v is this BFS's start verte
      while (!q.isEmpty()) {
        String v = q.removeFirst();
        for (String nbr : graph.get(v)) {
          if (visited.containsKey(nbr)) continue; // move on to the next neighbor
          q.add(nbr);
          visited.put(nbr, v);
          componentSize += graph.get(v).length;
          }
          
        }     
      }
      
     return componentSize / 2;
  }

  public boolean isConnected() {
    int count = 0;
    boolean coonected = false;
    LinkedList<String> q = new LinkedList<>();
    // visited keeps track of vertices we've seen before
    DSHashMap<String> visited = new DSHashMap<>();

    // Loop over all vertices of the graph
    for (String start : graph) {
      if (visited.containsKey(start))
        continue;

      // New, unseen vertex. Do a BFS from v
      q.clear();
      q.add(start); // v is this BFS's start vertex
      count++;
      int componentSize = 1;

      while (!q.isEmpty()) {
        String v = q.removeFirst();
        for (String nbr : graph.get(v)) {
          if (visited.containsKey(nbr))
            continue; // move on to the next neighbor
          q.add(nbr);
          componentSize++;
          visited.put(nbr, "");
          if (count == 0) {
            coonected = false;
          }
          if (count > 1) {
            coonected = false;
          }
          coonected = true;
        }

      }

      // System.out.printf("The component containing %s has size %d\n", start,
      // componentSize);
    }
    return coonected;
  }
  
  public int discoverAllComponents() {
    int count = 0;
    LinkedList<String> q = new LinkedList<>();
    // visited keeps track of vertices we've seen before
    DSHashMap<String> visited = new DSHashMap<>();

    // Loop over all vertices of the graph
    for (String start : graph) {
      if (visited.containsKey(start))
        continue;

      // New, unseen vertex. Do a BFS from v
      q.clear();
      q.add(start); // v is this BFS's start vertex
      int componentSize = 1;
      count++;
      while (!q.isEmpty()) {
        String v = q.removeFirst();
        for (String nbr : graph.get(v)) {
          if (visited.containsKey(nbr))
            continue; // move on to the next neighbor
          q.add(nbr);
          componentSize++;
          visited.put(nbr, "");
        }

      }

      // System.out.printf("The component containing %s has size %d\n", start,
      // componentSize);
    }
    return count;
  }
}

