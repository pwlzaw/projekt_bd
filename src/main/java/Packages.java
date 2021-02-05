
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Packages {

    private IntegerProperty id;
    private StringProperty stan;
    private StringProperty rozmiar;
    private IntegerProperty id_nadawcy;
    private IntegerProperty id_odbiorcy;
    private IntegerProperty skrytka_nadania_id;
    private IntegerProperty skrytka_odbioru_id;
    private StringProperty data_nadania;
    private StringProperty data_wysłania;
    private StringProperty data_dostarczenia;
    private StringProperty data_odbioru;

    public Packages() {
        id = new SimpleIntegerProperty();
        stan = new SimpleStringProperty();
        rozmiar= new SimpleStringProperty();
        id_nadawcy=new SimpleIntegerProperty();
        id_odbiorcy=new SimpleIntegerProperty();
        skrytka_nadania_id=new SimpleIntegerProperty();
        skrytka_odbioru_id=new SimpleIntegerProperty();
        data_nadania = new SimpleStringProperty();
        data_wysłania = new SimpleStringProperty();
        data_dostarczenia= new SimpleStringProperty();
        data_odbioru = new SimpleStringProperty();
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

    public String getRozmiar() {
        return rozmiar.get();
    }

    public StringProperty rozmiarProperty() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar.set(rozmiar);
    }

    public int getId_nadawcy() {
        return id_nadawcy.get();
    }

    public IntegerProperty id_nadawcyProperty() {
        return id_nadawcy;
    }

    public void setId_nadawcy(int id_nadawcy) {
        this.id_nadawcy.set(id_nadawcy);
    }

    public int getId_odbiorcy() {
        return id_odbiorcy.get();
    }

    public IntegerProperty id_odbiorcyProperty() {
        return id_odbiorcy;
    }

    public void setId_odbiorcy(int id_odbiorcy) {
        this.id_odbiorcy.set(id_odbiorcy);
    }

    public int getSkrytka_nadania_id() {
        return skrytka_nadania_id.get();
    }

    public IntegerProperty skrytka_nadania_idProperty() {
        return skrytka_nadania_id;
    }

    public void setSkrytka_nadania_id(int skrytka_nadania_id) {
        this.skrytka_nadania_id.set(skrytka_nadania_id);
    }

    public int getSkrytka_odbioru_id() {
        return skrytka_odbioru_id.get();
    }

    public IntegerProperty skrytka_odbioru_idProperty() {
        return skrytka_odbioru_id;
    }

    public void setSkrytka_odbioru_id(int skrytka_odbioru_id) {
        this.skrytka_odbioru_id.set(skrytka_odbioru_id);
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

    public String getData_wysłania() {
        return data_wysłania.get();
    }

    public StringProperty data_wysłaniaProperty() {
        return data_wysłania;
    }

    public void setData_wysłania(String data_wysłania) {
        this.data_wysłania.set(data_wysłania);
    }

    public String getData_dostarczenia() {
        return data_dostarczenia.get();
    }

    public StringProperty data_dostarczeniaProperty() {
        return data_dostarczenia;
    }

    public void setData_dostarczenia(String data_dostarczenia) {
        this.data_dostarczenia.set(data_dostarczenia);
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


