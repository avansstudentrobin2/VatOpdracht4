package frontend;

import classes.GetAllShapes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import Shape.Shape;
import javafx.scene.control.TextField;


public class blokcontroller {
    @FXML
    private TextField lengthInput;
    @FXML
    private TextField widthInput;
    @FXML
    private TextField heightInput;
    GetAllShapes AddToDatabase = new GetAllShapes();

    public void enterShape(ActionEvent event) {
        try{
            Double inputLength = Double.parseDouble(lengthInput.getText());
            Double inputWidth = Double.parseDouble(widthInput.getText());
            Double inputHeight = Double.parseDouble(heightInput.getText());
            Shape shape = new Shape("Blok", inputLength, inputWidth, inputHeight, 0);
            AddToDatabase.addToDatabase(shape);
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "main.fxml", "Vat Opdracht");

        } catch(Exception e){
            System.out.println("Onjuist invoer");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invoer fout");
            alert.setHeaderText(null);
            alert.setContentText("Vul een geldige waarde in.");
            alert.show();
        }
    }
}
