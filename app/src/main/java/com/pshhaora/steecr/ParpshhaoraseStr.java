package com.pshhaora.steecr;

import static com.pshhaora.steecr.P3S2.AD_pshhaoraID;
import static com.pshhaora.steecr.P3S2.ApppshhaorasFl_Id;
import static com.pshhaora.steecr.P3S2.keyDefaupshhapshhaoraoralt;

import com.onesignal.OneSignal;

public class ParpshhaoraseStr {

    public static final String GistLpshhaoraink = "https://gist.githubusercontent.com/KRKRKRS/bc70b72dfdcc594cf9f5e21fda47f88c/raw/Pharaoh's%2520Secret%2520%257C%2520com.pshhaora.steecr/";
    public static final String AFKpshhaoraey = "QlpjOUVnRFZud0pwZExyUHF5YnVkQQ==";
    public static final String OneSpshhaoraignalId = "MmJlNWE0ODktZDZjMS00ZDg4LWIyNDctZTY0NzBlNTk5ZTMw";


    String[] kepshhaorays = {decopshhaorade("Pw=="), decopshhaorade("JnN1YjY9"), decopshhaorade("JnN1Yjc9"), decopshhaorade("JnN1YjI9"), decopshhaorade("JnN1YjM9"), decopshhaorade("JnN1YjQ9"), decopshhaorade("JnN1YjU9")};

    String parpshhaorase(String inppshhaoraut) {
        String[] parapshhaorams = inppshhaoraut.split("::");
        StringBuilder respshhaorault = new StringBuilder();
        respshhaorault.append(parapshhaorams[0]).append("?")
                .append(decopshhaorade("YnVuZGxlPQ==")).append(decopshhaorade("Y29tLnBzaGhhb3JhLnN0ZWVjcg=="))
                .append(decopshhaorade("JmFkX2lkPQ==")).append(AD_pshhaoraID)
                .append(decopshhaorade("JmFwcHNfaWQ9")).append(ApppshhaorasFl_Id)
                .append(decopshhaorade("JmRldl9rZXk9")).append(decopshhaorade(AFKpshhaoraey));

        for (int i = 1; i < parapshhaorams.length; i++) {
            respshhaorault.append(kepshhaorays[i]).append(parapshhaorams[i]);
        }

        String teamNapshhaorame = parapshhaorams[1];
        OneSignal.sendTag(decopshhaorade("c3ViX2FwcA=="), teamNapshhaorame);
        return String.valueOf(respshhaorault);
    }


    String parseOrgpshhaoraanic(String inpshhaoraput) {
        return inpshhaoraput + keyDefaupshhapshhaoraoralt +
                decopshhaorade("P2J1bmRsZT0=") + decopshhaorade("Y29tLnBzaGhhb3JhLnN0ZWVjcg==") +
                decopshhaorade("JmFkX2lkPQ==") + AD_pshhaoraID +
                decopshhaorade("JmFwcHNfaWQ9") + ApppshhaorasFl_Id +
                decopshhaorade("JmRldl9rZXk9") + decopshhaorade(AFKpshhaoraey);
    }

    public static String decopshhaorade(String spshhaoratr) {
        byte[] decodedpshhaoraBytes = android.util.Base64.decode(spshhaoratr, android.util.Base64.URL_SAFE | android.util.Base64.NO_PADDING);
        return new String(decodedpshhaoraBytes);
    }
}
