package org.example.client;

import org.example.observable.AgentBorsa;
import org.example.observer.AgenciaBorsa;
import static org.junit.Assert.*;


public class Main {
    public static void main(String[] args) {
        AgentBorsa agent = new AgentBorsa();
        AgenciaBorsa agencia = new AgenciaBorsa();

        agent.addObserver(agencia);
        agent.setEstatDelMercat("SP500 is going down with a 1,2%");
        assertEquals(agencia.getEstatDelMercat(), "SP500 is going down with a 1,2%");
    }
}