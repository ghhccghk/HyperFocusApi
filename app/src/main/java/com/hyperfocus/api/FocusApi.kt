package com.hyperfocus.api

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.core.app.NotificationCompat
import org.json.JSONObject

class FocusApi {

    /**发送焦点通知
     * @param ticker 焦点在状态栏内容
     * @param title 焦点通知标题
     * @param content 焦点通知小标题
     * @param subContent 焦点通知小标题边上的小标题
     * @param aodTitle aodTitle 息屏标题
     * @param subTitle 焦点通知副标题
     * @param extraTitle 焦点通知额外标题
     * @param specialTitle 焦点通知特殊标题
     * @param desc1 焦点通知描述1 (不可用
     * @param desc2 焦点通知描述2 （不可用
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
     * @param normalHeight 焦点通知高度（无法使用）
     * @param picbgtype 背景标志 未知 1~2 可用
     * @param picmarkv2type 焦点通知右边标志 未知 1~4 可用
     * 图标要是对应不上反一下 这个我之前测试有点问题
     * @param picticker 焦点在状态栏图标浅色
     * @param pictickerdark 焦点在状态栏图标深色
     * @param picbg 焦点通知背景，留空为默认背景
     * @param picbgtype 背景标志 未知
     * @param picmarkv2 焦点通知右边图标
     * @param picmarkv2type 焦点通知右边标志 未知
     * @param basetype 基础标志 可以改成 2
     * @param protocol 控制版本 默认即可
     * @param updatable 焦点通知是否还要更新
     * @param enableFloat 焦点通知是否弹出
     * @param padding padding开关
     * @param timeout 焦点通知超时时间 单位秒
     * @param aodPic aodPic 息屏图标
     * @param builder 通知Builder */
    @SuppressLint("NewApi")
    fun sendFocus(
        builder: NotificationCompat.Builder,
        title: String,
        ticker: String,
        content: String? = null,
        aodTitle: String? = null,
        subTitle: String? = null,
        subContent: String? = null,
        extraTitle: String? = null,
        specialTitle: String? = null,
        desc1: String? = null,
        desc2: String? = null,
        colorsubTitle: String? = "#000000",
        colorSubTitleDark: String? = "#000000",
        colorSubContent: String = "#000000",
        colorSubContentDark: String? = null,
        colorContent: String = "#000000",
        colorContentDark: String? = null,
        colorTitle: String = "#000000",
        colorTitleDark: String? = null,
        colorExtraTitle: String = "#000000",
        colorExtraTitleDark: String? = null,
        colorSpecialTitle: String = "#000000",
        colorSpecialTitleDark: String? = null,
        colorSpecialTitleBg: String = "#000000",
        picticker: Icon,
        pictickerdark: Icon? = null,
        picmarkv2: Icon? = null,
        aodPic: String? = null,
        picbg: Icon? = null,
        picbgtype: Int = 1,
        basetype: Int = 1,
        protocol: Int = 1,
        picmarkv2type: Int = 1,
        timeout: Int? = 280,
        normalHeight: Int? = null,
        updatable: Boolean = true,
        enableFloat: Boolean = false,
        padding:Boolean = false
    ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val param_v2 = JSONObject()
        val baseInfo = JSONObject()

        baseInfo.put("title", title)
        baseInfo.put("colorTitle", colorTitle)

        if (colorTitleDark != null){
            baseInfo.put("colorTitleDark", colorTitleDark)
        }

        baseInfo.put("type", basetype)

        param_v2.put("protocol", protocol)
        param_v2.put("enableFloat", enableFloat)
        param_v2.put("ticker", ticker)
        param_v2.put("tickerPic", "miui.focus.pic_ticker")
        param_v2.put("updatable", updatable)
        param_v2.put("padding", padding)

        pics.putParcelable(
            "miui.focus.pic_ticker", picticker
        )
        if (normalHeight != null){
            param_v2.put("normalHeight", normalHeight)

        }

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

        if (picmarkv2 != null) {
            val picInfo = JSONObject()
            picInfo.put("type", picmarkv2type)
            picInfo.put("pic", "miui.focus.pic_mark_v2")
            param_v2.put("picInfo", picInfo)
            pics.putParcelable("miui.focus.pic_mark_v2", picmarkv2)
        }

        if (content != null) {
            baseInfo.put("content", content)
            baseInfo.put("colorContent", colorContent)
            if (colorContentDark != null){
                baseInfo.put("colorContentDark", colorContentDark)
            }

        }

        if (subContent != null) {
            baseInfo.put("subContent", subContent)
            baseInfo.put("colorSubContent", colorSubContent)
            if (colorSubContentDark != null) {
                baseInfo.put("colorSubContentDark", colorSubContentDark)
            }
        }

        if (extraTitle != null) {
            baseInfo.put("extraTitle", extraTitle)
            baseInfo.put("colorExtraTitle", colorExtraTitle)
            if (colorExtraTitleDark != null){
                baseInfo.put("colorExtraTitleDark", colorExtraTitleDark)
            }
        }
        if (specialTitle != null) {
            baseInfo.put("specialTitle", specialTitle)
            baseInfo.put("colorSpecialTitle", colorSpecialTitle)
            if (colorSpecialTitleDark != null){
                baseInfo.put("colorSpecialTitleDark", colorSpecialTitleDark)
            }

            baseInfo.put("colorSpecialTitleBg", colorSpecialTitleBg)
        }

        if (aodTitle != null){
            param_v2.put("aodTitle", title)
            if (aodPic != null){
                param_v2.put("aodPic", aodPic)
            }
        }
        if (subTitle != null){
            baseInfo.put("subTitle", subTitle)
            baseInfo.put("colorSubTitle",colorsubTitle)
            if (colorSubTitleDark != null){
                baseInfo.put("colorSubTitleDark", colorSubTitleDark)
            }
        }
        if (desc1 != null){
            baseInfo.put("desc1", desc1)
        }

        if (desc2 != null){
            baseInfo.put("desc2", desc2)
        }

        if (timeout != null){
            param_v2.put("timeout", timeout)
        }

        paramBundle.putBundle("miui.focus.pics", pics)
        param_v2.put("baseInfo", baseInfo)
        param.put("param_v2", param_v2)
        paramBundle.putString("miui.focus.param", param.toString())

        builder.addExtras(paramBundle)
        return paramBundle
    }
}