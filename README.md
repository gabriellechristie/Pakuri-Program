/**
 * This class is a blueprint for the different critter objects.
 */
public class Pakuri implements Cloneable, Comparable<Pakuri> {
    private String species = "";
    private int length;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species) {
        this.species = species;
        length = 0;
        attack = (species.length() * 7) + 9;;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;;
    }

    public String getSpecies() {
        return species;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    //returns the speed.
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public void evolve() {
        //when evolved the attack is doubled, defense quadrupled, and speed tripled.
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }

    @Override
    public int compareTo(Pakuri target) {
        int value = 0;
        if (this.getSpecies().compareTo(target.getSpecies()) == 0) {
            return 0;
        }
        if (this.getSpecies().compareTo(target.getSpecies()) < 0) {
            return -1;
        }
        if (this.getSpecies().compareTo(target.getSpecies()) > 0) {
            return 1;
        }
        return value;
    }

    public Object clone() throws CloneNotSupportedException {
        Pakuri pakuri = (Pakuri) super.clone();
        pakuri = new Pakuri(this.getSpecies());
        pakuri.setAttack(this.attack);
        pakuri.setDefense(this.defense);
        pakuri.setSpeed(this.speed);
        return pakuri;
    }
}
