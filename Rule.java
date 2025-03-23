package Reve;

import java.awt.Point;
import java.util.Scanner;

public class Rule {

    //棋子移动的八个方向
    private static int moveX[]={-1, 0, 1, 1, 1, 0,-1,-1};
    private static int moveY[]={-1,-1,-1, 0, 1, 1, 1, 0};
    
    //棋盘的边界
    private static int leftborder=1,rightborder=8;

    public static boolean whetherInBoard(int extendX,int extendY){
        if(extendX>=leftborder && extendX<=rightborder && extendY>=leftborder && extendY<=rightborder){return true;}
        return false;
    }

    //判断点（x，y）是否为piece的合理位置，以及通过控制wherToReversi来选择是否进行翻转棋盘上的棋子
    public static boolean whetherCanReversi(board board,Point position,char piece,boolean whetherToReversi){
        boolean exist=false;

        //op是opposite的简写，表示与传入棋子颜色相反的棋子
        char op=piece==(player.PLAYER1.getPiece())?(player.PLAYER2.getPiece()):(player.PLAYER1.getPiece());

        //往八个方向均试探一遍，检查是否有颜色相反的棋子
        for(int cout=0;cout<rightborder;cout++){ 
            boolean hasOP=false;
            int extendX=position.x+moveX[cout];
            int extendY=position.y+moveY[cout];

            //如果有则继续往该方向延申，直到尽头
            while(whetherInBoard(extendX, extendY) && board.getboard()[extendX][extendY]==op){extendX+=moveX[cout];extendY+=moveY[cout];hasOP=true;}
            
            //检查尽头是否有与传入棋子颜色相同的棋子
            if(whetherInBoard(extendX, extendY)&& board.getboard()[extendX][extendY]==piece && hasOP){

                //成立则exist存在
                exist=true;

                //往原方向相反的方向返回，将棋子进行翻转
                while((extendX!=position.x || extendY!=position.y) && whetherToReversi){
                    if(!whetherInBoard(extendX, extendY)){
                        break;
                    }
                    extendX-=moveX[cout];extendY-=moveY[cout];
                    board.getboard()[extendX][extendY]=piece;}
                }
        }
        return exist;
    }

    //判断是否该点为空点
    public static boolean whetherBlank(board board,Point position){if(board.getboard()[position.x][position.y]!='·'){return false;}return true;}

    //寻找棋盘上可以下的点位,通过控制indication来选择是否给出提示
    public static boolean whetherToIndicate(board board,char piece,boolean indication){
        int count=0;
        if(indication){System.out.println("当前"+piece+"可下的位置是：");}
        for(int i=leftborder;i<=rightborder;i++){
            for(int j=leftborder;j<=rightborder;j++){
                if(whetherBlank(board,new Point(i,j)) && whetherCanReversi(board,new Point(i,j),piece,false)){
                    count++;
                    if(indication){System.out.print(""+board.getboard()[i][0]+board.getboard()[0][j]+" ");}
                }
            }
        }
        if(count!=0){return true;}
        System.out.println("无");
        return false;
    }

    public static boolean indication(char ans){if(ans=='Y')return true;return false;}


    public static boolean rule(board board,Point position,char piece,Scanner scanner){
        char ans;
        if(whetherBlank(board,position)){
            if(whetherCanReversi(board,position,piece,false)){
                whetherCanReversi(board,position,piece,true);
                return true;
            }else{
                System.out.println(piece+" 落点不符合规则，是否需要提示[Y/N]");
                ans=scanner.next().charAt(0);
                if(indication(ans)){whetherToIndicate(board,piece,true);}
                System.out.println("请重新输入");
            }   
        }
        else{
            System.out.println("该落点已被占用，请重新输入");
        }
        return false;
    }
}
