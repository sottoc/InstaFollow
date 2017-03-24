package com.innovatty.a;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class a
{
    public a()
    {
    }

    public static void a(Context context)
    {
        long l;
        SharedPreferences sharedpreferences;
        l = 0L;
        sharedpreferences = context.getSharedPreferences("apprater", 0);
        if(sharedpreferences.getBoolean("app_rated", false))
        	return;
        android.content.SharedPreferences.Editor editor;
        long l1;
        int i;
        editor = sharedpreferences.edit();
        l1 = sharedpreferences.getLong("launch_count_since_last_rating_message", l);
        Long long1 = Long.valueOf(sharedpreferences.getLong("date_of_last_rating_message", l));
        if(long1.longValue() == l)
        {
            editor.putLong("date_of_last_rating_message", Long.valueOf(System.currentTimeMillis()).longValue());
        } else
        {
            l = (System.currentTimeMillis() - long1.longValue()) / 0x5265c00L;
        }
        i = sharedpreferences.getInt("last_rating_response", 0);
        if(i != 0)
        {
        	if(i == 1)
            	return;
            if(i == 2)
            {
                if(l1 >= 3L || l >= 1L)
                {
                    a(context, editor);
                }
            } else
            if(i == 3 && (l1 >= 10L || l >= 3L))
            {
                a(context, editor);
            }
        }else if(l1 >= 3L || l >= 1L)
        {
            a(context, editor);
        }
        editor.commit();
    }

    private static void a(Context context, android.content.SharedPreferences.Editor editor)
    {
        Dialog dialog = new Dialog(context);
        dialog.setTitle("Rate InstaFollow");
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        TextView textview = new TextView(context);
        textview.setText("If you enjoy using InstaFollow, please take a moment to rate it. Thanks for your support!");
        textview.setWidth(i);
        textview.setPadding(4, 0, 4, 10);
        linearlayout.addView(textview);
        Button button = new Button(context);
        button.setText("Rate InstaFollow");
        button.setOnClickListener(new com.innovatty.a.b(editor, context, dialog));
        linearlayout.addView(button);
        Button button1 = new Button(context);
        button1.setText("Remind me later");
        button1.setOnClickListener(new c(editor, dialog));
        linearlayout.addView(button1);
        Button button2 = new Button(context);
        button2.setText("No, thanks");
        button2.setOnClickListener(new com.innovatty.a.d(editor, dialog));
        linearlayout.addView(button2);
        editor.putLong("launch_count_since_last_rating_message", 0L);
        editor.putLong("date_of_last_rating_message", System.currentTimeMillis());
        editor.commit();
        dialog.setContentView(linearlayout);
        dialog.show();
    }

    //public com.google.android.gms.common.api.d a(com.google.android.gms.common.api.b b1, com.google.android.gms.appdatasearch.GetRecentContextCall.Request request)
    //{
    //    return b1.a(new com.google.android.gms.appdatasearch.a(request, b1));
    //}
}
