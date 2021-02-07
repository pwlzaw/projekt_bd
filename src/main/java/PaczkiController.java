import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class PaczkiController {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button connectClientButton;

    @FXML
    private Button connectWorkerButton;

    @FXML
    private TextArea consoleTextArea;

    public static DBUtil dbUtil;
    public static PaczkiDAO paczkiDAO;
    public static String username;

    private static Scene scene;
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkiApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @FXML
    void connectClientButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        username=userTextField.getText();
        dbUtil = new DBUtil(userTextField.getText(), passwordTextField.getText(), consoleTextArea);
        paczkiDAO = new PaczkiDAO(dbUtil, consoleTextArea);

        dbUtil.dbConnect();

        consoleTextArea.appendText("Access granted for user \"" + userTextField.getText() + "\"." + "\n");

        try {
            Stage stage = new Stage();
            scene = new Scene(loadFXML("userView"), 800, 600);
            stage.setScene(scene);
            stage.setTitle("Client App");
            stage.show();
        }catch (IOException e){
            throw e;
        }

    }

    @FXML
    void connectWorkerButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        username=userTextField.getText();
        dbUtil = new DBUtil(userTextField.getText(), passwordTextField.getText(), consoleTextArea);
        paczkiDAO = new PaczkiDAO(dbUtil, consoleTextArea);

        dbUtil.dbConnect();

        try {
            Stage stage = new Stage();
            scene = new Scene(loadFXML("moderatorView"), 800, 600);
            stage.setScene(scene);
            stage.setTitle("Worker App");
            stage.show();
        }catch (IOException e){
            throw e;
        }

        consoleTextArea.appendText("Access granted for user \"" + userTextField.getText() + "\"." + "\n");
    }

}


















//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import tables.Paczki;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class PaczkiController {
//
//    @FXML // ResourceBundle that was given to the FXMLLoader
//    private ResourceBundle resources;
//
//    @FXML // URL location of the FXML file that was given to the FXMLLoader
//    private URL location;
//
//    @FXML // fx:id="userTextField"
//    private TextField userTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="passwordTextField"
//    private PasswordField passwordTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="connectButton"
//    private Button connectButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="disconnectButton"
//    private Button disconnectButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="consoleTextArea"
//    private TextArea consoleTextArea; // Value injected by FXMLLoader
//
//    @FXML // fx:id="racketNameToAddTextField"
//    private TextField racketNameToAddTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="addRacketButton"
//    private Button addRacketButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="selectRacketNameTextField"
//    private TextField selectRacketNameTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="selectRacketButton"
//    private Button selectRacketButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="showRacketsButton"
//    private Button showRacketsButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="racketTable"
//    private TableView racketTable; // Value injected by FXMLLoader
//
//    @FXML
//    private TableColumn<Paczki, String> nameCol;
//
//    @FXML
//    private TableColumn<Paczki, String> manufacturerCol;
//
//    @FXML
//    private TableColumn<Paczki, String> massCol;
//
//    @FXML
//    private TableColumn<Paczki, String> headSizeCol;
//
//    @FXML
//    private TableColumn<Paczki, String> dominantColorCol;
//
//    @FXML
//    private TableColumn<Paczki, String> priceUSDCol;
//
//    private DBUtil dbUtil;
//    private PaczkiDAO paczkiDAO;
//
//
//    @FXML
//    void addRacketButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
////        try {
////
////            if (!racketNameToAddTextField.getText().equals(null)) {
////
////                paczkiDAO.sendPackage(racketNameToAddTextField.getText());
////                consoleTextArea.appendText("New Racket " + racketNameToAddTextField.getText() + " inserted." + "\n");
////
////            }
////        } catch (SQLException e) {
////            consoleTextArea.appendText("Error occurred while inserting racket.\n");
////            throw e;
////        }
//
//    }
//
//    @FXML
//    void connectButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        dbUtil = new DBUtil(userTextField.getText(), passwordTextField.getText(), consoleTextArea);
//        paczkiDAO = new PaczkiDAO(dbUtil, consoleTextArea);
//
//        dbUtil.dbConnect();
//
//        consoleTextArea.appendText("Access granted for user \"" + userTextField.getText() + "\"." + "\n");
//        connectButton.setDisable(true);
//        disconnectButton.setDisable(false);
//        addRacketButton.setDisable(false);
//        selectRacketButton.setDisable(false);
//        showRacketsButton.setDisable(false);
//
//        selectRacketNameTextField.setDisable(false);
//        racketNameToAddTextField.setDisable(false);
//
//    }
//
//    @FXML
//    void disconnectButtonPressed(ActionEvent event) throws SQLException {
//
//        dbUtil.dbDisconnect();
//        connectButton.setDisable(false);
//        disconnectButton.setDisable(true);
//        addRacketButton.setDisable(true);
//        selectRacketButton.setDisable(true);
//        showRacketsButton.setDisable(true);
//        selectRacketNameTextField.setDisable(true);
//        selectRacketNameTextField.setText("");
//        selectRacketNameTextField.setPromptText("Podaj nazwę");
//        racketNameToAddTextField.setDisable(true);
//        racketNameToAddTextField.setText("");
//        racketNameToAddTextField.setPromptText("Podaj nazwę");
//        racketTable.getItems().clear();
//
//    }
//
//    @FXML
//    void selectRacketButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        try {
//
//            if (!selectRacketNameTextField.getText().equals(null)) {
//
//                racketTable.getItems().clear();
//                ObservableList<Paczki> wineData = paczkiDAO.searchPackagesToDeliver();
//                populateRackets(wineData);
////
//            }
//        } catch (SQLException e) {
//            consoleTextArea.appendText("Error occurred while getting wines from DB.\n");
//            throw e;
//        }
//
//    }
//
//    @FXML
//    void showRacketsButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        try {
//
//            racketTable.getItems().clear();
//            ObservableList<Paczki> paczkiData = paczkiDAO.showAllRackets();
//            populateRackets(paczkiData);
//
//        } catch (SQLException e) {
//            consoleTextArea.appendText("Error occurred while getting rackets from DB.\n");
//            throw e;
//        }
//
//    }
//
//    private void populateRackets(ObservableList<Paczki> paczkiData) {
//        racketTable.setItems(paczkiData);
//    }
//
//    @FXML
//        // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        assert userTextField != null : "fx:id=\"userTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert connectButton != null : "fx:id=\"connectButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert disconnectButton != null : "fx:id=\"disconnectButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert consoleTextArea != null : "fx:id=\"consoleTextArea\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert racketNameToAddTextField != null : "fx:id=\"racketNameToAddTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert addRacketButton != null : "fx:id=\"addRacketButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert selectRacketNameTextField != null : "fx:id=\"selectRacketNameTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert selectRacketButton != null : "fx:id=\"selectRacketButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert showRacketsButton != null : "fx:id=\"showRacketsButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert racketTable != null : "fx:id=\"racketTable\" was not injected: check your FXML file 'dbFX.fxml'.";
//
//        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert manufacturerCol != null : "fx:id=\"manufacturerCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert massCol != null : "fx:id=\"massCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert headSizeCol != null : "fx:id=\"headSizeCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert dominantColorCol != null : "fx:id=\"dominantColorCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert priceUSDCol != null : "fx:id=\"priceUSDCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//
//
//    }
//
//
//}
