package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class Fragment1 extends Fragment {

    private String val;
    private Button btn3;
    private View view;

    OnFragment1DataListener frListener;

    public Fragment1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            val = getArguments().getString(MainActivity.KEY);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragment1DataListener) {
            frListener = (OnFragment1DataListener) context;
        } else {
            // исключение можно выбросить
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        btn3 = view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // печатаем полученное значение из активности
                //Snackbar.make(view.findViewById(R.id.fr1root),val,Snackbar.LENGTH_LONG).show();
                // вызываем метод реализованный в активности
                frListener.onFragment1DataListener("back string");

            }
        });
        return view;
    }

    public interface OnFragment1DataListener {
        void onFragment1DataListener(String str);
    }

}