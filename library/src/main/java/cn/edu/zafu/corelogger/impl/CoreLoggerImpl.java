package cn.edu.zafu.corelogger.impl;

import android.util.Log;

import cn.edu.zafu.corelogger.CoreLogger;
import cn.edu.zafu.corelogger.CoreLoggerFactory;

/**
 * User:lizhangqu(513163535@qq.com)
 * Date:2015-11-08
 * Time: 11:32
 */
public class CoreLoggerImpl implements CoreLogger {
    private final String tag;

    public CoreLoggerImpl(String tag) {
        this.tag = tag;
    }

    public CoreLoggerImpl(Class<?> clazz) {
        this(clazz.getSimpleName());
    }

    @Override
    public void log(String msg, CoreLogLevel level) {
        if (!CoreLoggerFactory.isEnableLog()) {
            return;
        }
        if (level.getLevel() < CoreLoggerFactory.getMinLevel().getLevel()) {
            return;
        }

        switch (level) {
            case DEBUG:
                Log.d(tag,msg);
                break;
            case INFO:
                Log.i(tag,msg);
                break;
            case WARNING:
                Log.w(tag,msg);
                break;
            case ERROR:
                Log.e(tag,msg);
                break;
            default:
                break;
        }
    }

    @Override
    public void log(String msg, CoreLogLevel level, Throwable throwable) {
        if (!CoreLoggerFactory.isEnableLog()) {
            return;
        }
        if (level.getLevel() < CoreLoggerFactory.getMinLevel().getLevel()) {
            return;
        }

        switch (level) {
            case DEBUG:
                Log.d(tag,msg,throwable);
                break;
            case INFO:
                Log.i(tag,msg,throwable);
                break;
            case WARNING:
                Log.w(tag,msg,throwable);
                break;
            case ERROR:
                Log.e(tag,msg,throwable);
                break;
            default:
                break;
        }
    }
}
