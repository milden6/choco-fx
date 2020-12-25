import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import сlient.controller.LoginController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("сlient/form/LoginForm.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Вход");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();

        Parent root2 = new FXMLLoader(getClass().getResource("сlient/form/MainForm.fxml")).load();
//        (( LoginController ) loader.getController()).setStage(primaryStage, root2);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
