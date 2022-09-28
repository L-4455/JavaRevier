package Day01;

import java.util.*;

/**
 * @Author LiZiHao
 * @Date 2022/09/28/21:04
 */
public class CrapsGame {
    /*
    CRAPS赌博游戏。
    说明：CRAPS又称花旗骰，是美国拉斯维加斯非常受欢迎的一种的桌上赌博游戏。该游戏使用两粒骰子，
    玩家通过摇两粒骰子获得点数进行游戏。简单的规则是：玩家第一次摇骰子如果摇出了7点或11点，玩家胜；
    玩家第一次如果摇出2点、3点或12点，庄家胜；其他点数玩家继续摇骰子，如果玩家摇出了7点，庄家胜；
    如果玩家摇出了第一次摇的点数，玩家胜；其他点数，玩家继续要骰子，直到分出胜负。

    我们设定玩家开始游戏时有1000元的赌注
    游戏结束的条件是玩家输光所有的赌注
     */
    public static void main(String[] args) {
//        模拟骰子
        Random random = new Random();
        int money = 1000;
        while (money > 0) {
            System.out.println("你的总资金为:" + money);
            System.out.println("请下注:");
            Scanner scanner = new Scanner(System.in);
            int bet = scanner.nextInt();
            if (bet > money || bet <= 0) {
                System.out.println("你的资金不足,无法进行游戏!!");
                break;
            } else {
                int first = random.nextInt(6) + 1 + random.nextInt(6) + 1;
                System.out.println("玩家第一回合摇出了--->" + first + "点");
                if (first == 7 || first == 11) {
                    System.out.println("玩家胜利!!");
                    money += bet;
                } else if (first == 2 || first == 3 || first == 12) {
                    System.out.println("庄家胜利!!");
                    money -= bet;
                } else {
                    boolean is_over = true;
                    System.out.println("第一回合平局,进入第二回合:规则-->玩家摇出7点,庄家胜利;玩家摇出和第一回合摇出的相同则玩家胜利");
                    while (is_over) {
                        int current = random.nextInt(6) + 1 + random.nextInt(6) + 1;
                        System.out.println("玩家第二次摇出了--->" + current + "点");
                        is_over = false;
                        if (current == first) {
                            System.out.println("玩家胜利!!!");
                            money += bet;
                        } else if (current == 7) {
                            System.out.println("庄家胜利!!!");
                            money -= bet;
                        } else {
                            is_over = true;
                        }
                    }
                }
            }
            if(money <= 0){
                System.out.println("你破产了");
            }
        }
    }
}
