package cn.edu.zafu.corelogger;

import cn.edu.zafu.corelogger.impl.CoreLoggerImpl;

/**
 * User:lizhangqu(513163535@qq.com)
 * Date:2015-11-08
 * Time: 11:32
 */
public class CoreLoggerFactory {
    private static boolean enableLog;
    private static CoreLogger.CoreLogLevel minLevel;
    private static final String DEFAULT_TAG = "CoreLogger";

    static {
        enableLog = false;
        minLevel = CoreLogger.CoreLogLevel.DEBUG;
    }

    public static void init(Builder builder) {
        enableLog = builder.enableLog;
        minLevel = builder.minLevel;
    }


    public static boolean isEnableLog() {
        return enableLog;
    }

    public static CoreLogger.CoreLogLevel getMinLevel() {
        return minLevel;
    }

    public static CoreLogger getLogger() {
        return getLogger(DEFAULT_TAG, null);
    }

    public static CoreLogger getLogger(String tag) {
        return getLogger(tag, null);
    }

    public static CoreLogger getLogger(Class<?> clazz) {
        return getLogger(DEFAULT_TAG, clazz);
    }

    public static CoreLogger getLogger(String tag, Class<?> clazz) {
        return clazz != null ? new CoreLoggerImpl(clazz) : new CoreLoggerImpl(tag);
    }

    public static class Builder {
        private boolean enableLog;
        private CoreLogger.CoreLogLevel minLevel;

        public Builder enableLog() {
            this.enableLog = true;
            return this;
        }

        public Builder disableLog() {
            this.enableLog = false;
            return this;
        }

        public Builder setMinLevel(CoreLogger.CoreLogLevel minLevel) {
            this.minLevel = minLevel;
            return this;
        }

        public Builder build() {
            return this;
        }
    }
}
