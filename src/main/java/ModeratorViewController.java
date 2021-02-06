import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tables.Paczki;

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
    private TableColumn<?, ?> tableStatsId;

    @FXML
    private TableColumn<?, ?> tableStatsAdres;

    @FXML
    private TableColumn<?, ?> tableStatsDeliveredNumber;

    @FXML
    private TableView<?> tableToBeDelivered;

    @FXML
    private TableColumn<?, ?> tableToBeDeliveredId;

    @FXML
    private TableColumn<?, ?> tableToBeDeliveredAdres;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private void populatePackages(ObservableList<Paczki> paczkiData) {
        tableStats.setItems(paczkiData);}

    @FXML
    void buttonDayEarningsOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableStats.getItems().clear();
            ObservableList<Paczki> wineData = paczkiDAO.statystykiDnia(datePicker.toString());
            populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonDeliverOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            paczkiDAO.dostarczPaczke(textPackageId.getText());
            textOutput.setText("Package delivered.\n");


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonReciveOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

             paczkiDAO.odbierzPaczke(textPackageId.getText());
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
            ObservableList<Paczki> wineData = paczkiDAO.statystykiAutomatu(textAutomatId.getText(),datePicker.toString());
            populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

    @FXML
    void buttonToBeDeliveredOnClick(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {

            tableStats.getItems().clear();
            ObservableList<Paczki> wineData = paczkiDAO.searchPackagesToDeliver();
            populatePackages(wineData);


        } catch (SQLException e) {
            textOutput.setText("Error occurred while getting wines from DB.\n");
            throw e;
        }
    }

}