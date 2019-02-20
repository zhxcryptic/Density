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
     * 优点很明显就是将设计稿中的值直接使用就可以 缺点也是明显的在app中注册所有的页面都使用的这个适配方案 导致第三方的界面会很奇怪</br> 
     * 在BaseActivity中注册不会 但是仍然还要考虑是不是存在某些机型会在进行某些设置的时候重置Density</br>
     * 最后推荐使用最小宽度限定符适配 用来用去还是这个好</br>
