import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {
    private Scanner in;
    private FileWriter fw;
    private String inputFile;
    private String outputFile;

    private int[][] matrix;
    static int MAXN = (int) 1e7;

    public FileReader(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        toMatrix();
    }

    private void toMatrix() {
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
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                System.out.println("Error: \n" + e.getMessage());
            else if (e instanceof FileNotFoundException)
                System.out.println("File not found");
            else {
                System.out.println("An Error has occurred");
            }
            e.printStackTrace();
            // System.exit(1);
        }

    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void printToFile(int[][] matrix, String message) {
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

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
        toMatrix();
    }
}
