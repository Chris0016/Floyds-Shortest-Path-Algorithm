public class FloydsAlgo {
    private int[][] adjMatrix, shortestPaths; // -1 Represents Infinity
    private int n;
    private String summary;
    private PairsMatricies pMatricies;

    static int MAXN = (int) 1e7;

    public FloydsAlgo(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;

        // Will generate (adjMatrix.length) matricies of dimensions (adjMatrix.length) x
        // (adjMatrix.length).
        n = adjMatrix.length;
        pMatricies = new PairsMatricies(n);
        shortestPaths = new int[n][n];
        calculateShortestPairs();

    }

    private void calculateShortestPairs() {
        // Initialize values in pMatricies

        int item = 0;
        int n = adjMatrix.length;
        int[][] prevMatrix = adjMatrix;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // Maybe change logic: instead of -1 use Integer.MAX_INT. More space but less
                    // comparisons
                    int pos1 = prevMatrix[i][j];
                    int pos2 = prevMatrix[i][k] + prevMatrix[k][j];

                    // System.out.print("Comparing " + pos1 + " and " + pos2); //Debug

                    item = ((pos1 > pos2) && (pos2 != -1)) ? pos2 : pos1;

                    // if (item >= MAXN)
                    // item = -1;

                    // System.out.println(" -> " + item); //Debug
                    // System.out.println("pos: " + k + i + j); //Debug
                    // System.out.println(); //Debug

                    pMatricies.setItem(k, i, j, item);
                }
            }

            prevMatrix = pMatricies.getMatrix(k);

        }
        pMatricies.cleanMatrices();
        calcSummary();
    }

    public void calcSummary() {
        // use pMatriesces to generate a summary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPaths[i][j] = shortestDistance(i, j);
            }

        }

    }

    public int shortestDistance(int point1, int point2) {

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

    public String getSummary() {
        return summary;
    }

    public int[][] getShortestPathsMatrix() {
        return shortestPaths;
    }

    // Testing only. Delete after use.
    public PairsMatricies getPMatrices() {
        return this.pMatricies;
    }
}
