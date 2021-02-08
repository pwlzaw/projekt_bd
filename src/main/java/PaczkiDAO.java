import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import tables.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
            r.setRozmiar(rs.getInt("rozmiar"));
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

    private ObservableList<StanPaczek> getStatusList(ResultSet rs) throws SQLException {

        ObservableList<StanPaczek> paczkiList = FXCollections.observableArrayList();

        while (rs.next()) {

            StanPaczek r = new StanPaczek();
            r.setId(rs.getInt("id"));
            r.setStan(rs.getString("stan"));
            r.setOdbiorca(rs.getString(2));
            r.setNadawca(rs.getString(1));
            r.setData_nadania(rs.getString("data_nadania"));
            r.setData_odbioru(rs.getString("data_odbioru"));
            paczkiList.add(r);
        }

        return paczkiList;
    }

    private ObservableList<GetStats> getStatsList(ResultSet rs) throws SQLException {

        ObservableList<GetStats> paczkiList = FXCollections.observableArrayList();

        while (rs.next()) {

            GetStats r = new GetStats();
            r.setLiczbaS(rs.getInt(1));
            r.setLiczbaM(rs.getInt(2));
            r.setLiczbaL(rs.getInt(3));
            r.setLiczbaXL(rs.getInt(4));
            paczkiList.add(r);
        }

        return paczkiList;
    }

    private double getEarningsList(ResultSet rs) throws SQLException {

       double zysk=0;

        while (rs.next()) {

                zysk=(rs.getDouble("sum(c.cena)"));

        }

        return zysk;
    }

    private ObservableList<PaczkiDoOdebrania> getToBeDeliveredList(ResultSet rs) throws SQLException {

        ObservableList<PaczkiDoOdebrania> paczkiList = FXCollections.observableArrayList();


        while (rs.next()) {

            PaczkiDoOdebrania r = new PaczkiDoOdebrania();
            r.setId(rs.getInt("id"));
            r.setAdres_nadania(rs.getString(2));
            r.setAdres_odbioru(rs.getString(3));
            paczkiList.add(r);
        }

        return paczkiList;
    }
// test
    private int getUsersID(ResultSet rs) throws SQLException {

        int id=0;


        while (rs.next()) {
            id=(rs.getInt("id"));
        }

        return id;
    }

//// stare metody
//    public ObservableList<Paczki> searchPackages(String manuf) throws SQLException, ClassNotFoundException {
//
//        String selectStmt = "SELECT * FROM paczki WHERE rozmiar LIKE '%" + manuf + "%';";
//
//        try {
//
//            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
//
//            ObservableList<Paczki> aPackages = getPackagesList(resultSet);
//
//            consoleTextArea.appendText(selectStmt + "\n");
//
//            return aPackages;
//
//        } catch (SQLException e) {
//            consoleTextArea.appendText("While searching a racket from '" + manuf + "' name, an error occurred. \n");
//            throw e;
//        }
//
//    }
//
//
//
//    public ObservableList<Paczki> showAllRackets() throws SQLException, ClassNotFoundException {
//
//        String selectStmt = "SELECT * FROM rackets;";
//
//        try {
//
//            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
//
//            ObservableList<Paczki> paczkiList = getPackagesList(resultSet);
//            consoleTextArea.appendText(selectStmt);
//
//            return paczkiList;
//
//
//        } catch (SQLException e) {
//            consoleTextArea.appendText("While searching rackets, an error occurred. \n");
//            throw e;
//        }
//
//    }
    // początek metod docelowych
    public void sendPackage(String reciverName,String reciverPhone, String reciverEmail,String senderName, String senderPhone, String senderEmail, String reciverMachineID, String senderMachineID,String size, String username) throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("call nadaj_przesylke('");
        sb.append(reciverName);
        sb.append("',");
        sb.append(reciverPhone);
        sb.append(",'");
        sb.append(reciverEmail);
        sb.append("','");
        sb.append(senderName);
        sb.append("',");
        sb.append(senderPhone);
        sb.append(",'");
        sb.append(senderEmail);
        sb.append("',");
        sb.append(reciverMachineID);
        sb.append(",");
        sb.append(senderMachineID);
        sb.append(",");
        sb.append(size);
        sb.append(",'");
        sb.append(username);
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
// test
public String searchUsersID() throws SQLException, ClassNotFoundException {

    String selectStmt = "SELECT * FROM Klienci WHERE username = '" + PaczkiController.username + "';";

    try {

        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

        int ID = getUsersID(resultSet);

        consoleTextArea.appendText(selectStmt + "\n");

        return String.valueOf(ID);

    } catch (SQLException e) {
        consoleTextArea.appendText("While searching packages, an error occurred. \n");
        throw e;
    }
}

    public String searchEarnings(String data) throws SQLException, ClassNotFoundException {

        String selectStmt = "call PodgladZysku('" + data + "');";


        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            double zysk = getEarningsList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return String.valueOf(zysk);

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }


    public ObservableList<PaczkiDoOdebrania> searchPackagesToDeliver() throws SQLException, ClassNotFoundException {

        String selectStmt = "call PaczkiDoOdebrania();";


        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<PaczkiDoOdebrania> aPackages = getToBeDeliveredList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<StanPaczek> klientHistoriaOdebranych(String id) throws SQLException, ClassNotFoundException {

        String selectStmt = "call klientHistoriaOdebranych(" + id + ");";


        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<StanPaczek> aPackages = getStatusList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<StanPaczek> klientHistoriaNadanych(String id) throws SQLException, ClassNotFoundException {

        String selectStmt = "call klientHistoriaNadanych(" + id + ");";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<StanPaczek> aPackages = getStatusList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<StanPaczek> stanPaczek(String id_klienta) throws SQLException, ClassNotFoundException {

        String selectStmt = "call stanPaczeK(" + id_klienta + ");";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<StanPaczek> aPackages = getStatusList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public ObservableList<GetStats> statystykiAutomatu(String id_automatu, String dzien) throws SQLException, ClassNotFoundException {

        String selectStmt = "call statystykiAutomatu(" + id_automatu + ",'" + dzien + "');";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<GetStats> aPackages = getStatsList(resultSet);

            consoleTextArea.appendText(selectStmt + "\n");

            return aPackages;

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }


    public void dostarczPaczke(String id) throws SQLException, ClassNotFoundException {

        String insertStmt = "call dostarcz_przesylke(";
        insertStmt+=id;
        insertStmt+=");";

        try {

            dbUtil.dbExecuteUpdate(insertStmt);
            consoleTextArea.appendText(insertStmt + "\n");

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public void odbierzPaczke(String id) throws SQLException, ClassNotFoundException {

        String insertStmt = "call odbierz_przesylke(";
        insertStmt+=id;
        insertStmt+=");";

        try {

            dbUtil.dbExecuteUpdate(insertStmt);
            consoleTextArea.appendText(insertStmt + "\n");

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }

    public void odbierzPaczkeKlient(String id) throws SQLException, ClassNotFoundException {

        String insertStmt = "call klient_odbierz_przesylke(";
        insertStmt+=id;
        insertStmt+=");";

        try {

            dbUtil.dbExecuteUpdate(insertStmt);
            consoleTextArea.appendText(insertStmt + "\n");

        } catch (SQLException e) {
            consoleTextArea.appendText("While searching packages, an error occurred. \n");
            throw e;
        }

    }
}
