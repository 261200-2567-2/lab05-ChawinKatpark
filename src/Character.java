import java.util.Random;

public class Character implements CharInterface {
    String job;
    String name;
    double hp;
    double atk;
    double def;
    double critRate;
    Accessory ring;
    Accessory boot;

    public Character(String name, String job) {
        this.name = name;
        this.job = job;

        if (job.equals("Fighter")) {
            System.out.println("New " + job + " character has been created. The name is " + name);
            this.hp = 500;
            this.atk = 100;
            this.def = 25;
            this.critRate = 0;
        } else if (job.equals("Tank")) {
            System.out.println("New " + job + " character has been created. The name is " + name);
            this.hp = 650;
            this.atk = 60;
            this.def = 50;
            this.critRate = 0;
        } else if (job.equals("Healer")) {
            System.out.println("New " + job + " character has been created. The name is " + name);
            this.hp = 450;
            this.atk = 80;
            this.def = 15;
            this.critRate = 0;
        } else {
            System.out.println("Invalid job, " + name + " will be created as Jobless");
            this.job = "Jobless";
            this.hp = 150;
            this.atk = 30;
            this.def = 5;
            this.critRate = 0;
        }
    }

    @Override
    public void showStat() {
        System.out.println("Name: " + this.name);
        System.out.println("Job: " + this.job);
        System.out.println("HP: " + this.hp);
        System.out.println("Atk: " + this.atk);
        System.out.println("Def: " + this.def);
        System.out.println("Critical Rate: " + this.critRate);
        if (this.ring != null) {
            System.out.println("Equipped Ring: " + this.ring.name);
        }
        if (this.boot != null) {
            System.out.println("Equipped Boot: " + this.boot.name);
        }
    }

    @Override
    public void equipRing(Accessory ring) {
        if (this.ring != null) {
            System.out.println(this.name + " already has a ring equipped: " + this.ring.name);
        } else if (ring instanceof Accessory.Ring) {
            System.out.println(this.name + " successfully equips " + ring.name);
            this.ring = ring;
            calcStatRing();
        } else {
            System.out.println(this.name + " cannot equip a " + ring.name + " as a ring. It is a " + ring.type + "!");
        }
    }

    @Override
    public void equipBoot(Accessory boot) {
        if (this.boot != null) {
            System.out.println(this.name + " already has boots equipped: " + this.boot.name);
        } else if (boot instanceof Accessory.Boot) {
            System.out.println(this.name + " successfully equips " + boot.name);
            this.boot = boot;
            calcStatBoot();
        } else {
            System.out.println(this.name + " cannot equip a " + boot.name + " as boots. It is a " + boot.type + "!");
        }
    }

    @Override
    public void fight(Character target) {
        if (this.hp <= 0) {
            System.out.println(this.name + " cannot fight! (Already dead)");
            return;
        }

        if (target.hp <= 0) {
            System.out.println(target.name + " is already dead!");
            return;
        }

        if (this == target) {
            System.out.println("Characters cannot fight themself!");
            return;
        }

        System.out.println(this.name + " fights with " + target.name);

        //Critical Damage
        Random rand = new Random();
        int randChance = rand.nextInt(100);
        double atkDmg = this.atk;
        if (critRate > 0) {
            if (randChance <= critRate) {
                System.out.println("Critical Attack!!!");
                atkDmg *= 2;
            }
        }

        double finalDmg = atkDmg - target.def;
        if (finalDmg < 0) {
            finalDmg = 0;
        }

        target.hp -= finalDmg;

        if (target.hp <= 0) {
            target.hp = 0;
        }

        System.out.print(this.name + " deals " + finalDmg + " to " + target.name);
        System.out.println(" (" + target.name + " has " + target.hp + " HP left)");

        double heal = finalDmg*0.25;
        if (job.equals("Healer")) {
            System.out.println("(" + job + " heals themself for " + heal + " HP)");
            this.hp += heal;
        }
    }

    @Override
    public void calcStatRing() {
        if (this.ring != null) {
            if (ring instanceof Accessory.NoobRing) {
                this.hp += 20;
                this.atk += 20;
                this.def += 5;
            } else if (ring instanceof Accessory.RingOfWind) {
                this.atk += 25;
                this.critRate += 15;
            }
        }
    }

    @Override
    public void calcStatBoot() {
        if (this.boot != null) {
            if (boot instanceof Accessory.LegendaryBoot) {
                this.hp += 50;
                this.atk += 30;
                this.def += 10;
                this.critRate += 10;
            } else if (boot instanceof Accessory.GalaxyBoot) {
                this.hp += 5;
                this.atk += 5;
                this.def += 80;
                this.critRate += 5;
            }
        }
    }
}
