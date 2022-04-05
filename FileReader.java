import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {
    private Scanner in;
    private PrintWriter pw;
    private String inputFile;
    private String outputFile;
    
    private int[][] matrix;

    public FileReader(String inputFile, String outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        toMatrix();
    }

    private void toMatrix(){
        try{
            in = new Scanner(new File(inputFile));
            //in.useDelimiter(" "); //Change to "," this if the matrix is divided by commas 
        
            int size =  Integer.valueOf(in.nextLine()),
                temp = 0;

            matrix = new int[ size ][ size ];

            for(int i = 0; i < size; i++)
                for(int j = 0; j < size; j++){
                    //Assume that it is a square matrix
                    
                    matrix[i][j] = Integer.valueOf(in.next());
                    

                } 

            in.close();
        }catch(Exception e ){
            if( e instanceof IllegalArgumentException)
                System.out.println("Error: \n" + e.getMessage());
            else if (e instanceof FileNotFoundException)
                System.out.println("File not found");
            else {
                System.out.println("An Error has occurred");
            }
            e.printStackTrace();
            //System.exit(1);
        }
       
    }


    public int[][] getMatrix(){
        return matrix;
    }

    public void printToFile(){
        try{
            pw = new PrintWriter(new File(outputFile));
            for(int[] e : matrix) {
                    for(int f : e )
                        pw.write(f + " ");
                    pw.write("\n");
                }
            pw.close();
        }catch(Exception e ){
            System.out.println("Error writing to file: \n" + e.getMessage());

        }
    }

    public void setInputFile(String inputFile){
        this.inputFile = inputFile;
        toMatrix();
    }
}
