import java.io.*;
import java.util.Scanner;

public class removeDEBUG {

    public static void main(String[] args) {
        File target = new File("./output/output-semaphore1.txt");
        remove(target);
        System.out.println("Done removing DEBUG tag");
    }

    public static void remove(File output) {
        String keyword = "DEBUG";

        Scanner sc = null;
        String content = "";

        try {
            sc = new Scanner(new FileInputStream(output));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file to operate");
        }

        String line;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(!line.contains(keyword) && !line.isBlank()) {
                content = content + "\n" + line;
            }
        }

        sc.close();


        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(output));
            pw.println("OUTPUT FILE WITHOUT DEBUG FLAGS");
            pw.println(content);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        pw.close();
    }
}
