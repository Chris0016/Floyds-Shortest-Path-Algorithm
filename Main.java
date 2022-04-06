public class Main {

    public static void main(String[] args) {

        String basePath = ".\\IO\\";

        String inputFile = basePath + "input.txt";
        String outputFile = basePath + "output.txt";

        ReaderWriter io = new ReaderWriter(inputFile, outputFile);

        int[][] adjMatrix = io.fileToMatrix();
        System.out.println("Adjancey Matrix: ");
        print2DArray(adjMatrix);
        System.out.println();

        FloydsAlgo fAlgo = new FloydsAlgo(adjMatrix);
        PairsMatricies pMatricies = fAlgo.getPMatrices();

        int pMSizes = pMatricies.getTotalMatricies();
        int[][] shortestPathsMatrix = fAlgo.getShortestPathsMatrix();

        System.out.println("Inter Matricies from calculations: ");
        for (int i = 0; i < pMSizes; i++) {
            print2DArray(pMatricies.getMatrix(i));
            System.out.println();
        }

        // Unit test for Shortest Distance Method
        // =========================

        int a = 0,
                b = 1,
                c = 2,
                d = 3;

        System.out.println();
        System.out.println("(Test) Shortest Distance between D and C: ");
        System.out.println(fAlgo.shortestDistBetweenPoints(d, c));

        // =========================

        // Integration test for final result
        // =========================

        System.out.println();
        System.out.println(" Shortest Pairs Matrix: ");
        print2DArray(shortestPathsMatrix);
        System.out.println();

        // =========================

        io.cleanMatrix(adjMatrix); // Turn MAXN values to -1 for better representation.

        // Write out to output file
        // =========================

        io.matrixToFile(adjMatrix, "Adjency Matrix: ");
        io.printToFile("\n");

        for (int i = 0; i < pMSizes; i++) {
            io.matrixToFile(pMatricies.getMatrix(i), "Matrix " + (1 + i) + ": ");
            io.printToFile("\n");
        }

        io.matrixToFile(shortestPathsMatrix, "\nShortest Path Pairs Matrix: \na b c d");
        // =========================
    }

    static void print2DArray(int[][] arr) {
        for (int[] e : arr) {
            for (int f : e)
                System.out.print(f + " ");
            System.out.println();
        }
    }

}