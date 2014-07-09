package am.home.LoginApp;

import android.app.Application;

/**
 * Created by nadya on 7/7/14.
 */
public class LogRegApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Toaster.init(this);
    }
}
