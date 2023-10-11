##### 1.2.5 Add text [Selected] status & Color background & dynamically generated rounded corner drawable [Enabled] Status selector<?xml version="1.0" encoding="utf-8"?>

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

Add dependencies:

```groovy
dependencies {
    implementation("com.github.Remielpub:DrawableMaker:1.0.0-alpha-4")
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

##### 1.1.1 Set Add [Solid color] background

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

Result：

![image_gradient_1.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_1.jpg)

##### 1.1.2 Set Add [Rounded corners] [Solid color] background

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

Result：

![image_gradient_2.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_2.jpg)

##### 1.1.3 Set Add [Solid Border] background

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

Result

![image_gradient_3.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_3.jpg)

##### 1.1.4 Set Add [Dashed Border] background

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

Result

![image_gradient_4.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_4.jpg)

##### 1.1.5 At the same time set [rounded corners] [solid color background] [solid line border] (Method 1)

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

Result

##### 1.1.6 At the same time set [partial rounded corners] [solid color background] [solid line border] (Method 2)

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

Result

![image_gradient_6.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_6.jpg)

##### 1.1.7 At the same time set [rounded corners] [solid color background] [dashed border] (Method 1)

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

Result

##### 1.1.8 At the same time set [partial rounded corners] [solid color background] [dashed border] (Method 2)

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

Result：

![image_gradient_8.jpg](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_gradient_8.jpg)

#### 1.2 StateListDrawable

##### 1.2.1 Add solid color background 【Selected】 State selector Drawable

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

Result

![image_statelist_1.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_1.gif)

##### 1.2.2 Add drawable background 【Selected】 State selector Drawable

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

Result

![image_statelist_2.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_2.gif)

##### 1.2.3 Adds mipmap background [Selected] status selector Drawable

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

Result

![image_statelist_3.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_3.gif)

##### 1.2.4 Adds the Selected state selector Drawable for the text&MIPmap background

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

Result

![image_statelist_4.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_4.gif)

##### 1.2.5 Add text [Selected] status & Color background & dynamically generated rounded corner drawable [Enabled] Status selector<?xml version="1.0" encoding="utf-8"?>

Result

![image_statelist_5.gif](https://github.com/Remielpub/DrawableMaker/blob/main/image/image_statelist_5.gif)

### 2. Used in code

```kotlin
val drawable = GradientDrawableUtil.drawable(10, Color.RED,  5, Color.BLUE)
view.background = drawable 
```

This is done in the same way that you create Drawable objects in xml, so I won't go into details here.
