import pokemon.*;
import skills.*;
import statuses.*;
import java.util.Scanner;
import random.Random;

public class Main {

	public static void main(String[] args) {
        Pokemon player1 = new Pikachu(new Skill[] {
            new Thunderbolt(),
            new IronTail(),
            new QuickAttack(),
            new VoltTackle(),
        });
        Pokemon player2 = new Eevee(new Skill[] {
            new Thunderbolt(),
            new IronTail(),
            new QuickAttack(),
            new VoltTackle(),
        });

        Scanner stdin = new Scanner(System.in);

        while(true) {
            System.out.println("プレイヤー1: " + player1.formatedStatus());
            System.out.println("プレイヤー2: " + player2.formatedStatus());

            System.out.println("技を選んでください: " + player1.formatedSkills());
            int skillNum = stdin.nextInt();
            int maxSkillNum = player1.getSkills().length - 1;
            if(skillNum < 0 || skillNum > maxSkillNum) {
                System.out.printf("0~%dのいずれかを入力してください\n", maxSkillNum);
                continue;
            }
            player2.wasAttacked(player1.attack(skillNum));

            player1.wasAttacked(player2.attack(Random.random() % 4));

            if(isEndGame(player1, player2)) {
                break;
            }
            System.out.println("=== Turn end ===");
        }
    }

    private static boolean isEndGame(Pokemon player1, Pokemon player2) {
        if(!player1.isActive()) {
            System.out.println(player1.getTribeName() + "はたおれた！");
            return true;
        } else if(!player2.isActive()) {
            System.out.println(player2.getTribeName() + "はたおれた！");
            return true;
        }
        return false;
    }
}
