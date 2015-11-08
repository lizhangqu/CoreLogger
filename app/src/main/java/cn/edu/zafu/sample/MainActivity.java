package cn.edu.zafu.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.zafu.corelogger.CoreLogger;
import cn.edu.zafu.corelogger.CoreLoggerFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoreLoggerFactory.Builder builder=new CoreLoggerFactory.Builder();
        builder.enableLog().setMinLevel(CoreLogger.CoreLogLevel.WARNING);
        CoreLoggerFactory.init(builder);
        CoreLogger logger=CoreLoggerFactory.getLogger("TAG");
        logger.log("nihao", CoreLogger.CoreLogLevel.WARNING);

    }
}
