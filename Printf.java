package Reve;

//打印当前棋盘与得分
public class Printf {
    public static void print(String name1,String name2,board board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print("  "+board.getboard()[i][j]);
            }
            if(i==3){System.out.print(" 棋盘"+board.getOrder());}
            if(i==4){System.out.print(" 玩家【"+name1+"】"+player.PLAYER1.getPiece()+"得分:"+Count.count(board.getboard(),board.getSize())[0]);}
            if(i==5){System.out.print(" 玩家【"+name2+"】"+player.PLAYER2.getPiece()+"得分:"+Count.count(board.getboard(),board.getSize())[1]);}
            System.out.println();
        }
    }
}
