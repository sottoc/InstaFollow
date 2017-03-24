package com.innovatty.instafollow;

import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Purchase;

final class b implements com.android.vending.billing.util.IabHelper.OnIabPurchaseFinishedListener
{

    private MainActivity a;

    b(MainActivity mainactivity)
    {
    	super();
        a = mainactivity;
    }

    public final void onIabPurchaseFinished(IabResult iabresult, Purchase purchase)
    {
        if(iabresult.isFailure())
        {
            if(iabresult.getResponse() != -1005)
            {
                a.e((new StringBuilder("Purchasing Error: ")).append(iabresult).toString());
            }
        } else
        {
            String s = purchase.getSku();
            if(s.equals("premium"))
            {
                a.a("Thank you for purchasing the Premium Package", "Thanks!");
                MainActivity.b = true;
                a.e();
                a.s();
                a.t();
                return;
            }
            if(s.equals("insight"))
            {
                a.a("Thank you for purchasing the User Insight Pacakge", "Thanks!");
                a.c = true;
                a.e();
                a.t();
                return;
            }
            if(s.equals("engagement"))
            {
                a.a("Thank you for purchasing the Engagement Package", "Thanks!");
                a.d = true;
                a.e();
                a.t();
                return;
            }
            if(s.equals("more"))
            {
                a.a("Thank you for purchasing the Media Insight Package", "Thanks!");
                a.e = true;
                a.e();
                a.t();
                return;
            }
            if(s.equals("all"))
            {
                a.a("Thank you for purchasing All Packages", "Thanks!");
                a.f = true;
                MainActivity.b = true;
                a.c = true;
                a.d = true;
                a.e = true;
                a.e();
                a.s();
                a.t();
                return;
            }
        }
    }
}
