package wzq.nothing;

import android.app.Application;

import wzq.nothing.util.Timber;


/**
 * Created by wangziqiang on 2015/8/19.
 */
public class NothingApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
//        else {
//            Timber.plant(new CrashReportingTree());
//        }
    }
}
