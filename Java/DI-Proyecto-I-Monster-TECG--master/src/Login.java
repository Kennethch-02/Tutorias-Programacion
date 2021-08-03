import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * Executor class application area
 */
public class Login extends Application implements EventHandler<ActionEvent>{
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * instantiate game start
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        VBox containerLeft = new VBox();

        Label labelTitle = new Label("Login");
        labelTitle.setFont(new Font(40));
        labelTitle.setTextFill(Color.web("#F8F8FF"));

        VBox containerconection = new VBox();

        Label labelIP = new Label("Port");
        labelIP.setFont(new Font(20));

        Label labelName = new Label("Name");
        labelName.setFont(new Font(20));

        TextField textIP = new TextField();
        textIP.setFont(new Font(18));
        textIP.setPromptText("Enter the server port");
        textIP.setPrefWidth(341);
        textIP.setPrefHeight(44);

        TextField textName = new TextField();
        textName.setFont(new Font(18));
        textName.setPromptText("Name");
        textName.setPrefWidth(341);
        textName.setPrefHeight(44);

        Button btnLogin = new Button("Start");
        btnLogin.setFont(new Font(20));
        btnLogin.setPrefWidth(370);
        btnLogin.setPrefHeight(44);
        btnLogin.setMaxWidth(Double.MAX_VALUE);
        btnLogin.setCursor(Cursor.HAND);
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int port = Integer.parseInt(textIP.getText());
                try {
                    App app = new App("client", port, textName.getText());
                    app.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnHost = new Button("Start as a Host");
        btnHost.setFont(new Font(20));
        btnHost.setPrefWidth(370);
        btnHost.setPrefHeight(44);
        btnHost.setMaxWidth(Double.MAX_VALUE);
        btnHost.setCursor(Cursor.HAND);
        btnHost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    App app = new App("server", 0, textName.getText());
                    app.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        containerconection.getChildren().addAll(labelIP, textIP, labelName, textName, btnLogin, btnHost);
        containerconection.setAlignment(Pos.TOP_LEFT);


        VBox.setMargin(labelIP, new Insets(10, 0, 0, 0));
        VBox.setMargin(labelName, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnLogin, new Insets(20, 0, 0, 0));
        VBox.setMargin(btnHost, new Insets(30, 0, 0, 0));

        containerLeft.getChildren().addAll(labelTitle, containerconection);
        containerLeft.setPrefWidth(300);
        containerLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(containerconection, new Insets(0, 30, 0, 30));

        VBox containerRight = new VBox();



        containerRight.setPrefWidth(422);
        containerRight.setAlignment(Pos.TOP_RIGHT);

        HBox root = new HBox();
        root.getChildren().addAll(containerLeft, containerRight);
        HBox.setHgrow(containerLeft, Priority.ALWAYS);
        HBox.setHgrow(containerRight, Priority.ALWAYS);

        BackgroundImage FondoHBox= new BackgroundImage(new Image("/images/background_2.jpg",850,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        root.setBackground(new Background(FondoHBox));

        Scene scene = new Scene(root, 850, 500);

        primaryStage.setTitle("Monsters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
    }
}
