package Reve;

import java.util.Arrays;

public class board {
    private final int boardSize=9;
    private final int boardMax=64;
    private final char board[][]=new char[boardSize][boardSize];
    private final int boardOrder;
    private final String boardModel;
    private final char blank='·';
    
    //初始化棋盘
    public board(int Order,String Model) {
        boardOrder=Order;
        boardModel=Model;
        initializeBoard();
        setRowColumnLabels();
        initializePieces();
    }

    private void initializeBoard(){
        for(int i=0;i<boardSize;i++){
            Arrays.fill(board[i],blank);
        }
    }

    private void setRowColumnLabels(){
        for(int i=1;i<boardSize;i++){
            board[i][0]=(char)('0'+i);
        }
        for(int j=1;j<9;j++){
            board[0][j]=(char)('A'+j-1);
        }
    }

    private void initializePieces(){
        board[0][0]=' ';
        board[4][4]=player.PLAYER1.getPiece();
        board[5][5]=player.PLAYER1.getPiece();
        board[4][5]=player.PLAYER2.getPiece();
        board[5][4]=player.PLAYER2.getPiece();
    }

    public char[][] getboard(){return board;}
    public int getSize(){return boardSize;}
    public int getMax(){return boardMax;}
    public int getOrder(){return boardOrder;}
    public String getModel(){return boardModel;}
    public char getblank(){return blank;}
}
