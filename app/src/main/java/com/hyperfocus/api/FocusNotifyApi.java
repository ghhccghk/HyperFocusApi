package com.hyperfocus.api;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyperfocus.api.info.ActionInfo;
import com.hyperfocus.api.info.Template;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class FocusNotifyApi {
    private static final Gson mGson = new GsonBuilder().create();
    private NotificationCompat.Builder mBuilder;
    private Template mTemplate = null;

    public Template build(NotificationCompat.Builder builder) {
        mBuilder = builder;
        return mTemplate = new Template(new Bundle(), this);
    }

    public FocusDiy diy(NotificationCompat.Builder builder) {
        return new FocusDiy(builder);
    }

    public Bundle create(List<ActionInfo> actionInfos, Bundle picBundle) {
        try {
            JSONObject jsonObject = new JSONObject();
            Bundle bundle = new Bundle();
            String param = mGson.toJson(mTemplate);

            jsonObject.put("miui.focus.actions", mGson.toJson(actionInfos));
            jsonObject.put("param_v2", param);
            bundle.putBundle("miui.focus.pics", picBundle);
            bundle.putString("miui.focus.param", jsonObject.toString());
            mBuilder.addExtras(bundle);
            return bundle;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static class FocusDiy {
        private final NotificationCompat.Builder mBuilder;
        private Icon picTicker;
        private String ticker;
        private Icon picTickerDark;
        private String aodTitle;
        private Icon aodPic;
        private RemoteViews rv;
        private RemoteViews rvAod;
        private RemoteViews rvNight;
        private RemoteViews rvTiny;
        private RemoteViews rvTinyNight;
        private RemoteViews rvDecoLand;
        private RemoteViews rvDecoLandNight;
        private RemoteViews rvDecoPort;
        private RemoteViews rvDecoPortNight;
        private boolean enableFloat = false;
        private boolean updatable = true;
        private int timeout = 280;
        private String reopen;
        private final Bundle addPics = new Bundle();

        private FocusDiy(NotificationCompat.Builder builder) {
            this.mBuilder = builder;
        }

        public FocusDiy setPicTicker(Icon picTicker) {
            this.picTicker = picTicker;
            return this;
        }

        public FocusDiy setTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public FocusDiy setPicTickerDark(Icon picTickerDark) {
            this.picTickerDark = picTickerDark;
            return this;
        }

        public FocusDiy setRv(RemoteViews rv) {
            this.rv = rv;
            return this;
        }

        public FocusDiy setRvAod(RemoteViews rvAod) {
            this.rvAod = rvAod;
            return this;
        }

        public FocusDiy setRvNight(RemoteViews rvNight) {
            this.rvNight = rvNight;
            return this;
        }

        public FocusDiy setRvTiny(RemoteViews rvTiny) {
            this.rvTiny = rvTiny;
            return this;
        }

        public FocusDiy setRvTinyNight(RemoteViews rvTinyNight) {
            this.rvTinyNight = rvTinyNight;
            return this;
        }

        public FocusDiy setRvDecoLand(RemoteViews rvDecoLand) {
            this.rvDecoLand = rvDecoLand;
            return this;
        }

        public FocusDiy setRvDecoLandNight(RemoteViews rvDecoLandNight) {
            this.rvDecoLandNight = rvDecoLandNight;
            return this;
        }

        public FocusDiy setRvDecoPort(RemoteViews rvDecoPort) {
            this.rvDecoPort = rvDecoPort;
            return this;
        }

        public FocusDiy setRvDecoPortNight(RemoteViews rvDecoPortNight) {
            this.rvDecoPortNight = rvDecoPortNight;
            return this;
        }

        public FocusDiy setEnableFloat(boolean enableFloat) {
            this.enableFloat = enableFloat;
            return this;
        }

        public FocusDiy setAddPics(String name, Icon icon) {
            this.addPics.putParcelable("miui.focus.pic_" + name, icon);
            return this;
        }

        public FocusDiy setAodTitle(String aodTitle) {
            this.aodTitle = aodTitle;
            return this;
        }

        public FocusDiy setAodPic(Icon aodPic) {
            this.aodPic = aodPic;
            return this;
        }

        public FocusDiy setUpdatable(boolean updatable) {
            this.updatable = updatable;
            return this;
        }

        public FocusDiy setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public FocusDiy setReopen(String reopen) {
            this.reopen = reopen;
            return this;
        }

        public Bundle create() {
            Bundle focusBundle = new Bundle();
            Bundle picsBundle = new Bundle();
            Bundle customBundle = new Bundle();

            customBundle.putString("ticker", ticker);
            customBundle.putBoolean("enableFloat", enableFloat);
            customBundle.putString("tickerPic", "miui.focus.pic_ticker");
            customBundle.putBoolean("updatable", updatable);
            if (reopen != null)
                customBundle.putString("reopen", reopen);
            customBundle.putInt("timeout", timeout);

            if (picTickerDark != null) {
                customBundle.putString("tickerPicDark", "miui.focus.pic_ticker_dark");
                picsBundle.putParcelable("miui.focus.pic_ticker_dark", picTickerDark);
            }
            if (aodTitle != null && rvAod == null) {
                customBundle.putString("aodTitle", aodTitle);
                if (aodPic != null) {
                    picsBundle.putParcelable("miui.focus.pic_aod", aodPic);
                    customBundle.putString("aodPic", "miui.focus.pic_aod");
                }
            }
            picsBundle.putParcelable("miui.focus.pic_ticker", picTicker);
            picsBundle.putAll(addPics);
            focusBundle.putParcelable("miui.focus.param.custom", customBundle);
            focusBundle.putString("miui.focus.ticker", ticker);
            focusBundle.putParcelable("miui.focus.pics", picsBundle);
            focusBundle.putParcelable("miui.focus.rv", rv);
            if (aodTitle == null && rvAod != null)
                focusBundle.putParcelable("miui.focus.rvAod", rvAod);
            if (rvNight != null)
                focusBundle.putParcelable("miui.focus.rvNight", rvNight);
            if (rvTiny != null)
                focusBundle.putParcelable("miui.focus.rv.tiny", rvTiny);
            if (rvTinyNight != null)
                focusBundle.putParcelable("miui.focus.rv.tinyNight", rvTinyNight);
            if (rvDecoLand != null)
                focusBundle.putParcelable("miui.focus.rv.deco.land", rvDecoLand);
            if (rvDecoLandNight != null)
                focusBundle.putParcelable("miui.focus.rv.deco.landNight", rvDecoLandNight);
            if (rvDecoPort != null)
                focusBundle.putParcelable("miui.focus.rv.deco.port", rvDecoPort);
            if (rvDecoPortNight != null)
                focusBundle.putParcelable("miui.focus.rv.deco.portNight", rvDecoPortNight);

            mBuilder.addExtras(focusBundle);
            return focusBundle;
        }
    }
}
