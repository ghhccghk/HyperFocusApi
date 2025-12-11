![](https://socialify.git.ci/ghhccghk/HyperFocusApi/image?description=1&descriptionEditable=把小米澎湃的焦点通知和灵动岛写成Api方便调用，并将关键通知以特殊样式展示&language=1&name=1&owner=1&theme=Auto)

[![GitHub License](https://img.shields.io/github/license/ghhccghk/HyperFocusApi?color=blue)](https://github.com/ghhccghk/HyperFocusApi/blob/main/LICENSE)
[![](https://jitpack.io/v/ghhccghk/HyperFocusApi.svg)](https://jitpack.io/#ghhccghk/HyperFocusApi)

注：澎湃 OS 对于焦点通知有白名单应用限制，使用前请先安装无视白名单的 XP 模块。

[小米官方开发指南](https://dev.mi.com/xiaomihyperos/documentation/detail?pId=2131)

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

val sendNotification = NotificationHelper.sendNotification("你好", "世界")
val intent = Intent()
intent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"  // 设置 Action，跳转到应用详情页
intent.data = Uri.fromParts("package", this.packageName, null)  // 指定要打开的应用包名
val actions = FocusApi.ActionInfo(actionsIntent = intent, actionsTitle = "test")
val baseInfo = FocusApi.baseinfo(title = "title", colorTitle = "#FFFFFF",
    basetype = 1, content = "content", colorContent = "#FFFFFF", subContent = "subContent",
    colorSubContent = "#FFFFFF", extraTitle = "extraTitle", colorExtraTitle = "#FFFFFF",
    subTitle = "subTitle", colorsubTitle = "#FFFFFF",
    specialTitle = "special", colorSpecialTitle = "#FFFFFF",)
val hintInfo = FocusApi.HintInfo(type = 1 ,titleLineCount = 6,title = "这是Hint里的title", colortitle = "#FFFFFF" , content = "content",  colorContent = "#FFFFFF", actionInfo = actions)
val api = FocusApi.sendFocus(
    title = "测试",
    baseInfo = baseInfo,
    hintInfo = hintInfo,
    picbg = Icon.createWithResource(this,R.drawable.lycaon_bg_2),
    picmarkv2 = Icon.createWithResource(this,R.drawable.wdlyjz),
    picbgtype = 2,
    picmarkv2type = 2,
    builder = sendNotification,
    ticker = "ticker测试",
    picticker = Icon.createWithResource(this,R.drawable.ic_launcher_foreground)
)
sendNotification.addExtras(api)
NotificationManagerCompat.from(this).notify(1, sendNotification.build())
```
看完不会写可以看看这个! [demo](https://github.com/ghhccghk/HyperFocusNotifDemo)

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=ghhccghk/HyperFocusApi&type=Timeline)](https://star-history.com/#ghhccghk/HyperFocusApi&Timeline)

## Thanks
[<img src="https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png" width="200"/>](https://www.jetbrains.com)