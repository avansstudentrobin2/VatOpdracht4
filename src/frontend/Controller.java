package frontend;

import classes.GetAllShapes;
import classes.GetVolume;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import Shape.Shape;

import java.awt.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private GetAllShapes GetAllShapes;
    @FXML
    private Button newShape;
    @FXML
    private Button deleteShape;
    @FXML
    private TableView<Shape> tableViewShapes;
    @FXML
    private TableColumn<Shape, String> shapenameColumn;
    @FXML
    private TableColumn<Shape, Double> parametersColumn;

    @FXML
    private void displayValue(ActionEvent event) {
    }

    @FXML
    private ChoiceBox choiceBox;
    private String selectedShape = "Bol";
    @FXML
    private TextField selectedShapeVolume;
    @FXML
    private TextField totalShapeVolume;
    GetVolume getVolume = new GetVolume();

    public Controller() {
        try {
            GetAllShapes = new GetAllShapes();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shapenameColumn.setCellValueFactory(new PropertyValueFactory<>("shapeName"));
        selectedShapeVolume.setText("Selecteer een vorm");
        choiceBox.getItems().add("Bol");
        choiceBox.getItems().add("Cilinder");
        choiceBox.getItems().add("Blok");
        choiceBox.getItems().add("Kegel");
        choiceBox.getItems().add("Piramide");
        choiceBox.setValue("Bol");
        try {
            tableViewShapes.setItems(GetAllShapes.getAllShapes());
            getTotalShapeVolume();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void getTotalShapeVolume() {
        double totalVolume = 0;

        ObservableList<Shape> allShapes = tableViewShapes.getItems();
        for (Shape shape : allShapes) {
            if (shape.getShapeName().equals("Bol")) {
                totalVolume += getVolume.volumeBol(shape);
            } else if (shape.getShapeName().equals("Cilinder")) {
                totalVolume += getVolume.volumeCilinder(shape);
            } else if (shape.getShapeName().equals("Blok")) {
                totalVolume += getVolume.volumeBlok(shape);
            } else if (shape.getShapeName().equals("Kegel")) {
                totalVolume += getVolume.volumeKegel(shape);
            } else if (shape.getShapeName().equals("Piramide")) {
                totalVolume += getVolume.volumePiramide(shape);
            }
        }
        DecimalFormat df = new DecimalFormat("#,##");
        totalVolume = Double.valueOf(df.format(totalVolume));
        String volumeText = Double.toString(totalVolume);
        totalShapeVolume.setText(volumeText);
    }

    public void newShape(ActionEvent event) {
        if (choiceBox.getValue().toString().equals("Bol")) {
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "bolcontroller.fxml", "Add Bol");
        } else if (choiceBox.getValue().toString().equals("Cilinder")) {
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "cilindercontroller.fxml", "Add Cilinder");
        } else if (choiceBox.getValue().toString().equals("Blok")) {
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "blokcontroller.fxml", "Add Blok");
        } else if (choiceBox.getValue().toString().equals("Kegel")) {
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "kegelcontroller.fxml", "Add Kegel");
        } else if (choiceBox.getValue().toString().equals("Piramide")) {
            SceneChanger sc = new SceneChanger();
            sc.changeScenes(event, "piramidecontroller.fxml", "Add Piramide");
        }
    }

    public void deleteShape() {
        Shape selectedShape = tableViewShapes.getSelectionModel().getSelectedItem();
        try {
            GetAllShapes.deleteInDatabase(selectedShape);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Verwijderd");
            alert.setHeaderText(null);
            alert.setContentText("De vorm is verwijderd.");
            alert.show();
            tableViewShapes.setItems(GetAllShapes.getAllShapes());
            getTotalShapeVolume();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Verwijder fout");
            alert.setHeaderText(null);
            alert.setContentText("De vorm is niet verwijderd. Probeer opnieuw.");
            alert.show();
        }

    }

    public void closeProgram() {
        Platform.exit();
    }

    public void choiceBoxChanged() {
        selectedShape = choiceBox.getValue().toString();
        getTotalShapeVolume();
    }

    public void tableViewNewSelected() {
        Shape selectedShape = tableViewShapes.getSelectionModel().getSelectedItem();
        if (selectedShape != null) {
            if (selectedShape.getShapeName().equals("Bol")) {
                selectedShapeVolume.setText(Double.toString(getVolume.volumeBol(selectedShape)));
            } else if (selectedShape.getShapeName().equals("Cilinder")) {
                selectedShapeVolume.setText(Double.toString(getVolume.volumeCilinder(selectedShape)));
            } else if (selectedShape.getShapeName().equals("Blok")) {
                selectedShapeVolume.setText(Double.toString(getVolume.volumeBlok(selectedShape)));
            } else if (selectedShape.getShapeName().equals("Kegel")) {
                selectedShapeVolume.setText(Double.toString(getVolume.volumeKegel(selectedShape)));
            } else if (selectedShape.getShapeName().equals("Piramide")) {
                selectedShapeVolume.setText(Double.toString(getVolume.volumePiramide(selectedShape)));
            }
        } else {
            selectedShapeVolume.setText("Selecteer een vorm");
        }
    }
}
