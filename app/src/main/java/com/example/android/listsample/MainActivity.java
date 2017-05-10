package com.example.android.listsample;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItemFragment(1);

    }

    private void initItemFragment(int id) {
        Fragment f = ItemFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main_container, f, FRAGMENT_TAG)
                .commit();
    }

//    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//
//    }
}
