package com.hyperfocus.api

import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import org.json.JSONObject

class FocusApi {
    @RequiresApi(Build.VERSION_CODES.M)
    fun sendOnlyTitleFocus(builder : NotificationCompat.Builder,
                           title : String,
                           colorTitle:String = "#000000",
                           ticker : String,
                           picticker:Icon,
                           pictickerdark:Icon? = null,
                           picmarkv2:Icon? = null,
                           picbg:Icon? = null,
                           updatable:Boolean = true
                           ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val param_v2 = JSONObject()
        val baseInfo = JSONObject()

        baseInfo.put("title", title)
        baseInfo.put("colorTitle",colorTitle)

        param_v2.put("protocol",1)
        param_v2.put("aodTitle",title)
        param_v2.put("ticker", ticker)
        param_v2.put("tickerPic", "miui.focus.pic_ticker")
        param_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark")
        param_v2.put("updatable",updatable)

        pics.putParcelable(
            "miui.focus.pic_ticker", picticker
        )
        if (pictickerdark != null){
            pics.putParcelable(
                "miui.focus.pic_ticker_dark", pictickerdark
            )
        }
        if (picbg != null){
            val bgInfo = JSONObject()
            bgInfo.put("type",1)
            bgInfo.put("picBg","miui.focus.pic_bg")
            param_v2.put("bgInfo",bgInfo)
            pics.putParcelable(
                "miui.focus.pic_bg", picbg
            )
        }

        if (picmarkv2 != null){
            val picInfo = JSONObject()
            baseInfo.put("type", 2)
            picInfo.put("type",2)
            picInfo.put("pic","miui.focus.pic_mark_v2")
            param_v2.put("picInfo",picInfo)
            pics.putParcelable("miui.focus.pic_mark_v2",picmarkv2)
        } else {
            baseInfo.put("type", 1)
        }
        paramBundle.putBundle("miui.focus.pics", pics)

        param_v2.put("baseInfo", baseInfo)
        param.put("param_v2", param_v2)
        paramBundle.putString("miui.focus.param", param.toString())

        builder.addExtras(paramBundle)
        return paramBundle
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun sendTitleAndContentFocus(builder : NotificationCompat.Builder,
                                 tilie : String,
                                 colorTitle:String = "#000000",
                                 colorContent:String = "#000000",
                                 ticker : String,
                                 content:String,
                                 picticker:Icon,
                                 pictickerdark:Icon? = null,
                                 picmarkv2:Icon? = null,
                                 picbg:Icon? = null,
                                 updatable:Boolean = true,
                                 showSmallIcon:Boolean = true
    ): Bundle {
        val paramBundle = Bundle()
        val pics = Bundle()
        val param = JSONObject()
        val param_v2 = JSONObject()
        val baseInfo = JSONObject()

        baseInfo.put("title", tilie)
        baseInfo.put("content",content)
        baseInfo.put("colorTitle",colorTitle)
        baseInfo.put("colorContent",colorContent)

        param_v2.put("protocol",1)
        param_v2.put("aodTitle",tilie)
        param_v2.put("baseInfo", baseInfo)
        param_v2.put("ticker", ticker)
        param_v2.put("tickerPic", "miui.focus.pic_ticker")
        param_v2.put("updatable",updatable)
        param_v2.put("showSmallIcon",showSmallIcon)
        param.put("param_v2", param_v2)

        pics.putParcelable(
            "miui.focus.pic_ticker", picticker
        )
        if (pictickerdark != null){
            param_v2.put("tickerPicDark", "miui.focus.pic_ticker_dark")
            pics.putParcelable(
                "miui.focus.pic_ticker_dark", pictickerdark
            )
        }

        if (picbg != null){
            val bgInfo = JSONObject()
            bgInfo.put("type",1)
            bgInfo.put("picBg","miui.focus.pic_bg")
            param_v2.put("bgInfo",bgInfo)
            pics.putParcelable(
                "miui.focus.pic_bg", picbg
            )
        }

        if (picmarkv2 != null){
            val picInfo = JSONObject()
            baseInfo.put("type", 2)
            picInfo.put("type",2)
            picInfo.put("pic","miui.focus.pic_mark_v2")
            param_v2.put("picInfo",picInfo)
            pics.putParcelable("miui.focus.pic_mark_v2",picmarkv2)
        } else {
            baseInfo.put("type", 1)
        }

        paramBundle.putBundle("miui.focus.pics", pics)
        param_v2.put("baseInfo", baseInfo)
        param.put("param_v2", param_v2)
        paramBundle.putString("miui.focus.param", param.toString())

        builder.addExtras(paramBundle)
        return paramBundle
    }
}