package west.brian.myapplication;

import java.util.Date;

public class controller {
    private Time1 time;
    private Command command;

    public controller() {
        time = new Time1();
        command = new Command();
    }

    public Date getDate() {
        Date date = time.getDate();
        return date;
    }

    public void setDate(Date date1) {
        command.pushCmd(time.getDateChg());
        int[] x = time.getDateChg();
        time.setDate(date1);
        command.emptyRedo();
    }

    public void undo(){
        if(!command.Sisempty()) {
            int [] x = command.undo();
            command.addCmd(time.getDateChg());
            time.setDateChg(x);
        }
    }

    public void redo(){
        if(!command.Qisempty()){
            int [] x = command.redo();
            command.pushCmd(time.getDateChg());
            time.setDateChg(x);
        }
    }
}
