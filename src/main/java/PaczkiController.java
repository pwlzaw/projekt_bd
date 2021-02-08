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
