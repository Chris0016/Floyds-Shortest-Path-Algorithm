import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ReaderWriter {
    private Scanner in;
    private FileWriter fw;
    private String inputFile, outputFile;

    public ReaderWriter(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    private int[][] matrix;
    static int MAXN = (int) 1e7;

    public int[][] fileToMatrix() {
        try {
            in = new Scanner(new File(inputFile));
            // in.useDelimiter(" "); //Change to "," this if the matrix is divided by commas

            int size = Integer.valueOf(in.nextLine()),
                    temp = 0;

            matrix = new int[size][size];

            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    // Assume that it is a square matrix
                    temp = Integer.valueOf(in.next());
                    matrix[i][j] = (temp == -1) ? MAXN : temp;

                }

            in.close();
            return matrix;

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                System.out.println("Error: \n" + e.getMessage());
            else if (e instanceof FileNotFoundException)
                System.out.println("File not found");
            else {
                System.out.println("An Error has occurred");
            }
            e.printStackTrace();
            System.exit(1);
        }
        return null;

    }

    public void matrixToFile(int[][] matrix, String message) {
        try {
            fw = new FileWriter(new File(outputFile), true);
            fw.write(message + "\n");
            for (int[] e : matrix) {
                for (int f : e)
                    fw.write(f + " ");
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: \n" + e.getMessage());

        }
    }

    public void printToFile(String message) {
        try {
            fw = new FileWriter(new File(outputFile), true);
            fw.write(message + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: \n" + e.getMessage());

        }
    }

    public int[][] cleanMatrix(int[][] m) {
        int n = m.length,
                curr = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {

                if (m[i][j] == MAXN)
                    m[i][j] = -1;
            }

        return matrix;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
        matrix = null;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

}
