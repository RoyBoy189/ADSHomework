import java.util.LinkedList;

/**
 * This is a class to hold a graph.
 */

public class DSGraph {

    // Our graph is a DSHashMap, mapping strings to a DSArrayList of neighbors
    DSHashMap<DSArrayList<String>> graph;

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
        addVertex(v1);
        // Make sure v2 exists as a vertex
        addVertex(v2);

        // Add v1 and v2 to each others' neighbor lists
        if(graph.get(v1).contains(v2)) return; // Don't add a duplicate edge


