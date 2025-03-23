package Reve;

//将棋子放在棋盘上

import java.awt.Point;

public class Put {
    public static void put(board board,Point position,char piece){
        board.getboard()[position.x][position.y]=piece;
    }
}
