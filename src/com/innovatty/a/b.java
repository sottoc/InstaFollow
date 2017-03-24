package com.innovatty.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

final class b implements android.view.View.OnClickListener
{

    private final android.content.SharedPreferences.Editor a;
    private final Context b;
    private final Dialog c;

    b(android.content.SharedPreferences.Editor editor, Context context, Dialog dialog)
    {
    	super();
        a = editor;
        b = context;
        c = dialog;
    }

    public final void onClick(View view)
    {
        if(a != null)
        {
            a.putInt("last_rating_response", 1);
            a.putBoolean("app_rated", true);
            a.commit();
        }
        b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.innovatty.instafollow")));
        c.dismiss();
    }
}
