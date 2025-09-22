package com.hyperfocus.api

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import org.json.JSONObject

@Suppress("unused", "LocalVariableName", "KotlinConstantConditions", "FunctionName")
object IslandApi {
    /**
     * 小米超级岛展开配置
     * @param BigIslandData 大岛数据
     * @param SmallIslandData 小岛数据
     * @param islandPriority 优先级
     * @param islandProperty 优先级
     * */
    fun islandData(
        BigIslandData: JSONObject,
        SmallIslandData: JSONObject,
        islandPriority:Int = 1,
        islandProperty:Int = 1,
    ): JSONObject {
        val json = JSONObject()
        json.put("islandPriority",islandPriority)
        json.put("islandProperty",islandProperty)
        json.put("bigIsland",BigIslandData)
        json.put("smallIsland",SmallIslandData)
        return json
    }

    /**
     * 小米超级岛之音乐岛分享配置
     * @param addpic 添加图标
     * @param pic 分享卡片图标
     * @param content 分享卡片内容
     * @param title 分享卡片标题
     * @param shareContent 分享到应用的内容
     * @param sharePic 分享到应用的图片 (目前不知道怎么分享图片，未测试)
     * @return 直接注入到媒体通知即可 */
    fun isLandMusicShare(
        addpic: Bundle,
        pic: String = "miui_media_album_icon",
        content: String,
        title: String,
        shareContent: String,
        sharePic: String? = null,
    ): Bundle {
        val nfBundle = Bundle()
        val param = JSONObject()
        val paramV2 = JSONObject()
        val island = JSONObject()
        island.put("shareData", ShareData(
            title = title,
            content = content,
            pic = if (pic != "miui_media_album_icon" ) "miui.focus.pic_$pic" else "miui_media_album_icon",
            sharePic = sharePic,
            shareContent = shareContent
        ))

        paramV2.put("param_island",island)
        param.put("param_v2",paramV2)

        nfBundle.putBundle("miui.focus.pics",addpic)
        nfBundle.putString("miui.focus.param.media",param.toString())
        return nfBundle
    }


    /**
     * 小米超级岛初始化配置
     * @param bigIslandArea 大岛区域
     * @param business 业务
     * @param dismissIsland 是否可关闭
     * @param expandedTime 展开时间
     * @param highlightColor 高亮颜色
     * @param islandOrder 是否展开
     * @param islandPriority 优先级
     * @param islandProperty 优先级
     * @param islandTimeout 超时时间
     * @param maxSize 是否最大尺寸
     * @param needCloseAnimation 是否需要关闭动画
     * @param shareData 分享数据
     * @param smallIslandArea 小岛区域
     * */
    fun IslandTemplate(
        bigIslandArea: JSONObject? =null,
        business: String? =null,
        dismissIsland: Boolean = false,
        expandedTime: Int = 0,
        highlightColor:String? = null,
        islandOrder:Boolean = false,
        islandPriority:Int = 2,
        islandProperty:Int = 2,
        islandTimeout:Int = 280,
        maxSize:Boolean = false,
        needCloseAnimation:Boolean = true,
        shareData:JSONObject? = null,
        smallIslandArea: JSONObject? = null,
    ): JSONObject {
        val json = JSONObject()
        json.put("bigIslandArea",bigIslandArea)
        json.put("business",business)
        json.put("dismissIsland",dismissIsland)
        json.put("expandedTime",expandedTime)

        if (highlightColor != null){
            json.put("highlightColor",highlightColor)
        }

        json.put("islandOrder",islandOrder)
        json.put("islandPriority",islandPriority)
        json.put("islandProperty",islandProperty)
        json.put("islandTimeout",islandTimeout)
        json.put("maxSize",maxSize)
        if (needCloseAnimation){
            json.put("needCloseAnimation",needCloseAnimation)
        }
        if (shareData != null){
            json.put("shareData",shareData)
        }
        if (smallIslandArea != null){
            json.put("smallIslandArea",smallIslandArea)
        }
        return json
    }

    /**
     * 小米超级岛未展开态区域
     * @param combinePicInfo 图片和进度信息
     * @param picInfo 图片信息*/
    fun SmallIslandArea(
        combinePicInfo: JSONObject ?= null,
        picInfo: JSONObject ?= null,
    ): JSONObject {
        val json = JSONObject()
        if (combinePicInfo != null) { json.put("combinePicInfo", combinePicInfo) }
        picInfo?.let { json.put("picInfo", it) }
        return json
    }

