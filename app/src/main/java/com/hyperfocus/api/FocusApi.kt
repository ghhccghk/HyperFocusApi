package com.hyperfocus.api

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.RemoteViews
import org.json.JSONArray
import org.json.JSONObject

@Suppress("unused")
/**
 * 小米焦点通知APi
 * 注意：在使用 actionInfo 传递 Action 行为时，通过自定义方式创建 Action 参数时， 需要在清单文件中将
 * actionIntent 对应的 BroadcastReceiver/Service 将 exported 属性显式声明为 true, 否则在一些系列设
 * 备中将无法响应对应 Action 的行为
 * 来自小米超级岛APi文档*/
object FocusApi {
    /**发送焦点通知 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param ticker 焦点在状态栏内容
     * @param scene 场景
     * @param baseInfo 基础信息
     * @param highlightInfo 高亮信息
     * @param progressInfo 进度信息 不能和hintInfo 同时使用
     * @param chatinfo 聊天信息
     * @param hintInfo 提示信息 不能和 ProgressInfo 同时使用
     * @param chatinfo 聊天信息
     * @param actions 按钮信息 不能和picmarkv2 同时使用 ，ActionInfo使用JSONArray合并一起可生成两个按钮
     * @param textButton 文字按钮
     * @param animTextInfo 动画文字
     * @param coverInfo 封面
     * @param multiProgressInfo 多进度
     * @param iconTextInfo 图标文字
     * @param island 小米超级岛配置信息
     * @param notifyId 通知id
     * @param orderId 订单id
     * @param outEffectColor 外部特效颜色
     * @param outEffectSrc 外部特效图片
     * @param reopen 打开
     * @param title 焦点通知标题
     * @param content 焦点通知小标题
     * @param aodTitle aodTitle 息屏标题
     * @param aodPic aodPic 息屏图标
     * @param  picInfotype 焦点通知右边标志 未知 1~4 可用 不可跟按钮使用
     * 图标要是对应不上反一下 这个我之前测试有点问题
     * @param picticker 焦点在状态栏图标浅色
     * @param pictickerdark 焦点在状态栏图标深色
     * @param picbg 焦点通知背景，留空为默认背景
     * @param picbgtype 焦点通知背景图的效果的type：1 :全屏（默认） 2: 右侧
     * @param
     * @param picInfo 焦点通知右边图标 不可跟按钮使用
     * @param protocol 控制版本 默认即可
     * @param updatable 焦点通知是否还要更新
     * @param enableFloat 焦点通知是否弹出
     * @param padding padding开关
     * @param timeout 焦点通知超时时间 单位秒
     * @param isShowNotification 是否显示通知在通知栏
     * @param islandFirstFloat 小米超级岛是否弹出
     * @param showSmallIcon 是否显示小图标
     * @param hideDeco 是否隐藏Deco
     * @param cancel 是否取消显示焦点通知
     * @param addpics 添加图标
     * @param actions_b Bundle 按钮信息 不能和picmarkv2同时使用，可以实现传递一个Notification.Action以使用PendingIntent 在里面塞命名为miui.focus.action_test 的Bundle
     * @return Bundle*/
    @SuppressLint("NewApi")
    @Suppress("KotlinConstantConditions")
    fun sendFocus(
        baseInfo: JSONObject? = null,
        highlightInfo: JSONObject? = null,
        highlightInfoV3: JSONObject? = null,
        hintInfo: JSONObject? = null,
        chatinfo: JSONObject? = null,
        progressInfo: JSONObject? = null,
        animTextInfo: JSONObject? = null,
        coverInfo: JSONObject? = null,
        multiProgressInfo: JSONObject? = null,
        iconTextInfo: JSONObject? = null,
        island: JSONObject? = null,

        actions : JSONArray? = null,
        textButton: JSONArray? =null,

        scene: String? = null,
        title: String? = null ,
        colorTitle: String? = null,
        content: String? = null,
        ticker: String,
        aodTitle: String? = null,
        notifyId:String? = null,
        orderId:String? = null,
        outEffectColor:String? = null,
        outEffectSrc:String? = null,
        reopen: String? = null,
        colorBg: String? = null,


        picticker: Icon,
        pictickerdark: Icon? = null,
        picInfo: Icon? = null,
        aodPic: Icon? = null,
        picbg: Icon? = null,
        addpics: Bundle? = null,

        picbgtype: Int = 1,
        protocol: Int = 1,
        picInfotype: Int = 1,
        timeout: Int? = 280,

        updatable: Boolean = true,
        enableFloat: Boolean = false,
        padding:Boolean = false,
        isShowNotification : Boolean = true,
        islandFirstFloat: Boolean = true,
        showSmallIcon: Boolean = true,
        hideDeco: Boolean = false,
        cancel: Boolean = false,

        actions_b : Bundle? =null,
    ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val paramv2 = JSONObject()

        paramv2.put("protocol", protocol)
        if (enableFloat){
            paramv2.put("enableFloat", enableFloat)
        }
        island?.let{ paramv2.put("param_island",it) }
        paramv2.put("ticker", ticker)
        paramv2.put("tickerPic", "miui.focus.pic_ticker")
        if (updatable){
            paramv2.put("updatable", updatable)
        }
        if (padding){
            paramv2.put("padding", padding)
        }

        if (content != null ){
            param.put("content", content)
        }

        if (title != null){
            param.put("title", title)
            if (colorTitle != null){
                param.put("colorTitle", colorTitle)
            }
        }
        if (scene != null){
            param.put("scene", scene)
        }

        pics.putParcelable(
            "miui.focus.pic_ticker", picticker
        )

        if (pictickerdark != null) {
            paramv2.put("tickerPicDark", "miui.focus.pic_ticker_dark")
            pics.putParcelable(
                "miui.focus.pic_ticker_dark", pictickerdark
            )
        }
        if (picbg != null || colorBg != null) {
            val bgInfo = JSONObject()
            picbg?.let {
                bgInfo.put("picBg", "miui.focus.pic_bg")
                pics.putParcelable(
                    "miui.focus.pic_bg", it
                )
            }
            bgInfo.put("type", picbgtype)
            colorBg?.let { bgInfo.put("colorBg", it) }
            paramv2.put("bgInfo", bgInfo)

        }

        if (picInfo != null) {
            val picInfoj = JSONObject()
            picInfoj.put("type", picInfotype)
            picInfoj.put("pic", "miui.focus.pic_mark_v2")
            paramv2.put("picInfo", picInfoj)
            pics.putParcelable("miui.focus.pic_mark_v2", picInfo)
        }


        if (aodTitle != null){
            paramv2.put("aodTitle", aodTitle)
            if (aodPic != null){
                pics.putParcelable("miui.focus.pic_aod", aodPic)
                paramv2.put("aodPic", "miui.focus.pic_aod")
            }
        }


        if (timeout != null){
            paramv2.put("timeout", timeout)
        }

        if (highlightInfo != null){
            paramv2.put("highlightInfo", highlightInfo)
        }

        if (chatinfo != null){
            paramv2.put("chatInfo", chatinfo)
        }

        textButton?.let { paramv2.put("textButton", textButton) }
        animTextInfo?.let { paramv2.put("animTextInfo", animTextInfo) }
        coverInfo?.let { paramv2.put("coverInfo", coverInfo) }
        multiProgressInfo?.let { paramv2.put("multiProgressInfo", multiProgressInfo) }
        iconTextInfo?.let { paramv2.put("iconTextInfo", iconTextInfo) }
        notifyId?.let { paramv2.put("notifyId", notifyId) }
        orderId?.let { paramv2.put("orderId", orderId) }
        highlightInfoV3?.let { paramv2.put("highlightInfoV3", highlightInfoV3) }
        outEffectColor?.let { paramv2.put("outEffectColor", outEffectColor) }
        outEffectSrc?.let { paramv2.put("outEffectSrc", outEffectSrc) }
        reopen?.let { paramv2.put("reopen", reopen) }
        cancel.let { paramv2.put("cancel", cancel) }
        showSmallIcon.let { paramv2.put("showSmallIcon", showSmallIcon) }
        hideDeco.let { paramv2.put("hideDeco", hideDeco) }


        if (chatinfo != null || highlightInfo != null || baseInfo != null && progressInfo == null){
            if (hintInfo != null){
                paramv2.put("hintInfo", hintInfo)
            }
        }

        if (progressInfo != null && hintInfo == null){
            paramv2.put("progressInfo", progressInfo)
        }


        if (addpics != null){
            pics.putAll(addpics)
        }

        paramBundle.putBundle("miui.focus.pics", pics)


        if (baseInfo != null){
            paramv2.put("baseInfo", baseInfo)
        }


        if (actions != null && actions_b == null) {
            paramBundle.putString("miui.focus.actions", actions.toString())
        }

        if (actions == null && actions_b != null) {
            paramBundle.putBundle("miui.focus.actions", actions_b)
        }

        param.put("param_v2", paramv2)
        param.put("isShowNotification",isShowNotification)
        paramBundle.putString("miui.focus.param", param.toString())
        return paramBundle
    }


