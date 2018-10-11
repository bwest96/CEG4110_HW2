package west.brian.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Digital extends Fragment{
    private static final String TAG = "Digital";
    private TextView tv;

    public TextView getTv() {
        return tv;
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.digital,container,false);
        tv = (TextView) view.findViewById(R.id.textViewD);

        return view;

    }

    public void add(View v){

    }

}