    /**
     * 未测试
     * 小米超级岛未展开态Data
     * @param pic 图片
     * */
    fun SmallIslandData(
        pic: String,
    ): JSONObject{
        val json = JSONObject()
        json.put("pic",pic)
        return json
    }


    /**
     * 小米超级岛时间信息
     * @param timerType 时间类型
     * @param timerTotal 总时间
     * @param timerWhen 剩余时间
     * @param timerSystemCurrent 系统时间
     * */
    fun TimerInfo(
        timerType: Int = -1,
        timerTotal:Long? = null,
        timerWhen: Long? = null,
        timerSystemCurrent: Long? = null,
    ): JSONObject {
        val timerInfo = JSONObject()
        timerInfo.put("timerType", timerType)
        if (timerTotal != null){
            timerInfo.put("timerTotal", timerTotal)
        }
        if (timerWhen != null){
            timerInfo.put("timerWhen", timerWhen)
        }
        if (timerSystemCurrent != null){
            timerInfo.put("timerSystemCurrent", timerSystemCurrent)
        }

        return timerInfo
    }

    /**
     * 小米超级岛文字信息
     * @param content 内容
     * @param frontTitle 前置标题
     * @param showHighlightColor 是否显示高亮颜色
     * @param turnAnim 动画开关
     * @param isTitleDigit 是否数字
     * @param title 标题
     * */
    fun TextInfo(
        content: String? = null,
        frontTitle: String? = null,
        showHighlightColor: Boolean = false,
        turnAnim: Boolean = true,
        isTitleDigit: Boolean = false,
        title: String,
    ): JSONObject {
        val json = JSONObject()
        content?.let { json.put("content", it) }
        frontTitle.let{ json.put("frontTitle",it) }
        json.put("showHighlightColor",showHighlightColor)
        json.put("turnAnim",turnAnim)
        json.put("isTitleDigit",isTitleDigit)
        json.put("title",title)
        return json

    }

    /**
     * 小米超级岛固定宽度信息
     * @param content 内容
     * @param digit 数字
     * @param timeInfo 时间信息 如果单使用这个请不要传 digit
     * @param showHighlightColor 是否显示高亮颜色
     * @param turnAnim 动画开关
     * */
    fun SameWidthDigitInfo(
        content: String? = null,
        digit:String? = null,
        timeInfo: JSONObject? = null,
        showHighlightColor: Boolean = false,
        turnAnim: Boolean = false,
    ): JSONObject{
        val json = JSONObject()
        content?.let { json.put("content", content) }
        digit?.let { json.put("digit", digit) }
        timeInfo?.let { json.put("timerInfo", timeInfo) }
        json.put("showHighlightColor",showHighlightColor)
        json.put("turnAnim",turnAnim)
        return json
    }

    /**
     * 小米超级岛分享信息
     * @param content 内容
     * @param title 标题
     * @param pic 图片
     * @param shareContent 分享内容
     * @param sharePic 分享图片
     * */
    fun ShareData(
        content: String,
        title: String,
        pic: String,
        shareContent: String,
        sharePic: String? = null,
    ): JSONObject{
        val json = JSONObject()
        json.put("content",content)
        json.put("title",title)
        json.put("pic","miui.focus.pic_$pic")
        json.put("shareContent",shareContent)
        sharePic?.let { json.put("sharePic", it) }
        return json
    }

    /**
     * 小米超级岛进度和文字信息
     * @param progressInfo 进度信息
     * @param textInfo 文字信息
     * */
    fun ProgressTextInfo(
        progressInfo: JSONObject,
        textInfo: JSONObject,
    ): JSONObject {
        val json = JSONObject()
        json.put("progressInfo",progressInfo)
        json.put("textInfo",textInfo)
        return json
    }
    /**
     * 小米超级岛图片信息
     * @param autoplay 是否自动播放
     * @param contentDescription 内容描述
     * @param effectColor 效果颜色
     * @param effectSrc 效果图片
     * @param loop Lottie 动画文件是否循环
     * @param number 当为 Lottie 动画文件时，可以指定动画循环次数
     * @param pic 图片，可注入 Lottie 动画文件名称，目前只能使用小米预设动画
     * */
    fun PicInfo(
        autoplay: Boolean = false,
        contentDescription: String? = null,
        effectColor: String? = null,
        effectSrc: String? = null,
        loop: Boolean = false,
        number:Int = 0,
        pic: String,
        type: Int = 1,
    ): JSONObject {
        val json = JSONObject()
        json.put("autoplay",autoplay)
        contentDescription?.let { json.put("contentDescription", it) }
        if (effectColor != null){ json.put("effectColor", effectColor) }
        if (effectSrc != null){ json.put("effectSrc", effectSrc) }
        json.put("loop",loop)
        if (number <= 1){ json.put("number", number) }
        json.put("pic","miui.focus.pic_$pic")
        json.put("type",type)
        return json
    }

