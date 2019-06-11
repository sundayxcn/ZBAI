package custom.sunday.zbautotrade.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import custom.sunday.zbautotrade.utils.ColorUtil;

/**
 * @author apple
 * @decrption 自定义多数据拼接显示文本View
 * @data 2019-05-24
 **/
public class OrderTextView extends AppCompatTextView {
    public static final String SKIN_NAME_SPACE = "http://schemas.android.com/apk/res/color";
    public static final String ATTR_COLOR_TYPE = "colorType";

    //显示的行数
    private int line;
    //一行显示的字符串长度
    private int lineLength;

    private int[] 

    public OrderTextView(Context context) {
        this(context,null);
    }

    public OrderTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public OrderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        String value = attrs.getAttributeValue(SKIN_NAME_SPACE,ATTR_COLOR_TYPE);
        if(value != null) {
            if (value.equals("rise")) {
                setTextColor(ColorUtil.getInstance().getRiseColor());
            } else {
                setTextColor(ColorUtil.getInstance().getFellColor());
            }
        }
    }


    public void setOrderLines(int line){

    }

    public void setLineLength(int lineLength){

    }


    /**
     * 数据个数
     * */
    public void setLineData(@NonNull String... data){

    }

    /**
     * LEFT 左对齐
     * MIDDLE 居中
     * RIGHT 右对齐
     * 对应数据长度
     * */
    public void setLineDataStyle(@NonNull int... style){

    }




}