    /** 自定义焦点通知
     * @param ticker 焦点在状态栏内容
     * @param picticker 焦点图标浅色
     * @param pictickerdark 焦点图标深色
     * @param aodTitle aod文本 与 rvAod 互斥
     * @param aodPic aod图标 与 rvAod 互斥
     * @param rv 焦点通知的RemoteViews
     * @param rvAod 焦点通知Aod的RemoteViews 与 aodTitle 互斥
     * @param rvNight 焦点通知深色的RemoteViews
     * @param rvtiny 焦点通知小图标的RemoteViews
     * @param rvtinyNight 焦点通知小图标深色的RemoteViews
     * @param rvdecoland 焦点通知横屏的RemoteViews
     * @param rvdecolandNight 焦点通知横屏深色的RemoteViews
     * @param rvdecoport 焦点通知竖屏的RemoteViews
     * @param rvdecoportNight 焦点通知竖屏深色的RemoteViews
     * @param rvIsLand 小米超级岛点击展开视图
     * @param enableFloat 焦点通知是否弹出
     * @param addpics 添加图标
     * @param island 小米超级岛配置
     * @param rvIsLand 小米超级岛点击展开视图
     * @param isShowNotification 是否显示通知在通知栏
     * @return Bundle*/

    @SuppressLint("NewApi")
    fun sendDiyFocus(
        picticker: Icon,
        ticker: String,
        aodTitle: String? = null,
        outEffectSrc:String? = null,
        islandFirstFloat: Boolean = true,
        aodPic: Icon? = null,
        pictickerdark: Icon? = null,
        island: JSONObject? = null,
        rv: RemoteViews,
        rvIsLand: RemoteViews? = null,
        rvAod : RemoteViews? = null,
        rvNight: RemoteViews? = null,
        rvtiny : RemoteViews? = null,
        rvtinyNight: RemoteViews? = null,
        rvdecoland: RemoteViews? =null,
        rvdecolandNight: RemoteViews? =null,
        rvdecoport: RemoteViews? =null,
        rvdecoportNight: RemoteViews? =null,
        enableFloat: Boolean = false,
        updatable: Boolean = true,
        timeout: Int = 280,
        reopen: String? = null ,
        addpics: Bundle? = null,
        isShowNotification : Boolean = true,
    ): Bundle{
        val focus = Bundle()
        val pics = Bundle()
        pics.putParcelable("miui.focus.pic_ticker",picticker)
        val cus = JSONObject()
        cus.put("ticker",ticker)
        cus.put("tickerPic","miui.focus.pic_ticker")
        cus.put("enableFloat",enableFloat)
        cus.put("updatable",updatable)
        cus.put("isShowNotification",isShowNotification)
        outEffectSrc.let { cus.put("outEffectSrc", it) }
        islandFirstFloat.let { cus.put("islandFirstFloat", it) }
        reopen?.let { cus.put("reopen",it)}
        cus.put("timeout",timeout)
        if (pictickerdark != null) {
            cus.put("tickerPicDark", "miui.focus.pic_ticker_dark")
            pics.putParcelable(
                "miui.focus.pic_ticker_dark", pictickerdark
            )
        }

        if (aodTitle != null && rvAod == null ){
            cus.put("aodTitle", aodTitle)
            if (aodPic != null){
                pics.putParcelable("miui.focus.pic_aod", aodPic)
                cus.put("aodPic", "miui.focus.pic_aod")
            }
        }
        addpics?.let { pics.putAll(it) }
        island?.let { cus.put("param_island",it) }
        focus.putString("miui.focus.param.custom",cus.toString())
        focus.putParcelable("miui.focus.pics",pics)
        focus.putParcelable("miui.focus.rv",rv)
        focus.putString("miui.focus.ticker", ticker)
        if (aodTitle == null ){
            rvAod?.let { focus.putParcelable("miui.focus.rvAod",it)}
        }
        rvIsLand?.let { focus.putParcelable("miui.focus.rv.island.expand",it)}
        rvNight?.let {  focus.putParcelable("miui.focus.rvNight",it)}
        rvtiny?.let {  focus.putParcelable("miui.focus.rv.tiny",it)}
        rvtinyNight?.let {  focus.putParcelable("miui.focus.rv.tinyNight",it)}
        rvdecoland?.let {  focus.putParcelable("miui.focus.rv.deco.land",it)}
        rvdecolandNight?.let {  focus.putParcelable("miui.focus.rv.deco.landNight",it)}
        rvdecoport?.let {  focus.putParcelable("miui.focus.rv.deco.port",it)}
        rvdecoportNight?.let {  focus.putParcelable("miui.focus.rv.deco.portNight",it)}

        return focus
    }

