package Reve;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static char pieceBlackOrWhite(int eachBoardTurn){
        if(eachBoardTurn==1){return player.PLAYER1.getPiece();}
        return player.PLAYER2.getPiece();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1, name2;
        int changeBoard=1111,peaceModel=2222,reversiModel=3333,GameNums=0;

        // position：坐标点，eachBoardTurn：轮到黑棋还是白棋下，whichBoard：当前游戏编号
        Point position = new Point(0, 0);
        ArrayList<Integer> eachBoardTurn =new ArrayList<>(Arrays.asList(1,1));
        int whichBoard = 0;
        ArrayList<board> boards = new ArrayList<>();

        // 初始化棋盘
        boards.add(new board(++GameNums,"peace"));
        boards.add(new board(++GameNums,"reversi"));

        // 输入玩家的名字
        System.out.println("Please enter the names of Player 1 and Player 2.");
        name1 = scanner.nextLine();
        name2 = scanner.nextLine();
        player.PLAYER1.setName(name1);
        player.PLAYER2.setName(name2);
        Printf.print(boards.get(whichBoard),boards,player.PLAYER1.getPiece());

        

        // 判断棋盘是否被下满，结束游戏
        while (Count.count(boards.get(whichBoard).getboard(),
            boards.get(whichBoard).getSize())[2] != boards.get(whichBoard).getMax()) {
            switch (eachBoardTurn.get(whichBoard)) {

                // case1：轮到黑棋下
                case 1:
                    System.out.println("【" + player.PLAYER2.getName() + "】请输入" + player.PLAYER1.getPiece() + "的坐标/游戏编号1-"+GameNums+"/新游戏类型[peace/reversi]");
                    position = Input.input(scanner);

                    // 切换棋盘
                    if (position.y == changeBoard) {
                        int lastBoard=whichBoard;
                        whichBoard = position.x;
                        try{
                            Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                            System.out.println("Switch to Game " + (int)(whichBoard+1));
                            break;
                        }catch(Exception e){
                            whichBoard=lastBoard;
                            System.out.println("输入的棋盘编号不正确");
                            break;
                        }
                    }

                    //新游戏：peace模式
                    if(position.y == peaceModel){
                        boards.add(new board(++GameNums,"peace"));
                        eachBoardTurn.add(1);
                        System.out.println("New Game: Game"+GameNums+"[peace]");
                        whichBoard=GameNums-1;
                        Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                        break;
                    }

                    //新游戏：reversi模式
                    if(position.y == reversiModel){
                        boards.add(new board(++GameNums,"reversi"));
                        eachBoardTurn.add(1);
                        System.out.println("New Game: Game"+GameNums+"[reversi]");
                        whichBoard=GameNums-1;
                        Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                        break;
                    }

                    // 用户选择输入黑棋坐标点
                    else {
                        if (!Rule.whetherToIndicate(boards.get(whichBoard), player.PLAYER1.getPiece()).isEmpty() || ("peace".equals(boards.get(whichBoard).getModel()))) {

                            // 判断下棋的位置是否符合规则
                            if (Rule.rule(boards.get(whichBoard), position, player.PLAYER1.getPiece())) {

                                // 符合规则下棋
                                Put.put(boards.get(whichBoard), position, player.PLAYER1.getPiece());

                                // 切换为玩家2：白棋
                                eachBoardTurn.set(whichBoard, 2);
                                
                                Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                                break;
                                

                                // 不符合下棋规则，下一次下棋方黑棋继续
                            } else {
                                eachBoardTurn.set(whichBoard, 1);
                                break;
                            }
                            // 黑棋没有可以下的位置，白棋继续下
                        } else {
                            System.out.println("黑棋无处可下，白棋继续");
                            eachBoardTurn.set(whichBoard, 2);
                            break;
                        }
                    }

                    // case2：轮到白棋下
                case 2:
                    System.out.println("【" + player.PLAYER2.getName() + "】请输入" + player.PLAYER2.getPiece() + "的坐标/游戏编号1-"+GameNums+"/新游戏类型:[peace/reversi]");
                    position = Input.input(scanner);

                    // 切换棋盘
                    if (position.y == changeBoard) {
                        int lastBoard=whichBoard;
                        whichBoard = position.x;
                        try{
                            Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                            System.out.println("Switch to Game " + (int)(whichBoard+1));
                            break;
                        }catch(Exception e){
                            whichBoard=lastBoard;
                            System.out.println("输入的棋盘编号不正确");
                            break;
                        }
                    }

                    //新游戏：peace模式
                    if(position.y == peaceModel){
                        boards.add(new board(++GameNums,"peace"));
                        eachBoardTurn.add(1);
                        System.out.println("New Game: Game"+GameNums+" peace");
                        whichBoard=GameNums-1;
                        Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                        break;
                    }

                    //新游戏：reversi模式
                    if(position.y == reversiModel){
                        boards.add(new board(++GameNums,"reversi"));
                        eachBoardTurn.add(1);
                        System.out.println("New Game: Game"+GameNums+" reversi");
                        whichBoard=GameNums-1;
                        Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                        break;
                    }

                    // 用户选择输入白棋坐标点
                    else {
                        if (!Rule.whetherToIndicate(boards.get(whichBoard), player.PLAYER2.getPiece()).isEmpty() || ("peace".equals(boards.get(whichBoard).getModel()))) {

                            // 判断下棋的位置是否符合规则
                            if (Rule.rule(boards.get(whichBoard), position, player.PLAYER2.getPiece())) {

                                // 符合规则下棋
                                Put.put(boards.get(whichBoard), position, player.PLAYER2.getPiece());

                                // 将下一次下棋方切换为玩家1：黑棋
                                eachBoardTurn.set(whichBoard, 1);

                                Printf.print(boards.get(whichBoard),boards,pieceBlackOrWhite(eachBoardTurn.get(whichBoard)));
                                break;

                                // 不符合下棋规则，下一次下棋方白棋继续
                            } else {
                                eachBoardTurn.set(whichBoard, 2);
                                break;
                            }

                            // 白棋没有可以下的位置，黑棋继续下
                        } else {
                            System.out.println("白棋无处可下，黑棋继续");
                            eachBoardTurn.set(whichBoard, 1);
                            break;
                        }
                    }
            }
        }
    }
}
