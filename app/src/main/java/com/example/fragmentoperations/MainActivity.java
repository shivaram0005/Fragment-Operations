package com.example.fragmentoperations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();


    }

    public void addA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragmentTransaction.add(R.id.linearlayout, fragment1, "A");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void addB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment2 fragment2 = new Fragment2();
        fragmentTransaction.add(R.id.linearlayout, fragment2, "B");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void removeA(View view) {
        Fragment fragment3 = fragmentManager.findFragmentByTag("A");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment3 != null) {
            fragmentTransaction.remove(fragment3);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment A was not added before", Toast.LENGTH_SHORT).show();
        }
    }  public void removeB(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment4=fragmentManager.findFragmentByTag("B");
        if(fragment4!=null){
            fragmentTransaction.remove(fragment4);
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(this, "Fragment B was not added before", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceAwithB(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment5=fragmentManager.findFragmentByTag("B");
        fragmentTransaction.replace(R.id.linearlayout,fragment5);
        fragmentTransaction.commit();

    }
    public void replaceBwithA(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment6=fragmentManager.findFragmentByTag("A");
        fragmentTransaction.replace(R.id.linearlayout,fragment6);
        fragmentTransaction.commit();
    }


}