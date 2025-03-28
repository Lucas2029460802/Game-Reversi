package Reve;

import java.awt.Point;
import java.util.ArrayList;
//打印当前棋盘与得分

public class Printf {
    public static void print(board board,ArrayList<board> boards,char piece){

        //提示的字符
        char indication='+';

        //棋盘的左边界与右边界
        int leftBorder=0,rightBorder=9;
        int BoardsSize=boards.size();
        int maxLength=Math.max(player.PLAYER1.getName().length(),player.PLAYER2.getName().length());
        
        //格式化打印昵称
        String formaName1=String.format("%-"+maxLength+"s",player.PLAYER1.getName());
        String formaName2=String.format("%-"+maxLength+"s",player.PLAYER2.getName());
        ArrayList<Point> legalDots=Rule.whetherToIndicate(board, piece);

        //在棋盘上修改提示
        for(Point dots:legalDots){
            board.getboard()[dots.x][dots.y]=indication;
        }
        for(int i=leftBorder;i<rightBorder;i++){
            for(int j=leftBorder;j<rightBorder;j++){
                System.out.print("  "+board.getboard()[i][j]);
            }
            if(i==3){System.out.print("  Game"+board.getOrder());}
            if(i==4){System.out.print("  Player1["+formaName1+"] "+player.PLAYER1.getPiece()+' '+Count.count(board.getboard(),board.getSize())[0]);}
            if(i==5){System.out.print("  Player2["+formaName2+"] "+player.PLAYER2.getPiece()+' '+Count.count(board.getboard(),board.getSize())[1]);}
            System.out.println();
        }

        //打印当前开的所有游戏
        System.out.println();
        System.out.println(" [GameList]");

        for(int i=0;i<BoardsSize;i++){
            System.out.println(" "+(int)(i+1)+"."+boards.get(i).getModel());
        }

        System.out.println();
        
        //将提示改回空白字符，防止干扰下次提示
        for(Point dots:legalDots){
            board.getboard()[dots.x][dots.y]=board.getblank();
        }
    }

}
