/**
 * This class contains all the Pakuri that you will encounter as Pakuri objects.
 */
public class Pakudex {
    private int critterSizeValue;
    private Pakuri[] pakudexArray;

    public Pakudex() {
        pakudexArray = new Pakuri[20];
        critterSizeValue = 0;
    }

    Pakudex(int capacity) {
        pakudexArray = new Pakuri[capacity];
    }

    public int getSize() {
        return critterSizeValue;
    }

    public int getCapacity() {
        return pakudexArray.length;
    }

    public String[] getSpeciesArray() {
        if(getSize() == 0) {
            return  null;
        }
        String[] speciesArray = new String[this.getSize()];
        for (int i = 0; i < getSize(); i++ ) {
            speciesArray[i] = pakudexArray[i].getSpecies();
        }
        return speciesArray;
    }

    /**
     *  Returns the stats when called and if the size is equal to 0 returns null.
     */
    public int[] getStats(String species) {
        int[] speciesStatsArray = new int[3];
        if (getSize() == 0) {
            return null;
        }
        for (Pakuri pakuri : pakudexArray) {
            if(pakuri == null){
                return null;
            }
            if (pakuri.getSpecies().equals(species)) {
                speciesStatsArray[0] = pakuri.getAttack();
                speciesStatsArray[1] = pakuri.getDefense();
                speciesStatsArray[2] = pakuri.getSpeed();
                break;
            }
        }
        return speciesStatsArray;
    }

    public void sortPakuri() {
        //if the size is less then or equal to 1 then it returns.
        if (this.getSize() <= 1) {
            return;
        }
        else if(this.getSize()==2){
            if (pakudexArray[0].compareTo(pakudexArray[1])>0) {
                try {
                    Pakuri temporaryPakuri = (Pakuri) pakudexArray[0].clone();
                    pakudexArray[0] = pakudexArray[1];
                    pakudexArray[1] = temporaryPakuri;
                }
                catch (Exception ignored) {
                }
            }
            return;
        }
        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = 0; j < getSize() - i - 1; j++) {
                if (pakudexArray[j].compareTo(pakudexArray[j + 1]) > 0) {
                    try {
                        Pakuri temporaryPakuri = (Pakuri) pakudexArray[j].clone();
                        pakudexArray[j] = pakudexArray[j + 1];
                        pakudexArray[j + 1] = temporaryPakuri;
                    }
                    catch (Exception ignored) {

                    }
                }
            }
        }
    }

    /**
     *This method adds species to an array, checking for if its full or if a species already exists.
     */
    public boolean addPakuri(String species) {
        if (getCapacity() == getSize()) {
            System.out.println("Error: Pakudex is full!");
            return false;
        }
        if (this.getSize() != 0) {
            for (int i = 0; i < getSize(); i++) {
                if (pakudexArray[i].getSpecies().equals(species)) {
                    System.out.println("Error: Pakudex already contains this species!");
                    return false;
                }
            }
        }
        pakudexArray[critterSizeValue] = new Pakuri(species);
        critterSizeValue++;
        return true;
    }

    public boolean evolveSpecies(String species) {
        for (Pakuri pakuri : pakudexArray) {
            if(pakuri == null){
             return false;
            }
            if (pakuri.getSpecies().equals(species)) {
                pakuri.evolve();
                return true;
            }
        }
        return false;
    }
}

