package frontend;

import Shape.Shape;
import classes.GetAllShapes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class bolcontroller {
    @FXML
    private TextField rayInput;
    private Button enterShape;
    GetAllShapes AddToDatabase = new GetAllShapes();

    public void enterShape(ActionEvent event) {
        try{
            Double inputRay = Double.parseDouble(rayInput.getText());
            Shape shape = new Shape("Bol", 0, 0, 0, inputRay);
            AddToDatabase.addToDatabase(shape);
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "main.fxml", "Vat Opdracht");

        } catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invoer fout");
            alert.setHeaderText(null);
            alert.setContentText("Vul een geldige waarde in.");
            alert.show();
        }
    }
}
