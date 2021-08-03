/**
 * starting hand of cards with their random added
 */
public class Initial_cards {
    private DoubleLinkedList All_Cards;
    private DoubleCircularList Mass;
    private Stack Deck;
    private String rute;
    private int Henchmen;
    private int Secrets;
    private int Spells;
    public Initial_cards(){
        this.All_Cards = new DoubleLinkedList();
        this.Mass = new DoubleCircularList();
        this.Deck = new Stack(17);
        this.rute = "/images/cards/";
        this.Henchmen = 17;
        this.Secrets = 8;
        this.Spells = 12;
    }
    /**
     * constructor with attributes necessary for the creation of cards
     */
    public void crete_All_cards(){
        for(int i = 1; i<=36; i++){
                switch (i){
                    case 1:
                        Henchmen henchman = new Henchmen(75, 50, this.rute + "Henchmen/henchman_1");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 2:
                        Secret secret = new Secret(0, "-10%", this.rute + "Secrets/Secret1");
                        All_Cards.insertFirst(secret);
                        break;
                    case 3:
                        Spell spell = new Spell(0, "r_damage", this.rute + "Spells/Spell_1");
                        All_Cards.insertFirst(spell);
                        break;
                    case 4:
                        henchman = new Henchmen(150, 125, this.rute + "Henchmen/henchman_4");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 5:
                        henchman = new Henchmen(175, 150, this.rute + "Henchmen/henchman_5");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 6:
                        henchman = new Henchmen(200, 175, this.rute + "Henchmen/henchman_6");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 7:
                        henchman = new Henchmen(225, 200, this.rute + "Henchmen/henchman_7");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 8:
                        henchman = new Henchmen(250, 225, this.rute + "Henchmen/henchman_8");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 9:
                        henchman = new Henchmen(270, 250, this.rute + "Henchmen/henchman_9");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 10:
                        henchman = new Henchmen(300, 275, this.rute + "Henchmen/henchman_10");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 11:
                        henchman = new Henchmen(325, 300, this.rute + "Henchmen/henchman_11");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 12:
                        henchman = new Henchmen(350, 325, this.rute + "Henchmen/henchman_12");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 13:
                        henchman = new Henchmen(375, 350, this.rute + "Henchmen/henchman_13");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 14:
                        henchman = new Henchmen(400, 375, this.rute + "Henchmen/henchman_14");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 15:
                        henchman = new Henchmen(425, 400, this.rute + "Henchmen/henchman_15");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 16:
                        henchman = new Henchmen(450, 425, this.rute + "Henchmen/henchman_16");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 17:
                        henchman = new Henchmen(50, 25, this.rute + "Henchmen/henchman_17");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 18:
                        henchman = new Henchmen(125, 100, this.rute + "Henchmen/henchman_3");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 19:
                        spell = new Spell(0, "v_+50%", this.rute + "Spells/Spell_2");
                        All_Cards.insertFirst(spell);
                        break;
                    case 20:
                        secret = new Secret(0, "n_damage", this.rute + "Secrets/Secret10");
                        All_Cards.insertFirst(secret);
                        break;

                    case 21:
                        henchman = new Henchmen(475, 450, this.rute + "Henchmen/henchman_18");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 22:
                        henchman = new Henchmen(525, 500, this.rute + "Henchmen/henchman_19");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 23:
                        spell = new Spell(0,"shield", this.rute + "Spells/Spell_6");
                        All_Cards.insertFirst(spell);
                        break;
                    case 24:
                        spell = new Spell(0, "freeze_x1", this.rute + "Spells/Spell_7");
                        All_Cards.insertFirst(spell);
                        break;
                    case 25:
                        spell = new Spell(0, "-damage", this.rute + "Spells/Spell_8");
                        All_Cards.insertFirst(spell);
                        break;
                    case 26:
                        secret = new Secret(0, "c_mass", this.rute + "Secrets/Secret9");
                        All_Cards.insertFirst(secret);
                        break;
                    case 27:
                        henchman = new Henchmen(500, 475, this.rute + "Henchmen/henchman_20");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 28:
                        spell = new Spell(0, "v_+25%", this.rute + "Spells/Spell_11");
                        All_Cards.insertFirst(spell);
                        break;
                    case 29:
                        spell = new Spell(0, "+100m", this.rute + "Spells/Spell_12");
                        All_Cards.insertFirst(spell);
                        break;
                    case 30:
                        henchman = new Henchmen(100, 75, this.rute + "Henchmen/henchman_2");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 31:
                        secret = new Secret(0, "-10%m", this.rute + "Secrets/Secret2");
                        All_Cards.insertFirst(secret);
                        break;
                    case 32:
                        secret = new Secret(0, "-30%", this.rute + "Secrets/Secret3");
                        All_Cards.insertFirst(secret);
                        break;
                    case 33:
                        secret = new Secret(0, "big_damage", this.rute + "Secrets/Secret8");
                        All_Cards.insertFirst(secret);
                        break;
                    case 34:
                        secret = new Secret(0, "+lastM", this.rute + "Secrets/Secret5");
                        All_Cards.insertFirst(secret);
                        break;
                    case 35:
                        secret = new Secret(0, "E_250", this.rute + "Secrets/Secret6");
                        All_Cards.insertFirst(secret);
                        break;
                    case 36:
                        secret = new Secret(0, "doubleM", this.rute + "Secrets/Secret7");
                        All_Cards.insertFirst(secret);
                        break;
                    case 37:
                        secret = new Secret(0, "d_card", this.rute + "Secrets/Secret4");
                        All_Cards.insertFirst(secret);
                        break;
                    case 38:
                        spell = new Spell(0, "p_3cards", this.rute + "Spells/Spell_13");
                        All_Cards.insertFirst(spell);
                        break;
                    case 39:
                        spell = new Spell(0, "freeze_x2", this.rute + "Spells/Spell_9");
                        All_Cards.insertFirst(spell);
                        break;
                    case 40:
                        spell = new Spell(0, "p_4cards", this.rute + "Spells/Spell_3");
                        All_Cards.insertFirst(spell);
                        break;
                }
        }
    }
    /**
     * create the card bank
     * @throws Exception
     */
    public void create_Deck() throws Exception {
        for(int i = 0; i<16; i++){
            int random = ((int) (Math.random() * 36) + 1);
            Deck.push(All_Cards.Data_find(random));
        }
    }
    public void create_Mass(){
        for(int i = 0; i<4; i++){
            int random = ((int) (Math.random() * 36) + 1);
            Mass.insertFirst(All_Cards.Data_find(random));
        }
    }
    public DoubleCircularList getMass() {
        return Mass;
    }
    public DoubleLinkedList getAll_Cards() {
        return All_Cards;
    }
    public Stack getDeck() {
        return Deck;
    }
}
