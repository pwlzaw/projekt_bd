package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StanPaczek {
    private StringProperty nadawca;
    private StringProperty odbiorca;
    private IntegerProperty id;
    private StringProperty stan;
    private StringProperty data_nadania;
    private StringProperty data_odbioru;

    public StanPaczek() {
        nadawca= new SimpleStringProperty();
        odbiorca= new SimpleStringProperty();
        id = new SimpleIntegerProperty();
        stan= new SimpleStringProperty();
        data_nadania= new SimpleStringProperty();
        data_odbioru= new SimpleStringProperty();
    }

    public String getNadawca() {
        return nadawca.get();
    }

    public StringProperty nadawcaProperty() {
        return nadawca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca.set(nadawca);
    }

    public String getOdbiorca() {
        return odbiorca.get();
    }

    public StringProperty odbiorcaProperty() {
        return odbiorca;
    }

    public void setOdbiorca(String odbiorca) {
        this.odbiorca.set(odbiorca);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getStan() {
        return stan.get();
    }

    public StringProperty stanProperty() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan.set(stan);
    }

    public String getData_nadania() {
        return data_nadania.get();
    }

    public StringProperty data_nadaniaProperty() {
        return data_nadania;
    }

    public void setData_nadania(String data_nadania) {
        this.data_nadania.set(data_nadania);
    }

    public String getData_odbioru() {
        return data_odbioru.get();
    }

    public StringProperty data_odbioruProperty() {
        return data_odbioru;
    }

    public void setData_odbioru(String data_odbioru) {
        this.data_odbioru.set(data_odbioru);
    }
}