    /**
     * 小米超级岛进度信息
     * @param colorReach 进度颜色
     * @param colorUnReach 未完成进度颜色
     * @param isCCW 是否顺时针
     * @param progress 进度
     * */
    fun ProgressInfo(
        colorReach: String? = null,
        colorUnReach: String? = null,
        isCCW:Boolean = false,
        progress: Int,
    ): JSONObject {
        val json = JSONObject()
        colorReach?.let { json.put("colorReach", it) }
        colorUnReach?.let { json.put("colorUnReach", it) }
        json.put("isCCW",isCCW)
        json.put("progress",progress)
        return json
    }


    /**
     * 小米超级岛固定宽度信息
     * @param content 内容
     * @param digit 数字，只能最多传3个数字并且只能有一个小数点
     * @param showHighlightColor 是否显示高亮颜色
     * @param turnAnim 动画开关 */
    fun FixedWidthDigitInfo(
        content: String? = null,
        digit: Int,
        showHighlightColor: Boolean = false,
        turnAnim: Boolean = true,
    ): JSONObject {
        val json = JSONObject()
        content?.let{ json.put("content", it) }
        json.put("digit",digit)
        json.put("showHighlightColor",showHighlightColor)
        json.put("turnAnim",turnAnim)
        return json
    }


    /**
     * 小米超级岛未展开小岛 Combine 图片进度信息
     * @param picInfo 图片信息
     * @param progressInfo 进度信息
     * @param smallPicInfo 小图片信息
     * */
    fun CombinePicInfo(
        picInfo: JSONObject,
        progressInfo: JSONObject ? = null,
        smallPicInfo: JSONObject? = null
    ): JSONObject{
        val combine = JSONObject()
        combine.put("picInfo",picInfo)
        progressInfo?.let { combine.put("progressInfo", progressInfo) }
        smallPicInfo.let { combine.put("smallPicInfo", smallPicInfo) }
        return combine
    }

    /**
     * 小米超级岛，图片和文字配置
     * @param picInfo 图片信息
     * @param textInfo 文字信息
     * @param type 标识 left为 1 right 为 2 ~ 5
     * @param progressInfo 进度信息
     * */
    fun ImageTextInfo(
        picInfo: JSONObject? = null ,
        textInfo: JSONObject? = null,
        type: Int = 1,
        progressInfo: JSONObject? =null,
    ): JSONObject {
        val json = JSONObject()
        json.put("type",type)
        picInfo?.let {json.put("picInfo",it)}
        textInfo?.let { json.put("textInfo", it) }
        progressInfo?.let { json.put("progressInfo", it) }
        return json
    }

    /**
     * 小米超级岛展开配置
     * @param fixedWidthDigitInfo 固定宽度信息
     * @param imageTextInfoLeft 左边图片和文字信息
     * @param imageTextInfoRight 右边图片和文字信息
     * @param picInfo 图片信息
     * @param progressTextInfo 进度和文字信息
     * @param sameWidthDigitInfo 同宽度信息
     * @param textInfo 文字信息
     * */
    fun BigIslandArea(
        fixedWidthDigitInfo: JSONObject? = null,
        imageTextInfoLeft: JSONObject? = null,
        imageTextInfoRight: JSONObject? = null,
        picInfo: JSONObject? = null,
        progressTextInfo: JSONObject? = null,
        sameWidthDigitInfo: JSONObject? = null,
        textInfo: JSONObject? = null
    ): JSONObject {
        val json = JSONObject()
        fixedWidthDigitInfo?.let { json.put("fixedWidthDigitInfo", it) }
        imageTextInfoLeft?.let { json.put("imageTextInfoLeft", it) }
        imageTextInfoRight?.let { json.put("imageTextInfoRight", it) }
        picInfo?.let { json.put("picInfo", it) }
        progressTextInfo?.let { json.put("progressTextInfo", it) }
        sameWidthDigitInfo?.let { json.put("sameWidthDigitInfo", it) }
        textInfo?.let { json.put("textInfo", it) }
        return json
    }


    fun bigIslandData(
        firstTitle: String,
        pic:String? = null,
        secondTitle: String? = null,
    ): JSONObject {
        val json = JSONObject()
        json.put("firstTitle",firstTitle)
        if (pic != null){
            json.put("pic",pic)
        }
        if (secondTitle != null){
            json.put("secondTitle",secondTitle)
        }
        return json

    }

}