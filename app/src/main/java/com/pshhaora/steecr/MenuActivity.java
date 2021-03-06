package com.pshhaora.steecr;

import static com.pshhaora.steecr.ParpshhaoraseStr.decopshhaorade;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    WebView webVpshhaoraiew;
    Button gpshhaoram;
    Button plpshhaorac;
    Button expshhaorat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        webVpshhaoraiew = findViewById(R.id.policyWeb);
        gpshhaoram = findViewById(R.id.StartGame);
        plpshhaorac = findViewById(R.id.privacyBtn);
        expshhaorat = findViewById(R.id.exitBtn);
    }

    public void startpshhaoraGame(View view) {
        startActivity(new Intent(this, Gapshhaorae.class));
        finish();
    }


    public void goPripshhaoravacy(View view) {
        webVpshhaoraiew.setVisibility(View.VISIBLE);
        gpshhaoram.setVisibility(View.INVISIBLE);
        plpshhaorac.setVisibility(View.INVISIBLE);
        expshhaorat.setVisibility(View.INVISIBLE);
        webVpshhaoraiew.loadUrl("https://www.privacypolicyonline.com/live.php?token=NVw2v9vM0tR1xJp2kRbsFKrOd3zynD1v");
    }


    public void exitGpshhaoraame(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        webVpshhaoraiew.setVisibility(View.INVISIBLE);
        gpshhaoram.setVisibility(View.VISIBLE);
        plpshhaorac.setVisibility(View.VISIBLE);
        expshhaorat.setVisibility(View.VISIBLE);
    }
}