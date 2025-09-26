package FightGame;

import java.util.Random;

public class fightGame {
    private String name;
    private int blood;
    private char gender;
    private String face;

    String[] boyfaces = {"风流倜傥", "英俊潇洒", "气宇轩昂", "相貌英俊"};
    String[] girlfaces = {"倾国倾城", "美艳绝伦", "沉鱼落雁", "婷婷玉立"};

    String[] attack_desc = {
            "%s使出了一招【九阴白骨爪】，转到对方身后，一掌向%s背心的灵台穴抓去",
            "%s使出了一招【降龙十八掌】，撞向%s",
            "%s使出了一招【葵花宝典】，将掌心翻起向%s打去",
            "%s使出了一招【六脉神剑】，向%s刺去",
            "%s使出了一招【七伤拳】，向%s打去",
            "%s使出了一招【一阳指】，向%s刺去",
    };
    String[] injured_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成了一处创伤",
            "结果一击命中，%s痛得弯腰",
            "结果%s痛苦地闷哼了一声，受了点内伤",
            "结果%s脸色一下变得惨白，受了重伤",
    };

    public fightGame() {
    }

    public fightGame(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        if (gender == '男') {
            this.face = boyfaces[r.nextInt(boyfaces.length)];
        } else if (gender == '女') {
            this.face = girlfaces[r.nextInt(girlfaces.length)];
        } else {
            this.face = "无容";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }


    //展示
    public void show() {
        System.out.println("姓名：" + getName());
        System.out.println("血量：" + getBlood());
        System.out.println("性别：" + getGender());
        System.out.println("长相：" + getFace());
    }


    public void attack(fightGame f) {
        Random r = new Random();
        String kungfu = attack_desc[r.nextInt(attack_desc.length)];

        //输出一个攻击的效果
        System.out.printf(kungfu, this.getName(), f.getName());
        System.out.println();
        //计算造成的伤害（1到20的随机数）和剩余的血量

        int hurt = r.nextInt(20) + 1;

        int remainBlood = f.getBlood() - hurt;
        remainBlood = remainBlood < 0 ? 0 : remainBlood;
        f.setBlood(remainBlood);

        //输出受伤的效果
        if (remainBlood > 80) {
            System.out.printf(injured_desc[0] + "\n", f.getName());
            System.out.println(f.getName() + "的剩余血量为" + f.getBlood());
        } else if (remainBlood < 80 && remainBlood > 60) {
            System.out.printf(injured_desc[1] + "\n", f.getName());
            System.out.println(f.getName() + "的剩余血量为" + f.getBlood());
        } else if (remainBlood < 60 && remainBlood > 40) {
            System.out.printf(injured_desc[2] + "\n", f.getName());
            System.out.println(f.getName() + "的剩余血量为" + f.getBlood());
        } else if (remainBlood < 40 && remainBlood > 20) {
            System.out.printf(injured_desc[3] + "\n", f.getName());
            System.out.println(f.getName() + "的剩余血量为" + f.getBlood());
        } else {
            System.out.printf(injured_desc[4] + "\n", f.getName());
            System.out.println(f.getName() + "的剩余血量为" + f.getBlood());
        }
        System.out.println();
    }


}
