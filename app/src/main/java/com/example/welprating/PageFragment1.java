package com.example.welprating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class PageFragment1 extends Fragment {
    ViewGroup rootView;
    TextView average;
    FirebaseDatabaseHelper helper = new FirebaseDatabaseHelper();
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.page_1, container, false);
        average = rootView.findViewById(R.id.avg1);
        Button update = rootView.findViewById(R.id.updateButton1);
        //updates the text view
        double arg = helper.getAverage("Daniel");
        average.setText(Double.toString(arg));
        update.setOnClickListener(new View.OnClickListener() {
            // if the button is clicked do the update again.
            public void onClick(View v) {
                double arg = helper.getAverage("Daniel");
                average.setText(Double.toString(arg));
            }
        });
        return rootView;
    }
}
