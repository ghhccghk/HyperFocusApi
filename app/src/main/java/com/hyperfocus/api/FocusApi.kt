package com.hyperfocus.api

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.RemoteViews
import org.json.JSONArray
import org.json.JSONObject

@Suppress("unused")
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
     * @param picbgtype 背景标志 未知 1~2 可用
     * @param  picInfotype 焦点通知右边标志 未知 1~4 可用 不可跟按钮使用
     * 图标要是对应不上反一下 这个我之前测试有点问题
     * @param picticker 焦点在状态栏图标浅色
     * @param pictickerdark 焦点在状态栏图标深色
     * @param picbg 焦点通知背景，留空为默认背景
     * @param picbgtype 背景标志 未知
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
     * @param addpics 添加图标 */
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
        if (picbg != null) {
            val bgInfo = JSONObject()
            bgInfo.put("type", picbgtype)
            bgInfo.put("picBg", "miui.focus.pic_bg")
            paramv2.put("bgInfo", bgInfo)
            pics.putParcelable(
                "miui.focus.pic_bg", picbg
            )
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


        if (actions != null && picInfo == null){
            param.put("miui.focus.actions",actions)
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
     * @param title 焦点通知标题
     * @param subTitle 焦点通知副标题
     * @param content 焦点通知内容
     * @param extraTitle 焦点通知额外标题
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
     * @param picFunctionDark 小图标深色 请使用addpics自行添加picFunctionDark
     * @param picFunction 小图标 请使用addpics自行添加picFunction */
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
    ): JSONObject{
        val baseInfo = JSONObject()

        baseInfo.put("title", title)
        baseInfo.put("colorTitle", colorTitle)

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
    /** HighlightInfo 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param type 标志
     * @param timerInfo 时间信息
     * @param actionInfo 按钮信息
     * @param content 内容
     * @param picFunction 小图标
     * @param title 标题
     * @param subContent 小内容
     * @param colorSubContent 小标题颜色
     * @param colorSubContentDark 小标题深色颜色
     * @param colorContent 内容颜色
     * @param colorContentDark 内容深色颜色
     * @param colorTitle 标题颜色
     * @param colorTitleDark 标题深色颜色
     * @param picFunctionDark 小图标深色 请使用addpics自行添加picFunctionDark
     * @return JSONObject
     * */
    fun highlightInfo(
        type: Int = 1,
        timerInfo: JSONObject? = null,
        actionInfo: JSONObject? = null,
        picFunction : String? = null,
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
        highlightInfo.put("type", type)
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
            if (picFunction != null){
                highlightInfo.put("picFunction", picFunction)
            }
            if (picFunctionDark != null){
                highlightInfo.put("picFunctionDark", picFunctionDark)
            }


        }
        return highlightInfo
    }

    /** 时间 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param timerType 时间类型 1:过了多少 不设置为倒计时
     * @param timerWhen 结束时间戳
     * @param timerSystemCurrent 系统时间
     * @param timerTotal 总时间,os3新增
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
     * @param picProfileDark 图标 请使用addpics自行添加picProfileDark
     * @param timerInfo 时间信息
     * @param title 标题
     * @param colortitle 标题颜色
     * @param colortitleDark 标题深色颜色
     * @param content 内容
     * @param colorcontent 内容颜色
     * @param colorcontentDark 内容深色颜色
     * @param appIconPkg 应用图标包名
     * @return JSONObject*/
    fun chatinfo(
        picProfile: String? = null,
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
     * @param colorContentBg 内容背景颜色
     * @param type 标志
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
        actionInfo: JSONObject? = null,
        title: String? = null,
        content: String? = null,
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
        if (title != null){
            hintInfo.put("title", title)
            if (colortitle != null) {
                hintInfo.put("colorTitle", colortitle)
            }
            if (colortitleDark != null){
                hintInfo.put("colortitleDark", colortitleDark)
            }
        }
        if (titleLineCount != null){
            hintInfo.put("titleLineCount", titleLineCount)
        }
        if (content != null){
            hintInfo.put("content", content)
            if (colorContent != null){
                hintInfo.put("colorContent", colorContent)
            }
            if (colorContentDark != null){
                hintInfo.put("colorContentDark", colorContentDark)
            }
        }
        if (actionInfo != null){
            hintInfo.put("actionInfo", actionInfo)
        }
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


    /** 进度条
     * @param colorProgress 进度条颜色
     * @param colorProgressEnd 进度条结束颜色
     * @param picEnd 进度条结束图标
     * @param picEndUnselected 进度条未选中图标
     * @param picForward 进度条向前图标
     * @param picMiddle 进度条中间图标
     * @param picMiddleUnselected 进度条未选中中间图标
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

    /** 按钮信息 图标和文本不要在一起用 只能分开用 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param actionBgColor 按钮背景颜色
     * @param actionBgColorDark 按钮深色背景颜色
     * @param actionIcon 按钮图标
     * @param actionIconDark 按钮深色图标
     * @param actionIntent Intent
     * @param actionIntentType Intent类型
     * @param actionTitle 按钮标题
     * @param actionTitleColor 按钮标题颜色
     * @param actionTitleColorDark 按钮深色标题颜色
     * @return JSONObject */
    @SuppressLint("UseRequiresApi")
    fun actionInfo(
        actionBgColor: String? = null,
        actionBgColorDark: String? = null,
        actionIcon: String? = null,
        actionIconDark: String? = null,
        actionIntent: Intent,
        actionIntentType: String? = null,
        actionTitle: String? = null,
        actionTitleColor: String? = null,
        actionTitleColorDark: String? = null,
    ): JSONObject  {
        val actionObject = JSONObject()  // 单个 action 信息

        actionObject.put("actionIntent", actionIntent.toUri(Intent.URI_INTENT_SCHEME))
        actionObject.put("actionIntentType", actionIntentType)
        actionObject.put("actionTitle", actionTitle)
        actionObject.put("actionTitleColor", actionTitleColor)

        actionBgColor?.let { actionObject.put("actionBgColor", it) }
        actionBgColorDark?.let { actionObject.put("actionBgColorDark", it) }
        actionIcon?.let { actionObject.put("actionIcon", it) }
        actionIconDark?.let { actionObject.put("actionIconDark", it) }
        actionTitleColorDark?.let { actionObject.put("actionTitleColorDark", it) }

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
     * @param timerInfo 时间信息
     * @param animIconInfo 动画图标信息*/
    fun animTextInfo(
        timerInfo: JSONObject? = null,
        animIconInfo: JSONObject? = null,
    ): JSONObject{
        val animObject = JSONObject()
        animObject.put("TimerInfo",timerInfo)
        animObject.put("AnimIconInfo",animIconInfo)
        return animObject
    }

    /**
     * 封面信息,os3添加
     * @param picCover 封面
     * @return JSONObject
     * */
    fun coverInfo(
        title: String,
        picCover: String,
    ): JSONObject{
        val coverObject = JSONObject()
        coverObject.put("picCover",picCover)
        coverObject.put("title", title)
        return coverObject
    }

    /**
     * 多进度点进度条信息,os3添加
     * @param progress 进度
     * @param points 进度点
     * @param color 颜色*/
    fun multiProgressInfo(
        progress: Int = 1,
        points: Int = 1,
        color: String? = null,
    ): JSONObject {
        val json = JSONObject()
        json.put("progress",progress).put("points",points)
        color?.let { json.put("color",it) }
        return json
    }
}