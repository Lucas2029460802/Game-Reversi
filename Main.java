package Reve;

import java.awt.Point;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1, name2;

        // position用来承接坐标点，eachBoardTurn用来判断切换棋盘之后轮到黑棋还是白棋下，x，y表示坐标，whichBoard表示现在是第几块板子在进行游戏
        Point position = new Point(0, 0);
        int[] eachBoardTurn = { 1, 1, 1 };
        int whichBoard = 0;
        board[] board = new board[3];

        // 初始化三个棋盘
        board[0] = new board('1');
        board[1] = new board('2');
        board[2] = new board('3');

        // 输入玩家的名字
        System.out.println("请输入玩家1,2的名字");
        name1 = scanner.nextLine();
        name2 = scanner.nextLine();
        player.PLAYER1.setName(name1);
        player.PLAYER2.setName(name2);
        Printf.print(player.PLAYER1.getName(), player.PLAYER2.getName(), board[whichBoard]);

        // 循环

        // 判断棋盘是否被下满，结束游戏的依据
        while (Count.count(board[whichBoard].getboard(),
                board[whichBoard].getSize())[2] != board[whichBoard].getMax()) {
            switch (eachBoardTurn[whichBoard]) {

                // case1：轮到黑棋下
                case 1:
                    System.out.println("【" + player.PLAYER1.getName() + "】请输入" + player.PLAYER1.getPiece() + "落点或者棋盘号");
                    position = Input.input(scanner);

                    // 用户选择切换棋盘
                    if (position.y == 1111) {
                        System.out.println("切换为棋盘" + position.x);
                        whichBoard = position.x;
                        Printf.print(player.PLAYER1.getName(), player.PLAYER2.getName(), board[whichBoard]);
                        break;
                    }

                    // 用户选择输入黑棋坐标点
                    else {
                        if (Rule.whetherToIndicate(board[whichBoard], player.PLAYER1.getPiece(), false)) {

                            // 判断下棋的位置是否符合规则
                            if (Rule.rule(board[whichBoard], position, player.PLAYER1.getPiece(), scanner)) {

                                // 符合规则下棋
                                Put.put(board[whichBoard], position, player.PLAYER1.getPiece());
                                Printf.print(player.PLAYER1.getName(), player.PLAYER2.getName(), board[whichBoard]);

                                // 将下一次下棋方切换为玩家2：白棋
                                eachBoardTurn[whichBoard] = 2;
                                break;

                                // 不符合下棋规则，下一次下棋方黑棋继续
                            } else {
                                eachBoardTurn[whichBoard] = 1;
                                break;
                            }
                            // 黑棋没有可以下的位置，白棋继续下
                        } else {
                            eachBoardTurn[whichBoard] = 2;
                            break;
                        }
                    }

                    // case2：轮到白棋下
                case 2:
                    System.out.println("【" + player.PLAYER2.getName() + "】请输入" + player.PLAYER2.getPiece() + "落点或者棋盘号");
                    position = Input.input(scanner);

                    // 用户选择切换棋盘
                    if (position.y == 1111) {
                        System.out.println("切换为 Game " + position.x);
                        whichBoard = position.x;
                        Printf.print(player.PLAYER1.getName(), player.PLAYER2.getName(), board[whichBoard]);
                        break;
                    }

                    // 用户选择输入白棋坐标点
                    else {
                        if (Rule.whetherToIndicate(board[whichBoard], player.PLAYER2.getPiece(), false)) {

                            // 判断下棋的位置是否符合规则
                            if (Rule.rule(board[whichBoard], position, player.PLAYER2.getPiece(), scanner)) {

                                // 符合规则下棋
                                Put.put(board[whichBoard], position, player.PLAYER2.getPiece());
                                Printf.print(player.PLAYER1.getName(), player.PLAYER2.getName(), board[whichBoard]);

                                // 将下一次下棋方切换为玩家1：黑棋
                                eachBoardTurn[whichBoard] = 1;
                                break;

                                // 不符合下棋规则，下一次下棋方黑棋继续
                            } else {
                                eachBoardTurn[whichBoard] = 2;
                                break;
                            }

                            // 黑棋没有可以下的位置，白棋继续下
                        } else {
                            eachBoardTurn[whichBoard] = 1;
                            break;
                        }
                    }
            }
        }
    }
}
