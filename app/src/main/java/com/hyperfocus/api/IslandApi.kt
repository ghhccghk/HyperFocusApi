package com.hyperfocus.api

import org.json.JSONObject

@Suppress("unused", "LocalVariableName", "KotlinConstantConditions", "FunctionName")
object IslandApi {
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

    fun SmallIslandArea(
        combinePicInfo: JSONObject?=null,
        picInfo: JSONObject,
    ): JSONObject {
        val json = JSONObject()
        if (combinePicInfo != null) { json.put("combinePicInfo", combinePicInfo) }
        json.put("picInfo",picInfo)
        return json
    }

    fun SmallIslandData(
        pic: String,
    ): JSONObject{
        val json = JSONObject()
        json.put("pic",pic)
        return json
    }

    fun timerInfo(
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

    fun SameWidthDigitInfo(
        content: String,
        digit:String,
        timeInfo: JSONObject,
        showHighlightColor: Boolean = false,
        turnAnim: Boolean = false,
    ): JSONObject{
        val json = JSONObject()
        json.put("content",content)
        json.put("digit",digit)
        json.put("timeInfo",timeInfo)
        json.put("showHighlightColor",showHighlightColor)
        json.put("turnAnim",turnAnim)
        return json
    }

    fun ShareData(
        content: String,
        title: String,
        pic: String,
        shareContent: String,
        sharePic: String,
    ): JSONObject{
        val json = JSONObject()
        json.put("content",content)
        json.put("title",title)
        json.put("pic",pic)
        json.put("shareContent",shareContent)
        json.put("sharePic",sharePic)
        return json
    }

    fun ProgressTextInfo(
        progressInfo: JSONObject,
        textInfo: JSONObject,
    ): JSONObject {
        val json = JSONObject()
        json.put("progressInfo",progressInfo)
        json.put("textInfo",textInfo)
        return json
    }

    fun PicInfo(
        autoplay: Boolean = false,
        contentDescription: String? = null,
        effectColor: String? = null,
        effectSrc: String? = null,
        loop: Boolean = false,
        number:Int = 1,
        pic: String,
        type: Int = 1,
    ): JSONObject {
        val json = JSONObject()
        json.put("autoplay",autoplay)
        contentDescription?.let { json.put("contentDescription", it) }
        if (effectColor != null){ json.put("effectColor", effectColor) }
        if (effectSrc != null){ json.put("effectSrc", effectSrc) }
        json.put("loop",loop)
        json.put("number",number)
        json.put("pic",pic)
        json.put("type",type)
        return json
    }

    fun ProgressInfo(
        colorReach: String,
        colorUnReach: String,
        isCCW:Boolean = false,
        progress: Int,
    ): JSONObject {
        val json = JSONObject()
        json.put("colorReach",colorReach)
        json.put("colorUnReach",colorUnReach)
        json.put("isCCW",isCCW)
        json.put("progress",progress)
        return json
    }

    fun FixedWidthDigitInfo(
        content: String,
        digit:String,
        showHighlightColor: Boolean = false,
        turnAnim: Boolean = false,
    ): JSONObject {
        val json = JSONObject()
        json.put("content",content)
        json.put("digit",digit)
        json.put("showHighlightColor",showHighlightColor)
        json.put("turnAnim",turnAnim)
        return json
    }

    fun CombinePicInfo(
        picInfo: JSONObject,
        progressInfo: JSONObject,
        smallPicInfo: JSONObject
    ): JSONObject{
        val combine = JSONObject()
        combine.put("picInfo",picInfo)
        combine.put("progressInfo",progressInfo)
        combine.put("smallPicInfo",smallPicInfo)
        return combine
    }

    /**
     * 小米超级岛，图片和文字配置
     * @param picInfo 图片信息
     * @param textInfo 文字信息
     * @param type 标识 left为 1 right 为 2
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

    fun BigIslandAreaToJson(
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