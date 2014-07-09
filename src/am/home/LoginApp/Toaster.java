package am.home.LoginApp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nadya on 7/7/14.
 */
public class Toaster {

    private static Toast currentToast;
    private static Context context;

    public static void init(Context context) {
        Toaster.context = context;
    }

    public static void showToast(String text)
    {
        /*if(currentToast == null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        currentToast.show();

*/
        if(currentToast == null)
        {
            currentToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }

        currentToast.setText(text);
        currentToast.setDuration(android.widget.Toast.LENGTH_SHORT);
        currentToast.show();
    }


}
