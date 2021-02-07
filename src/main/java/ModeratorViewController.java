import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tables.Automaty;
import tables.Paczki;
import tables.PaczkiDoOdebrania;

import java.sql.SQLException;
import java.time.LocalDate;

public class ModeratorViewController {

    @FXML
    private Button buttonStats;

    @FXML
    private Button buttonToBeDelivered;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField textAutomatId;

    @FXML
    private Button buttonRecive;

    @FXML
    private Button buttonDeliver;

    @FXML
    private TextField textPackageId;

    @FXML
    private Button buttonDayEarnings;

    @FXML
    private Text textOutput;

    @FXML
    private TableView<Paczki> tableStats;

    @FXML
    private TableColumn<Paczki, String> tableStatsId;

    @FXML
    private TableColumn<Paczki, String> tableStatsAdres;

    @FXML
    private TableColumn<Paczki, String> tableStatsDeliveredNumber;

    @FXML
    private TableView<PaczkiDoOdebrania> tableToBeDelivered;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeDeliveredId;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeRecivedAdres;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeDeliveredAdres;


    private void populateStats(ObservableList<Paczki> paczkiData) {
        tableStats.setItems(paczkiData);}
    private void populateToBeDelivered(ObservableList<PaczkiDoOdebrania> paczkiData) {
        tableToBeDelivered.setItems(paczkiData);}

    @FXML
    void buttonDayEarningsOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableStats.getItems().clear();
            ObservableList<Paczki> wineData = PaczkiController.paczkiDAO.statystykiDnia(datePicker.toString());
            populateStats(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonDeliverOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            PaczkiController.paczkiDAO.dostarczPaczke(textPackageId.getText());
            textOutput.setText("Package delivered.\n");


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonReciveOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            PaczkiController.paczkiDAO.odbierzPaczke(textPackageId.getText());
             textOutput.setText("Package received.\n");

        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonStatsOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableStats.getItems().clear();
            ObservableList<Paczki> wineData = PaczkiController.paczkiDAO.statystykiAutomatu(textAutomatId.getText(),datePicker.toString());
            populateStats(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonToBeDeliveredOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableToBeDelivered.getItems().clear();
            ObservableList<PaczkiDoOdebrania> wineData = PaczkiController.paczkiDAO.searchPackagesToDeliver();
            populateToBeDelivered(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

}