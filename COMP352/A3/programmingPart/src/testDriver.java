import java.io.*;
import java.util.Scanner;

public class testDriver {
    public static void main(String[] args) {
        SmartAR_Sequence<Car> test = new SmartAR_Sequence<>();
        Scanner input = null;
        File benchMark = new File("./benchmarkFiles/ar_test_file1.txt");
        try {
            input = new Scanner(new FileInputStream(benchMark));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            System.exit(0);
        }

        while(input.hasNextLine()) {
            test.add(input.nextLine(), new Car());
        }

        System.out.println(test.nextKey("hsbdjhabsdjab"));


        input.close();
    }
}
