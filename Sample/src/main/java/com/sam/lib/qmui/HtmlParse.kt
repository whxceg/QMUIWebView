package com.sam.lib.qmui

object HtmlParse {

    const val html = """
        <!DOCTYPE html >
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <meta id="viewport" name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1; user-scalable=no;"/>
        </head>
        <body>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div id='nr'>
                    
                    
                    字母A可以翻译为“甲”。
在HTML中表示地址标签。
在网上，A就是诈骗，欺骗的意思(我A你，就是我骗你)。
在大多数即时战略游戏中，A是Attack的意思（正面对A就是正面对攻）
在财务管理中，A是amortization摊销的意思。
汇编语言中，A为累加器ACC，算数操作结果只能放在A中，如： ADD A,#0A0H;
在扑克牌中，A表示“1 ”，英文读作ace（王牌）。广东话为“烟屎”、“A屎”。
在美国空军中，A代表攻击机。
物理学中“A”表示绝对温度，即absolute temperature。
“A°” （圆圈位于正上方）表示波长单位“埃”，1A°等于10的-10次方米。
a在力学中表示加速度（acceleration） a=△v/△t=s/t^2 国际单位是m/s^2 （米每平方秒）
A在电学中表示电流强度的单位：安培（ampere）。
物理学中表示机械波的振幅也可以用A来表示，
在医学中，A表示动脉。
血型中有A型血。
在遗传学中，A表示腺嘌呤（Adenine）或腺嘌呤核糖核苷（Adenosine）。
在生物化学中，A表示丙氨酸（Ala，Alanine）。
在电影界，A代表成人观看级别（adult video，AV）。
在合唱（多声部合唱）中，A表示女低声部（Alto）。
在买内衣的时候是小码的意思， A罩杯。
A也可以表示回答（answer）。
缩写中A的含义
ACG是动画-漫画-游戏产业的总称，其中A为Anime/Animation的缩写，动画。
CPA为注册会计师的英文缩写，其中的A为Accountant的缩写，意思是会计师。
CMA为中国计量认证的英文缩写，其中A为Accreditation的缩写，意思是认证。
MBA为工商管理硕士的英文缩写，其中A为Administration的缩写，意思是管理。
NBA为美国职业篮球联赛的英文缩写，其中A为Association的缩写，意思是联盟。
                    
                    <div id='bn'></div>
                    <div id='js'></div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
             function zxcx(){
                a.zxcx();
             }
             function sync(){
                 window.QMUIBridge.send("sync", function (responseData) {
                     document.getElementById('js').innerHTML=JSON.stringify(responseData);
                 })
//                    window.QMUIBridge.send("sync", function(resp){});
             }
             var nr = document.getElementById('nr');
             if(nr != null){
                 var b1 = "<p class=\"nav\"><a class=\"btm\" onclick=\"zxcx()\">在线查询</a>&nbsp;&nbsp;<a class=\"btm\" onclick=\"sync()\">有误同步更新</a>&nbsp;&nbsp;<a class=\"btm\" onclick=\"wrong()\">错误反馈</a>&nbsp;&nbsp;<a class=\"btm\" onclick=\"tj()\">编辑</a></p>";
                 var b2  = " 没有找到相关内容。<a class=\"btm\" onclick=\"zxcx()\">线上试试</a>&nbsp;&nbsp;<a class=\"btm\" onclick=\"tj()\">添加</a>";
                 var content = nr.innerHTML;
                 if(content != null && content.length>0){
                     document.getElementById('bn').innerHTML=b1;
                 } else {
                     document.getElementById('bn').innerHTML=b2;
                 }
             }
             
             
        </script>

        </body>
        </html>
    """
}
