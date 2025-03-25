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

正在建设