public class Cord {
    public int XPos;
    public int YPos;
    public Cord(){
        this.XPos = -1;
        this.YPos = -1;
    }
    public <type> Cord(type x, type y){
        XPos = (int)x;
        YPos = (int)y;
    }
    public Cord(Cord other){
        this.XPos = other.XPos;
        this.YPos = other.YPos;
    }
    //this method assumes that the co ordinates stored
    //within the instance are of the board co ordinates format
    public int ToIndex(){
        return (XPos - 1 + (8*(YPos-1)));
    }
}
