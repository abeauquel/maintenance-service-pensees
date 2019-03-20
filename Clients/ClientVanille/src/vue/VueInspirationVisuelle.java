package vue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VueInspirationVisuelle extends Application {
    public VueInspirationVisuelle()
    {
        System.out.println("new VueInspiration()");
        VueInspirationVisuelle.instance = this;
    }
    protected static VueInspirationVisuelle instance = null;
    public static VueInspirationVisuelle getInstance() {return VueInspirationVisuelle.instance;};

    protected Scene scene = null;
    @Override
    public void start(Stage stade) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("inspiration-visuelle.fxml"));
        //Pane racine = new StackPane();
        scene = new Scene(racine, 800, 600);
        stade.setScene(scene);
        stade.show();
        ControleurInspirationVisuelle.getInstance().initialiser();

        // stade.setOnShowing(new EventHandler<WindowEvent>() {public void handle(WindowEvent event) {  } });
    }

    public void afficherListePensees()
    {
        System.out.println("afficherListePensees()");
        TextArea champsMessage = (TextArea) scene.lookup("#listePensees");
        champsMessage.setText("test");
    }


}