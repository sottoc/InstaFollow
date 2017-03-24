package com.innovatty.a;

import android.app.Dialog;
import android.view.View;

final class c implements android.view.View.OnClickListener
{
    private final android.content.SharedPreferences.Editor a;
    private final Dialog b;

    c(android.content.SharedPreferences.Editor editor, Dialog dialog)
    {
    	super();
        a = editor;
        b = dialog;
    }

    public final void onClick(View view)
    {
        a.putInt("last_rating_response", 2);
        a.commit();
        b.dismiss();
    }
}
