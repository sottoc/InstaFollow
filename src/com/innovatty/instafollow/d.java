package com.innovatty.instafollow;

import com.android.vending.billing.util.IabHelper;
import com.android.vending.billing.util.IabResult;

final class d implements com.android.vending.billing.util.IabHelper.OnIabSetupFinishedListener
{

    private MainActivity a;

    d(MainActivity mainactivity)
    {
    	super();
        a = mainactivity;
    }

    public final void onIabSetupFinished(IabResult iabresult)
    {
        try
        {
            if(!iabresult.isSuccess())
            {
                return;
            }
        }
        catch(Exception exception)
        {
            return;
        }
        a.h = true;
        a.g.queryInventoryAsync(a.i);
        return;
    }
}