    /** Baseinfo 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param basetype 文本组件类型 , 取值如下 1或 2 默认1
     * @param title 主要文本 1
     * @param subTitle 主要文本 2
     * @param content 次要文本 1 在 basetype = 2 时候必须传
     * @param extraTitle 次要文本 2
     * @param specialTitle 焦点通知特殊标题
     * @param colorsubTitle 焦点通知小标题颜色
     * @param colorSubContent 焦点通知小标题边上的小标题的颜色
     * @param colorSubTitleDark 焦点通知副标题深色颜色
     * @param colorTitle title颜色
     * @param colorTitleDark title深色颜色
     * @param colorContent Content颜色
     * @param colorContentDark Content深色颜色
     * @param colorExtraTitle extraTitle颜色
     * @param colorExtraTitleDark extraTitle深色颜色
     * @param colorSpecialTitle specialTitle颜色
     * @param colorSpecialTitleDark specialTitle深色颜色
     * @param colorSpecialTitleBg specialTitle背景颜色
     * @param picFunctionDark 功能图标深色 请使用addpics自行添加picFunctionDark
     * @param picFunction 功能图标 请使用addpics自行添加picFunction
     * @param showDivider 间隔符号 是否显示主要文本间的分割符
     * @param showContentDivider 是否显示主要文本和补充文本的分割符
     * */
    fun baseinfo(
        basetype: Int = 1,
        title: String,
        content: String? = null,
        subTitle: String? = null,
        subContent: String? = null,
        extraTitle: String? = null,
        specialTitle: String? = null,
        colorsubTitle: String? = null,
        colorSubTitleDark: String? = null,
        colorSubContent: String? = null,
        colorSubContentDark: String? = null,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colorTitle: String? = null,
        colorTitleDark: String? = null,
        colorExtraTitle: String? = null,
        colorExtraTitleDark: String? = null,
        colorSpecialTitle: String? = null,
        colorSpecialTitleDark: String? = null,
        colorSpecialTitleBg: String? = null,
        picFunction : String? = null,
        picFunctionDark : String? = null,
        showDivider: Boolean = false,
        showContentDivider: Boolean = false,
    ): JSONObject{
        val baseInfo = JSONObject()

        baseInfo.put("title", title)

        colorTitle?.let { baseInfo.put("colorTitle", it) }

        if (colorTitleDark != null){
            baseInfo.put("colorTitleDark", colorTitleDark)
        }


        if (content != null) {
            baseInfo.put("content", content)
            if (colorContent != null){
                baseInfo.put("colorContent", colorContent)
            }

            if (colorContentDark != null){
                baseInfo.put("colorContentDark", colorContentDark)
            }

        }
        if (basetype == 2) {
            if (content != null) {
                baseInfo.put("content", content)
                if (colorContent != null) {
                    baseInfo.put("colorContent", colorContent)
                }

                if (colorContentDark != null) {
                    baseInfo.put("colorContentDark", colorContentDark)
                }

            } else {
                baseInfo.put("content", title)
            }
        }

        if (subContent != null) {
            baseInfo.put("subContent", subContent)
            if (colorSubContent != null){
                baseInfo.put("colorSubContent", colorSubContent)
            }
            if (colorSubContentDark != null) {
                baseInfo.put("colorSubContentDark", colorSubContentDark)
            }
            if (picFunction != null){
                baseInfo.put("picFunction", picFunction)
            }
            if (picFunctionDark != null){
                baseInfo.put("picFunctionDark", picFunctionDark)
            }
        }

        if (extraTitle != null) {
            baseInfo.put("extraTitle", extraTitle)
            if (colorExtraTitle != null){
                baseInfo.put("colorExtraTitle", colorExtraTitle)
            }
            if (colorExtraTitleDark != null){
                baseInfo.put("colorExtraTitleDark", colorExtraTitleDark)
            }
        }

        if (specialTitle != null) {
            baseInfo.put("specialTitle", specialTitle)
            if (colorSpecialTitle != null){
                baseInfo.put("colorSpecialTitle", colorSpecialTitle)
            }
            if (colorSpecialTitleDark != null){
                baseInfo.put("colorSpecialTitleDark", colorSpecialTitleDark)
            }

            baseInfo.put("colorSpecialTitleBg", colorSpecialTitleBg)
        }

        if (subTitle != null){
            baseInfo.put("subTitle", subTitle)
            if (colorsubTitle != null){
                baseInfo.put("colorSubTitle", colorsubTitle)
            }
            if (colorSubTitleDark != null){
                baseInfo.put("colorSubTitleDark", colorSubTitleDark)
            }
        }

        baseInfo.put("type", basetype)
        return baseInfo
    }

