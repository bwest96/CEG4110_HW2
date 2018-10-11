package west.brian.myapplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time1 {
    private Date date;
    private int [] dateChg;

    public Time1() {
        date = Calendar.getInstance().getTime();
        dateChg = new int[6];
    }

    public Date getDate() {
        date = Calendar.getInstance().getTime();
        String s = date.toString();
        int [] arr = new int[6];
        arr[0] = date.getYear() - dateChg[0];
        arr[1] = date.getMonth() - dateChg[1];
        arr[2] = date.getDate() - dateChg[2];
        arr[3] = date.getHours() - dateChg[3];
        arr[4] = date.getMinutes() - dateChg[4];
        arr[5] = date.getSeconds() - dateChg[5];
        date = new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
        return date;
    }

    public int [] setDate(Date date1) {
        date = Calendar.getInstance().getTime();
        dateChg[0] = date.getYear() - date1.getYear();
        dateChg[1] = date.getMonth() - date1.getMonth();
        dateChg[2] = date.getDate() - date1.getDate();
        dateChg[3] = date.getHours() - date1.getHours();
        dateChg[4] = date.getMinutes() - date1.getMinutes();
        dateChg[5] = date.getSeconds() - date1.getSeconds();
        return dateChg;
    }

    public int[] getDateChg() {
        return dateChg;
    }

    public void setDateChg(int[] Chg) {
        dateChg = Chg;
    }
}
