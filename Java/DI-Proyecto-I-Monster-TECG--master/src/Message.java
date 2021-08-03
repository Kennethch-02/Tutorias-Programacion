/**
 *  Class Message
 *
 *  To send Messages in sockets
 */
public class Message {
    private String type;
    private String action;
    private int mana;
    private int attack;

    public Message(String type, String action, int mana, int attack){
        this.mana = mana;
        this.attack = attack;
        this.action = action;
        this.type = type;
    }
    public void setType(String type){this.type = type;}
    public void setAction(String action){this.action = action;}
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getMana() {
        return mana;
    }
    public int getAttack() {
        return attack;
    }
    public String getType(){return this.type;}
    public String getAction(){return this.action;}
}
