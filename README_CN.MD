<img title="" src="https://github.com/Remielpub/DrawableMaker/blob/main/image/image_title.png" alt="image_title.png" data-align="left">

[English](https://github.com/Remielpub/DrawableMaker/blob/main/README.md) | 中文

[![](https://jitpack.io/v/Remielpub/DrawableMaker.svg)](https://jitpack.io/#Remielpub/DrawableMaker)
[![](https://img.shields.io/badge/License-Apache--2.0-blue.svg)](https://github.com/Remielpub/DrawableMaker/blob/main/LICENSE)

Drawable Maker 是一个Android 简化Drawable创建及使用的工具库，旨在搭建xml布局过程中，需要创建Drawable时，不需要频繁切换文件编辑TAG，使编码更流畅；同时可以略微降低APK大小（毕竟一个Drawable文件也要200B， 100个就要20K）

## 引用方法

在根目录的 build.gradle 添加：

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

添加依赖及配置：

```groovy

android {
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation("com.github.Remielpub:DrawableMaker:1.0.0-alpha07")
}
```

## 原理

原理很简单，配合VIewBinding 与 BindingAdapter，通过自定义属性，把生成的Drawable设置到View的background属性。目前只想到设置background属性的使用场景，如果兄弟们想到其他需要使用Drawable的场景，请随时提Issue。

## 支持Drawable种类

**ColorDrawable & GradientDrawable** ：带颜色 ｜ 圆角 ｜ 边框（或虚线边框）的Drawable。

**StateListDrawable** ：对应Selector的Drawable，目前支持常用属性：

- android.R.attr.state_selected（是否选中）

- android.R.attr.state_enabled（是否使能）

- android.R.attr.state_pressed（是否按下）

- android.R.attr.state_checked（是否勾选）

- android.R.attr.state_focused（是否获取焦点）

## **使用方式：**

### 1 配合ViewBinding 与 BindingAdapter在布局xml中使用

#### 1.1 ColorDrawable & GradientDrawable

##### 1.1.1 设置【纯色】【矩形】Drawable 背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_marginTop="60dp"
            bg_drawable="@{dm.drawable().withColor(@color/purple_200).make()}" />
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图：

![image_gradient_1.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_1.jpg)

##### 1.1.2 设置【纯色】【矩形】Drawable背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tv1"
            style="@style/text_style"
            android:layout_marginTop="60dp"
            bg_drawable='@{dm.drawable().withColor("#FF018786").make()}'/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图：

![image_gradient_2.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_2.jpg)

##### 1.1.3 设置【纯色】【矩形】Drawable背景 方式3

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tv1"
            style="@style/text_style"
            android:layout_marginTop="60dp"
            bg_withCorners='@{pf.cornerProperty(0, "#FF018786", c.RECTANGLE)}'/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图：

![image_gradient_18.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_18.jpg)

##### 1.1.4 设置【纯色】【圆形】Drawable 背景 

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_drawable="@{dm.drawable().withColor(@color/purple_200, c.OVAL).make()}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_3.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_3.jpg)

##### 1.1.5 设置【全部圆角】【纯色背景】【矩形】背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_drawable="@{dm.drawable().withCorner(10, @color/purple_200).make()}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_4.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_4.jpg)

##### 1.1.6 设置【全部圆角】【纯色背景】【矩形】背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv4"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_drawable='@{dm.drawable().withCorner(10, "#FF018786").make()}'/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_5.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_5.jpg)

##### 1.1.7 设置【全部圆角】【纯色背景】【矩形】背景 方式3

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv4"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_withCorners='@{pf.cornerProperty(10, "#FF018786", c.RECTANGLE)}'/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_19.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_19.jpg)

##### 1.1.8 设置【部分圆角】【纯色背景】【矩形】背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv6"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_drawable="@{dm.drawable().withCorner(d.cornerRadius(0, 10, 10, 0), @color/purple_200).make()}" />     
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_6.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_6.jpg)

##### 1.1.9 设置【部分圆角】【纯色背景】【矩形】背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_drawable='@{dm.drawable().withCorner(d.cornerRadius(0, 10, 10, 0), "#FF018786").make()}' />       
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_7.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_7.jpg)

##### 1.1.10 设置【部分圆角】【纯色背景】【矩形】背景 方式3

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_withCorners='@{pf.cornerProperty(d.cornerRadius(0, 10, 10, 0), "#FF018786", c.RECTANGLE)}'/>       
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_20.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_20.jpg)

##### 1.1.11 设置 【全部圆角】【实线边框】【矩形】背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
         <TextView
             style="@style/text_style"
             android:layout_margin="30dp" 
             bg_drawable="@{dm.drawable().withCorner(10).withStroke(1, @color/purple_200).make()}" />     
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_8.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_8.jpg)

##### 1.1.12 设置 【全部圆角】【实线边框】【矩形】背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv4"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_withCorners='@{pf.cornerProperty(10, "#FF018786", c.RECTANGLE)}'
            bg_withStroke="@{pf.strokeProperty(1, @color/purple_200)}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_21.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_21.jpg)

##### 1.1.13 设置 【部分圆角】【实线边框】【矩形】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(d.cornerRadius(10, 10)).withStroke(1, @color/purple_200).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_9.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_9.jpg)

##### 1.1.14 设置【实线边框】【圆形】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withStroke(1, @color/purple_200, c.OVAL).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_10.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_10.jpg)

##### 1.1.15 设置【全部圆角】【虚线边框】【矩形】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withDash(2, @color/purple_200, 10, 10).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_11.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_11.jpg)

##### 1.1.16 设置【虚线边框】【圆形】背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withDash(2, @color/purple_200, 10, 10, c.OVAL).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_12.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_12.jpg)

##### 1.1.17 设置【虚线边框】【圆形】背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_withCorners='@{pf.cornerProperty(10, "#FF018786", c.OVAL)}'
            bg_withStroke="@{pf.dashProperty(3, @color/purple_200, 5, 5)}"/>   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_22.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_22.jpg)

