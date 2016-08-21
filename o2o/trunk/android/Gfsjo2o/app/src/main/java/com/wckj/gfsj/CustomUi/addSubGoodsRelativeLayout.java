package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.OwerToastShow;

/**
 * Created by Administrator on 2016/8/21.
 */
public class addSubGoodsRelativeLayout extends RelativeLayout implements View.OnClickListener {
    private View childView;
    private ImageButton subbt;
    private TextView edt;
    private ImageButton addbt;
    private int num=1;

    public addSubGoodsRelativeLayout(Context context) {
        super(context);
        initView();
    }

    public addSubGoodsRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    public addSubGoodsRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        childView = View.inflate(getContext(), R.layout.layout_add_sub, null);
                subbt = (ImageButton) childView.findViewById(R.id.subbt);
        addbt = (ImageButton) childView.findViewById(R.id.addbt);
        edt = (TextView) childView.findViewById(R.id.edt);
        subbt.setOnClickListener(this);
        addbt.setOnClickListener(this);
        addView(childView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            得到输入框里的数字
            case R.id.addbt:
                String numString = edt.getText().toString();
//            进行判断为空或是没文字设置为0
                if (numString.equals("")) {
                    edt.setText("1");
                } else {
//                    当点击 - 的时候一次递减（num--）
//                    if (v.getTag().equals("-")) {
//                        判断（大于0的才能往下减）
//                        if (++num < 0)  //先加，再判断
//                        {
//                            num--;
//                            Toast.makeText(MainActivity.this, "请输入一个大于0的数字",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            edt.setText(String.valueOf(num));
//                        }
//                    } else if (v.getTag().equals("+")) {
                    if (--num <= 0)  //先减，再判断
                    {
                        num++;
                        OwerToastShow.show("不能小于等于0");
                    } else {
                        edt.setText(String.valueOf(num));
                    }
                }
                break;
            case R.id.subbt:
                String str = edt.getText().toString();
//            进行判断为空或是没文字设置为0
                if (str.equals("")) {
                    edt.setText("1");
                } else {
                    if (++num <= 0)  //先加，再判断
                    {
                        num--;
                        OwerToastShow.show("不能小于等于0");
                    } else {
                        edt.setText(String.valueOf(num));
                    }
                    break;
                }
        }
        }

//    String numString = s.toString();
//    if(numString == null || numString.equals(""))
//    {
//        num = 0;
//    }
//    else {
//        int numInt = Integer.parseInt(numString);
//        if (numInt < 0)
//        {
//            Toast.makeText(MainActivity.this, "请输入一个大于0的数字",
//                    Toast.LENGTH_SHORT).show();
//        } else
//        {
//            //设置EditText光标位置 为文本末端
//            edt.setSelection(edt.getText().toString().length());
//            num = numInt;
//
//        }
}