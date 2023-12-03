package package3pt2;

public class Star {
    boolean value=true;
    int[] adjacents=new int[2];
    int freeSpaces=1;

    public int multiplyValues(){
        return this.adjacents[0]*this.adjacents[1];
    }
    
}
