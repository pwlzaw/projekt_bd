package tables;

import javafx.beans.property.*;

public class GetEarnings {
    private DoubleProperty zysk;


    public GetEarnings() {
        zysk = new SimpleDoubleProperty();
    }

    public double getZysk() {
        return zysk.get();
    }

    public DoubleProperty zyskProperty() {
        return zysk;
    }

    public void setZysk(double zysk) {
        this.zysk.set(zysk);
    }
}
