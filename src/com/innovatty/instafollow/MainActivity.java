package com.innovatty.instafollow;

import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.*;
import android.webkit.*;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.ads.*;
import com.innovatty.a.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONObject;

public class MainActivity extends Activity
{
    public final class a extends WebChromeClient
    {

        private MainActivity a;

        public final void onConsoleMessage(String s1, int i1, String s2)
        {
            a.d(s1);
            a.a = (new StringBuilder(String.valueOf(s1))).append(" -- From line ").append(i1).append(" of ").append(s2).toString();
            a.t();
        }

        public final void onExceededDatabaseQuota(String s1, String s2, long l1, long l2, long l3, android.webkit.WebStorage.QuotaUpdater quotaupdater)
        {
            quotaupdater.updateQuota(l2 << 1);
        }

        public final boolean onJsAlert(WebView webview, String s1, String s2, JsResult jsresult)
        {
            jsresult.confirm();
            String s3;
            String s4;
            try{
	            JSONObject jsonobject = new JSONObject(s2);
	            s3 = jsonobject.getString("function");
	            s4 = jsonobject.getString("parameter1");
	            if(s3.equals("syncCookies"))
	            {
	                //a;
	                com.innovatty.instafollow.MainActivity.a();
	            }else if(s3.equals("removeAllCookies")){
	            	a.b();
	            }
	            else if(s3.equals("logout")){
	            	a.c();
	            }else if(s3.equals("refresh")){
	            	a.d();
	            }else if(s3.equals("home")){
	            	a.e();
	            }else if(s3.equals("openURL")){
	            	a.b(s4);
	            }else if(s3.equals("launchApp")){
	            	a.c(s4);
	            }else if(s3.equals("tryToShowRateDialog")){
	            	a.k();
	            }else if(s3.equals("AdMobAdShow")){
	            	//a;
	                MainActivity.l();
	            }else if(s3.equals("AdMobAdHide")){
	            	//a;
	                MainActivity.m();
	            }else if(s3.equals("AdMobBannerAdCreate")){
	            	MainActivity.n();
	            }else if(s3.equals("AdMobBannerAdRemove")){
	            	MainActivity.o();
	            }else if(s3.equals("AdMobInterstitialAdCreate")){
	            	a.a(true);
	            }else if(s3.equals("AdMobInterstitialAdLoad")){
	            	a.a(false);
	            }else if(s3.equals("hideBannerAdBeforeLoadingPage")){
	            	a.p();
	            }else if(s3.equals("showBannerAdBeforeLoadingPage")){
	            	a.q();
	            }else if(s3.equals("upgrade")){
	            	a.f();
	            }else if(s3.equals("getInsightPackage")){
	            	a.g();
	            }else if(s3.equals("getEngagementPackage")){
	            	a.h();
	            }else if(s3.equals("getMorePackage")){
	            	a.i();
	            }else if(s3.equals("getAllPackages")){
	            	a.j();
	            }
            }catch(Exception e){}
            return true;
        }

        public final void onReachedMaxAppCacheSize(long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
        {
            quotaupdater.updateQuota(l1 << 1);
        }

        public a()
        {
        	super();
            a = MainActivity.this;
        }
    }

    public final class b extends WebViewClient
    {

        private MainActivity a;

        public final void onPageFinished(WebView webview, String s1)
        {
            try
            {
                MainActivity _tmp = a;
                com.innovatty.instafollow.MainActivity.a();
                if(s1.startsWith("http://instafollow.elasticbeanstalk.com"))
                {
                    MainActivity.n();
                }
                if(com.innovatty.instafollow.MainActivity.a(a) != null && com.innovatty.instafollow.MainActivity.a(a).isShowing())
                {
                    com.innovatty.instafollow.MainActivity.a(a).dismiss();
                }
                return;
            }
            catch(Exception exception)
            {
                return;
            }
        }

        public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            try
            {
                if(!s1.startsWith("http://instafollow.elasticbeanstalk.com") || a.r())
                {
                    MainActivity.o();
                }
                if(com.innovatty.instafollow.MainActivity.a(a) != null && !com.innovatty.instafollow.MainActivity.a(a).isShowing() && !a.isFinishing())
                {
                    com.innovatty.instafollow.MainActivity.a(a).show();
                }
                return;
            }
            catch(Exception exception)
            {
                return;
            }
        }

        public final void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            Log.i("WEB_VIEW_TEST", (new StringBuilder("error code:")).append(i1).toString());
            super.onReceivedError(webview, i1, s1, s2);
            String s3 = (new StringBuilder("Network Error (")).append(i1).append("): ").append(s1).toString();
            a.a(s3);
        }