    /** 强调图文组件 自定义背景必须设置颜色，否则导致崩溃后果自负
     * 标题 和 timerInfo二选一传
     * @param type 是否隐藏辅助文本  传入 1隐藏辅助文本
     * @param timerInfo 计时信息
     * @param actionInfo 按钮信息
     * @param content 辅助文本 1
     * @param picFunction 功能图标 必传 请使用addpics自行添加picFunction
     * @param title 强调文本
     * @param subContent 辅助文本 2
     * @param colorSubContent 辅助文本 2 颜色
     * @param colorSubContentDark 辅助文本 2 深色颜色
     * @param colorContent 辅助文本 1颜色
     * @param colorContentDark 辅助文本 1深色颜色
     * @param colorTitle 强调文本颜色
     * @param colorTitleDark 强调文本深色颜色
     * @param picFunctionDark 暗黑模式下功能图标 请使用addpics自行添加picFunctionDark
     * @return JSONObject
     * */
    fun highlightInfo(
        type: Int = 0,
        timerInfo: JSONObject? = null,
        actionInfo: JSONObject? = null,
        picFunction: String,
        picFunctionDark : String? = null,
        title: String? = null,
        content: String? = null,
        subContent: String? = null,
        colorSubContent: String? = null,
        colorSubContentDark: String? = null,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colorTitle: String? = null,
        colorTitleDark: String? = null,
    ): JSONObject{
        val highlightInfo = JSONObject()
        if (type == 1) {
            highlightInfo.put("type", type)
        }
        if (timerInfo != null){
            highlightInfo.put("timerInfo", timerInfo)
        }
        if (actionInfo != null){
            highlightInfo.put("actionInfo", actionInfo)
        }
        if (title != null){
            highlightInfo.put("title", title)
        }
        if (colorTitle != null){
            highlightInfo.put("colorTitle", colorTitle)
        }

        if (colorTitleDark != null){
            highlightInfo.put("colorTitleDark", colorTitleDark)
        }
        if (content != null){
            highlightInfo.put("content", content)
            if (colorContent != null){
                highlightInfo.put("colorContent", colorContent)
            }
            if (colorContentDark != null){
                highlightInfo.put("colorContentDark", colorContentDark)
            }
        }

        if (subContent != null){
            highlightInfo.put("subContent", subContent)
            if (colorSubContent != null){
                highlightInfo.put("colorSubContent", colorSubContent)
            }
            if (colorSubContentDark != null){
                highlightInfo.put("colorSubContentDark", colorSubContentDark)
            }
            if (picFunctionDark != null){
                highlightInfo.put("picFunctionDark", picFunctionDark)
            }
        }
        highlightInfo.put("picFunction", picFunction)
        return highlightInfo
    }

