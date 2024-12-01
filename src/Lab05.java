public class Lab05 {
    public static void main(String[] args) {
        Character c1 = new Character("Somchai", "Fighter");
        Character c2 = new Character("Somyud", "Healer");
        System.out.println("-------------------");

        Accessory a1 = new Accessory.RingOfWind();
        Accessory a2 = new Accessory.NoobRing();
        Accessory a3 = new Accessory.LegendaryBoot();
        System.out.println("-------------------");

        a1.showStat();
        a3.showStat();
        System.out.println("-------------------");

        c1.showStat();
        System.out.println("-------------------");
        c1.equipRing(a1);
        c1.equipBoot(a3);
        System.out.println("-------------------");
        c1.showStat();
        System.out.println("-------------------");

        c1.equipRing(a2);
        System.out.println("-------------------");

        c1.fight(c2);
        System.out.println("-------------------");
        c1.fight(c2);
        System.out.println("-------------------");
        c1.fight(c2);
        System.out.println("-------------------");
        c1.fight(c2);
        System.out.println("-------------------");

        c1.fight(c1);
        System.out.println("-------------------");
        c2.fight(c1);
    }
}