##### 1.1.18 设置【圆角】【纯色背景】【实线边框】

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10, @color/purple_200).withStroke(2, @color/teal_200).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_13.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_13.jpg)

##### 1.1.19 设置【圆角】【线性渐变颜色】背景 方式1

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), c.ORIENTATION_LEFT_RIGHT).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_14.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_14.jpg)

##### 1.1.20 设置【圆角】【线性渐变颜色】背景 方式2

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
        
        <import type="com.childdddd.libdrawalemaker.factory.PropertyFactory"
            alias="pf"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_withCorners='@{pf.cornerProperty(10, "#FF018786", c.RECTANGLE)}'
            bg_withStroke="@{pf.strokeProperty(1, @color/purple_200)}"
            bg_withGradient="@{pf.gradientProperty(d.colors(@color/purple_200, @color/teal_200), c.ORIENTATION_LEFT_RIGHT)}"/>   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_23.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_23.jpg)

##### 1.1.21 设置【雷达形状渐变颜色】【圆形】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />

        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
        
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), c.ORIENTATION_TOP_BOTTOM, c.OVAL, c.GRADIENT_RADIAL, 30, d.center(0.5F, 0.5F)).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_15.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_15.jpg)

##### 1.1.22 设置【扫描形状渐变颜色】【圆形】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
        <import
            alias="c"
            type="com.childdddd.libdrawalemaker.utils.Constants" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), c.ORIENTATION_TOP_BOTTOM, c.OVAL, c.GRADIENT_SWEEP).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_16.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_16.jpg)

##### 1.1.23 设置【圆角】【线性渐变颜色】【使用useLevel】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        <import
            alias="d"
            type="com.childdddd.libdrawalemaker.utils.DrawableUtil" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), c.ORIENTATION_LEFT_RIGHT, c.RECTANGLE, c.GRADIENT_LINEAR, true, 1000).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_17.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_17.jpg)


