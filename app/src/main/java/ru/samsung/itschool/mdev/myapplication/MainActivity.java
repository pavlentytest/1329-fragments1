package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.OnFragment1DataListener {

    private Button btn1, btn2;

    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    private void loadFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();

        Bundle args = new Bundle();
        args.putString(KEY,"something");
        f.setArguments(args);

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frLayout,f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            loadFragment(new Fragment1());
        } else {
           // loadFragment(new Fragment2());
            MyDialog md = new MyDialog();
            md.show(getSupportFragmentManager(),"alert1");
        }
    }


    @Override
    public void onFragment1DataListener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}