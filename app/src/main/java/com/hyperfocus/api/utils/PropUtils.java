/*
 * This file is part of HyperCeiler.

 * HyperCeiler is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.

 * Copyright (C) 2023-2025 HyperCeiler Contributions
 */

/*
 * 这里复用了 HyperCeilier 的代码，已经经过原作者同意,这里复用的代码不会带有GPL3传染性，商业使用请保留本项目的开源地址
 * */

package com.hyperfocus.api.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemProperties;
import android.util.Log;


@SuppressLint("PrivateApi")
public class PropUtils {
    private static final String TAG = "PropUtils";

    public static String getProp(Context context, String name) {
        try {
            return classLoaderMethod(context, name);
        } catch (Throwable e) {
            Log.e(TAG, "PropUtils classLoader getProp String", e);
            return "";
        }
    }

    public static boolean getProp(String name, boolean def) {
        try {
            return SystemProperties.getBoolean(name, def);
        } catch (Throwable e) {
            Log.e(TAG, "PropUtils getProp int", e);
            return false;
        }
    }

    public static int getProp(String name, int def) {
        try {
            return SystemProperties.getInt(name, def);
        } catch (Throwable e) {
            Log.e(TAG, "PropUtils getProp int", e);
            return 0;
        }
    }

    public static long getProp(String name, long def) {
        try {
            return SystemProperties.getLong(name, def);
        } catch (Throwable e) {
            Log.e(TAG, "PropUtils getProp long", e);
            return 0L;
        }
    }

    public static String getProp(String key, String defaultValue) {
        try {
            return SystemProperties.get(key, defaultValue);
        } catch (Throwable throwable) {
            Log.e("getProp", "key get e: " + key + " will return default: " + defaultValue + " e:" + throwable);
            return defaultValue;
        }
    }

    public static String getProp(String name) {
        try {
            return SystemProperties.get(name);
        } catch (Throwable e) {
            Log.e(TAG, "PropUtils getProp String no def", e);
            return "";
        }
    }

    private static String classLoaderMethod(Context context, String name) throws Throwable {
        ClassLoader classLoader = context.getClassLoader();
        return InvokeUtils.callStaticMethod("android.os.SystemProperties", classLoader,
                "get", new Class[]{String.class}, name);
    }
}
