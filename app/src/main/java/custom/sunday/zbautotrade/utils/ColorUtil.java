package custom.sunday.zbautotrade.utils;

import android.graphics.Color;

import androidx.annotation.ColorInt;

/**
 * @author apple
 * @decrption
 * @data 2019-05-23
 **/
public class ColorUtil {

    public static final int CHINA = 0;
    public static final int AMERICAN = 1;
    private int style = CHINA;

    private ColorUtil() {

    }

    public static ColorUtil getInstance() {
        return Holder.Instance;
    }

    private boolean isChinaStyle() {
        return style == CHINA;
    }

    public void setStyle(int type){
        style = type;
    }


    /**
     * 上涨颜色
     **/
    @ColorInt
    public int getRiseColor() {
        if (isChinaStyle()) {
            return Color.RED;
        } else {
            return Color.GREEN;
        }
    }

    /**
     * 下跌颜色
     **/
    @ColorInt
    public int getFellColor() {
        if (isChinaStyle()) {
            return Color.GREEN;
        } else {
            return Color.RED;
        }
    }

    private static final class Holder {
        private static final ColorUtil Instance = new ColorUtil();
    }

}
