import java.util.TreeSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.LinkedList;

public class File {
    private LinkedList<Block> blockList = new LinkedList<Block>();

    public void loadFile(String fileName) throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner s = new Scanner(fr);
        int i = 0;
        String line = "";
        while (s.hasNextLine()) {

            line = s.nextLine();
            if (!line.isEmpty()) {
                this.blockList.addFirst(new Block(++i));

                // Inner loop to handle the contents of a block
                while (!line.isEmpty() && s.hasNextLine()) {
                    // System.out.println(line);
                    this.blockList.element().addElement(line);
                    line = s.nextLine();
                }
            }
        }
        this.blockList.element().addElement(line);
        s.close();

    }

    public static void main(String[] args) {
        // Start med at læse file intil blocke
        // Lav block intil sets
        StopWatch timer = new StopWatch();
        timer.StartWatch();
        File testFile = new File();
        String filePath = System.getProperty("user.dir") + java.io.File.separator + "Test.txt";
        try {
            testFile.loadFile(filePath);

            /*while (testFile.blockList.size() > 0) {
                //System.out.println(testFile.blockList.removeLast().toString());
                testFile.blockList.removeLast().translate();
            }*/
            for(int i = 0; i < testFile.blockList.size(); i++){
                testFile.blockList.get(i).translate();
                System.out.println();
            }
            System.out.println("\n\n\n");
            for(int i = 0; i < testFile.blockList.size(); i++){
                System.out.println(testFile.blockList.get(i).getSetString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        timer.EndWatch();
        System.out.println(timer.GetTime());

    }

}
