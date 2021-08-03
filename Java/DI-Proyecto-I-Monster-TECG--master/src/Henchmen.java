/**
 *  Class card Henchmen
 */
public class Henchmen {
    private int attack;
    private int mana;
    private String rute;
    public Henchmen(int attack, int mana, String rute){
        this.attack = attack;
        this.mana = mana;
        this.rute = rute;
    }
    /**
     * Getters and Setters of class
     * @return
     */
    public int getMana() {
        return mana;
    }
    public int getAttack() {
        return attack;
    }
    public String getRute() {
        return rute;
    }
}
