package west.brian.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.turki.alwaysonlibrarycontainer.MyAnalogClock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    private PageAdapter pageAdapter;
    private ViewPager viewPager;

    controller contr;
    Thread thread = new Thread() {

        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int position = viewPager.getCurrentItem();
                            String name = pageAdapter.getItem(position).toString();
                            if(name.contains("Digital")) {
                                TextView tv = (TextView) pageAdapter.getItem(position).getView().findViewById(R.id.textViewD);

                                tv.setText(contr.getDate().toString());
                            }else{

                            }

                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageAdapter = new PageAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        contr = new controller();
        thread.start();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = viewPager.getCurrentItem();
                String name = pageAdapter.getItem(position).toString();
                if(name.contains("Analog")) {
                    analogUpdate();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    private void setupViewPager(ViewPager viewPager) {
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Digital(), "Digital");
        pageAdapter = adapter;
        viewPager.setAdapter(adapter);
    }

    public void addDi(View view){
        pageAdapter.addFragment(new Digital(), "Digital");
        viewPager.setAdapter(pageAdapter);
    }

    public void addAn(View view){
        pageAdapter.addFragment(new Analog(), "Analog");
        viewPager.setAdapter(pageAdapter);
    }

    public void chang(View v){
        TextView tv = (TextView) findViewById(R.id.editText2);
        Scanner scan = new Scanner(tv.getText().toString());
        Date date = new Date(scan.nextInt()-1900,scan.nextInt()-1,scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
        contr.setDate(date);
        analogUpdate();
    }

    public void undo(View v){
        contr.undo();
        analogUpdate();
    }

    public void redo(View v){
        contr.redo();
        analogUpdate();
    }

    private void analogUpdate(){
        int position = viewPager.getCurrentItem();
        String name = pageAdapter.getItem(position).toString();
        if(name.contains("Analog")) {
            MyAnalogClock vectorAnalogClock = pageAdapter.getItem(position).getView().findViewById(R.id.clock);
            Calendar calendar = Calendar.getInstance();
            Date date = contr.getDate();
            calendar.set(date.getYear(),date.getMonth(),date.getDate(),date.getHours(),date.getMinutes(),date.getSeconds());
            vectorAnalogClock.setCalendar(calendar);
            DateFormat df = new SimpleDateFormat("yyyy MM dd");
            TextView tv = (TextView) pageAdapter.getItem(position).getView().findViewById(R.id.textView2);
            tv.setText(df.format(date));

        }
    }

}