package com.hyperfocus.api

import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import org.json.JSONObject

class FocusApi {

    /**发送焦点通知
     * @param ticker 焦点在状态栏内容
     * @param title 焦点通知标题
     * @param content 焦点通知小标题
     * @param subContent 焦点通知小标题边上的小标题
     * @param colorSubContent 焦点通知小标题边上的小标题的颜色
     * @param colorTitle title颜色
     * @param colorContent Content颜色
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
     * @param builder 通知Builder */

    @RequiresApi(Build.VERSION_CODES.M)
    fun sendFocus(
        builder: NotificationCompat.Builder,
        title: String,
        colorTitle: String = "#000000",
        ticker: String,
        content: String? = null,
        subContent: String? = null,
        colorSubContent: String = "#000000",
        colorContent: String = "#000000",
        picticker: Icon,
        pictickerdark: Icon? = null,
        picmarkv2: Icon? = null,
        picmarkv2type: Int = 1,
        picbg: Icon? = null,
        picbgtype: Int = 1,
        basetype: Int = 1,
        protocol: Int = 1,
        updatable: Boolean = true,
        enableFloat: Boolean = false
    ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val param_v2 = JSONObject()
        val baseInfo = JSONObject()

        baseInfo.put("title", title)
        baseInfo.put("colorTitle", colorTitle)
        baseInfo.put("type", basetype)

        param_v2.put("protocol", protocol)
        param_v2.put("aodTitle", title)
        param_v2.put("enableFloat", enableFloat)
        param_v2.put("ticker", ticker)
        param_v2.put("tickerPic", "miui.focus.pic_ticker")
        param_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark")
        param_v2.put("updatable", updatable)

        pics.putParcelable(
            "miui.focus.pic_ticker", picticker
        )
        if (pictickerdark != null) {
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

        paramBundle.putBundle("miui.focus.pics", pics)

        if (content != null) {
            baseInfo.put("content", content)
            baseInfo.put("colorContent", colorContent)
        }

        if (subContent != null) {
            baseInfo.put("subContent", subContent)
            baseInfo.put("colorSubContent", colorSubContent)
        }

        param_v2.put("baseInfo", baseInfo)
        param.put("param_v2", param_v2)
        paramBundle.putString("miui.focus.param", param.toString())

        builder.addExtras(paramBundle)
        return paramBundle
    }
}