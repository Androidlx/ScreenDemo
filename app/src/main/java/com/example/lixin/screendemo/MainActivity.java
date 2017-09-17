package com.example.lixin.screendemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout top_view;
    private View bottom_view;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.title_tv);

        String icon = "icon";
        String from = "张全蛋"+icon;
        String to = "赵铁柱";
        String txt = String.format("%s回复@%s:我是富士康3号流水线的张全蛋，" +
                "英文名叫Micheal Jack，发文名叫helodie Jaqueline。", from, to);

        //设置ClickSpan,为部分文字("icon")添加点击效果
        SpannableString span = new SpannableString(txt);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }
        };

        span.setSpan(clickableSpan,
                txt.indexOf(icon),
                txt.indexOf(icon) + icon.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置ImageSpan,占用可点击文字("icon")的位置

        span.setSpan(new ForegroundColorSpan(Color.parseColor("#00ff00")), txt.indexOf("Jack"), txt.indexOf("Jack") + "Jack".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

//        span.setSpan(new BackgroundColorSpan(Color.parseColor("#ff0000")), txt.indexOf("Jack"), txt.indexOf("Jack") + "Jack".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new UnderlineSpan(), txt.indexOf("Jack"), txt.indexOf("Jack") + "Jack".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);

        //设置一个边界
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        span.setSpan(new ImageSpan(drawable),
                txt.indexOf(icon), txt.indexOf(icon) + icon.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        BitmapDrawable drawable1 = new BitmapDrawable(getResources(), bitmap1);

        //设置一个边界
        drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
//        span.setSpan(new ImageSpan(drawable1), txt.indexOf("Jack"), txt.indexOf("Jack") + "Jack".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置TextView
        tv.setText(span);
//        tv.setHighlightColor(Color.TRANSPARENT);//消除点击时的背景色
//        tv.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
