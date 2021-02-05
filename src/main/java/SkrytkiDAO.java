import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.Skrytki;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkrytkiDAO {
    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public SkrytkiDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Skrytki> getSkrytkiList(ResultSet rs) throws SQLException {

        ObservableList<Skrytki> SkrytkiList = FXCollections.observableArrayList();

        while (rs.next()) {

            Skrytki s = new Skrytki();
            s.setId(rs.getInt("id"));
            s.setAutomat_id(rs.getInt("automat_id"));
            s.setRozmiar(rs.getString("rozmiar"));
            s.setStan(rs.getString("stan"));
            SkrytkiList.add(s);
        }

        return SkrytkiList;
    }
}
