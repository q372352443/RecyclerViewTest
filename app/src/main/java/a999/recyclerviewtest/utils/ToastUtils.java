package a999.recyclerviewtest.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ToastUtils
 * Created by 999 on 2016/10/15.
 */

public class ToastUtils extends Toast{

    private static Toast mToast;
    private static TextView tv;

    public ToastUtils(Context context) {
        super(context);
    }

    public static void show(Context mContext, String mMessage){
        if ("".equals(mMessage)){
            return;
        }
        if (mToast == null) {
            mToast = initView(mContext,mMessage);
        } else {
            tv.setText(mMessage);
        }
        mToast.show();
    }

    private static ToastUtils initView(Context mContext, String mMessage){
        ToastUtils result = new ToastUtils(mContext);
        tv = new TextView(mContext);
        tv.setText(mMessage);
        tv.setTextColor(Color.WHITE);
        tv.setBackgroundColor(Color.BLACK);
        result.setView(tv);
        result.setDuration(Toast.LENGTH_SHORT);
        return result;
    }
}
