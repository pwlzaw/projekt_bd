import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tables.Paczki;

import java.sql.SQLException;

public class UserViewController {



    @FXML
    private Button buttonHistorySent;

    @FXML
    private Button buttonState;

    @FXML
    private TableView<Paczki> tableState;

    @FXML
    private TableColumn<Paczki, String> tableStateColumnId;

    @FXML
    private TableColumn<Paczki, String> tableStateColumnState;

    @FXML
    private TableColumn<Paczki, String> tableStateColumnReciver;

    @FXML
    private TableColumn<Paczki, String> tableStateColumnAdres;

    @FXML
    private TableColumn<Paczki, String> tableHistoryColumnId;

    @FXML
    private TableColumn<Paczki, String> tableHistoryColumnState;

    @FXML
    private TableColumn<Paczki, String> tableHistoryColumnReciver;

    @FXML
    private TableColumn<Paczki, String> tableHistoryColumnSendDate;

    @FXML
    private TableColumn<Paczki, String> tableHistoryColumnReciveDate;

    @FXML
    private Button buttonHistoryCollected;

    @FXML
    private Text textOutput;

    @FXML
    private TextField txtReciverName;

    @FXML
    private TextField txtReciverMachineID;

    @FXML
    private TextField txtSize;

    @FXML
    private Button buttonSendPackage;

    @FXML
    private TextField txtSenderMachineID;

    @FXML
    private TextField txtSenderName;

    @FXML
    private TextField txtReciverNuber;

    @FXML
    private TextField txtReciverMail;

    @FXML
    private TextField txtSenderMail;

    @FXML
    private TextField txtSenderNumber;

    @FXML
    private TextField txtRecivePackage;

    @FXML
    private Button buttonRecivePackage;


    String IDKlienta;

    private void populatePackages(ObservableList<Paczki> paczkiData) {
        tableState.setItems(paczkiData);
    }

    @FXML
    void buttonHistoryCollectedOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableState.getItems().clear();
            ObservableList<Paczki> wineData = PaczkiController.paczkiDAO.klientHistoriaOdebranych(IDKlienta); // do zmiany id
            populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonHistorySentOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableState.getItems().clear();
            ObservableList<Paczki> wineData = PaczkiController.paczkiDAO.klientHistoriaNadanych(IDKlienta); // do zmiany id
            populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }



    @FXML
    void buttonStateOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

                tableState.getItems().clear();
                ObservableList<Paczki> wineData = PaczkiController.paczkiDAO.stanPaczek(IDKlienta); // do zmiany id
                populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonSendPackageOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            if (!txtReciverName.getText().equals(null) && !txtReciverMachineID.getText().equals(null) && !txtSize.getText().equals(null) && !txtSenderMachineID.getText().equals(null)
            && !txtSenderName.getText().equals(null) && !txtReciverNuber.getText().equals(null) && !txtReciverMail.getText().equals(null) && !txtSenderMail.getText().equals(null)
            && !txtSenderNumber.getText().equals(null)) {

                PaczkiController.paczkiDAO.sendPackage(txtReciverName.getText(),txtReciverNuber.getText(),txtReciverMail.getText(),txtSenderName.getText(),txtSenderNumber.getText(),txtSenderMail.getText(),txtReciverMachineID.getText(),txtSenderMachineID.getText(),txtSize.getText());
                textOutput.setText("Package sent.\n");
            }
        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonRecivePackageOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            PaczkiController.paczkiDAO.odbierzPaczkeKlient(txtRecivePackage.getText());
            textOutput.setText("Package received.\n");


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }
}