#### 1.2 StateListDrawable

##### 1.2.1 添加 纯色背景【Selected】状态 selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        
        <variable
            name="vm"
            type="com.remiel.drawablemaker.StateListDrawableViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv1"
            style="@style/text_style"
            bg_drawable="@{dm.stateDrawable().withSelected(@color/teal_200, @color/purple_200).make()}"
            bindSelected="@{vm.selected}"
            android:layout_marginTop="60dp"
            android:background="@color/white"/>  
    </LinearLayout>
</layout>
```

效果图

![image_statelist_1.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_1.gif)

##### 1.2.2 添加 drawable背景【Selected】状态 selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.remiel.drawablemaker.R"/>
        
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        
        <variable
            name="vm"
            type="com.remiel.drawablemaker.StateListDrawableViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv2"
            style="@style/text_style"
            bg_drawable="@{dm.stateDrawable().withSelected(R.drawable.shape_normal, R.drawable.shape_selected).make()}"
            bindSelected="@{vm.selected}"
            android:layout_marginTop="60dp"/>
    </LinearLayout>
</layout>
```

效果图

![image_statelist_2.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_2.gif)

##### 1.2.3 添加 mipmap背景 【Selected】状态 selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.remiel.drawablemaker.R"/>

        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />
        
        <variable
            name="vm"
            type="com.remiel.drawablemaker.StateListDrawableViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
      <TextView
          android:id="@+id/tv3"
          style="@style/text_style"
          bg_drawable="@{dm.stateDrawable().withSelected(R.mipmap.image_normal, R.mipmap.image_selected).make()}"
          bindSelected="@{vm.selected}"
          android:layout_marginTop="30dp"/>
    </LinearLayout>
</layout>
```

效果图

![image_statelist_3.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_3.gif)

##### 1.2.4 添加 文字 & mipmap背景的【Selected状态】 selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />

        <variable
            name="vm"
            type="com.remiel.drawablemaker.StateListDrawableViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv4"
            style="@style/text_style"
            bg_drawable="@{dm.stateDrawable().withSelected(R.mipmap.image_normal, R.mipmap.image_selected).make()}"
            bindSelected="@{vm.selected}"
            text_normalColor="@{@color/teal_200}"
            text_selectedColor="@{@color/purple_200}"
            android:layout_marginTop="30dp" />

    </LinearLayout>
</layout>
```

效果图

![image_statelist_4.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_4.gif)

##### 1.2.5 添加 文字 【Selected】状态 & 颜色背景 & 动态生成圆角drawable 【Enabled】状态 selector

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import
            alias="dm"
            type="com.childdddd.libdrawalemaker.DrawableMaker" />

        <import type="com.childdddd.libdrawalemaker.utils.ColorStateListUtil"
            alias="c"/>
        <variable
            name="vm"
            type="com.remiel.drawablemaker.StateListDrawableViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv5"
            style="@style/text_style"
            bg_drawable="@{dm.stateDrawable().withEnabled(dm.drawable().withColor(@color/teal_200).make(), dm.drawable().withColor(@color/purple_200).make()).make()}"
            bindEnabled="@{vm.selected}"
            text_state2='@{c.textStateColor2(1, "#FFBB86FC", "#FF03DAC5")}'
            android:layout_marginStart="30dp"
            android:layout_marginTop="30dp"
            android:layout_marginEnd="30dp"/>
    </LinearLayout>
</layout>
```

效果图

![image_statelist_5.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_5.gif)

### 2. 在代码中使用

代码中使用方式与xml中，创建Drawable对象方式一样，这里就不再赘述。

## TODO

1.渐变色背景支持 ✅

2.使用设计模式对项目重构，方便后续扩展及使用 ✅

##### 有问题欢迎随时联系我，QQ：120051195