    /** 时间 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param timerType 计时类型 取值 :-2,-1, 0 , 1,2 -2: 倒计时暂停 -1: 倒计时开始 0：默认值，如果设置为 0 的话，必须设置相同位置上的标题 1: 正计时开始 2. 正计时暂停
     * @param timerWhen 计时起点时间戳
     * @param timerSystemCurrent 计时误差
     * @param timerTotal 计时进度
     * timerWhen 比 timerSystemCurrent 大为倒计时 小为过了多少
     * @return JSONObject*/
    fun timerInfo(
        timerType: Int = -1,
        timerWhen: Long? = null,
        timerSystemCurrent: Long? = null,
        timerTotal: Long? = null,
    ): JSONObject {
        val timerInfo = JSONObject()
        timerInfo.put("timerType", timerType)
        if (timerWhen != null){
            timerInfo.put("timerWhen", timerWhen)
        }
        if (timerSystemCurrent != null){
            timerInfo.put("timerSystemCurrent", timerSystemCurrent)
        }
        timerTotal?.let{ timerInfo.put("timerTotal", timerTotal)}

        return timerInfo
    }

    /** 聊天信息 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param picProfile 头像，请使用addpics自行添加picProfile
     * @param picProfileDark 头像深色图标 请使用addpics自行添加picProfileDark
     * @param timerInfo 时间信息
     * @param title 主要文本
     * @param colortitle 主要文本颜色
     * @param colortitleDark 主要文本深色颜色
     * @param content 次要文本
     * @param colorcontent 次要文本 颜色
     * @param colorcontentDark 次要文本深色颜色
     * @param appIconPkg 自定义应用图标
     * @return JSONObject*/
    fun chatinfo(
        picProfile: String,
        picProfileDark: String? = null,
        timerInfo: JSONObject? = null,
        appIconPkg: String? = null,
        title: String,
        colortitle: String? = null,
        colortitleDark: String? = null,
        content: String,
        colorcontent: String? = null,
        colorcontentDark: String? = null,
    ): JSONObject {
        val chatInfo = JSONObject()
        if (picProfile != null){
            chatInfo.put("picProfile",picProfile)
        }
        if (picProfileDark != null) {
            chatInfo.put("picProfileDark", picProfileDark)
        }
        if (timerInfo != null) {
            chatInfo.put("timerInfo", timerInfo)
        }
        chatInfo.put("title", title)
        if (colortitle != null) {
            chatInfo.put("colorTitle", colortitle)
        }
        if (colortitleDark != null) {
            chatInfo.put("colortitleDark", colortitleDark)
        }

        chatInfo.put("content", content)
        if (colorcontent != null){
            chatInfo.put("colorContent", colorcontent)
        }
        if (colorcontentDark != null){
            chatInfo.put("colorContentDark", colorcontentDark)
        }
        appIconPkg?.let {chatInfo.put("appIconPkg",it) }
        return chatInfo
    }

