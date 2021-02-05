package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ceny {
    private IntegerProperty cena;
    private StringProperty rozmiar;

    public Ceny() {
        cena = new SimpleIntegerProperty();
        rozmiar = new SimpleStringProperty();
    }

    public int getCena() {
        return cena.get();
    }

    public IntegerProperty cenaProperty() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena.set(cena);
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
}
