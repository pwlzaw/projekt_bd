import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.Ceny;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CenyDAO {
    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public CenyDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Ceny> getCenyList(ResultSet rs) throws SQLException {

        ObservableList<Ceny> CenyList = FXCollections.observableArrayList();

        while (rs.next()) {

            Ceny c = new Ceny();
            c.setCena(rs.getInt("cena"));
            c.setRozmiar(rs.getString("rozmiar"));
            CenyList.add(c);
        }

        return CenyList;
    }
}
