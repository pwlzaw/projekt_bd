import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserViewController {

    @FXML
    private Button buttonHistory;

    @FXML
    private Button buttonState;

    @FXML
    private TableView<?> tableState;

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
    private TextField txtReciver;

    @FXML
    private TextField txtMachineID;

    @FXML
    private Button buttonSendPackage;

}
