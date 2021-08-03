import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * Definition of the variables necessary for the application
 */
public class App extends Application implements EventHandler<javafx.event.ActionEvent> {
    private Initial_cards InitCards;
    private DoubleLinkedList History;
    private DoubleCircularList Mass;
    private Stack Deck;
    private FlowPane containermanocartas;
    private String type;
    private Server server;
    private Client client;
    private String name;
    private String Inmessage;
    private boolean active;
    private float life;
    private float mana;
    private float lifead;
    private float manaad;
    private Label labelvidaAd;
    private Label labelmanaAd;
    private int port;
    private float f_mana;
    private float f_life;
    private float f_lifead;
    private float f_manaad;
    private ProgressBar BarVida;
    private ProgressBar BarMana;
    private ProgressBar BarVidaAd;
    private ProgressBar BarManaAd;
    private HBox containerVida;
    private HBox containerMana;
    private HBox containerVidaAd;
    private HBox containerManaAd;
    private boolean isMyTurn;
    private int LastDamage;
    private boolean shield;
    private int int_freeze;
    private int p_mana;
    private int E_250;
    private int mana_p;
    private double p_damage;
    private Stage stage;
    /**
     * Class Constructor
     * @param type type off card
     * @param port port used by player2
     * @param name name of player
     * @throws Exception avoid mistakes
     */
    public App(String type, int port, String name) throws Exception {
        this.History = new DoubleLinkedList();
        this.stage = null;
        this.p_damage = 1;
        this.mana_p = 50;
        this.E_250 = 0;
        this.p_mana = 50;
        this.int_freeze = 0;
        this.shield = false;
        this.LastDamage = 0;
        this.containerVida = new HBox();
        this.containerMana = new HBox();
        this.containerVidaAd = new HBox();
        this.containerManaAd = new HBox();
        this.type = type;
        this.name = name;
        this.mana = 200;
        this.f_mana = mana/1000;
        this.life = 1000;
        this.f_life = life/1000;
        this.manaad = 1000;
        this.f_manaad = manaad/1000;
        this.lifead = 1000;
        this.f_lifead = lifead/1000;
        this.labelvidaAd = new Label("Life adversary");
        this.labelmanaAd = new Label("Mana adversary");
        this.port = port;
        this.BarMana = new ProgressBar(f_mana);
        this.BarVida = new ProgressBar(f_life);
        this.BarManaAd = new ProgressBar(f_manaad);
        this.BarVidaAd = new ProgressBar(f_lifead);
        /**
         * Client server conditions
         */
        if(type == "client"){
            this.isMyTurn = true;
            this.client = new Client("127.0.0.1", this.port);
            Thread t_client = new Thread(client);
            t_client.start();
            this.port = client.getPort();
            this.active = true;
        }
        if(type == "server"){
            this.isMyTurn = false;
            this.server = new Server();
            Thread t_server = new Thread(server);
            t_server.start();
            this.port = server.getPort();
            this.active = true;
        }
        this.InitCards = new Initial_cards();
        this.InitCards.crete_All_cards();
        this.InitCards.create_Mass();
        this.InitCards.create_Deck();
        this.Deck = InitCards.getDeck();
        this.Mass = InitCards.getMass();
        this.containermanocartas = new FlowPane();
    }
    /**
     * method that starts the App
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        Label L_User = new Label("Name: " + this.name);
        L_User.setFont(new Font(25));
        L_User.setTextFill(Color.web("#FFFFFF"));
        Label L_Port = new Label("Port: " + Integer.toString(this.port));
        L_Port.setFont(new Font(25));
        L_Port.setTextFill(Color.web("#FFFFFF"));

        this.BarVida.setMinWidth(500);
        Label labelvida = new Label("Life");
        labelvida.setFont(new Font(40));
        labelvida.setTextFill(Color.web("#008000"));
        containerVida.setMargin(L_User, new Insets(5,10,0,0));
        containerVida.setMargin(L_Port, new Insets(5,280,0,0));
        HBox.setMargin(labelvida,new Insets(0,70,0,0));
        HBox.setMargin(BarVida,new Insets(20,250,0,0));

        this.BarVidaAd.setMinWidth(100);
        this.labelvidaAd.setFont(new Font(30));
        this.labelvidaAd.setTextFill(Color.web("#008000"));
        HBox.setMargin(labelvidaAd, new Insets(10,30,0,0));
        HBox.setMargin(BarVidaAd, new Insets(25,0,0,0));

        containerVida.getChildren().addAll(L_User, L_Port, labelvida,this.BarVida,labelvidaAd,this.BarVidaAd);
        containerVida.setPrefWidth(200);
        containerVida.setAlignment(Pos.TOP_LEFT);

        this.BarMana.setMinWidth(500);
        Label labelmana = new Label("Mana");
        labelmana.setFont(new Font(50));
        labelmana.setTextFill(Color.web("#DAA520"));
        HBox.setMargin(labelmana,new Insets(0,70,0,500));
        HBox.setMargin(BarMana,new Insets(25,215,0,0));

        this.BarManaAd.setMinWidth(100);
        this.labelmanaAd.setFont(new Font(30));
        this.labelmanaAd.setTextFill(Color.web("#DAA520"));
        HBox.setMargin(labelmanaAd, new Insets(10,30,0,0));
        HBox.setMargin(BarManaAd, new Insets(25,0,0,0));

        containerMana.getChildren().addAll(labelmana,BarMana,labelmanaAd,this.BarManaAd);
        containerMana.setPrefWidth(200);
        containerMana.setAlignment(Pos.TOP_LEFT);


        VBox containerdeck = new VBox();
        Image deck = new Image(getClass().getResourceAsStream("/images/background_2.jpg"));

        ImageView Viewdeck = new ImageView(deck);
        Viewdeck.setFitHeight(400);
        Viewdeck.setFitWidth(200);

        Button btndeck = new Button("Obtener Carta");
        btndeck.setFont(new Font(15));
        btndeck.setPrefHeight(35);
        btndeck.setPrefWidth(130);


        VBox.setMargin(Viewdeck, new Insets(100,0,0,0));
        VBox.setMargin(btndeck, new Insets(50,0,0,0));

        containerdeck.getChildren().addAll(Viewdeck,btndeck);
        containerdeck.setPrefWidth(300);
        containerdeck.setAlignment(Pos.CENTER);
        btndeck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isMyTurn()){
                    if(Mass.size()< 10){
                        Object card = Deck.pop();
                        Mass.insertEnd(card);
                        if(card.getClass() == Spell.class){
                            Image carta1 = new Image(((Spell) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                        if(card.getClass() == Henchmen.class){
                            Image carta1 = new Image(((Henchmen) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                        if(card.getClass() == Secret.class){
                            Image carta1 = new Image(((Secret) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                    }
                }
            }
        });
        update_cards();
        Thread t = new Thread(this::receive_message);
        t.start();

        containermanocartas.setOrientation(Orientation.HORIZONTAL);
        containermanocartas.setAlignment(Pos.CENTER);
        containermanocartas.setHgap(20);
        containermanocartas.setVgap(20);

        BackgroundImage myBI= new BackgroundImage(new Image("/images/background_3.jpg",1200,900,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        containermanocartas.setBackground(new Background(myBI));

        VBox containerextra = new VBox();
        containerextra.setPrefWidth(300);
        containerextra.setAlignment(Pos.CENTER);
        /*containerextra.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY,Insets.EMPTY)));*/
        Label labelcartas = new Label("Elige la carta");
        labelcartas.setFont(new Font(30));
        labelcartas.setTextFill(Color.web("#F8F8FF"));

