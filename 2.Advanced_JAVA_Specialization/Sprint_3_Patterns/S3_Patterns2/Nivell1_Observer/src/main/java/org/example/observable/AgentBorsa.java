package org.example.observable;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AgentBorsa {

    private String estatDelMercat = "";

    private List<Observer> agencies = new ArrayList<Observer>();

    public void setEstatDelMercat(String estatDelMercat) {
        this.estatDelMercat = estatDelMercat;
        agencies.forEach(agencia -> agencia.notificar(this.estatDelMercat));
    }

    public String getEstatDelMercat() {
        return this.estatDelMercat;
    }

    public void addObserver(Observer agencia){
        this.agencies.add(agencia);
    }

    public void removeObserver(Observer agencia){
        this.agencies.remove(agencia);
    }
}
