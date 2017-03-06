package com.example.inspiron.bitplacementc;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    private SharedPreferences pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pre=getPreferences(0);
        initFragment();
    }

    private void initFragment()
    {
        Fragment frag;
        if(pre.getBoolean(Constants.IS_LOGGED_IN,false)){
            frag=new ProfileFragment();
        }else{
            frag=new LoginFragment();
        }
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,frag);
        ft.commit();

    }
}
