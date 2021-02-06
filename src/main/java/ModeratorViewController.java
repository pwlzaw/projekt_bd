import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    private TableView<?> tableStats;

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

    @FXML
    void buttonDayEarningsOnClick(ActionEvent event) {

    }

    @FXML
    void buttonDeliverOnClick(ActionEvent event) {

    }

    @FXML
    void buttonReciveOnClick(ActionEvent event) {

    }

    @FXML
    void buttonStatsOnClick(ActionEvent event) {

    }

    @FXML
    void buttonToBeDeliveredOnClick(ActionEvent event) {

    }

}