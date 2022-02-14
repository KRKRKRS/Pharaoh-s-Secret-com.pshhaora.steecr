package com.pshhaora.steecr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    WebView webView;
    Button gm;
    Button plc;
    Button ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        webView = findViewById(R.id.policyWeb);
        gm = findViewById(R.id.StartGame);
        plc = findViewById(R.id.privacyBtn);
        ext = findViewById(R.id.exitBtn);
    }

    public void startGame(View view) {
        startActivity(new Intent(this, Game.class));
        finish();
    }


    public void goPrivacy(View view) {
        webView.setVisibility(View.VISIBLE);
        gm.setVisibility(View.INVISIBLE);
        plc.setVisibility(View.INVISIBLE);
        ext.setVisibility(View.INVISIBLE);
        webView.loadUrl("https://www.privacypolicyonline.com/live.php?token=NVw2v9vM0tR1xJp2kRbsFKrOd3zynD1v");
    }


    public void exitGame(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        webView.setVisibility(View.INVISIBLE);
        gm.setVisibility(View.VISIBLE);
        plc.setVisibility(View.VISIBLE);
        ext.setVisibility(View.VISIBLE);
    }
}