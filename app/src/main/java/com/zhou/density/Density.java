package com.zhou.density;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * title:屏幕适配方案 修改Density
 * tip:
 *
 * @author zhou
 * @date 2018-08-30 下午2:10
 */
public class Density {

    /**
     * 这个宽度是设计图的宽度
     * example:
     * 设计图 375px X 667px 一倍图 所以我们的宽度就是375px/2 = 187.5dp
     * 设计图 750px X 1334px 一倍图 所以我们的宽度就是750px/2 = 375dp
     * 总结：设计图的宽度获取 看看设计图是几倍图 自行计算我门所需要的宽度
     * 如：WIDTH = 187.5 那么我们在xml中
     * android:layout_width="187.5dp" 和 android:layout_width="match_parent"
     * 这两个是同样的效果 所以如果设计图上是距离左边10dp 我就直接android:layout_marginLeft="10dp"
     * 最后高度的话 也是对照宽度来的 所以高度是不会和手机的高度相同的 所以需要使用一个ScrollView包容
     * 有些页面只是超出一点点 也会滑动 那就手动将某些控件的高度或者留白减少一点
     * 毕竟设计图只是设计图 设计说不行 我一般总会说一句 重做安卓的图 要720*1280的 全部哦
     * <p>
     * MDPI	    1px=1dp
     * HDPI	    1.5px=1dp
     * XHDPI	2px=1dp
     * XXHDPI	3px=1dp
     * XXXHDPI	4px=1dp
     */
    private static float WIDTH;

    private static float sAppDensity;
    private static float sAppScaledDensity;
    private static DisplayMetrics sAppDisplayMetrics;


    public static void setDensity(@NonNull final Application application, float width) {
        sAppDisplayMetrics = application.getResources().getDisplayMetrics();
        WIDTH = width;
        registerActivityLifecycleCallbacks(application);

        if (sAppDensity == 0) {
            //初始化的时候赋值
            sAppDensity = sAppDisplayMetrics.density;
            sAppScaledDensity = sAppDisplayMetrics.scaledDensity;

            //添加字体变化的监听
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体改变后,将appScaledDensity重新赋值
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sAppScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {
                }
            });
        }
    }


    private static void setDefault(@NonNull Activity activity) {
        float targetDensity = 0;
        try {
            targetDensity = sAppDisplayMetrics.widthPixels / WIDTH;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        float targetScaledDensity = targetDensity * (sAppScaledDensity / sAppDensity);
        int targetDensityDpi = (int) (160 * targetDensity);

        //最后在这里将修改过后的值赋给系统参数
        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }


    /**
     * 注册Activity的生命周期
     * 当然也可以不用这么写 直接写在BaseActivity中也是可以的
     *
     * @param application Application
     */
    private static void registerActivityLifecycleCallbacks(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                setDefault(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {}

            @Override
            public void onActivityResumed(Activity activity) {}

            @Override
            public void onActivityPaused(Activity activity) {}

            @Override
            public void onActivityStopped(Activity activity) {}

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

            @Override
            public void onActivityDestroyed(Activity activity) {}
        });
    }
}

