package Package4pt2;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class Puzzle4 {

    int sum=0;
    int[] winningValues= new int[11]; //11
    int[] myValues=new int[26]; //26
    Pattern p=Pattern.compile("\\d+");
    Pattern slash=Pattern.compile("|");
    ArrayList<Line> lines= new ArrayList<Line>();
    

    public Puzzle4(){
        winningValues[0]=1; //prima cella contiene ultimo indice usato
        myValues[0]=1;
    }

    public void winningChecker(String line){
        boolean isfirst=true;
        this.winningValues[0]=1;
        this.myValues[0]=1;
        int[] actualArray=this.winningValues;
        Matcher mdigits=p.matcher(line);
        boolean found=false;
        int matches=0;
        Line actualLine=new Line();


//estraggo numeri da linea e li metto in due array separati
        while(mdigits.find()){ //finchè trova un'occorrenza della regex
            if(isfirst==false)
            { 
                int num=Integer.parseInt(mdigits.group());
                actualArray[actualArray[0]]=num;
                if(actualArray[0]+1<actualArray.length){
                    actualArray[0]++;
                }
                int firstDigit=mdigits.start();
                int lastDigit=mdigits.end();
                if(line.length()>lastDigit+1 && line.charAt(lastDigit+1)=='|')
                {
                    actualArray=this.myValues;
                }
            }
            else
            {
                int num=Integer.parseInt(mdigits.group());
                actualLine.idSetter(num);
                lines.add(actualLine);                
            }
            isfirst=false;
        }

//calcolo numero matches
        for(int i=1; i<myValues.length; i++){
            found=false;
            for(int j=1; j<winningValues.length && found==false; j++){
                if(myValues[i]==winningValues[j]){
                    found=true;
                    actualLine.matches++;
                }
            }
        }       
    }

    public void copiesSetter(){
        for(Line n: this.lines){
            while(n.copies>0)
            {                        
                this.sum=this.sum+1;
                for(Line k: this.lines){
                    if(k.lineId>n.lineId && k.lineId<=(n.lineId+n.matches)){
                        System.out.println(k.lineId);
                        k.copies++;
                    }
                }
                n.copies--;
            }
        }
    }



    public void getSum(){
         System.out.println("somma: " + this.sum);
    }

    }

