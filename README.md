![image_title.png](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_title.png)

English | [中文](https://github.com/Remielpub/DrawableMaker/blob/main/README_CN.MD)

[![](https://jitpack.io/v/Remielpub/DrawableMaker.svg)](https://jitpack.io/#Remielpub/DrawableMaker)
[![](https://img.shields.io/badge/License-Apache--2.0-blue.svg)](https://github.com/Remielpub/DrawableMaker/blob/main/LICENSE)

"Drawable Maker" is a utility library for Android that simplifies the creation and usage of Drawables. Its primary goal is to streamline the process of building XML layouts, eliminating the need for frequent switches between file editing tags. This tool aims to enhance the coding experience and slightly reduce APK size, as each Drawable file typically consumes around 200 bytes, and having 100 of them would add up to 20KB.

## Useage

In the root directory build.gradle add:

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

Add dependencies and config:

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

## Principle

The principle is quite simple. It works in conjunction with ViewBinding and BindingAdapter. By using custom attributes, it sets the generated Drawable to the View's background property. Currently, we've only considered scenarios where the background property needs to be set. If anyone has other use cases where Drawables are needed, please feel free to raise an issue.

## Supports Drawable

**ColorDrawable & GradientDrawable** ：Drawable with rounded  corners | border (or dashed border) ｜colored.

**StateListDrawable** ：The Drawable corresponding to the Selector is currently supported for common attributes：

- android.R.attr.state_selected（selected or not）

- android.R.attr.state_enabled（enabled or not）

- android.R.attr.state_pressed（pressed or not）

- android.R.attr.state_checked（Check whether）

- android.R.attr.state_focused（Get focus or not）

## **Detailed Usage：**

### 1 Used in layout xml with ViewBinding and BindingAdapter

#### 1.1 ColorDrawable & GradientDrawable

##### 1.1.1 Set [Solid color] [Rectangle] Drawable background mode 1

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

Result：

![image_gradient_1.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_1.jpg)

##### 1.1.2 Set [Solid color] [Rectangle] Drawable background mode 2

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

Result：

![image_gradient_2.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_2.jpg)

##### 1.1.3 Set [Solid color] [Rectangle] Drawable background mode 3

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

Result：

![image_gradient_18.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_18.jpg)

##### 1.1.4 Set the [solid] [round] Drawable background

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

Result

![image_gradient_3.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_3.jpg)

##### 1.1.5 Set [All round corners] [Solid background] [Rectangle] background mode 1

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

Result:

![image_gradient_4.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_4.jpg)

##### 1.1.6 Set [All round corners] [Solid background] [Rectangle] background mode 2

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

Result

![image_gradient_5.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_5.jpg)

##### 1.1.7 Set [All round corners] [Solid background] [Rectangle] background mode 3

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

Result

![image_gradient_19.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_19.jpg)

##### 1.1.8 Set [partially rounded] [Solid background] [Rectangular] background mode 1

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

Result

![image_gradient_6.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_6.jpg)

##### 1.1.9 Set [Partially rounded] [Solid background] [Rectangular] background mode 2

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

Result

![image_gradient_7.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_7.jpg)

##### 1.1.10 Set [Partially rounded] [Solid background] [Rectangular] background mode 3

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

Result

![image_gradient_20.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_20.jpg)

##### 1.1.11 Set [All round corners] [Solid border] [Rectangle] background

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

Result：

![image_gradient_8.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_8.jpg)

##### 1.1.12 Set [All round corners] [Solid border] [Rectangle] background mode 2

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

Result

![image_gradient_21.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_21.jpg)


##### 1.1.13 Set [partially rounded] [solid border] [Rectangle] background

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

Result：

![image_gradient_9.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_9.jpg)

##### 1.1.14 Set the [solid border] [round] background

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

Result：

![image_gradient_10.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_10.jpg)

##### 1.1.15 Set [All round corners] [dashed border] [Rectangle] background

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

Result：

![image_gradient_11.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_11.jpg)

##### 1.1.16 Set [dotted border] [Circle] background

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

Result：

![image_gradient_12.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_12.jpg)

##### 1.1.17 Set [Dashed border] [Circle] background mode 2

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

Result：

![image_gradient_22.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_22.jpg)

##### 1.1.18 Set 【 Rounded corners 】【 Solid background 】【 Solid border 】

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

Result：

![image_gradient_13.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_13.jpg)

##### 1.1.19 Set the [Rounded] [Linear Gradient Color] background

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
            alias="o"
            type="android.graphics.drawable.GradientDrawable.Orientation" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), o.LEFT_RIGHT).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

Result：

![image_gradient_14.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_14.jpg)

##### 1.1.20 Set [Rounded] [Linear Gradient Color] background mode 2

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

Result：

![image_gradient_23.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_23.jpg)

##### 1.1.21 Set the [Radar Shape Gradient Color] to the [Circle] background

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
            alias="o"
            type="android.graphics.drawable.GradientDrawable.Orientation" />
        <import
            alias="gd"
            type="android.graphics.drawable.GradientDrawable" />
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
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), o.TOP_BOTTOM, c.OVAL, gd.RADIAL_GRADIENT, 30, d.center(0.5F, 0.5F)).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

Result：

![image_gradient_15.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_15.jpg)

##### 1.1.22 Set the [Scan Shape Gradient Color] [Circle] background

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
            alias="o"
            type="android.graphics.drawable.GradientDrawable.Orientation" />
        <import
            alias="gd"
            type="android.graphics.drawable.GradientDrawable" />
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
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), o.TOP_BOTTOM, c.OVAL, gd.SWEEP_GRADIENT).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

