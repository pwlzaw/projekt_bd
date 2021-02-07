package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PaczkiDoOdebrania {
    private IntegerProperty id;
    private StringProperty adres_nadania;
    private StringProperty adres_odbioru;

    public PaczkiDoOdebrania() {
        id = new SimpleIntegerProperty();
        adres_nadania= new SimpleStringProperty();
        adres_odbioru= new SimpleStringProperty();
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

    public String getAdres_nadania() {
        return adres_nadania.get();
    }

    public StringProperty adres_nadaniaProperty() {
        return adres_nadania;
    }

    public void setAdres_nadania(String adres_nadania) {
        this.adres_nadania.set(adres_nadania);
    }

    public String getAdres_odbioru() {
        return adres_odbioru.get();
    }

    public StringProperty adres_odbioruProperty() {
        return adres_odbioru;
    }

    public void setAdres_odbioru(String adres_odbioru) {
        this.adres_odbioru.set(adres_odbioru);
    }
}
