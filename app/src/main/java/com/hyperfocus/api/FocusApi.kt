package com.hyperfocus.api

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import org.json.JSONArray
import org.json.JSONObject

class FocusApi {

    /**发送焦点通知 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param ticker 焦点在状态栏内容
     * @param scene 场景
     * @param baseInfo 基础信息
     * @param highlightInfo 高亮信息
     * @param ProgressInfo 进度信息 不能和hintInfo 同时使用
     * @param chatinfo 聊天信息
     * @param hintInfo 提示信息 不能和 ProgressInfo 同时使用
     * @param chatinfo 聊天信息
     * @param actions 按钮信息 不能和picmarkv2 同时使用 ，ActionInfo使用JSONArray合并一起可生成两个按钮
     * @param title 焦点通知标题
     * @param content 焦点通知小标题
     * @param subContent 焦点通知小标题边上的小标题
     * @param aodTitle aodTitle 息屏标题
     * @param aodPic aodPic 息屏图标
     * @param normalHeight 焦点通知高度（无法使用）
     * @param picbgtype 背景标志 未知 1~2 可用
     * @param  picInfotype 焦点通知右边标志 未知 1~4 可用 不可跟按钮使用
     * 图标要是对应不上反一下 这个我之前测试有点问题
     * @param picticker 焦点在状态栏图标浅色
     * @param pictickerdark 焦点在状态栏图标深色
     * @param picbg 焦点通知背景，留空为默认背景
     * @param picbgtype 背景标志 未知
     * @param picInfo 焦点通知右边图标 不可跟按钮使用
     * @param basetype 基础标志 可以改成 2
     * @param protocol 控制版本 默认即可
     * @param updatable 焦点通知是否还要更新
     * @param enableFloat 焦点通知是否弹出
     * @param padding padding开关
     * @param timeout 焦点通知超时时间 单位秒
     * @param addpics 添加图标
     * @param builder 通知Builder */
    @SuppressLint("NewApi")
    fun sendFocus(
        builder: NotificationCompat.Builder,
        baseInfo: JSONObject? = null,
        highlightInfo: JSONObject? = null,
        hintInfo: JSONObject? = null,
        chatinfo: JSONObject? = null,
        ProgressInfo: JSONObject? = null,
        actions : JSONArray? = null,
        scene: String? = null,
        title: String? = null ,
        colorTitle: String? = null,
        content: String? = null,
        ticker: String,
        aodTitle: String? = null,
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
        padding:Boolean = false
    ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val param_v2 = JSONObject()

        param_v2.put("protocol", protocol)
        if (enableFloat){
            param_v2.put("enableFloat", enableFloat)
        }
        param_v2.put("ticker", ticker)
        param_v2.put("tickerPic", "miui.focus.pic_ticker")
        if (updatable){
            param_v2.put("updatable", updatable)
        }
        if (padding){
            param_v2.put("padding", padding)
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
            param_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark")
            pics.putParcelable(
                "miui.focus.pic_ticker_dark", pictickerdark
            )
        }
        if (picbg != null) {
            val bgInfo = JSONObject()
            bgInfo.put("type", picbgtype)
            bgInfo.put("picBg", "miui.focus.pic_bg")
            param_v2.put("bgInfo", bgInfo)
            pics.putParcelable(
                "miui.focus.pic_bg", picbg
            )
        }

        if (picInfo != null) {
            val picInfoj = JSONObject()
            picInfoj.put("type", picInfotype)
            picInfoj.put("pic", "miui.focus.pic_mark_v2")
            param_v2.put("picInfo", picInfoj)
            pics.putParcelable("miui.focus.pic_mark_v2", picInfo)
        }


        if (aodTitle != null){
            param_v2.put("aodTitle", aodTitle)
            if (aodPic != null){
                pics.putParcelable("miui.focus.pic_aod", aodPic)
                param_v2.put("aodPic", "miui.focus.pic_aod")
            }
        }


        if (timeout != null){
            param_v2.put("timeout", timeout)
        }

        if (highlightInfo != null){
            param_v2.put("highlightInfo", highlightInfo)
        }

        if (chatinfo != null){
            param_v2.put("chatInfo", chatinfo)
        }

        if (chatinfo != null || highlightInfo != null || baseInfo != null && ProgressInfo == null){
            if (hintInfo != null){
                param_v2.put("hintInfo", hintInfo)
            }
        }

        if (ProgressInfo != null && hintInfo == null){
            param_v2.put("progressInfo", ProgressInfo)
        }


        if (addpics != null){
            pics.putAll(addpics)
        }

        paramBundle.putBundle("miui.focus.pics", pics)


        if (baseInfo != null){
            param_v2.put("baseInfo", baseInfo)
        }
        param.put("param_v2", param_v2)
        paramBundle.putString("miui.focus.param", param.toString())

        if (actions != null && picInfo == null){
            param.put("miui.focus.actions",actions)
        }

        builder.addExtras(paramBundle)
        return paramBundle
    }

