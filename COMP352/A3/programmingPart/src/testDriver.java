import java.io.*;
import java.util.Scanner;

public class testDriver {
    public static void main(String[] args) {
        SmartAR_HashTable<Car> test = new SmartAR_HashTable<>();

        Scanner input = null;
        File benchMark = new File("./benchmarkFiles/ar_test_file3.txt");
        try {
            input = new Scanner(new FileInputStream(benchMark));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            System.exit(0);
        }

        while(input.hasNextLine()) {
            test.add(input.nextLine(), new Car());
        }

        System.out.println("# of collision: " + test.getCollision());

        /*
        System.out.println("Historical data of key: ");
        if(test.previousCars("IMX1PL").size() != 0) {
            for(Entry each : test.previousCars("IMX1PL")) {
                System.out.println(each.getKey());
            }

        }

         */

        /*
        for(String each : test.allKeys()) {
            System.out.println(each);
        }

         */


        System.out.println("The size of the structure: " + test.getSize());

        input.close();
    }
}
