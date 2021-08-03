/**
 *  Class card Henchmen
 */
public class Secret {
    private String action;
    private int mana;
    private String rute;
    public Secret(int mana, String action, String rute){
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
