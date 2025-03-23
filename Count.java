package Reve;

//计算当前黑棋和白棋的数量
public class Count {
    public static int[] count(char board[][],int boardSize){
        int whitePieceNum=0;
        int blackPieceNum=0;
        for(char[] row:board){
            for(char piece:row){
                if(piece==player.PLAYER1.getPiece()){
                    blackPieceNum++;
                }
                if(piece==player.PLAYER2.getPiece()){
                    whitePieceNum++;
                }
            }
        }
        return new int[]{blackPieceNum,whitePieceNum,blackPieceNum+whitePieceNum};
    }
}
