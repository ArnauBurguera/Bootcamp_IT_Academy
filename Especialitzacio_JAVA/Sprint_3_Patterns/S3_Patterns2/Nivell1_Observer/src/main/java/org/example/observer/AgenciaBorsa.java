package org.example.observer;

public class AgenciaBorsa implements Observer {
    private String estatDelMercat = "";
    @Override
    public void notificar(String estatDelMercat) {
        this.setEstatDelMercat(estatDelMercat);
    }

    public String getEstatDelMercat() {
        return this.estatDelMercat;
    }

    public void setEstatDelMercat(String estatDelMercat) {
        this.estatDelMercat = estatDelMercat;
    }
}
