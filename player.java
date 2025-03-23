package Reve;

//玩家名字和黑白棋形状
public enum player{
    PLAYER1('●'),
    PLAYER2('○');

    private String name;
    private final char piece;
    player(char piece){
        this.piece=piece;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    
    public char getPiece(){
        return piece;
    }
}