    /** HintInfo 自定义背景必须设置颜色，否则导致崩溃后果自负
     * timerInfo和 title 二选一
     * @param colorContentBg 内容背景颜色
     * @param type 标志 • 1：按钮组件3; 2:按钮组件2
     * @param picContent 图标
     * @param timerInfo 时间信息
     * @param title 标题
     * @param content 小标题
     * @param colorContentDark 小标题字体颜色深色
     * @param colorContent 小标题字体颜色
     * @param colortitle 标题颜色
     * @param colortitleDark 标题深色颜色
     * @param titleLineCount 标题行数
     * @param actionInfo 按钮信息
     * @return JSONObject*/
    fun hintInfo(
        colorContentBg: String? = null,
        type: Int = 1,
        picContent: String? = null,
        timerInfo: JSONObject? = null,
        actionInfo: JSONObject,
        title: String,
        content: String,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colortitle: String? = null,
        colortitleDark: String? = null,
        titleLineCount: Int? = null,
    ): JSONObject{
        val hintInfo = JSONObject()
        if (colorContentBg != null){
            hintInfo.put("colorContentBg", colorContentBg)
        }
        if (picContent != null){
            hintInfo.put("picContent", picContent)
        }
        if (timerInfo != null){
            hintInfo.put("timerInfo", timerInfo)
        }
        if (timerInfo == null) {
            hintInfo.put("title", title)
        }
        if (colortitle != null) {
            hintInfo.put("colorTitle", colortitle)
        }
        if (colortitleDark != null) {
            hintInfo.put("colortitleDark", colortitleDark)
        }

        if (titleLineCount != null){
            hintInfo.put("titleLineCount", titleLineCount)
        }

        hintInfo.put("content", content)
        if (colorContent != null) {
            hintInfo.put("colorContent", colorContent)
        }
        if (colorContentDark != null) {
            hintInfo.put("colorContentDark", colorContentDark)
        }

        hintInfo.put("actionInfo", actionInfo)
        hintInfo.put("type", type)
        return hintInfo
    }

    /** 添加图标
     * @param name 图标名称
     * @param icon 图标
     * @return Bundle */
    @SuppressLint("NewApi")
    fun addpics(
        name : String,
        icon : Icon,
    ): Bundle {
        val pics = Bundle()
        val namea = name
        pics.putParcelable(namea, icon)
        return pics
    }


    /** 进度条，progressInfo 中不传入任何图标，即为 进度组件 2
     * @param colorProgress 进度条颜色
     * @param colorProgressEnd 进度条结束颜色
     * @param picEnd 进度条目标点图标(进度通过)
     * @param picEndUnselected 进度条目标点图标(进度未通过)
     * @param picForward 进度条前进图形
     * @param picMiddle 进度条中间节点图标(进度通过)
     * @param picMiddleUnselected 进度条中间节点图标(进度未通过)
     * @param progress 进度条进度 */
    fun progressInfo(
        colorProgress: String,
        colorProgressEnd: String? = null,
        picEnd: String? = null,
        picEndUnselected: String? = null,
        picForward: String? = null,
        picMiddle: String? = null,
        picMiddleUnselected: String? = null,
        progress:Int
    ): JSONObject{
        val progressInfo = JSONObject()

        progressInfo.put("colorProgress", colorProgress)
        colorProgressEnd?.let { progressInfo.put("colorProgressEnd", colorProgressEnd) }

        if (picEnd != null){
            progressInfo.put("picEnd", picEnd)
        }
        if (picEndUnselected != null) {
            progressInfo.put("picEndUnselected", picEndUnselected)
        }
        if (picForward != null){
            progressInfo.put("picForward", picForward)
        }
        if (picMiddle != null){
            progressInfo.put("picMiddle",picMiddle)
        }
        if (picMiddleUnselected != null){
            progressInfo.put("picMiddleUnselected", picMiddleUnselected)
        }
        progressInfo.put("progress", progress)

        return progressInfo
    }

