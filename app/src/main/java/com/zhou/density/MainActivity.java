package com.zhou.density;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
/**
 * title:
 * tip:
 *
 * @author zhou
 * @date 2018/8/31 上午10:30
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new BlankFragment()).commit();
    }
}
