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
    private TableColumn<?, ?> tableStateColumnId;

    @FXML
    private TableColumn<?, ?> tableStateColumnState;

    @FXML
    private TableColumn<?, ?> tableStateColumnReciver;

    @FXML
    private TableColumn<?, ?> tableStateColumnAdres;

    @FXML
    private TableColumn<?, ?> tableHistoryColumnId;

    @FXML
    private TableColumn<?, ?> tableHistoryColumnState;

    @FXML
    private TableColumn<?, ?> tableHistoryColumnReciver;

    @FXML
    private TableColumn<?, ?> tableHistoryColumnSendDate;

    @FXML
    private TableColumn<?, ?> tableHistoryColumnReciveDate;

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


    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private void populateRackets(ObservableList<Paczki> paczkiData) {
        tableState.setItems(paczkiData);
    }

    @FXML
    void buttonHistoryCollectedOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableState.getItems().clear();
            ObservableList<Paczki> wineData = paczkiDAO.klientHistoriaOdebranych();
            populateRackets(wineData);


        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    void buttonHistorySentOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableState.getItems().clear();
            ObservableList<Paczki> wineData = paczkiDAO.klientHistoriaNadanych();
            populateRackets(wineData);


        } catch (SQLException e) {
            throw e;
        }
    }



    @FXML
    void buttonStateOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

                tableState.getItems().clear();
                ObservableList<Paczki> wineData = paczkiDAO.stanPaczki();
                populateRackets(wineData);


        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    void buttonSendPackageOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            if (!txtReciverName.getText().equals(null) && !txtReciverMachineID.getText().equals(null) && !txtSize.getText().equals(null)) {

                paczkiDAO.sendPackage(txtReciverName.getText(),txtReciverMachineID.getText(),txtSize.getText());

            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