Result：

![image_gradient_16.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_16.jpg)

##### 1.1.23 Set the [Rounded] [Linear gradient color] [Use useLevel] background

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
            alias="o"
            type="android.graphics.drawable.GradientDrawable.Orientation" />
        <import
            alias="gd"
            type="android.graphics.drawable.GradientDrawable" />
    </data>

    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            style="@style/text_style"
            bg_drawable="@{dm.drawable().withCorner(10).withGradient(d.colors(@color/purple_200, @color/teal_200), o.LEFT_RIGHT, c.RECTANGLE, gd.LINEAR_GRADIENT, true, 1000).make()}"
            android:layout_marginTop="30dp" />   
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

Result：

![image_gradient_17.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_17.jpg)


#### 1.2 StateListDrawable

##### 1.2.1 Add solid color background 【Selected】 State selector Drawable

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
            android:layout_marginTop="60dp"
            bg_drawable="@{dm.stateDrawable().withSelected(@color/teal_200, @color/purple_200).make()}" />      
    </LinearLayout>
</layout>
```

Result

![image_statelist_1.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_1.gif)

##### 1.2.2 Add drawable background 【Selected】 State selector Drawable

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
            android:layout_marginTop="60dp"
            bindSelected="@{vm.selected}"
            bg_drawable="@{dm.stateDrawable().withSelected(R.drawable.shape_normal, R.drawable.shape_selected).make()}" />
    </LinearLayout>
</layout>
```

Result

![image_statelist_2.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_2.gif)

##### 1.2.3 Adds mipmap background [Selected] status selector Drawable

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <import
        alias="dm"
        type="com.childdddd.libdrawalemaker.DrawableMaker" />
    
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
            bg_drawable="@{dm.stateDrawable().withSelected(R.mipmap.image_normal, R.mipmap.image_selected).make()}" />
    </LinearLayout>
</layout>
```

Result

![image_statelist_3.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_3.gif)

##### 1.2.4 Adds the Selected state selector Drawable for the text&MIPmap background

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
            android:layout_marginTop="30dp"
            text_normalColor="@{@color/teal_200}"
            text_selectedColor="@{@color/purple_200}"
            bindSelected="@{vm.selected}"
            bg_drawable="@{dm.stateDrawable().withSelected(R.mipmap.image_normal, R.mipmap.image_selected).make()}" />

    </LinearLayout>
</layout>
```

Result

![image_statelist_4.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_4.gif)

##### 1.2.5 Add text [Selected] status & Color background & dynamically generated rounded corner drawable [Enabled] Status selector<?xml version="1.0" encoding="utf-8"?>

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
            android:layout_marginTop="30dp"
            android:layout_marginStart="30dp"
            android:layout_marginEnd="30dp"
            bg_drawable="@{dm.stateDrawable().withEnabled(dm.drawable().withColor(@color/teal_200).make(), dm.drawable().withColor(@color/purple_200).make()).make()}"
            bindEnabled="@{vm.selected}"
            text_state2='@{c.textStateColor2(1, "#FFBB86FC", "#FF03DAC5")}'/>
    </LinearLayout>
</layout>
```

Result

![image_statelist_5.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_5.gif)

### 2. Used in code

```kotlin
val drawable = GradientDrawableUtil.drawable(10, Color.RED,  5, Color.BLUE)
view.background = drawable 
```

This is done in the same way that you create Drawable objects in xml, so I won't go into details here.
