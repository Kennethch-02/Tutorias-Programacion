/**
 *  Class card Spell
 */
public class Spell {
    private String type;
    private String action;
    private int mana;
    private String rute;
    public Spell(int mana, String action, String rute){
        this.action = action;
        this.mana = mana;
        this.rute = rute;
    }
    public int getMana() {
        return mana;
    }
    public String getAction() {
        return action;
    }
    public String getRute() {
        return rute;
    }
}
