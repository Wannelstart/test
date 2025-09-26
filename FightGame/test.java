package FightGame;

public class test {
    public static void main(String[] args) {
        fightGame r1 = new fightGame("woden", 100, '男');
        fightGame r2 = new fightGame("jay", 100, '女');

        r1.show();
        System.out.println();
        r2.show();
        System.out.println();
        //开始格斗
        while (true) {
            r1.attack(r2);
            if (r2.getBlood() == 0) {
                System.out.println(r1.getName() + "  ko了  " + r2.getName());
                break;
            }

            r2.attack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r2.getName() + "  ko了  " + r1.getName());
                break;
            }
        }


    }
}
