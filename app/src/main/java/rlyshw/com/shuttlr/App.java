package rlyshw.com.shuttlr;

import android.app.Application;
import android.content.Context;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class App extends Application {
    private static Context mContext;

    public static Context getContext(){
        return mContext;
    }

    public static void setContext(Context mContext){
        App.mContext = mContext;
    }

}
