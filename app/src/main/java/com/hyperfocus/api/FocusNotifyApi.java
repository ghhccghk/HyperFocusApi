package com.hyperfocus.api;

import android.os.Bundle;

import androidx.core.app.NotificationCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyperfocus.api.info.Template;

import org.json.JSONException;
import org.json.JSONObject;

public class FocusNotifyApi {
    private static final Gson mGson = new GsonBuilder().create();
    private NotificationCompat.Builder mBuilder;
    private Template mTemplate = null;

    public Template build(NotificationCompat.Builder builder) {
        mBuilder = builder;
        return mTemplate = new Template(new Bundle(), this);
    }

    public Bundle create(Bundle picBundle) {
        try {
            JSONObject jsonObject = new JSONObject();
            Bundle bundle = new Bundle();
            String param = mGson.toJson(mTemplate);

            jsonObject.put("param_v2", param);
            bundle.putBundle("miui.focus.pics", picBundle);
            bundle.putString("miui.focus.param", jsonObject.toString());
            mBuilder.addExtras(bundle);
            return bundle;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