    /** 按钮信息 自定义背景必须设置颜色，否则导致崩溃后果自负
     * 按钮类型由 actionInfo.type 决定，
     * Action 按钮类型：
     * 0：普通按钮类型 (默认值)
     * 1：进度按钮类型
     * 2：文字按钮类型
     * 限制：
     * • 圆形按钮支持 1-3个
     * • 进度按钮支持 1-3 个
     * • 文字按钮支持 1 个
     * • 文字按钮和其他按钮不能同时使用，传入方式有两种，1为直接往 sendFocus传入函数里actions里加，2为自定义构建 Action二选一
     * @param actionBgColor 按钮背景颜色
     * @param actionBgColorDark 按钮深色背景颜色
     * @param actionIcon 按钮图标
     * @param actionIconDark 按钮深色图标
     * @param actionIntent Intent
     * @param actionIntentType Intent类型 1为url to activity 2为action to broadcast 3为action to service
     * @param actionTitle 按钮标题
     * @param actionTitleColor 按钮标题颜色
     * @param actionTitleColorDark 按钮深色标题颜色
     * @param progressInfo 进度信息
     * @param clickWithCollapse 点击是否收起面板 备注：1.Action的PendingIntent 是 Activity 类型 ， 默认点击收起 2. actionIntentType为1时，默认点击收起
     * @return JSONObject */
    @SuppressLint("UseRequiresApi")
    fun actionInfo(
        actionBgColor: String? = null,
        actionBgColorDark: String? = null,
        actionIcon: String? = null,
        actionIconDark: String? = null,
        actionIntent: String,
        actionIntentType: String? = null,
        actionTitle: String? = null,
        actionTitleColor: String? = null,
        actionTitleColorDark: String? = null,
        progressInfo: JSONObject? = null,
        clickWithCollapse: Boolean = true
    ): JSONObject  {
        val actionObject = JSONObject()  // 单个 action 信息

        actionObject.put("actionIntent", actionIntent)
        actionObject.put("actionIntentType", actionIntentType)
        actionObject.put("actionTitle", actionTitle)
        actionObject.put("actionTitleColor", actionTitleColor)

        actionBgColor?.let { actionObject.put("actionBgColor", it) }
        actionBgColorDark?.let { actionObject.put("actionBgColorDark", it) }
        actionIcon?.let { actionObject.put("actionIcon", it) }
        actionIconDark?.let { actionObject.put("actionIconDark", it) }
        actionTitleColorDark?.let { actionObject.put("actionTitleColorDark", it) }
        progressInfo?.let { actionObject.put("progressInfo", it) }
        actionObject.put("clickWithCollapse", clickWithCollapse)

        return actionObject
    }

    @SuppressLint("UseRequiresApi")
    /**
     * 动画图标信息，os3新增
     * @param autoplay 是否自动播放
     * @param effectColor 效果颜色
     * @param effectSrc 效果图片
     * @param loop 是否循环
     * @param number 循环次数
     * @param src 图片
     * @param srcDark 图片深色
     * @param type 标识
     * @return JSONObject*/
    fun animIconInfo(
        autoplay:Boolean,
        effectColor:String,
        effectSrc: String,
        loop: Boolean,
        number: Int,
        src: String,
        srcDark : String,
        type: Int
    ): JSONObject{
        val animObject = JSONObject()
        animObject.put("autoplay",autoplay)
        animObject.put("effectColor",effectColor)
        animObject.put("effectSrc",effectSrc)
        animObject.put("loop",loop)
        animObject.put("number",number)
        animObject.put("src",src)
        animObject.put("srcDark",srcDark)
        animObject.put("type",type)

        return animObject
    }
    /**
     * 动画信息，os3新增
     * 主要文本 计时信息 (⼆选⼀)
     * @param timerInfo 计时信息
     * @param title 主要文本
     * @param content 次要文本
     * @param colorContentDark 次要文本颜色深色
     * @param colorContent 次要文本颜色
     * @param colortitle 主要文本颜色
     * @param colortitleDark 主要文本深色颜色
     * @param animIconInfo 动画图标信息*/
    fun animTextInfo(
        timerInfo: JSONObject? = null,
        title: String? = null,
        animIconInfo: JSONObject,
        content: String? = null,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colortitle: String? = null,
        colortitleDark: String? = null,
    ): JSONObject{
        val animObject = JSONObject()
        title?.let { animObject.put("title", it) }
        content?.let { animObject.put("content", it) }
        timerInfo?.let { animObject.put("timerInfo", it) }
        animIconInfo.let { animObject.put("animIconInfo", it) }
        if (colortitle != null) {
            animObject.put("colorTitle", colortitle)
        }
        if (colortitleDark != null) {
            animObject.put("colortitleDark", colortitleDark)
        }

        if (colorContent != null) {
            animObject.put("colorContent", colorContent)
        }
        if (colorContentDark != null) {
            animObject.put("colorContentDark", colorContentDark)
        }


        return animObject
    }

    /**
     * 封面信息,os3添加
     * @param picCover 封面
     * @param content 辅助文本 1
     * @param title 强调文本
     * @param subContent 辅助文本 2
     * @param colorSubContent 辅助文本 2 颜色
     * @param colorSubContentDark 辅助文本 2 深色颜色
     * @param colorContent 辅助文本 1颜色
     * @param colorContentDark 辅助文本 1深色颜色
     * @param colorTitle 强调文本颜色
     * @param colorTitleDark 强调文本深色颜色
     * @return JSONObject
     * */
    fun coverInfo(
        title: String,
        content: String,
        subContent: String,
        picCover: String,
        colorSubContent: String? = null,
        colorSubContentDark: String? = null,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colorTitle: String? = null,
        colorTitleDark: String? = null,
    ): JSONObject{
        val coverObject = JSONObject()
        coverObject.put("picCover",picCover)
        coverObject.put("title", title)
        coverObject.put("subContent", subContent)
        coverObject.put("content", content)

        colorTitle?.let { coverObject.put("colorTitle", it) }

        if (colorTitleDark != null) {
            coverObject.put("colorTitleDark", colorTitleDark)
        }

        if (colorContent != null) {
            coverObject.put("colorContent", colorContent)
        }

        if (colorContentDark != null) {
            coverObject.put("colorContentDark", colorContentDark)
        }

        if (colorSubContent != null) {
            coverObject.put("colorSubContent", colorSubContent)
        }
        if (colorSubContentDark != null) {
            coverObject.put("colorSubContentDark", colorSubContentDark)
        }

        return coverObject
    }

