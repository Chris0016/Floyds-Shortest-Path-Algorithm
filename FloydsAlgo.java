public class FloydsAlgo {
    private int[][] adjMatrix, shortestPaths; // -1 Represents Infinity
    private int n;
    private PairsMatrices pMatricies;

    static int MAXN = (int) 1e7;

    public FloydsAlgo(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;

        // Will generate (adjMatrix.length) matricies of dimensions (adjMatrix.length) x
        // (adjMatrix.length).
        n = adjMatrix.length;
        pMatricies = new PairsMatrices(n);
        shortestPaths = new int[n][n];
        calculateShortestPairs();

    }

    /*
     * One thing to note is that the orginal adjency matrix and the newly created
     * matricies are converted from having -1 to represent infinity to MAXN and
     * then back again to -1 after calculations are complete.
     * 
     * A primary reason for this is that the algorithm below runs in O(n^3). Having
     * infinity represented as -1 would mean more logic when comparing two elements
     * which would massively compound in additional
     * computation when running under a O(n^3) function.
     * 
     * Using -1:
     * Use less space
     * Makes code cleaner and less redundant because of having to convert infinity
     * between -1 and MAXN and back to -1
     * 
     * Using MAXN:
     * Less comparisons in calculateShortestPairs() <- runs in O(n^3)
     * 
     * 
     * Conclusion: Although redundant, representing infinity as MAXN instead of -1
     * results in better
     * computation time because of less operations. This difference cannot be
     * observed in this small program
     * but rather in larger ones.
     * 
     * 
     * Other options considered if use -1 instead. This will make the program
     * overall slower.
     * if(pos1 * pos2 < 0)
     * Math.max(pos1, pos2);
     * else
     * Math.min(pos1, pos2);
     * 
     * if(pos1 == -1)
     * item = pos2;
     * else if (pos2 == -1)
     * item = pos1;
     * else
     * Math.min(pos1, pos2);
     * 
     */

    private void calculateShortestPairs() {

        int item = 0,
                pos1,
                pos2;

        int n = adjMatrix.length;
        int[][] prevMatrix = adjMatrix;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    pos1 = prevMatrix[i][j];
                    pos2 = prevMatrix[i][k] + prevMatrix[k][j];

                    // System.out.print("Comparing " + pos1 + " and " + pos2); //Debug

                    item = (pos1 > pos2) ? pos2 : pos1; // Stored in variable for debuggin purposes.

                    // System.out.println(" -> " + item); //Debug
                    // System.out.println("pos: " + k + i + j); //Debug
                    // System.out.println(); //Debug

                    pMatricies.setItem(k, i, j, item);
                }
            }
            prevMatrix = pMatricies.getMatrix(k);
        }
        pMatricies.cleanMatrices();
        calcShortDistMatrix();
    }

    private int calcShortDist(int point1, int point2) {

        int min = pMatricies.getItem(0, point1, point2),
                curr = 0,
                n = adjMatrix.length;

        for (int i = 1; i < n; i++) {
            curr = pMatricies.getItem(i, point1, point2);

            // System.out.print("min: " + min + " curr: " + curr); //Debugging
            if ((min > curr && curr != -1) || min == -1)
                min = curr;

            // System.out.println(" -> " + min); //Debugging
        }

        curr = adjMatrix[point1][point2];
        if (min > curr)
            min = curr;

        return min;
    }

    private void calcShortDistMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPaths[i][j] = calcShortDist(i, j);
            }
        }

    }

    public int shortestDistBetweenPoints(int point1, int point2) {
        return calcShortDist(point1, point2);
    }

    /*
     * Maybe include
     * Result is a string like:
     * Shortest distance between A and B: 2
     * ...
     * Shortest distance between A and D: 10
     * Shortest distance between B and A: 7
     * ...
     */
    // private void generateSummary(){

    // }

    // public String getSummary() {
    // return summary;
    // }

    public int[][] getShortestPathsMatrix() {
        return shortestPaths;
    }

    public PairsMatrices getPMatrices() {
        return pMatricies;
    }
}
