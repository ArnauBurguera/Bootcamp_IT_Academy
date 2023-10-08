package invoker;

import commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    List<Command> llistaCommands = new ArrayList<Command>();

    public void rebreCommand(Command command){
        llistaCommands.add(command);
    }

    public void executarCommands(){
        llistaCommands.forEach(Command::executar);
    }
}
