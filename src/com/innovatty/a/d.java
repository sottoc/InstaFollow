package com.innovatty.a;

import android.app.Dialog;
import android.view.View;

final class d implements android.view.View.OnClickListener
{

    private final android.content.SharedPreferences.Editor a;
    private final Dialog b;

    d(android.content.SharedPreferences.Editor editor, Dialog dialog)
    {
    	super();
        a = editor;
        b = dialog;
    }

    public final void onClick(View view)
    {
        if(a != null)
        {
            a.putInt("last_rating_response", 3);
            a.commit();
        }
        b.dismiss();
    }
}
