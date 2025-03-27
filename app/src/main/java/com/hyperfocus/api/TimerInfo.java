package com.hyperfocus.api;

import org.json.JSONObject;

/**
 * Builder for constructing the TimerInfo JSON object.
 * 用于描述通知中涉及的时间信息。
 */
public class TimerInfo {
    private JSONObject timerInfo;

    JSONObject getTimerInfo() {
        return timerInfo;
    }

    private TimerInfo setTimerInfo(JSONObject timerInfo) {
        this.timerInfo = timerInfo;
        return this;
    }

    public static class Builder {
        private int timerType = -1;
        private Long timerWhen;
        private Long timerSystemCurrent;

        /**
         * 设置时间类型。
         *
         * @param timerType 时间类型，负值表示倒计时
         * @return Builder 实例
         */
        public Builder setTimerType(int timerType) {
            this.timerType = timerType;
            return this;
        }

        /**
         * 设置结束时间戳。
         *
         * @param timerWhen 结束时间戳（毫秒）
         * @return Builder 实例
         */
        public Builder setTimerWhen(Long timerWhen) {
            this.timerWhen = timerWhen;
            return this;
        }

        /**
         * 设置当前系统时间戳。
         *
         * @param timerSystemCurrent 当前系统时间戳（毫秒）
         * @return Builder 实例
         */
        public Builder setTimerSystemCurrent(Long timerSystemCurrent) {
            this.timerSystemCurrent = timerSystemCurrent;
            return this;
        }

        /**
         * 构建 TimerInfo 的 JSONObject 对象。
         *
         * @return JSONObject 对象，包含时间信息
         */
        public TimerInfo build() {
            JSONObject timerInfo = new JSONObject();
            try {
                timerInfo.put("timerType", timerType);
                if (timerWhen != null) {
                    timerInfo.put("timerWhen", timerWhen);
                }
                if (timerSystemCurrent != null) {
                    timerInfo.put("timerSystemCurrent", timerSystemCurrent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new TimerInfo().setTimerInfo(timerInfo);
        }
    }
}
