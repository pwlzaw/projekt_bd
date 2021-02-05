import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.Automaty;
import tables.Paczki;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutomatyDAO {

    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public AutomatyDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Automaty> getAutomatyList(ResultSet rs) throws SQLException {

        ObservableList<Automaty> AutomatyList = FXCollections.observableArrayList();

        while (rs.next()) {

            Automaty a = new Automaty();
            a.setId(rs.getInt("id"));
            a.setAdres(rs.getString("adres"));
            AutomatyList.add(a);
        }

        return AutomatyList;
    }
}
