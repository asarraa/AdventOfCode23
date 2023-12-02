package package1;
import java.util.*;
import java.io.*;

public class Puzzle1{
    
    List<Number> numbers;
    int sum=0;

    public void createNumbers(){
        List<Number> numbers= new ArrayList<Number>();
        numbers.add(new Number("one", 1));
        numbers.add(new Number("two", 2));
        numbers.add(new Number("three", 3));
        numbers.add(new Number("four", 4));
        numbers.add(new Number("five", 5));
        numbers.add(new Number("six", 6));
        numbers.add(new Number("seven", 7));
        numbers.add(new Number("eight", 8));
        numbers.add(new Number("nine", 9));

        
        this.numbers=numbers;
    }

    public void CalibationValues(String string){
        int[] array= new int[2];
        int[] positionArray= new int[2];
        int num;
        int value=0;
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)<='9' && string.charAt(i)>=0)
            {
                num=Character.getNumericValue(string.charAt(i));
                //num=((int)string.charAt(i));
                if(value==0){
                    array[0]=num;
                    positionArray[0]=i;
                }
                else 
                {
                    array[1]=num;
                    positionArray[1]=i;
                }
                value++;
            }
        }
        if(value==0){
            positionArray[0]=string.length();
            positionArray[1]=0;
        }
        else
        {
            if(value==1){
                array[1]=array[0];
                positionArray[1]=positionArray[0];
            }
        }
        
        for(Number n: numbers){
            int j=string.indexOf(n.testo);
            if(j<positionArray[0] && j!=-1){
                array[0]=n.valore;
                positionArray[0]=j;
            }
            j=-1;
            while(string.indexOf(n.testo, j+1)!=-1)
            {
                j=string.indexOf(n.testo, j+1);
            }
            if(j>positionArray[1] && j!=-1){
                array[1]=n.valore;
                positionArray[1]=j;
            }
        }

        System.out.println(array[0] + " " + array[1]);
        this.sum=sum+array[0]*10+array[1];
    }

    public void getSum(){
        System.out.println(sum);
    }

}