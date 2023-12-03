package package3pt2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class Main {
    
        public static void main(String args[]) throws FileNotFoundException{
        String line;
        Puzzle3 puzzle=new Puzzle3();
        Scanner sc= new Scanner(new FileReader("test.txt"));
        while(sc.hasNextLine()){
            
            line=sc.nextLine();
            puzzle.symbolsAssigner(line);

        }
        puzzle.actualLineNumberResetter();
        Scanner sc2=new Scanner(new FileReader("test.txt"));
        while(sc2.hasNextLine()){
            line=sc2.nextLine();
            puzzle.numbersChecker(line);
        }


        puzzle.getSum();
        
    }
}
