import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class game_history extends Application implements EventHandler<ActionEvent> {
    private DoubleLinkedList history;
    private int position;
    private int size;
    private VBox c_container;
    public static void main(String[] args) {
        launch(args);
    }
    public game_history(DoubleLinkedList history){
        this.history = history;
        this.position = this.history.size();
        this.size = this.history.size();
        this.c_container = new VBox();
    }
    @Override
    public void start(Stage primaryStage) {
        VBox left_container = new VBox();
        VBox right_container = new VBox();
        VBox c_up_container = new VBox();
        VBox c_dow_container = new VBox();

        Label labelTitle = new Label("History");
        labelTitle.setFont(new Font(30));
        labelTitle.setTextFill(Color.web("#F8F8FF"));

        Label L_history = new Label((String) this.history.Data_find(1));
        L_history.setFont(new Font(20));
        L_history.setMaxWidth(400);
        L_history.setTextFill(Color.web("#F8F8FF"));


        Button btnRight = new Button("Next");
        btnRight.setFont(new Font(10));
        btnRight.setPrefWidth(150);
        btnRight.setPrefHeight(30);
        btnRight.setMaxWidth(400);
        btnRight.setCursor(Cursor.HAND);
        btnRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update_history("next");
            }
        });

        Button btnLeft = new Button("Previous");
        btnLeft.setFont(new Font(10));
        btnLeft.setPrefWidth(150);
        btnLeft.setPrefHeight(30);
        btnLeft.setMaxWidth(400);
        btnLeft.setCursor(Cursor.HAND);
        btnLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update_history("previous");
            }
        });


        Button btnContinue = new Button("Continue");
        btnContinue.setFont(new Font(20));
        btnContinue.setPrefWidth(370);
        btnContinue.setPrefHeight(44);
        btnContinue.setMaxWidth(400);
        btnContinue.setCursor(Cursor.HAND);
        btnContinue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Login login = new Login();
                    login.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        c_dow_container.getChildren().addAll(btnContinue);
        c_dow_container.setPrefWidth(300);
        c_dow_container.setAlignment(Pos.TOP_LEFT);

        c_up_container.getChildren().addAll(labelTitle);
        c_up_container.setPrefWidth(300);
        c_up_container.setAlignment(Pos.TOP_CENTER);

        right_container.getChildren().addAll(btnLeft);
        right_container.setPrefWidth(300);
        right_container.setAlignment(Pos.BOTTOM_CENTER);

        left_container.getChildren().addAll(btnRight);
        left_container.setPrefWidth(300);
        left_container.setAlignment(Pos.BOTTOM_CENTER);

        c_container.getChildren().addAll(L_history);
        c_container.setPrefWidth(300);
        c_container.setAlignment(Pos.CENTER_LEFT);

        HBox root = new HBox();
        root.getChildren().addAll(c_container, right_container, left_container, c_dow_container, c_up_container);
        HBox.setHgrow(c_container, Priority.ALWAYS);

        BackgroundImage FondoHBox= new BackgroundImage(new Image("/images/background_2.jpg",850,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        root.setBackground(new Background(FondoHBox));

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Monsters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void handle(ActionEvent event) {
    }
    public void update_history(String instruction){
        c_container.getChildren().clear();
        if (instruction.equals("next")){
            this.position++;
            if (this.position > this.size){
                this.position = 1;
            }
            Label L_history = new Label((String) this.history.Data_find(this.position));
            L_history.setFont(new Font(20));
            L_history.setTextFill(Color.web("#F8F8FF"));
            L_history.setMaxWidth(400);
            c_container.getChildren().add(L_history);
        }else{
            this.position--;
            if(this.position<=0){
                this.position = this.size;
                Label L_history = new Label((String) this.history.Data_find(this.position));
                L_history.setFont(new Font(20));
                L_history.setTextFill(Color.web("#F8F8FF"));
                L_history.setMaxWidth(400);
                c_container.getChildren().add(L_history);
            }else{
                Label L_history = new Label((String) this.history.Data_find(this.position));
                L_history.setFont(new Font(20));
                L_history.setTextFill(Color.web("#F8F8FF"));
                L_history.setMaxWidth(400);
                c_container.getChildren().add(L_history);
            }
        }
    }
}