package Reve;
import java.awt.Point;
import java.util.Scanner;

//输入用户输入，然后将其转化为坐标点
public class Input {
    public static Point input(Scanner scanner){
        Point position= new Point(0,0);char firstChar,secondChar;
        while(true){
            String input=scanner.nextLine();
            int length=input.length();
            try{
                firstChar=input.charAt(0);
                int x1=firstChar-'0';
                switch (length) {
                    case 1:position.x=x1-1;position.y=1111;return position;
                    case 2:
                    secondChar=input.charAt(1);int y1=secondChar-'A'+1;position.x=x1;position.y=y1;
                        if(x1>=1 && x1<=8 && y1>=1 && y1<=8){
                            return position;
                        }else{
                            System.out.println("请输入棋盘内的坐标");
                        }

                    case 5:
                        if(input=="peace"){}
                    default:
                        System.out.println("输入的格式有误，请重新输入坐标");}
                        }catch(StringIndexOutOfBoundsException e){}
        }
    }
}
