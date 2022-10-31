package midterm;



import java.util.Arrays;

import midterm.DSArrayList;

/**
 * Tester for student solutions to midterm
 */
public class Midterm {
    static DSHashMap<String> hashmap;
    static DSGraph graph;
    static String hashMapAnswer;

    // Global grade
    static int grade = 0;
    public static void main(String[] args) {
        // First grade the three DSHashMap questions
        gradeisConnected();
        gradeNumverticles();
        //gradeToString();
        gradeNumEdges();
        gradehascycles();
        // Now grade the two DSGraph questions
    }
private static void gradeisConnected() {
    System.out.println("\n no you");
    DSGraph g = new DSGraph();
    checkExpect(g.isConnected(), false, "Empty graph", 1);
    g.addEdge("a", "b");
    g.addEdge("a", "d");
    g.addEdge("c", "b");
    g.addEdge("c", "d");
    checkExpect(g.isConnected(), true, "Square graph", 1);
}

private static void gradeNumverticles() {
    System.out.println("\nGrading the numberOfComponents function");
        DSGraph g = new DSGraph();
        checkExpect(g.numVerticles(), 0, "Empty graph", 1);
        g.addEdge("a", "b");
        g.addEdge("a", "d");
        g.addEdge("c", "b");
        g.addEdge("c", "d");
        checkExpect(g.numVerticles(), 4, "Square graph", 1);
        
}
private static void gradeNumEdges() {
    System.out.println("\nGrading the numberOfEdgesfunction");
        DSGraph g = new DSGraph();
        checkExpect(g.numEdges(), 0, "Empty graph", 1);
        g.addEdge("a", "b");
        g.addEdge("a", "d");
        g.addEdge("c", "b");
        g.addEdge("c", "d");
        g.addEdge("e", "d");
        g.addEdge("e", "c");
        checkExpect(g.numEdges(), 6, "pentagon", 1);
        
}
private static void gradehascycles() {
    System.out.println("\nGrading the cycles function");
        DSGraph g = new DSGraph();
        checkExpect(g.hascycle(), false, "Empty graph", 1);
        g.addEdge("a", "b");
        g.addEdge("a", "d");
        g.addEdge("c", "b");
        g.addEdge("c", "d");
        checkExpect(g.hascycle(), false, "Square graph", 1);
}


    /**
     * For grading
     */
    private static void checkExpect(Object studentAnswer, Object correctAnswer, String string, int value) {
        if (studentAnswer.equals(correctAnswer)) {
            grade += value;
            System.out.printf("Correct answer %s for %s. %d/%d\n", String.valueOf(studentAnswer), string, value, value);
        } else {
            System.out.printf("Incorrect answer %s for %s. %d/%d\n", String.valueOf(studentAnswer), string, 0, value);
            System.out.printf("--- Correct answer was %s\n", String.valueOf(correctAnswer));
        }
    }

    /**
     * Test two hash map strings for equality, even if they're scrambled, hopefully.
     * 
     * @param s1
     * @param s2
     * @return
     */
    private static void checkExpectHashMapStrings(String studentAnswer, String correctAnswer, String string,
            int value) {
        String[] m1 = studentAnswer.replaceAll("[{} ]", "").split(",");
        String[] m2 = correctAnswer.replaceAll("[{} ]", "").split(",");
        Arrays.sort(m1);
        Arrays.sort(m2);
        boolean correct = true;
        if (m1.length != m2.length)
            correct = false;
        for (int i = 0; i < m1.length; i++) {
            if (!m1[i].equals(m2[i]))
                correct = false;
        }
        if (correct) {
            grade += value;
            System.out.printf("Correct answer %s for %s. %d/%d\n", String.valueOf(studentAnswer), string, value, value);
        } else {
            System.out.printf("Incorrect answer %s for %s. %d/%d\n", String.valueOf(studentAnswer), string, 0, value);
            System.out.printf("--- Correct answer was %s\n", String.valueOf(correctAnswer));
        }

    }

}
