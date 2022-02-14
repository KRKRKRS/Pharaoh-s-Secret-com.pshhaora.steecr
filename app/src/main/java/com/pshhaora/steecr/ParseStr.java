package com.pshhaora.steecr;

import static com.pshhaora.steecr.P3S2.AD_ID;
import static com.pshhaora.steecr.P3S2.AppsFl_Id;
import static com.pshhaora.steecr.P3S2.keyDefault;

import com.onesignal.OneSignal;

public class ParseStr {

    public static final String GistLink = "https://gist.githubusercontent.com/KRKRKRS/bc70b72dfdcc594cf9f5e21fda47f88c/raw/Pharaoh's%2520Secret%2520%257C%2520com.pshhaora.steecr/";
    public static final String AFKey = "QlpjOUVnRFZud0pwZExyUHF5YnVkQQ==";
    public static final String OneSignalId = "MmJlNWE0ODktZDZjMS00ZDg4LWIyNDctZTY0NzBlNTk5ZTMw";


    String[] keys = {decode("Pw=="), decode("JnN1YjY9"), decode("JnN1Yjc9"), decode("JnN1YjI9"), decode("JnN1YjM9"), decode("JnN1YjQ9"), decode("JnN1YjU9")};

    String parse(String input) {
        String[] params = input.split("::");
        StringBuilder result = new StringBuilder();
        result.append(params[0]).append("?")
                .append(decode("YnVuZGxlPQ==")).append(decode("Y29tLmV0Z3B5LnJzaWVjaA=="))
                .append(decode("JmFkX2lkPQ==")).append(AD_ID)
                .append(decode("JmFwcHNfaWQ9")).append(AppsFl_Id)
                .append(decode("JmRldl9rZXk9")).append(decode(AFKey));

        for (int i = 1; i < params.length; i++) {
            result.append(keys[i]).append(params[i]);
        }

        String teamName = params[1];
        OneSignal.sendTag(decode("c3ViX2FwcA=="), teamName);
        return String.valueOf(result);
    }


    String parseOrganic(String input) {
        return input + keyDefault +
                decode("P2J1bmRsZT0=") + "com.pshhaora.steecr" +
                decode("JmFkX2lkPQ==") + AD_ID +
                decode("JmFwcHNfaWQ9") + AppsFl_Id +
                decode("JmRldl9rZXk9") + decode(AFKey);
    }

    public static String decode(String str) {
        byte[] decodedBytes = android.util.Base64.decode(str, android.util.Base64.URL_SAFE | android.util.Base64.NO_PADDING);
        return new String(decodedBytes);
    }
}
