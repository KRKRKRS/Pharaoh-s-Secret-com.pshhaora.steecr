package com.pshhaora.steecr;

import static com.pshhaora.steecr.ParpshhaoraseStr.AFKpshhaoraey;
import static com.pshhaora.steecr.ParpshhaoraseStr.OneSpshhaoraignalId;
import static com.pshhaora.steecr.ParpshhaoraseStr.decopshhaorade;

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
        OneSignal.setAppId(decopshhaorade(OneSpshhaoraignalId));

        MyAppsFlyerListener MpshhaoraAF = new MyAppsFlyerListener();
        AppsFlyerLib.getInstance().init(decopshhaorade(AFKpshhaoraey), MpshhaoraAF, this);
        AppsFlyerLib.getInstance().start(this);
        P3S2.ApppshhaorasFl_Id = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        asdhasdkj dad = new asdhasdkj();
        dad.hashCode();


    }

    class asdhasdkj {
        private boolean iasdasdentDisplayed = false;

        String SasdasdFRAGMENT = "statasdasdent";
        String asdaCHOICE = "useasdasdoice";
        private int mRadasdasdhoice = 2;

        public asdhasdkj() {
            doneqrqw();
        }

        private void doneqrqw() {
            for (int i = 10; i < 20; i++) {
                SasdasdFRAGMENT = "" + mRadasdasdhoice;
                asdaCHOICE = "dsd";
                mRadasdasdhoice++;
            }
        }
    }


    static class MyAppsFlyerListener implements AppsFlyerConversionListener {
        @Override
        public void onConversionDataSuccess(Map<String, Object> map) {
            for (String attrName : map.keySet())
                P3S2.statusApppshhaorasFlyer = Objects.requireNonNull(map.get(decopshhaorade("YWZfc3RhdHVz"))).toString();
            if (P3S2.statusApppshhaorasFlyer.equals(decopshhaorade("Tm9uLW9yZ2FuaWM="))) {
                Log.i("MyApp", P3S2.statusApppshhaorasFlyer);
                String campaignStr = Objects.requireNonNull(map.get(decopshhaorade("Y2FtcGFpZ24="))).toString();
                ParpshhaoraseStr parserStr = new ParpshhaoraseStr();
                P3S2.strAppspshhaoraFlyer = parserStr.parpshhaorase(campaignStr);
            }
        }

        @Override
        public void onConversionDataFail(String s) {
            Log.i("MyApp", "AppsFl onConversionDataFail " + s);
            P3S2.afLoadpshhaoraed = true;
        }

        @Override
        public void onAppOpenAttribution(Map<String, String> map) {
            Log.i("MyApp", "AppsFl onAppOpenAttribution");
            P3S2.afLoadpshhaoraed = true;
        }

        @Override
        public void onAttributionFailure(String s) {
            Log.i("MyApp", "AppsFl onAttributionFailure" + s);
            P3S2.afLoadpshhaoraed = true;
        }
    }
}

