import java.util.Scanner;

public class Boks_Oyunu {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Fighter marc = new Fighter("Marc",15,100,90,30,50);
        Fighter alex = new Fighter("Alex",10,90,100,30,50);

        Match r = new Match(marc,alex , 90 , 100);
        r.run();

    }
}

public class Fighter
{
    String name;
    int damage;
    int healt;
    int weight;
    int dodge;
    int firstHit;

    //Constructor
    Fighter(String name, int damage, int healt, int weight, int dodge,int firstHit) {
        this.name = name;
        this.damage = damage;
        this.healt = healt;
        this.weight = weight;
        if (dodge >= 0 && dodge <= 100) { this.dodge = dodge; }
        else { this.dodge = 0; }
        if (firstHit >= 0 && firstHit <= 100) { this.firstHit = firstHit; }
        else { this.firstHit = 0; }
    }

    //Metotlar

    int hit(Fighter foe)
    {
        System.out.println(this.name + "=>" + foe.name + " " + this.damage + " hasar vurdu.");
        if (foe.isDodge()) {
            System.out.println("------------------");
            System.out.println(foe.name + " gelen hasarı blokladı");
            return foe.healt;
        }

        if (foe.healt - this.damage < 0) {
            return 0;
        }

        return foe.healt - this.damage;
    }

    boolean isDodge()
    {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }


    boolean isFirstHit()
    {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.firstHit;
    }
}

public class Match
{
    Fighter f1;
    Fighter f2;
    int minWeith;
    int maxWeith;

    //Constructor
    Match(Fighter f1, Fighter f2, int minWeith, int maxWeith) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeith = minWeith;
        this.maxWeith = maxWeith;

    }

    void run() {
        if (isCheck()) {
            while (this.f1.healt > 0 && this.f2.healt > 0) {
                System.out.println("====YENİ ROUND====");
                if (this.f1.isFirstHit()) {
                    this.f2.healt = this.f1.hit(f2);
                    if (isWin())
                        break;
                }
                if (this.f2.isFirstHit()) {
                    this.f1.healt = this.f2.hit(f1);
                    if (isWin())
                        break;
                }
                System.out.println(this.f1.name + " Sağlık: " + this.f1.healt);
                System.out.println(this.f2.name + " Sağlık: " + this.f2.healt);
            }
        } else {
            System.out.println("Siklet uyumsuzluğu.");
        }
    }

    boolean isCheck()
    {
        return (this.f1.weight >= minWeith && this.f1.weight <= maxWeith) && (this.f2.weight >= minWeith && this.f2.weight <= maxWeith);
    }

    boolean isWin()
    {
        if (this.f1.healt == 0) {
            System.out.println(this.f2.name + " kazandı");
            return true;
        }
        if (this.f2.healt == 0) {
            System.out.println(this.f1.name + " kazandı.");
            return true;
        }

        return false;
    }
}