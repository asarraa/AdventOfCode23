package package3;

public class Puzzle3 {
    boolean[][] symbols;
    int max=0;
    int sum=0;
    int actualLineNumber=0;
    boolean firstTime=true;


    public void symbolsAssigner(String line){
        if(firstTime==true){
            this.symbols=new boolean[160][line.length()+10];
            this.firstTime=false;
        }
        int i=0;
        while(i<line.length())
        {
            if(!Character.isLetterOrDigit(line.charAt(i)) && line.charAt(i)=='.'){
                this.symbols[actualLineNumber][i]=true;
            }
            else this.symbols[actualLineNumber][i]=false;
            i++;
        }
        this.max=actualLineNumber;
        actualLineNumber++;
    }



    public void actualLineNumberResetter(){
        this.actualLineNumber=0;
    }

    public void numbersChecker(String string){
        int k=0;
        int i;
        int[] limits= new int[3];
        int number=0;
        boolean isAdjacent=false;
        while(k<string.length()){ 
            isAdjacent=false;
            if(string.charAt(k)<='9' && string.charAt(k)>='0'){
                limits[0]=k;
                if(k<string.length()-1) //se non sono all'ultima cella
                {
                    if(string.charAt(k+1)<='9' && string.charAt(k+1)>='0') //se c'è cifra successiva (2 cifre)
                    {
                        if(k<string.length()-2 && string.charAt(k+2)<='9' && string.charAt(k+2)>='0') //se c'è cifra successiva (3 cifre)
                        {
                            number=number+Character.getNumericValue(string.charAt(k+2)); //unità
                            number=number+Character.getNumericValue(string.charAt(k+1))*10; //decine
                            number=number+Character.getNumericValue(string.charAt(k))*100; //centinaia
                            limits[1]=k+2;
                            limits[2]=number;
                            number=0;
                            k=k+3; //skippo l'intero numero
                        }
                        else
                        {
                        number=number+Character.getNumericValue(string.charAt(k+1)); //unità
                        number=number+Character.getNumericValue(string.charAt(k))*10; //decine
                        limits[1]=k+1;
                        limits[2]=number;
                        number=0;
                        k=k+2; //skippo l'intero numero
                        }

                    }
                    else
                    {
                        number=number+Character.getNumericValue(string.charAt(k)); //ci saranno solo le unità
                        limits[1]=k;
                        limits[2]=number;
                        number=0;
                        k=k+1;
                    }
                }
                else
                {
                    number=number+Character.getNumericValue(string.charAt(k)); //ci saranno solo le unità
                    limits[1]=limits[0];
                    limits[2]=number;
                    number=0;
                    k=string.length();
                }


                System.out.println("numero trovato: " + limits[2]);

                if(limits[0]!=0 && limits[1]!=(string.length()-1)){
            if(actualLineNumber!=0 && actualLineNumber!=max) 
            {
                for(i=limits[0]-1; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                    for(int j=actualLineNumber-1; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                        if(this.symbols[j][i]==true)
                        {
                            isAdjacent=true;
                        }
                    }
                }
            }
            else
            { 
                if (actualLineNumber==0)
                {
                        for(i=limits[0]-1; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                        }
                }
                else 
                { 
                    if(actualLineNumber==max)
                    {
                        for(i=limits[0]-1; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber-1; j<=actualLineNumber && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                            }

                    }
                } 
            }   
        }
        else 
        {       
            if(limits[0]==0){
                    if(actualLineNumber!=0 && actualLineNumber!=max) 
                    {
                        for(i=limits[0]; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber-1; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                        }
                    }
            else
            { 
                if (actualLineNumber==0)
                {
                        for(i=limits[0]; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                        }
                }
                else 
                { 
                    if(actualLineNumber==max)
                    {
                        for(i=limits[0]; i<=limits[1]+1 && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber-1; j<=actualLineNumber && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                            }

                    }
                } 
            }   
                }
                else 
                { 
                  if(limits[1]==(string.length()-1))
                  {
                    if(actualLineNumber!=0 && actualLineNumber!=max) 
                    {
                        for(i=limits[0]-1; i<=limits[1] && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber-1; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                        }
                    }
            else
            { 
                if (actualLineNumber==0)
                {
                        for(i=limits[0]-1; i<=limits[1] && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber; j<=actualLineNumber+1 && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                        }
                }
                else 
                { 
                    if(actualLineNumber==max)
                    {
                        for(i=limits[0]-1; i<=limits[1] && isAdjacent==false; i++){      //per tutta la lunghezza del numero + gli adiacenti
                            for(int j=actualLineNumber-1; j<=actualLineNumber && isAdjacent==false; j++){  //per la linea precedente, la linea attuale e la linea successiva
                                if(this.symbols[j][i]==true)
                                {
                                    isAdjacent=true;
                                }
                            }
                            }

                    }
                } 
            }   
                  }

                }
        }


        if(isAdjacent==true){
        System.out.println("numero da aggiungere: " + limits[2]);
        sum=sum+limits[2];
        }   

        }
        else k++;
        number=0;
    }
        actualLineNumber++;

        //caso ottimo, numero non ai limiti della linea e linea non ai limiti
        
    }

    public void getSum(){
        System.out.println(sum);
    }

}
