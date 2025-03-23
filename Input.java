package Reve;
import java.awt.Point;
import java.util.Scanner;

//输入用户输入，然后将其转化为坐标点
public class Input {
    public static Point input(Scanner scanner){
        Point position= new Point(0,0);char firstChar,secondChar;
        int changeBoard=1111,peaceModel=2222,reversiModel=3333;

        String input=scanner.nextLine();
        int length=input.length();
        try{
                firstChar=input.charAt(0);
                int x1=firstChar-'0';
                switch (length) {

                    //切换棋盘
                    case 1:
                        position.x=x1-1;position.y=changeBoard;return position;

                    //棋盘内坐标
                    case 2:
                        secondChar=input.charAt(1);int y1=secondChar-'A'+1;position.x=x1;position.y=y1;

                        if(Rule.whetherInBoard(x1, x1)){
                            return position;
                        }else{
                            System.out.println("请输入棋盘内的坐标");
                            input(scanner);
                        }

                    //切换模式
                    case 5:
                        if("peace".equals(input)){position.y=peaceModel;return position;}
                        else{System.out.println("请输入正确的模式");}
                        input(scanner);

                    case 7:
                        if("reversi".equals(input)){position.y=reversiModel;return position;}
                        else{System.out.println("请输入正确的模式");}
                        input(scanner);

                    default:
                        System.out.println("输入的格式有误，请重新输入坐标");
                        input(scanner);
                    }

            }catch(StringIndexOutOfBoundsException e){}
        return position;
    }    
            
}