        public b()
        {
        	super();
            a = MainActivity.this;
        }
    }


    static boolean b = false;
    private static Context j;
    private static LinearLayout n;
    private static AdView o;
    String a;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    IabHelper g;
    boolean h;
    com.android.vending.billing.util.IabHelper.QueryInventoryFinishedListener i;
    private String k;
    private ProgressDialog l;
    private MenuItem m;
    private InterstitialAd p;
    private boolean q;
    private boolean r;
    private com.android.vending.billing.util.IabHelper.OnIabPurchaseFinishedListener s;

    public MainActivity()
    {
        k = "";
        a = "";
        l = null;
        c = false;
        d = false;
        e = false;
        f = false;
        h = false;
        q = false;
        r = false;
        i = new com.innovatty.instafollow.a(this);
        s = new com.innovatty.instafollow.b(this);
    }

    static ProgressDialog a(MainActivity mainactivity)
    {
        return mainactivity.l;
    }

    private static String a(String s1, int i1)
    {
        char ac[] = s1.toCharArray();
        int j1 = 0;
        do
        {
            if(j1 >= ac.length)
            {
                return String.valueOf(ac);
            }
            ac[j1] = (char)(i1 ^ ac[j1]);
            j1++;
        } while(true);
    }

    public static void a()
    {
        CookieSyncManager.getInstance().sync();
    }

    static void a(MainActivity mainactivity, boolean flag)
    {
        mainactivity.q = false;
    }

    static InterstitialAd b(MainActivity mainactivity)
    {
        return mainactivity.p;
    }

    public static void l()
    {
        if(o != null)
        {
            o.setVisibility(0);
        }
    }

    public static void m()
    {
        if(o != null)
        {
            o.setVisibility(8);
        }
    }

    public static void n()
    {
        if(!b && o == null)
        {
            AdView adview = new AdView(j);
            o = adview;
            adview.setAdUnitId("ca-app-pub-1564155987389943/9682921799");
            o.setAdSize(AdSize.SMART_BANNER);
            n.addView(o);
            AdRequest adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("21286DE8418A798267A1D8575FF9347A").build();
            o.loadAd(adrequest);
        }
    }

    public static void o()
    {
        if(o != null)
        {
            n.removeAllViews();
            o.destroy();
            o = null;
        }
    }

    private void u()
    {
        try
        {
            if(l == null)
            {
                l = new ProgressDialog(this);
                l.setTitle("");
                l.setMessage("Loading ...");
            }
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public final void a(String s1)
    {
        try
        {
            ((WebView)findViewById(R.id.webview)).loadData(Base64.encodeToString((new StringBuilder("<html><body><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td><div align=\"center\"><font color=\"red\">")).append(s1).append("</font></div></td></tr>").append("</table><html><body>").toString().getBytes(), 0), "text/html; charset=utf-8", "base64");
            Toast.makeText(this, s1, 0).show();
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    final void a(String s1, String s2)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s2);
        builder.setMessage(s1);
        builder.setNeutralButton("OK", null);
        builder.create().show();
    }

    public final void a(boolean flag)
    {
        if(b)
        {
            //break MISSING_BLOCK_LABEL_117;
        	return;
        }
        if(p == null)
        {
            p = new InterstitialAd(this);
            p.setAdUnitId("ca-app-pub-1564155987389943/2159654992");
        }
        if(q)
        {
            //break MISSING_BLOCK_LABEL_117;
        	return;
        }
        if(p.isLoaded())
        {
            if(flag)
            {
                try
                {
                    p.show();
                    return;
                }
                catch(Exception exception) { }
            }
            //break MISSING_BLOCK_LABEL_117;
            return;
        }
        AdRequest adrequest;
        p.setAdListener(new c(this, flag));
        adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("21286DE8418A798267A1D8575FF9347A").build();
        p.loadAd(adrequest);
        q = true;
        return;
    }

    public final void b()
    {
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
    }

    public final void b(String s1)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s1)));
    }

    public final void c()
    {
        b();
        ((WebView)findViewById(R.id.webview)).loadUrl((new StringBuilder("http://instafollow.elasticbeanstalk.com/logout.php?ver=2.2.2&app=instafollowfree&dev=")).append(k).append("&premium=").append(String.valueOf(b)).append("&insight=").append(String.valueOf(c)).append("&engagement=").append(String.valueOf(d)).append("&more=").append(String.valueOf(e)).append("&all=").append(String.valueOf(f)).toString());
    }

    public final void c(String s1)
    {
        startActivity(getPackageManager().getLaunchIntentForPackage(s1));
    }

    public final void d()
    {
        ((WebView)findViewById(R.id.webview)).reload();
    }

    final void d(String s1)
    {
        try
        {
            if(s1.startsWith("Failed to setup DB!") && !r)
            {
                p();
                o();
                d();
            }
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public final void e()
    {
        ((WebView)findViewById(R.id.webview)).loadUrl((new StringBuilder("http://instafollow.elasticbeanstalk.com/index.php?ver=2.2.2&app=instafollowfree&dev=")).append(k).append("&action=home&premium=").append(String.valueOf(b)).append("&insight=").append(String.valueOf(c)).append("&engagement=").append(String.valueOf(d)).append("&more=").append(String.valueOf(e)).append("&all=").append(String.valueOf(f)).toString());
    }

    final void e(String s1)
    {
        a(s1, "Error");
    }

    public final void f()
    {
        if(!b)
        {
            if(h)
            {
                g.launchPurchaseFlow(this, "premium", 10001, s);
                return;
            } else
            {
                e("Purchase failed! Check your Google account!");
                return;
            }
        } else
        {
            s();
            return;
        }
    }

    public final void g()
    {
label0:
        {
            if(!c)
            {
                if(!h)
                {
                    break label0;
                }
                g.launchPurchaseFlow(this, "insight", 10001, s);
            }
            return;
        }
        e("Purchase failed! Check your Google account!");
    }

    public final void h()
    {
label0:
        {
            if(!d)
            {
                if(!h)
                {
                    break label0;
                }
                g.launchPurchaseFlow(this, "engagement", 10001, s);
            }
            return;
        }
        e("Purchase failed! Check your Google account!");
    }

    public final void i()
    {
label0:
        {
            if(!e)
            {
                if(!h)
                {
                    break label0;
                }
                g.launchPurchaseFlow(this, "more", 10001, s);
            }
            return;
        }
        e("Purchase failed! Check your Google account!");
    }

    public final void j()
    {
        if(!f)
        {
            if(h)
            {
                g.launchPurchaseFlow(this, "all", 10001, s);
                return;
            } else
            {
                e("Purchase failed! Check your Google account!");
                return;
            }
        } else
        {
            s();
            return;
        }
    }

    public final void k()
    {
        com.innovatty.a.a.a(this);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if(!g.handleActivityResult(i1, j1, intent))
        {
            super.onActivityResult(i1, j1, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if(isTaskRoot())
        	flag = false;
        else{
	        Intent intent = getIntent();
	        if(!intent.hasCategory("android.intent.category.LAUNCHER") || !"android.intent.action.MAIN".equals(intent.getAction()))
	        	flag = false;
	        else
	        	flag = true;
        }
        if(flag)
        {
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        j = getApplicationContext();
        n = (LinearLayout)findViewById(R.id.adLayout);
        SharedPreferences sharedpreferences;
        WebView webview;
        WebSettings websettings;
        try
        {
            k = getPreferences(0).getString("dev", null);
            if(k == null)
            {
                k = UUID.randomUUID().toString();
                android.content.SharedPreferences.Editor editor = getPreferences(0).edit();
                editor.putString("dev", k);
                editor.commit();
            }
        }
        catch(Exception exception)
        {
            k = "";
        }
        sharedpreferences = getPreferences(0);
        b = sharedpreferences.getBoolean("premium", false);
        c = sharedpreferences.getBoolean("insight", false);
        d = sharedpreferences.getBoolean("engagement", false);
        e = sharedpreferences.getBoolean("more", false);
        f = sharedpreferences.getBoolean("all", false);
        r = sharedpreferences.getBoolean("hideBannerAdBeforeLoadingPage", false);
        a = sharedpreferences.getString("lastJsError", "");
        s();
        u();
        webview = (WebView)findViewById(R.id.webview);
        websettings = webview.getSettings();
        websettings.setUserAgentString((new StringBuilder(String.valueOf(websettings.getUserAgentString()))).append(" (InstaFollow)").toString());
        websettings.setJavaScriptEnabled(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        try
        {
            websettings.setDomStorageEnabled(true);
            websettings.setDatabaseEnabled(true);
            websettings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
            websettings.setAllowFileAccess(true);
            websettings.setAppCacheEnabled(true);
            websettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
            websettings.setAppCacheMaxSize(0x500000L);
            websettings.setCacheMode(-1);
            websettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        }
        catch(Exception exception1) { }
        webview.setWebChromeClient(new a());
        webview.setWebViewClient(new b());
        webview.loadUrl((new StringBuilder("http://instafollow.elasticbeanstalk.com/index.php?ver=2.2.2&app=instafollowfree&dev=")).append(k).append("&action=launch&premium=").append(String.valueOf(b)).append("&insight=").append(String.valueOf(c)).append("&engagement=").append(String.valueOf(d)).append("&more=").append(String.valueOf(e)).append("&all=").append(String.valueOf(f)).toString());
        g = new IabHelper(this, (new StringBuilder(String.valueOf(a("HLLGLoDKGbntmnlB<r5GDT@CDDJFDT=DHLLGFbNFDT@DlMpK<Cb}4kS1pcf.]0h*3Pw_k}h@J36wFG0w4dM7SPubwqKiR6*saQPU", 5)))).append(a("mtmU^lB_3iVVQNFaVJSBFQUlshVur3>2Te7Pq_0_7rwlrR6UJS,KjVtHjfc2F]A`oTK}s_PrlWPUL2i0I1b(hBiMA7424I~lebLt", 7)).append(a("sP6md{`Kl.qJYklkchM9SYgI4WxCB*s460i0T0LSBk.WSjG2.o[nXM5mt9[yk197F``H*3628[sLnT6kqcuvfmQ1SnfIM{horDyx", 1)).append(a("LbbPZKs1EH/OnfcJT/5PRU4SAkPhdDrBl0NnlML7aLgPlhlkVcP8aLTRfv2dqfWVDurlmAdDpmdD/8iKNVcmXwIDAQAB", 0)).toString());
        g.enableDebugLogging(false);
        g.startSetup(new d(this));
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        m = menu.findItem(R.id.menu_upgrade);
        if(b)
        {
            m.setVisible(false);
            return true;
        } else
        {
            m.setVisible(true);
            return true;
        }
    }

    public void onDestroy()
    {
        if(isTaskRoot())
        {
            if(o != null)
            {
                o.destroy();
                o = null;
            }
            if(g != null)
            {
                try
                {
                    g.dispose();
                }
                catch(IllegalArgumentException illegalargumentexception)
                {
                    illegalargumentexception.printStackTrace();
                }
            }
            g = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        WebView webview = (WebView)findViewById(R.id.webview);
        if(i1 == 4 && webview.canGoBack())
        {
            webview.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch(menuitem.getItemId()){
        default:
        	return super.onOptionsItemSelected(menuitem);
        case R.id.menu_logout:
        	c();
            return true;
        case R.id.menu_refresh:
        	d();
            return true;
        case R.id.menu_home:
        	e();
            return true;
        case R.id.menu_help:
        	String s1 = "";
        	try{
	            String s2 = URLEncoder.encode(a, "UTF-8");
	            s1 = s2;
        	}catch(Exception e){}
            b((new StringBuilder("http://instafollow.elasticbeanstalk.com/help.php?ver=2.2.2&app=instafollowfree&dev=")).append(k).append("&lastjserror=").append(s1).toString());
            return true;
        case R.id.menu_more:
        	b((new StringBuilder("http://instafollow.elasticbeanstalk.com/more.php?ver=2.2.2&app=instafollowfree&dev=")).append(k).toString());
            return true;
        case R.id.menu_upgrade:
        	f();
            return true;
        }
    }

    public void onPause()
    {
        if(o != null)
        {
            o.pause();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if(o != null)
        {
            o.resume();
        }
        SharedPreferences sharedpreferences = getSharedPreferences("apprater", 0);
        if(!sharedpreferences.getBoolean("app_rated", false))
        {
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putLong("launch_count_since_last_rating_message", 1L + sharedpreferences.getLong("launch_count_since_last_rating_message", 0L));
            if(Long.valueOf(sharedpreferences.getLong("date_of_last_rating_message", 0L)).longValue() == 0L)
            {
                editor.putLong("date_of_last_rating_message", Long.valueOf(System.currentTimeMillis()).longValue());
            }
            editor.commit();
        }
    }

    final void p()
    {
        r = true;
        t();
    }

    final void q()
    {
        r = false;
        t();
    }

    final boolean r()
    {
        return r;
    }

    public final void s()
    {
        if(b)
        {
            if(m != null)
            {
                m.setVisible(false);
            }
            o();
        } else
        if(m != null)
        {
            m.setVisible(true);
            return;
        }
    }

    final void t()
    {
        android.content.SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putBoolean("premium", b);
        editor.putBoolean("insight", c);
        editor.putBoolean("engagement", d);
        editor.putBoolean("more", e);
        editor.putBoolean("all", f);
        editor.putBoolean("hideBannerAdBeforeLoadingPage", r);
        editor.putString("lastJsError", a);
        editor.commit();
    }

}
