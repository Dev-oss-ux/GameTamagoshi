import java.util.Random;

import java.util.Scanner;


class Tamagotchi {

    private static final int MAX_CYCLE = 8;

    private static final int HUNGRY_LEVEL = 3;

    private static final int BORED_LEVEL = 3;

    private static final String[] MOODS = {"Tout va bien !", "je m'ennuie à mourrir !", "je suis affamé !", "je suis affamé et je m'ennuie à mourrir !"};

    private static Tamagotchi[] pets;

    private String name;

    private int hunger;

    private int boredom;


    public Tamagotchi(String name) {

        this.name = name;

        hunger = 0;

        boredom = 0;

    }


    public String getName() {

        return name;

    }


    public boolean isAlive() {

        return hunger < HUNGRY_LEVEL && boredom < BORED_LEVEL;

    }


    public void play() {

        boredom--;

        System.out.println(name + " : \"On se marre !\"");

    }


    public void feed() {

        hunger--;

        System.out.println(name + " : \"Miam c'est bon !\"");

    }


    public void talk() {

        System.out.println(name + " : \"" + MOODS[getMoodIndex()] + "\"");

    }


    public void printMenu(int index) {

        System.out.print("(" + index + ") " + name + " ");

        if (this.getClass() == GrosMangeur.class) {

            System.out.print("(GrosMangeur) ");

        } else if (this.getClass() == GrosJoueur.class) {

            System.out.print("(GrosJoueur) ");

        }

    }


    public int getMoodIndex() {

        if (hunger >= HUNGRY_LEVEL && boredom >= BORED_LEVEL) {

            return 3;

        } else if (hunger >= HUNGRY_LEVEL) {

            return 2;

        } else if (boredom >= BORED_LEVEL) {

            return 1;

        } else {

            return 0;

        }

    }

    protected void consommeNourriture() {
    }

    protected void consommeFun() {
    }

    protected void consommeEnergie() {
    }
}


class GrosMangeur extends Tamagotchi {

    public GrosMangeur(String name) {

        super(name);

    }


    public void consommeEnergie() {

        super.consommeEnergie();

        super.consommeEnergie();

    }


    public void consommeNourriture() {

        super.consommeNourriture();

        super.consommeNourriture();

    }

}


class GrosJoueur extends Tamagotchi {

    public GrosJoueur(String name) {

        super(name);

    }


    public void consommeFun() {

        super.consommeFun();

        super.consommeFun();

    }


    public void consommeNourriture() {

        super.consommeNourriture();

        super.consommeNourriture();

    }

}


public class TamaGame {

    private static final int MAX_ROUNDS = 8;

    private static final String[] NAMES = {"Bob", "Alice", "John", "Karen", "Michael", "David"};

    private static Tamagotchi[] pets;

    private static Scanner scanner = new Scanner(System.in);

    private static Random random = new Random();


    public static void main(String[] args) {

        System.out.print("Entrez le nombre de Tamagotchi désiré : ");

        int numPets = scanner.nextInt();

        pets = new Tamagotchi[numPets];


        for (int i = 0; i < numPets; i++) {

            pets[i] = new Tamagotchi(NAMES[random.nextInt(NAMES.length)]);

        }


        for (int round = 1; round <= MAX_ROUNDS; round++) {

            System.out.println("Tour " + round + " :");

            for (Tamagotchi pet : pets) {

                pet.play();

            }

            System.out.println();

        }


        System.out.println("Fin du jeu !");

    }

}