    /**
     * 多进度点进度条信息,os3添加
     * @param progress 进度
     * @param points 进度点 数量：支持 0-4 个 颜色和进度条一致
     * @param color 颜色
     * @param title 描述文本 最小压缩宽度：6 个汉字，12 个字符，72dp */
    fun multiProgressInfo(
        progress: Int = 1,
        points: Int = 1,
        color: String? = null,
        title: String
    ): JSONObject {
        val json = JSONObject()
        json.put("progress",progress).put("points",points)
        color?.let { json.put("color",it) }
        return json
    }


    /** highlightInfoV3
     * @param primaryText 高亮文本
     * @param secondaryText 补充文本
     * @param showSecondaryLine 补充文本是否划线
     * @param highLightText 文字标签
     * @param highLightbgColor 文字标签背景颜色
     * @param primaryColor 高亮文本颜色
     * @param primaryColorDark 高亮文本颜色深色
     * @param secondaryColor 补充文本颜色
     * @param secondaryColorDark 补充文本颜色深色
     * @param actionInfo 按钮信息
     * */
    fun highlightInfoV3(
        primaryText: String,
        secondaryText: String? = null,
        showSecondaryLine: Boolean = false,
        highLightText: String? = null,
        primaryColor: String? = null,
        secondaryColor: String? = null,
        highLightTextColor: String? = null,
        highLightbgColor: String? = null,
        primaryColorDark: String? = null,
        secondaryColorDark: String? = null,
        highLightTextColorDark: String? = null,
        highLightbgColorDark: String? = null,
        actionInfo: JSONObject
    ): JSONObject {
        val highlightInfoV3 = JSONObject()
        highlightInfoV3.put("primaryText", primaryText)
        secondaryText?.let { highlightInfoV3.put("secondaryText", it) }
        highLightText?.let { highlightInfoV3.put("highLightText", it) }
        primaryColor?.let { highlightInfoV3.put("primaryColor", it) }
        secondaryColor?.let { highlightInfoV3.put("secondaryColor", it) }
        highLightTextColor?.let { highlightInfoV3.put("highLightTextColor", it) }
        highLightbgColor?.let { highlightInfoV3.put("highLightbgColor", it) }
        primaryColorDark?.let { highlightInfoV3.put("primaryColorDark", it) }
        secondaryColorDark?.let { highlightInfoV3.put("secondaryColorDark", it) }
        highLightTextColorDark?.let { highlightInfoV3.put("highLightTextColorDark", it) }
        primaryColorDark?.let { highlightInfoV3.put("primaryColorDark", it) }
        highLightbgColorDark?.let { highlightInfoV3.put("highLightbgColorDark", it) }
        highLightTextColorDark?.let { highlightInfoV3.put("highLightTextColorDark", it) }
        highlightInfoV3.put("actionInfo", actionInfo)
        highlightInfoV3.put("showSecondaryLine", showSecondaryLine)

        return highlightInfoV3
    }

    /**
     * iconTextInfo,os3添加
     * @param animIconInfo 图片信息
     * @param content 辅助文本 1
     * @param title 强调文本
     * @param subContent 辅助文本 2
     * @param colorSubContent 辅助文本 2 颜色
     * @param colorSubContentDark 辅助文本 2 深色颜色
     * @param colorContent 辅助文本 1颜色
     * @param colorContentDark 辅助文本 1深色颜色
     * @param colorTitle 强调文本颜色
     * @param colorTitleDark 强调文本深色颜色
     * @return JSONObject
     * */
    fun iconTextInfo(
        title: String,
        content: String,
        subContent: String,
        animIconInfo: JSONObject,
        colorSubContent: String? = null,
        colorSubContentDark: String? = null,
        colorContent: String? = null,
        colorContentDark: String? = null,
        colorTitle: String? = null,
        colorTitleDark: String? = null,

        ): JSONObject {
        val iconTextObject = JSONObject()
        iconTextObject.put("title", title)
        iconTextObject.put("subContent", subContent)
        iconTextObject.put("content", content)
        iconTextObject.put("animIconInfo", animIconInfo)
        colorTitle?.let { iconTextObject.put("colorTitle", it) }
        colorTitleDark?.let { iconTextObject.put("colorTitleDark", it) }
        colorSubContent?.let { iconTextObject.put("colorSubContent", it) }
        colorSubContentDark?.let { iconTextObject.put("colorSubContentDark", it) }
        colorContent?.let { iconTextObject.put("colorContent", it) }
        colorContentDark?.let { iconTextObject.put("colorContentDark", it) }

        return iconTextObject
    }
}