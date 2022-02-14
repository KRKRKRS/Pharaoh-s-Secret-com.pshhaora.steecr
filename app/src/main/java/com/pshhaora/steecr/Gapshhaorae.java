package com.pshhaora.steecr;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Gapshhaorae extends AppCompatActivity {


    private TextView mspshhaora;
    private ImageView impshhaorag1, impshhaorag2, impshhaorag3;
    private Whepshhaorael whepshhaorael1, whpshhaoraeel2, whepshhaorael3;
    private Button pshhaora;
    private boolean isStapshhaorarted;

    public static final Random RANpshhaoraDOM = new Random();

    public static long randopshhaoramLong(long lowpshhaoraer, long upppshhaoraer) {
        return lowpshhaoraer + (long) (RANpshhaoraDOM.nextDouble() * (upppshhaoraer - lowpshhaoraer));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        impshhaorag1 = findViewById(R.id.im1);
        impshhaorag2 = findViewById(R.id.im2);
        impshhaorag3 = findViewById(R.id.im3);
        pshhaora = findViewById(R.id.start_btn);
        mspshhaora = findViewById(R.id.textVeiw);

    }


    public void pshhaoras(View view) {
        if (isStapshhaorarted) {
            whepshhaorael1.stopWpshhaoraheel();
            whpshhaoraeel2.stopWpshhaoraheel();
            whepshhaorael3.stopWpshhaoraheel();

            if (whepshhaorael1.currentpshhaoraIndex == whpshhaoraeel2.currentpshhaoraIndex && whpshhaoraeel2.currentpshhaoraIndex == whepshhaorael3.currentpshhaoraIndex) {
                mspshhaora.setText(R.string.big_win);
            } else if (whepshhaorael1.currentpshhaoraIndex == whpshhaoraeel2.currentpshhaoraIndex || whpshhaoraeel2.currentpshhaoraIndex == whepshhaorael3.currentpshhaoraIndex
                    || whepshhaorael1.currentpshhaoraIndex == whepshhaorael3.currentpshhaoraIndex) {
                mspshhaora.setText(R.string.win);
            } else {
                mspshhaora.setText(R.string.lose);
            }

            pshhaora.setText(R.string.strt);
            isStapshhaorarted = false;

        } else {

            whepshhaorael1 = new Whepshhaorael(img -> runOnUiThread(() -> impshhaorag1.setImageResource(img)), randopshhaoramLong(0, 200));

            whepshhaorael1.start();

            whpshhaoraeel2 = new Whepshhaorael(img -> runOnUiThread(() -> impshhaorag2.setImageResource(img)), randopshhaoramLong(150, 400));

            whpshhaoraeel2.start();

            whepshhaorael3 = new Whepshhaorael(img -> runOnUiThread(() -> impshhaorag3.setImageResource(img)), randopshhaoramLong(150, 400));

            whepshhaorael3.start();

            pshhaora.setText(R.string.stp);
            mspshhaora.setText("");
            isStapshhaorarted = true;
        }
    }
}


class Whepshhaorael extends Thread {

    interface WheelLipshhaorastener {
        void newImapshhaorage(int impshhaorag);
    }

    private static final int[] ipshhaoramgs = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8};
    public int currentpshhaoraIndex;
    private final WheelLipshhaorastener wheelLipshhaorastener;
    private final long starpshhaoratIn;
    private boolean isStapshhaorarted;

    public Whepshhaorael(WheelLipshhaorastener wheelLipshhaorastener, long starpshhaoratIn) {
        this.wheelLipshhaorastener = wheelLipshhaorastener;
        this.starpshhaoratIn = starpshhaoratIn;
        currentpshhaoraIndex = 0;
        isStapshhaorarted = true;
    }

    public void nexpshhaoratImg() {
        currentpshhaoraIndex++;

        if (currentpshhaoraIndex == ipshhaoramgs.length) {
            currentpshhaoraIndex = 0;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(starpshhaoratIn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (isStapshhaorarted) {
            try {
                long frameDuration = 199;
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nexpshhaoratImg();

            if (wheelLipshhaorastener != null) {
                wheelLipshhaorastener.newImapshhaorage(ipshhaoramgs[currentpshhaoraIndex]);
            }
        }
    }

    public void stopWpshhaoraheel() {
        isStapshhaorarted = false;
    }
}
