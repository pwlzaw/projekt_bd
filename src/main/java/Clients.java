import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clients {
    private IntegerProperty id;
    private StringProperty imię_nazwisko;
    private StringProperty email;
    private IntegerProperty tel;

    public Clients() {
        id = new SimpleIntegerProperty();
        imię_nazwisko= new SimpleStringProperty();
        email = new SimpleStringProperty();
        tel = new SimpleIntegerProperty();
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

    public String getImię_nazwisko() {
        return imię_nazwisko.get();
    }

    public StringProperty imię_nazwiskoProperty() {
        return imię_nazwisko;
    }

    public void setImię_nazwisko(String imię_nazwisko) {
        this.imię_nazwisko.set(imię_nazwisko);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getTel() {
        return tel.get();
    }

    public IntegerProperty telProperty() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel.set(tel);
    }
}
