import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tables.*;

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
    private TableView<GetStats> tableStats;

    @FXML
    private TableColumn<GetStats, String> tableCountS;

    @FXML
    private TableColumn<GetStats, String> tableCountM;

    @FXML
    private TableColumn<GetStats, String> tableCountL;

    @FXML
    private TableColumn<GetStats, String> tableCountXL;

    @FXML
    private TableView<PaczkiDoOdebrania> tableToBeDelivered;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeDeliveredId;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeRecivedAdres;

    @FXML
    private TableColumn<PaczkiDoOdebrania, String> tableToBeDeliveredAdres;


    private void populateStats(ObservableList<GetStats> paczkiData) {
        tableStats.setItems(paczkiData);}
    private void populateToBeDelivered(ObservableList<PaczkiDoOdebrania> paczkiData) {
        tableToBeDelivered.setItems(paczkiData);}

    @FXML
    void buttonDayEarningsOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            String zysk = PaczkiController.paczkiDAO.searchEarnings(datePicker.getValue().toString());
            textOutput.setText(zysk + " - Zysk w danym dniu.\n");


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

            tableToBeDelivered.setVisible(false);
            tableStats.setVisible(true);
            tableStats.getItems().clear();
            ObservableList<GetStats> wineData = PaczkiController.paczkiDAO.statystykiAutomatu(textAutomatId.getText(),datePicker.getValue().toString());
            populateStats(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonToBeDeliveredOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {
            tableStats.setVisible(false);
            tableToBeDelivered.setVisible(true);
            tableToBeDelivered.getItems().clear();
            ObservableList<PaczkiDoOdebrania> wineData = PaczkiController.paczkiDAO.searchPackagesToDeliver();
            populateToBeDelivered(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

}