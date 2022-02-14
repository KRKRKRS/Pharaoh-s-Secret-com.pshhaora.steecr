package com.pshhaora.steecr;

import static com.pshhaora.steecr.ParseStr.AFKey;
import static com.pshhaora.steecr.ParseStr.OneSignalId;
import static com.pshhaora.steecr.ParseStr.decode;

import android.app.Application;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.onesignal.OneSignal;

import java.util.Map;
import java.util.Objects;

public class ApplClss extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(decode(OneSignalId));

        MyAppsFlyerListener MAF = new MyAppsFlyerListener();
        AppsFlyerLib.getInstance().init(decode(AFKey), MAF, this);
        AppsFlyerLib.getInstance().start(this);
        P3S2.AppsFl_Id = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        asdhasdkj dad = new asdhasdkj();
        dad.hashCode();


    }

    class asdhasdkj {
        private boolean iasdasdentDisplayed = false;

        String SasdasdFRAGMENT = "statasdasdent";
        String asdaCHOICE = "useasdasdoice";
        private int mRadasdasdhoice = 2;

        public asdhasdkj() {
            doneqrqw ();
        }

        private void doneqrqw () {
            for (int i = 10; i < 20; i++) {
                SasdasdFRAGMENT = ""+mRadasdasdhoice;
                asdaCHOICE = "dsd";
                mRadasdasdhoice ++;
            }
        }
    }


    static class MyAppsFlyerListener implements AppsFlyerConversionListener {
        @Override
        public void onConversionDataSuccess(Map<String, Object> map) {
            for (String attrName : map.keySet())
                P3S2.statusAppsFlyer = Objects.requireNonNull(map.get(decode("YWZfc3RhdHVz"))).toString();
            if (P3S2.statusAppsFlyer.equals(decode("Tm9uLW9yZ2FuaWM="))) {
                Log.i("MyApp", P3S2.statusAppsFlyer);
                String campaignStr = Objects.requireNonNull(map.get(decode("Y2FtcGFpZ24="))).toString();
                ParseStr parserStr = new ParseStr();
                P3S2.strAppsFlyer = parserStr.parse(campaignStr);
            }
        }

        @Override
        public void onConversionDataFail(String s) {
            Log.i("MyApp", "AppsFl onConversionDataFail " + s);
            P3S2.afLoaded = true;
        }

        @Override
        public void onAppOpenAttribution(Map<String, String> map) {
            Log.i("MyApp", "AppsFl onAppOpenAttribution");
            P3S2.afLoaded = true;
        }

        @Override
        public void onAttributionFailure(String s) {
            Log.i("MyApp", "AppsFl onAttributionFailure" + s);
            P3S2.afLoaded = true;
        }
    }
}

