package com.innovatty.instafollow;

import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Inventory;

final class a
    implements com.android.vending.billing.util.IabHelper.QueryInventoryFinishedListener
{

    private MainActivity a;

    a(MainActivity mainactivity)
    {
    	super();
        a = mainactivity;
    }

    public final void onQueryInventoryFinished(IabResult iabresult, Inventory inventory)
    {
        if(iabresult.isFailure())
        {
            return;
        }
        boolean flag = MainActivity.b;
        boolean flag1 = a.c;
        boolean flag2 = a.d;
        boolean flag3 = a.e;
        boolean flag4 = a.f;
        a.f = inventory.hasPurchase("all");
        if(a.f)
        {
            MainActivity.b = true;
            a.c = true;
            a.d = true;
            a.e = true;
        } else
        {
            MainActivity.b = inventory.hasPurchase("premium");
            a.c = inventory.hasPurchase("insight");
            a.d = inventory.hasPurchase("engagement");
            a.e = inventory.hasPurchase("more");
        }
        if(flag != MainActivity.b || flag1 != a.c || flag2 != a.d || flag3 != a.e || flag4 != a.f)
        {
            a.e();
        }
        a.s();
        a.t();
    }
}
