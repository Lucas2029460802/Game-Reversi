package Reve;

import java.awt.Point;
import java.util.ArrayList;
//打印当前棋盘与得分

public class Printf {
    public static void print(board board,ArrayList<board> boards,char piece){
        char indication='+';
        int leftBorder=0,rightBorder=9;
        int maxLength=Math.max(player.PLAYER1.getName().length(),player.PLAYER2.getName().length());
        String formaBlank=String.format("%-"+maxLength+1+"s",' ');
        String formaName1=String.format("%-"+maxLength+"s",player.PLAYER1.getName());
        String formaName2=String.format("%-"+maxLength+"s",player.PLAYER2.getName());
        ArrayList<Point> legalDots=Rule.whetherToIndicate(board, piece);

        for(Point dots:legalDots){
            board.getboard()[dots.x][dots.y]=indication;
        }
        for(int i=leftBorder;i<rightBorder;i++){
            for(int j=leftBorder;j<rightBorder;j++){
                System.out.print("  "+board.getboard()[i][j]);
            }
            if(i==2){System.out.print(formaBlank+"Game List");}
            if(i==3){System.out.print("  Game"+board.getOrder());}
            if(i==4){System.out.print("  Player1【"+formaName1+"】"+player.PLAYER1.getPiece()+"scores:"+Count.count(board.getboard(),board.getSize())[0]);}
            if(i==5){System.out.print("  Player2【"+formaName2+"】"+player.PLAYER2.getPiece()+"scores:"+Count.count(board.getboard(),board.getSize())[1]);}
            System.out.println();
        }
        for(Point dots:legalDots){
            board.getboard()[dots.x][dots.y]=board.getblank();
        }
    }

}
