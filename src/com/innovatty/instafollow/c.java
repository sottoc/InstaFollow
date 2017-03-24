package com.innovatty.instafollow;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

final class c extends AdListener
{

    private MainActivity a;
    private final boolean b;

    c(MainActivity mainactivity, boolean flag)
    {
    	super();
        a = mainactivity;
        b = flag;
    }

    public final void onAdFailedToLoad(int i)
    {
        super.onAdFailedToLoad(i);
        MainActivity.a(a, false);
    }

    public final void onAdLoaded()
    {
        super.onAdLoaded();
        if(MainActivity.b(a).isLoaded() && b)
        {
            MainActivity.b(a).show();
        }
        MainActivity.a(a, false);
    }
}
