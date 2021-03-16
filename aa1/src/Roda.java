import javax.swing.text.StyledEditorKit.BoldAction;

public class Roda {
    private boolean estaCalibrada;

    public Roda() {
        this.estaCalibrada = false;
    }

    public boolean getCalibragem() {
        return this.estaCalibrada;
    }

    public void setCalibragem(boolean calibrar) {
        this.estaCalibrada = calibrar;
    }
}
