public abstract class Accessory implements AccInterface {
    String name;
    String type;
    protected double hp;
    protected double atk;
    protected double def;
    protected double critRate;

    public Accessory(String name) {
        this.name = name;
        System.out.println("New accessory created!");
    }

    @Override
    public void showStat() {
        System.out.println(type + " Name: " + this.name);
        if (this.hp > 0) {
            System.out.print("+" + this.hp + " HP ");
        }
        if (this.atk > 0) {
            System.out.print("+" + this.atk + " ATK ");
        }
        if (this.def > 0) {
            System.out.print("+" + this.def + " DEF ");
        }
        if (this.critRate > 0) {
            System.out.print("+" + this.critRate + " Critical Rate ");
        }
        System.out.println("");
    }

    public static class Boot extends Accessory {
        public Boot(String name) {
            super(name);
            this.type = "Boot";
        }
    }

    public static class Ring extends Accessory {
        public Ring(String name) {
            super(name);
            this.type = "Ring";
        }
    }

    public static class NoobRing extends Ring {
        public NoobRing() {
            super("Noob Ring");
            this.hp = 20;
            this.atk = 20;
            this.def = 5;
            this.critRate = 0;
        }
    }

    public static class RingOfWind extends Ring {
        public RingOfWind() {
            super("Ring of Wind");
            this.hp = 0;
            this.atk = 25;
            this.def = 0;
            this.critRate = 15;
        }
    }

    public static class LegendaryBoot extends Boot {
        public LegendaryBoot() {
            super("Legendary Boot");
            this.hp = 50;
            this.atk = 30;
            this.def = 10;
            this.critRate = 10;
        }
    }

    public static class GalaxyBoot extends Boot {
        public GalaxyBoot() {
            super("Galaxy Boot");
            this.hp = 5;
            this.atk = 5;
            this.def = 80;
            this.critRate = 5;
        }
    }
}
