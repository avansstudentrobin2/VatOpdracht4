package frontend;

import Shape.Shape;
import classes.GetAllShapes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class kegelcontroller {
    @FXML
    private TextField rayInput;
    @FXML
    private TextField heightInput;
    GetAllShapes AddToDatabase = new GetAllShapes();

    public void enterShape(ActionEvent event) {
        try{
            Double inputRay = Double.parseDouble(rayInput.getText());
            System.out.println(inputRay);
            System.out.println(heightInput.getText());
            Double inputHeight = Double.parseDouble(heightInput.getText());
            System.out.println(inputHeight);
            Shape shape = new Shape("Kegel", 0, 0, inputHeight, inputRay);
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
