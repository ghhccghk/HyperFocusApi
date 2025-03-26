[![](https://jitpack.io/v/ghhccghk/HyperFocusApi.svg)](https://jitpack.io/#ghhccghk/HyperFocusApi)

### 使用方法

### 1. 项目 Gradle 添加 JitPack 依赖

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

or

```kotlin
allprojects {
    repositories {
        // ...
        maven("https://jitpack.io")
    }
}
```

### 2. 要使用的模块下添加 HyperFocusApi 依赖


```groovy
dependencies {
    // ...
    implementation 'com.github.ghhccghk:HyperFocusApi:<VERSION>'
}
```

or

```kotlin
dependencies {
    // ...
    implementation("com.github.ghhccghk:HyperFocusApi:<VERSION>")
}
```

### 3.如何在代码下使用

```kotlin
//代码还需要补充
import com.hyperfocus.api.FocusApi

val FocusApi = FocusApi()
val builder = NotificationCompat.Builder(context, "lyricgetter")
sendFocus(builder,
    ticker = "text",
    title = "text",
    colorTitle = "#FFFFFF",
    aodTitle = text,
    aodPic = "miui.focus.pic_mark_v2",
    picmarkv2 = Icon,
    picmarkv2type = 3,
    picticker = Icon,
    picbg = Icon,)
val notification = builder.build()
(context.getSystemService("notification") as NotificationManager).notify(
    "lyricgetter".hashCode(), notification
)
```
正在建设