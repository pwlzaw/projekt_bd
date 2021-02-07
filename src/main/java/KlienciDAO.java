import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.Klienci;


import java.sql.ResultSet;
import java.sql.SQLException;

public class KlienciDAO {
    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public KlienciDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Klienci> getKlienciList(ResultSet rs) throws SQLException {

        ObservableList<Klienci> KlienciList = FXCollections.observableArrayList();

        while (rs.next()) {

            Klienci k = new Klienci();
            k.setId(rs.getInt("id"));
            k.setImię_nazwisko(rs.getString("imię_nazwisko"));
            k.setEmail(rs.getString("email"));
            k.setTel(rs.getInt("tel"));
            k.setUsername(rs.getString("username"));
            KlienciList.add(k);
        }

        return KlienciList;
    }
}
