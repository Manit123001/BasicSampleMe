package com.android.sample.mcnew.basicsampleme.ui.activitry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.sample.mcnew.basicsampleme.R;
import com.android.sample.mcnew.basicsampleme.ui.fragment.ProductListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            ProductListFragment fragment = new ProductListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProductListFragment.TAG).commit();
        }
    }
}