        TextField textCarta = new TextField();
        textCarta.setFont(new Font(15));
        textCarta.setMaxWidth(200);

        Button btncarta = new Button("Lanzar");
        btncarta.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if(isMyTurn()){
                    int card_selected = Integer.parseInt(textCarta.getText());
                    if(card_selected == 0){
                        setMana(-mana_p);
                        if (type.equals("client")){
                            setMyTurn(false);
                            textCarta.clear();
                            client.SendMessage("null");
                        }
                        if(type.equals("server")){
                            setMyTurn(false);
                            textCarta.clear();
                            server.SendMessage("null");
                        }
                    }else{
                        textCarta.clear();
                        Object card = Mass.Data_find(card_selected);
                        if(isEnough(card)){
                            setMyTurn(false);
                            Mass.delete(card);
                            update_cards();

                        }
                    }
                }
            }
        });
        btncarta.setFont(new Font(15));
        btncarta.setPrefHeight(35);
        btncarta.setPrefWidth(130);

        VBox.setMargin(labelcartas,new Insets(50,0,0,0));
        VBox.setMargin(textCarta, new Insets(50,0,0,0));
        VBox.setMargin(btncarta, new Insets(50,0,0,0));

        containerextra.getChildren().addAll(labelcartas,textCarta,btncarta);

        BorderPane root = new BorderPane();

        root.setTop(containerVida);
        root.setBottom(containerMana);
        root.setRight(containerdeck);
        root.setCenter(containermanocartas);
        root.setLeft(containerextra);


        BackgroundImage FondoCentro= new BackgroundImage(new Image("/images/background_1.jpg",1800,1000,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        root.setBackground(new Background(FondoCentro));


        primaryStage.setTitle("Monsters");
        Scene scene = new Scene(root,1800,1000);
        primaryStage.setScene(scene);
        primaryStage.show();





    }

    /**
     * Setters method
     */
    public void setLastDamage(int lastDamage) {
        LastDamage = lastDamage;
    }

    public void setInt_freeze(int int_freeze) {
        if (int_freeze == 0){
            setMyTurn(true);
        }
        this.int_freeze = int_freeze;
    }

    public void setE_250(int e_250) {
        E_250 = e_250;
    }

    public void setMana_p(int mana_p) {
        this.mana_p = mana_p;
    }

    public void setP_damage(double p_damage) {
        this.p_damage = p_damage;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public void setP_mana(int p_mana) {
        this.p_mana = p_mana;
    }

    /**
     * Instantiation of the letters to be used with the action of forwarding and receiving
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void Action_send(String action){
        History.insertFirst("Send" + "\n" + "User " + name + "\n" + "Action: " + action + "\n" + "Life: " + this.life + "\n" + "Mana: " + this.mana);
        switch (action){
            case "d_card":
                break;
            case "+lastM":
                setMana(-p_mana);
                setP_mana(0);
                break;
            case "E_250":
                setE_250(250);
                break;
            case "doubleM":
                setMana_p(this.mana_p*2);
                break;
            case "big_damage":
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setDamage(300);
                        setLastDamage(300);
                    }
                });

                break;
            case "c_mass":
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setDamage(150);
                        setLastDamage(150);
                    }
                });
                setDamage(150);
                break;
            case "n_damage":
                setShield(true);
                break;
            case "r_damage":
                setDamage(-this.LastDamage);
                setLastDamage(0);
                break;
            case "v_+50%":
                setDamage((int) -(this.life/2));
                break;
            case "p_4cards":
                setMyTurn(true);
                break;
            case "shield":
                setShield(true);
                break;
            case "freeze_x1":
                setMyTurn(true);
                break;
            case "-damage":
                setP_damage(0.2);
                break;
            case "freeze_x2":
                setMyTurn(true);
                break;
            case "v_+25%":
                setDamage((int) -(this.life/4));
                break;
            case "+100m":
                setMana(-100);
                break;
            case "p_3cards":
                setMyTurn(true);
                break;

            }
    }
    public void Action_received(String action, int attack){
        if(action.equals("null")){
            this.History.insertFirst("Received" + "\n" + "User " + name + "\n" + "Action: " + "Attack" + "\n" + "Life: " + this.life + "\n" + "Mana: " + this.mana);
            if(attack > 0){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setDamage(attack);
                        setLastDamage(attack);
                    }
                });
            }
        }else {
            this.History.insertFirst("Received" +"\n"+ "User " + name + "\n" + "Action: " + action + "\n" + "Life: " + this.life + "\n" + "Mana: " + this.mana);
            switch (action) {
                case "-10%":
                    Platform.runLater(new Runnable() {
                        public void run() {
                            setDamage((int) (life*0.1));
                        }
                    });
                    break;
                case "-10m":
                    Platform.runLater(new Runnable() {
                        public void run() {
                            setMana((int) (mana*0.1));
                        }
                    });
                    break;
                case "-30%":
                    Platform.runLater(new Runnable() {
                        public void run() {
                            setDamage((int) (life*0.3));
                        }
                    });
                    break;
                case "d_card":
                case "freeze_x2":
                    setInt_freeze(2);
                    if (this.type.equals("server")) {
                        setMyTurn(false);
                        server.SendMessage("null");
                    } else {
                        setMyTurn(false);
                        client.SendMessage("null");
                    }
                    break;
                case "big_damage":
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setDamage(600);
                            setLastDamage(600);
                        }
                    });

                    break;
                case "c_mass":
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setDamage(300);
                            setLastDamage(300);
                        }
                    });
                    break;
                case "n_damage":
                    //No Afecta al contrincante
                    break;
                case "p_4cards":
                    setInt_freeze(4);
                    if (this.type.equals("server")) {
                        setMyTurn(false);
                        server.SendMessage("null");
                    } else {
                        setMyTurn(false);
                        client.SendMessage("null");
                    }
                    break;
                case "freeze_x1":
                    if (this.type.equals("server")) {
                        setMyTurn(false);
                        server.SendMessage("null");
                    } else {
                        setMyTurn(false);
                        client.SendMessage("null");
                    }
                    break;
                case "p_3cards":
                    setInt_freeze(3);
                    if (this.type.equals("server")) {
                        setMyTurn(false);
                        server.SendMessage("null");
                    } else {
                        setMyTurn(false);
                        client.SendMessage("null");
                    }
                    break;
            }
        }
    }
    /**
     * WIN METHOD
     * @param result
     */
    public void win(String result){
        GameOver gameOver = new GameOver(result, name, this.History);
        gameOver.start(this.stage);
        if(result.equals("LOSER")){
            if(type == "server"){
                server.SendMessage("WINNER");
            }else{
                client.SendMessage("WINNER");
            }
        }
    }
    /**
     * It is in charge of verifying if it has enough mana to carry out the cost of the card
     * @param event
     */
    @Override
    public void handle(ActionEvent event) { }
    public boolean isActive(){return this.active;}
    public boolean isEnough(Object data){
        if(data.getClass() == Spell.class){
            if(((Spell) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }
        }
        if(data.getClass() == Henchmen.class){
            if(((Henchmen) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }
        }
        if(data.getClass() == Secret.class){
            if(((Secret) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }
    /**
     * Send the message from JSON where the letters are stored
     * @param data
     * @throws JsonProcessingException
     */
    public void sendMessage(Object data) throws JsonProcessingException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setMana(-mana_p);
                setMana_p(50);
            }
        });
        Json json = new Json();
        Message message;
            if(type == "client"){
                if(data.getClass() == Secret.class){
                    message = new Message("Secret", ((Secret) data).getAction(), ((Secret) data).getMana(), 0);

                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Secret) data).getMana());
                    setP_mana(((Secret) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Henchmen.class){
                    message = new Message("Henchmen", "null", ((Henchmen) data).getMana(), ((Henchmen) data).getAttack());
                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Henchmen) data).getMana());
                    setP_mana(((Henchmen) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Spell.class){
                    message = new Message("Spell", ((Spell) data).getAction(), ((Spell) data).getMana(),0);
                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Spell) data).getMana());
                    setP_mana(((Spell) data).getMana());
                    setMyTurn(false);
                }
            }
            if(type == "server"){
                if(data.getClass() == Secret.class){
                    message = new Message("Secret", ((Secret) data).getAction(), ((Secret) data).getMana(), 0);
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Secret) data).getMana());
                    setP_mana(((Secret) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Henchmen.class){
                    message = new Message("Henchmen", "null", ((Henchmen) data).getMana(), ((Henchmen) data).getAttack());
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Henchmen) data).getMana());
                    setP_mana(((Henchmen) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Spell.class){
                    message = new Message("Spell", ((Spell) data).getAction(), ((Spell) data).getMana(),0);
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Spell) data).getMana());
                    setP_mana(((Spell) data).getMana());
                    setMyTurn(false);
                }
        }
    }
    /**
     * keeps the cards constantly updated
     */
    public void update_cards(){
        containermanocartas.getChildren().clear();
        for(int i = 1; this.Mass.size()>=i; i++){
            Object data = this.Mass.Data_find(i);
            if(data.getClass() == Spell.class){
                Image carta1 = new Image(((Spell) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
            if(data.getClass() == Henchmen.class){
                Image carta1 = new Image(((Henchmen) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
            if(data.getClass() == Secret.class){
                Image carta1 = new Image(((Secret) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
        }
    }
    public void setMana(int mana){

        this.mana -= mana;
        this.f_mana = this.mana/1000;
        this.containerMana.getChildren().remove(BarMana);
        this.containerMana.getChildren().remove(labelmanaAd);
        this.containerMana.getChildren().remove(BarManaAd);
        this.BarMana = new ProgressBar(f_mana);
        this.labelmanaAd = new Label("Mana Adversary");
        this.labelmanaAd.setFont(new Font(30));
        this.labelmanaAd.setTextFill(Color.web("#DAA520"));
        this.BarManaAd = new ProgressBar(f_manaad);
        this.BarMana.setMinWidth(500);
        this.BarManaAd.setMinWidth(100);
        HBox.setMargin(BarMana,new Insets(25,215,0,0));
        HBox.setMargin(labelmanaAd, new Insets(10,30,0,0));
        HBox.setMargin(BarManaAd, new Insets(25,0,0,0));
        this.containerMana.getChildren().addAll(BarMana,labelmanaAd,BarManaAd);
        containerMana.setPrefWidth(200);
        containerMana.setAlignment(Pos.TOP_LEFT);
    }
    public void setDamage(int damage){
        damage = (int) (damage*p_damage);
        if(this.shield) {
            setShield(false);
        }else{
            if(damage>E_250){
                if((this.life-(damage))<=1000){
                    if ((this.life-(damage))<= 0){
                        win("LOSER");
                    }
                    this.life -= damage;
                    this.f_life = this.life/1000;
                    this.containerVida.getChildren().remove(BarVida);
                    this.containerVida.getChildren().remove(labelvidaAd);
                    this.containerVida.getChildren().remove(BarVidaAd);
                    this.BarVida = new ProgressBar(f_life);
                    this.labelvidaAd = new Label("Life Adversary");
                    this.labelvidaAd.setFont(new Font(30));
                    this.labelvidaAd.setTextFill(Color.web("#008000"));
                    this.BarVidaAd = new ProgressBar(f_lifead);
                    this.BarVida.setMinWidth(500);
                    this.BarVidaAd.setMinWidth(100);
                    HBox.setMargin(BarVida,new Insets(20,250,0,0));
                    HBox.setMargin(labelvidaAd, new Insets(10,30,0,0));
                    HBox.setMargin(BarVidaAd, new Insets(25,0,0,0));
                    this.containerVida.getChildren().addAll(BarVida,labelvidaAd,BarVidaAd);
                }else{
                    this.life = 1000;
                    this.f_life = this.life/1000;
                    this.containerVida.getChildren().remove(BarVida);
                    this.containerVida.getChildren().remove(labelvidaAd);
                    this.containerVida.getChildren().remove(BarVidaAd);
                    this.BarVida = new ProgressBar(f_life);
                    this.labelvidaAd = new Label("Life Adversary");
                    this.labelvidaAd.setFont(new Font(30));
                    this.labelvidaAd.setTextFill(Color.web("#008000"));
                    this.BarVidaAd = new ProgressBar(f_lifead);
                    this.BarVida.setMinWidth(500);
                    this.BarVidaAd.setMinWidth(100);
                    HBox.setMargin(BarVida,new Insets(20,250,0,0));
                    HBox.setMargin(labelvidaAd, new Insets(10,30,0,0));
                    HBox.setMargin(BarVidaAd, new Insets(25,0,0,0));
                    this.containerVida.getChildren().addAll(BarVida,BarVidaAd);
                }
            }
            containerVida.setPrefWidth(200);
            containerVida.setAlignment(Pos.TOP_LEFT);
        }


    }
    /**
     * Conditions of passage to send message
     */
    public void receive_message(){
        while (isActive()) {
            Json json = new Json();
            if (type.equals("client")) {
                if (this.client.getInMessage() != null) {
                    this.Inmessage = this.client.getInMessage();
                    this.client.setInMessage(null);
                }
            }
            if (type.equals("server")) {
                if (this.server.getInMessage() != null) {
                    this.Inmessage = this.server.getInMessage();
                    this.server.setInMessage(null);
                }
            }
            if (Inmessage != null) {
                if (this.int_freeze == 0) {
                    if (Inmessage.equals("null")){
                        setMyTurn(true);
                        this.Inmessage = null;
                    }else{
                        if(Inmessage.equals("WINNER")){
                            this.Inmessage = null;
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    win("WINNER");
                                }
                            });
                        }else {
                            try {
                                JsonNode node = json.parsing(Inmessage);
                                Message message = new Message(node.get("type").textValue(), node.get("action").asText(), node.get("mana").asInt(), node.get("attack").asInt());
                                Action_received(message.getAction(), message.getAttack());
                                setMyTurn(true);
                                this.Inmessage = null;
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    setInt_freeze(this.int_freeze - 1);
                    setMyTurn(false);
                    if(type == "server") {
                        server.SendMessage("null");
                        this.Inmessage = null;
                    } else {
                        client.SendMessage("null");
                        this.Inmessage = null;
                    }
                }this.Inmessage = null;
            }

        }
    }
    public boolean isMyTurn() {
        return isMyTurn;
    }
    public void setMyTurn(boolean myTurn) {
        this.isMyTurn = myTurn;
    }
}
