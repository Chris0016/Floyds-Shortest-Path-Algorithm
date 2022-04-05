public class Main {

    public static void main(String[] args) {
        // Read matrix: File Reader

        String basePath = ".\\IO\\";

        String inputFile = basePath + "input.txt";
        String outputFile = basePath + "output.txt";

        FileReader io = new FileReader(inputFile, outputFile);

        int[][] adjMatrix = io.getMatrix();
        print2DArray(adjMatrix);
        io.printToFile(adjMatrix, "Adjency Matrix: ");

        System.out.println();

        FloydsAlgo fAlgo = new FloydsAlgo(adjMatrix);
        PairsMatricies pMatricies = fAlgo.getPMatrices();

        int pMSizes = pMatricies.getTotalMatricies();

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
        System.out.println("Shortest Distance between D and C: ");
        System.out.println(fAlgo.shortestDistance(d, c));

        // =========================

        // Integration test for final result
        // =========================

        System.out.println();
        System.out.println(" Shortest Pairs Matrix: ");
        print2DArray(fAlgo.getShortestPathsMatrix());
        System.out.println();

        // =========================

        // Write out to output file
        // =========================
        for (int i = 0; i < adjMatrix.length; i++) {
            io.printToFile(fAlgo.getPMatrices().getMatrix(i), "Matrix " + (1 + i) + ": ");
        }

        io.printToFile(fAlgo.getShortestPathsMatrix(), "Shortest Path Pairs Matrix: ");
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