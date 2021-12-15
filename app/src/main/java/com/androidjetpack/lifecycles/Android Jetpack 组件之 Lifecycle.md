## 一、Lifecycles简介

Lifecycles是Jetpack当中的一个来**解决生命周期管理问题的组件**，通过监听生命周期的方式。如果我们的类不是Activity的话(广播\碎片另说)，那么它是没有生命周期的。但在开发过程中，在MVP模式里，我们需要在P层里回调View的接口来更新UI，如果不对P层做生命周期处理，就很容易发生内存泄漏，为了让P层感知Activity的生命周期，通常会定义如下接口：

```java
interface IPresenter {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}
```
每个Presenter都实现IPresenter，然后在对应的Activity里回调这些接口，完成生命周期管理。
而**Lifecycles**就是实现这一功能而推出的，它**是一个可以被其他对象观察其生命周期的类**，Lifecycles**是基于观察者模式实现的来对外响应生命周期的变化的**，这里面有2个枚举变量Event和Evenet来一一对应的。

## 二、导入依赖

```javascript
def lifecycle_version = "2.0.0"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-common-java8:2.2.0"
implementation "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0" 
testImplementation "androidx.arch.core:core-testing:2.1.0"
```

## 三、使用
我们先创建一个Observer，实现LifecycleObserver接口，然后通过注解的方式来监听对应的生命周期：

```java
class LifecycleListener : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun lifecycleOnCreate() {
        Logs.log("lifecycleOnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun lifecycleOnStart() {
        Logs.log("lifecycleOnStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun lifecycleOnResume() {
        Logs.log("lifecycleOnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun lifecycleOnPause() {
        Logs.log("lifecycleOnPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun lifecycleOnStop() {
        Logs.log("lifecycleOnStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun lifecycleOnDestroy() {
        Logs.log("lifecycleOnDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun lifecycleOnAny() {
        Logs.log("lifecycleOnAny")
    }
}
```
然后在Activity的onCreate()或者onStart()方法里面添加监听：addObserver()即可完成监听(在onResume之前)

运行代码，我们模拟一下三个场景：
1、App启动后正常运行，App会执行(lifecycle)onCreate、(lifecycle)onstart、(lifecycle)onresume方法；然后我们再点击右下方的App切换按键，但是不切换App，这是会执行(lifecycle)onPause、(lifecycle)onStop方法；

2、然后我们再让App回到前台，这时会执行·、(lifecycle)onStart、(lifecycle)onResume方法；
3、最后我们再点击home键，让App回到后台，这个时候会执行：(lifecycle)onPause、(lifecycle)onStop方法。然后我们再让App回到前台运行，则会执行： onRestart、(lifecycle)onStart、(lifecycle)onResume。

我们会发现另外两个现象：lifecycle没有执行lifecycleonRestart，因他没有这个方法。另外，出了前面提到的lifecycleonRestart方法，之后的每个方法在被调用之后，都会执行lifecycleOnAny方法。

Lifecycles的监听在onCreate()、onStart()、onResume()之后调用的，而onPause()、onStop()、onDestroy()则是之前调用。原因很好理解：我们就是要在那个时间段进行某些操作，如果是一直在之后调用，那还有什么用？
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201230095948243.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhb3l1ZWdvbmd6aQ==,size_16,color_FFFFFF,t_70)


