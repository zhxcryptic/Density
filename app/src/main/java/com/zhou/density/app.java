package com.zhou.density;

import android.app.Application;

/**
 * title:
 * tip:
 *
 * @author zhou
 * @date 2018-08-30 下午2:49
 */
public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Density.setDensity(this, 187.5f);
    }
}
