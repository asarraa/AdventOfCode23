package Package4pt2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class Main {
    
        public static void main(String args[]) throws FileNotFoundException{        
            String line;
            Puzzle4 puzzle= new Puzzle4();        
            Scanner sc= new Scanner(new FileReader("Package4pt2/test.txt"));        
            while(sc.hasNextLine()){            
                line=sc.nextLine();         
                puzzle.winningChecker(line);      
            }
            puzzle.copiesSetter();
        puzzle.getSum();
    }
}