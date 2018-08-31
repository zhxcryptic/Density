# Density</br>
屏幕适配方案 修改Density</br>
主题选中：Material.Light.Panel</br>
     * example:</br>
     * 设计图 375px X 667px 一倍图 所以我们的宽度就是375px/2 = 187.5dp</br>
     * 设计图 750px X 1334px 一倍图 所以我们的宽度就是750px/2 = 375dp</br>
     * 总结：设计图的宽度获取 看看设计图是几倍图 自行计算我门所需要的宽度</br>
     * 如：WIDTH = 187.5 那么我们在xml中</br>
     * android:layout_width="187.5dp" 和 android:layout_width="match_parent"</br>
     * 这两个是同样的效果 所以如果设计图上是距离左边10dp 我就直接android:layout_marginLeft="10dp"</br>
     * 最后高度的话 也是对照宽度来的 所以高度是不会和手机的高度相同的 所以需要使用一个ScrollView包容</br>
     * 有些页面只是超出一点点 也会滑动 那就手动将某些控件的高度或者留白减少一点</br>
     * 毕竟设计图只是设计图 设计说不行 我一般总会说一句 重做安卓的图 要720*1280的 全部哦</br>
![Alt text](https://github.com/zhxcryptic/Density/blob/master/screenshot/setting.png "设置图")</br>