    /** Baseinfo 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param title 焦点通知标题
     * @param subTitle 焦点通知副标题
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
     * @param colorSpecialTitleBg specialTitle背景颜色 */
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
     * @param picFunction 小图标
     * @param title 标题
     * @param subContent 小标题
     * @param colorSubContent 小标题颜色
     * @param colorSubContentDark 小标题深色颜色
     * @param colorContent 内容颜色
     * @param colorContentDark 内容深色颜色
     * @param colorTitle 标题颜色
     * @param colorTitleDark 标题深色颜色
     * @param picFunctionDark 小图标深色 请使用addpics自行添加picFunctionDark
     * @param picFunction 小图标 请使用addpics自行添加picFunction
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
     * timerWhen 比 timerSystemCurrent 大为倒计时 小为过了多少
     * @return JSONObject*/
    fun timerInfo(
        timerType: Int = -1,
        timerWhen: Long? = null,
        timerSystemCurrent: Long? = null,
    ): JSONObject {
        val timerInfo = JSONObject()
        timerInfo.put("timerType", timerType)
        if (timerWhen != null){
            timerInfo.put("timerWhen", timerWhen)
        }
        if (timerSystemCurrent != null){
            timerInfo.put("timerSystemCurrent", timerSystemCurrent)
        }

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
     * @return JSONObject*/
    fun chatinfo(
        picProfile: String? = null,
        picProfileDark: String? = null,
        timerInfo: JSONObject? = null,
        title: String,
        colortitle: String? = null,
        colortitleDark: String? = null,
        content: String,
        colorcontent: String? = null,
        colorcontentDark: String? = null,
    ): JSONObject {
        val chatInfo = JSONObject()
        if (picProfile != null){
            chatInfo.put("picProfile", picProfile)
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
        return chatInfo
    }

    /** HintInfo 自定义背景必须设置颜色，否则导致崩溃后果自负
     * @param colorContentBg 内容背景颜色
     * @param type 标志
     * @param picContent 图标
     * @param timerInfo 时间信息
     * @param title 标题
     * @param colortitle 标题颜色
     * @param colortitleDark 标题深色颜色
     * @param titleLineCount 标题行数
     * @param actionInfo 按钮信息
     * @return JSONObject*/
    fun HintInfo(
        colorContentBg: String? = null,
        type: Int = 1,
        picContent: String? = null,
        timerInfo: JSONObject? = null,
        actionInfo: JSONObject? = null,
        title: String? = null,
        content: String? = null,
        subTitle: String? = null,
        subContent: String? = null,
        colorsubTitle: String? = null,
        colorSubTitleDark: String? = null,
        colorSubContent: String? = null,
        colorSubContentDark: String? = null,
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
        if (subTitle != null){
            hintInfo.put("subTitle", subTitle)
            if (colorsubTitle != null) {
                hintInfo.put("colorSubTitle", colorsubTitle)
            }
            if (colorSubTitleDark != null){
                hintInfo.put("colorSubTitleDark", colorSubTitleDark)
            }
        }
        if (subContent != null) {
            hintInfo.put("subContent", subContent)
            if (colorSubContent != null){
                hintInfo.put("colorSubContent", colorSubContent)
            }
            if (colorSubContentDark != null) {
                hintInfo.put("colorSubContentDark", colorSubContentDark)
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
    @Suppress("NewApi")
    fun addpics(
        name : String,
        icon : Icon,
    ): Bundle {
        val pics = Bundle()
        val namea = "miui.focus.pic_$name"
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
    fun ProgressInfo(
        colorProgress: String,
        colorProgressEnd: String,
        picEnd: String? = null,
        picEndUnselected: String? = null,
        picForward: String? = null,
        picMiddle: String? = null,
        picMiddleUnselected: String? = null,
        progress:Int
    ): JSONObject{
        val progressInfo = JSONObject()

        progressInfo.put("colorProgress", colorProgress)
        progressInfo.put("colorProgressEnd", colorProgressEnd)

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
            progressInfo.put("picMiddle", picMiddle)
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
     * @param actionsIcon 按钮图标
     * @param actionsIconDark 按钮深色图标
     * @param actionsIntent Intent
     * @param actionsIntentType Intent类型
     * @param actionsTitle 按钮标题
     * @param actionTitleColor 按钮标题颜色
     * @param actionTitleColorDark 按钮深色标题颜色
     * @return JSONObject */
    @TargetApi(Build.VERSION_CODES.DONUT)
    fun ActionInfo(
        actionBgColor: String? = null,
        actionBgColorDark: String? = null,
        actionsIcon: String? = null,
        actionsIconDark: String? = null,
        actionsIntent: Intent,
        actionsIntentType: String? = null,
        actionsTitle: String? = null,
        actionTitleColor: String? = null,
        actionTitleColorDark: String? = null,
    ): JSONObject  {
        val actionObject = JSONObject()  // 单个 action 信息

        actionObject.put("actionIntent", actionsIntent.toUri(Intent.URI_INTENT_SCHEME))
        actionObject.put("actionIntentType", actionsIntentType)
        actionObject.put("actionTitle", actionsTitle)
        actionObject.put("actionTitleColor", actionTitleColor)

        actionBgColor?.let { actionObject.put("actionBgColor", it) }
        actionBgColorDark?.let { actionObject.put("actionBgColorDark", it) }
        actionsIcon?.let { actionObject.put("actionIcon", it) }
        actionsIconDark?.let { actionObject.put("actionIconDark", it) }
        actionTitleColorDark?.let { actionObject.put("actionTitleColorDark", it) }

        return actionObject
    }
}