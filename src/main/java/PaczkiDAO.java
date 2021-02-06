import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.Paczki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaczkiDAO {

    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public PaczkiDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Paczki> getPackagesList(ResultSet rs) throws SQLException {

        ObservableList<Paczki> paczkiList = FXCollections.observableArrayList();

        while (rs.next()) {

            Paczki r = new Paczki();
            r.setId(rs.getInt("id"));
            r.setStan(rs.getString("stan"));
            r.setRozmiar(rs.getString("rozmiar"));
            r.setId_nadawcy(rs.getInt("id_nadawcy"));
            r.setId_odbiorcy(rs.getInt("id_odbiorcy"));
            r.setSkrytka_nadania_id(rs.getInt("skrytka_nadania_id"));
            r.setSkrytka_odbioru_id(rs.getInt("skrytka_odbioru_id"));
            r.setData_dostarczenia(rs.getString("data_dostarczenia"));
            r.setData_nadania(rs.getString("data_nadania"));
            r.setData_odbioru(rs.getString("data_odbioru"));
            r.setData_wysłania(rs.getString("data_wysłania"));
            paczkiList.add(r);
        }

        return paczkiList;
    }


    public ObservableList<Paczki> searchPackages(String manuf) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM paczki WHERE rozmiar LIKE '%" + manuf + "%';";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching a racket from '" + manuf + "' name, an error occurred. \n");
            throw e;
        }

    }



    public ObservableList<Paczki> showAllRackets() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM rackets;";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> paczkiList = getPackagesList(resultSet);
            consoleTextArea.appendText(selectStmt);

            return paczkiList;


        } catch (SQLException e) {
            consoleTextArea.appendText("While searching rackets, an error occurred. \n");
            throw e;
        }

    }
    // początek metod docelowych
    public void sendPackage(String reciver,String machineID,String size) throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("INSERT INTO packages(id_odbiorcy,skrytka_odbioru_id,rozmiar,data_nadania) VALUES(");
        sb.append(reciver);
        sb.append("),(");
        sb.append(machineID);
        sb.append("),('");
        sb.append(size);
        sb.append("'),('");
        sb.append(LocalDate.now().toString());
        sb.append("');");
        String insertStmt = sb.toString();

        try {

            dbUtil.dbExecuteUpdate(insertStmt);
            consoleTextArea.appendText(insertStmt + "\n");

        } catch (SQLException e) {
            consoleTextArea.appendText("Error occurred while INSERT Operation.");
            throw e;
        }

    }

    public ObservableList<Paczki> searchPackagesToDeliver() throws SQLException, ClassNotFoundException {

        String selectStmt = "call PaczkiDoOdebrania();";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching a package from '" + "' name, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<Paczki> klientHistoriaOdebranych() throws SQLException, ClassNotFoundException {

        String selectStmt = "call klientHistoriaOdebranych();";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<Paczki> klientHistoriaNadanych() throws SQLException, ClassNotFoundException {

        String selectStmt = "call klientHistoriaNadanych();";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<Paczki> stanPaczki() throws SQLException, ClassNotFoundException {

        String selectStmt = "call stanPaczki();";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<Paczki> statystykiAutomatu() throws SQLException, ClassNotFoundException {

        String selectStmt = "call statystykiAutomatu();";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Paczki> aPackages = getPackagesList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }
}
