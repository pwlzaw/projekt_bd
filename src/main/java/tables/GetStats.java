package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GetStats {
    private IntegerProperty liczbaS;
    private IntegerProperty liczbaM;
    private IntegerProperty liczbaL;
    private IntegerProperty liczbaXL;


    public GetStats() {
        liczbaS = new SimpleIntegerProperty();
        liczbaM = new SimpleIntegerProperty();
        liczbaL = new SimpleIntegerProperty();
        liczbaXL = new SimpleIntegerProperty();

    }

    public int getLiczbaS() {
        return liczbaS.get();
    }

    public IntegerProperty liczbaSProperty() {
        return liczbaS;
    }

    public void setLiczbaS(int liczbaS) {
        this.liczbaS.set(liczbaS);
    }

    public int getLiczbaM() {
        return liczbaM.get();
    }

    public IntegerProperty liczbaMProperty() {
        return liczbaM;
    }

    public void setLiczbaM(int liczbaM) {
        this.liczbaM.set(liczbaM);
    }

    public int getLiczbaL() {
        return liczbaL.get();
    }

    public IntegerProperty liczbaLProperty() {
        return liczbaL;
    }

    public void setLiczbaL(int liczbaL) {
        this.liczbaL.set(liczbaL);
    }

    public int getLiczbaXL() {
        return liczbaXL.get();
    }

    public IntegerProperty liczbaXLProperty() {
        return liczbaXL;
    }

    public void setLiczbaXL(int liczbaXL) {
        this.liczbaXL.set(liczbaXL);
    }
}
