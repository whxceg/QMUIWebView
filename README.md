# QMUI for Android



## How to import

Add this to your build.gradle:

```
repositories {
    maven { url 'https://www.jitpack.io' }
}

dependencies {
    implementation 'com.github.whxceg:QMUI:Tag'
}
```

## Example


### Changelog

#### 2.0.0-alpha10

##### 添加js调用java方法 #####

 1、js发送消息
 ```xml
 window.QMUIBridge.send("message", function(resp){});
 ```

 2、Java中处理消息
 
 ```java
  mWebView.webViewClient = QMUIBridgeWebViewClient(true, true, object : QMUIWebViewBridgeHandler(mWebView) {
             override fun handleMessage(message: String?): JSONObject {
                ......
             }
         })
 ```


#### 0.0.1
* Init
