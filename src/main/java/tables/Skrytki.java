package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Skrytki {
    private IntegerProperty id;
    private IntegerProperty automat_id;
    private StringProperty rozmiar;
    private StringProperty stan;

    public Skrytki() {
        id = new SimpleIntegerProperty();
        automat_id= new SimpleIntegerProperty();
        rozmiar= new SimpleStringProperty();
        stan= new SimpleStringProperty();
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

    public int getAutomat_id() {
        return automat_id.get();
    }

    public IntegerProperty automat_idProperty() {
        return automat_id;
    }

    public void setAutomat_id(int automat_id) {
        this.automat_id.set(automat_id);
    }

    public String getRozmiar() {
        return rozmiar.get();
    }

    public StringProperty rozmiarProperty() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar.set(rozmiar);
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
}
