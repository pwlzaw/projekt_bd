import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import tables.Paczki;

import java.sql.SQLException;

public class UserViewController {

    @FXML
    private Button buttonHistorySent;

    @FXML
    private Button buttonState;

    @FXML
    private TableView tableState;

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
    private TextField txtReciver;

    @FXML
    private TextField txtMachineID;

    @FXML
    private TextField txtSize;

    @FXML
    private Button buttonSendPackage;

    @FXML
    private Button buttonHistory1;

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

            if (!txtReciver.getText().equals(null) && !txtMachineID.getText().equals(null) && !txtSize.getText().equals(null)) {

                paczkiDAO.sendPackage(txtReciver.getText(),txtMachineID.getText(),txtSize.getText());

            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
