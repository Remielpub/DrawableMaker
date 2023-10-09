<img title="" src="https://github.com/Remielpub/DrawableMaker/blob/main/image/image_title.png" alt="image_title.png" data-align="left">

[English](README.MD) | 中文

Drawable Maker 是一个Android 简化Drawable创建及使用的工具库，旨在搭建xml布局过程中，需要创建Drawable时，不需要频繁切换文件编辑TAG，使编码更流畅；同时可以略微降低APK大小（毕竟一个Drawable文件也要200B， 100个就要20K）

## 原理

原理很简单，配合VIewBinding 与 BindingAdapter，通过自定义属性，把生成的Drawable设置到View的background属性。目前只想到设置background属性的使用场景，如果兄弟们想到其他需要使用Drawable的场景，请随时提Issue。

## 支持Drawable种类

**ColorDrawable & GradientDrawable** ：带颜色 ｜ 圆角 ｜ 边框（或虚线边框）的Drawable。

**StateListDrawable** ：对应Selector的Drawable，目前支持日常常用属性：

- android.R.attr.state_selected（是否选中）

- android.R.attr.state_enabled（是否使能）

- android.R.attr.state_pressed（是否按下）

- android.R.attr.state_checked（是否勾选）

- android.R.attr.state_focused（是否获取焦点）

## **使用方式：**

### 1 配合ViewBinding 与 BindingAdapter在布局xml中使用

#### 1.1 ColorDrawable & GradientDrawable

##### 1.1.1 设置添加 【纯色】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv_8"
            style="@style/text_style"
            android:layout_marginTop="60dp"
            bg_addCorners="@{g.addCorners(0, @color/purple_200)}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图：

![image_gradient_1.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_1.jpg)

##### 1.1.2 设置添加 【圆角】【纯色】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tv1"
            style="@style/text_style"
            android:layout_marginTop="60dp"
            bg_addCorners="@{g.addCorners(g.cornerRadius(10), @color/purple_200)}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图：

![image_gradient_2.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_2.jpg)

##### 1.1.3 设置添加【实线边框】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv2"
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_addStroke="@{g.addStroke(1, @color/purple_200)}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_3.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_3.jpg)

##### 1.1.4 设置添加【虚线边框】背景

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tv3"
            style="@style/text_style"
            android:layout_marginTop="30dp"
            bg_addStroke="@{g.addDash(2, @color/purple_200, 10, 10)}" />
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_4.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_4.jpg)

##### 1.1.5 同时设置【圆角】【纯色背景】【实线边框】(方式1)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv4"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_addCorners="@{g.addCorners(g.cornerRadius(10), @color/purple_200)}"
            bg_addStroke="@{g.addStroke(2, @color/teal_200)}"/>
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_5.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_5.jpg)

##### 1.1.6 同时设置【部分圆角】【纯色背景】【实线边框】(方式2)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv6"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_corners="@{g.cornerRadius(0, 10, 10, 0)}"
            bg_solidColor="@{@color/purple_200}"
            bg_strokeWitdh="@{2}"
            bg_strokeColor="@{@color/teal_200}"/>     
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_6.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_6.jpg)

##### 1.1.7 同时设置【圆角】【纯色背景】【虚线边框】(方式1)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/tv5"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_addCorners="@{g.addCorners(10, @color/purple_200)}"
            bg_addStroke="@{g.addDash(2, @color/teal_200, 10, 10)}"/>       
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图

![image_gradient_7.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_7.jpg)

##### 1.1.8 同时设置【部分圆角】【纯色背景】【虚线边框】(方式2)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
         <TextView
            android:id="@+id/tv7"
            style="@style/text_style"
            android:layout_margin="30dp"
            bg_corners="@{g.cornerRadius(0, 10, 10, 0)}"
            bg_solidColor="@{@color/purple_200}"
            bg_strokeWitdh="@{2}"
            bg_strokeColor="@{@color/teal_200}"
            bg_dashWidth="@{10}"
            bg_dashGap="@{10}"/>     
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

效果图如下：

![image_gradient_8.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_8.jpg)

#### 1.2 StateListDrawable

##### 1.2.1 添加 纯色背景【Selected】状态 selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
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
            android:layout_marginTop="60dp"
            bindSelected="@{vm.selected}"
            bg_normalColor="@{@color/teal_200}"
            bg_selectedColor="@{@color/purple_200}"/>      
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
            android:layout_marginTop="60dp"
            bindSelected="@{vm.selected}"
            bg_imageNormal="@{R.drawable.shape_normal}"
            bg_imageSelected="@{R.drawable.shape_selected}"/>
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
            android:layout_marginTop="30dp"
            bindSelected="@{vm.selected}"
            bg_imageNormal="@{R.mipmap.image_normal}"
            bg_imageSelected="@{R.mipmap.image_selected}"/>
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
        <import type="com.childdddd.libdrawalemaker.utils.StateListDrawableUtil"
            alias="s"/>

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
            android:layout_marginTop="30dp"
            text_normalColor="@{@color/teal_200}"
            text_selectedColor="@{@color/purple_200}"
            bindSelected="@{vm.selected}"
            bg_state="@{s.setState(0, R.mipmap.image_normal, R.mipmap.image_selected)}"/>

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
        <import type="com.childdddd.libdrawalemaker.utils.StateListDrawableUtil"
            alias="s"/>

        <import type="com.childdddd.libdrawalemaker.utils.GradientDrawableUtil"
            alias="g"/>

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
            android:layout_marginTop="30dp"
            android:layout_marginStart="30dp"
            android:layout_marginEnd="30dp"
            text_state2='@{c.textStateColor2(1, "#FFBB86FC", "#FF03DAC5")}'
            bindEnabled="@{vm.selected}"
            bg_state2="@{s.setState2(1, g.drawable(0, @color/teal_200), g.drawable(10, @color/purple_200))}"/>
    </LinearLayout>
</layout>
```

效果图

![image_statelist_5.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_5.gif)

### 2. 在代码中使用

```kotlin
        val drawable = GradientDrawableUtil.drawable(10, Color.RED,  5, Color.BLUE)
        view.background = drawable 
```

代码中使用方式与xml中，创建Drawable对象方式一样，这里就不再赘述。
