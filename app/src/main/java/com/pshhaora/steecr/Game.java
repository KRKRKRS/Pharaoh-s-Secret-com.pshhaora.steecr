package com.pshhaora.steecr;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game extends AppCompatActivity {

    private TextView msg;
    private ImageView img1, img2, img3;
    private Wheel wheel1, wheel2, wheel3;
    private Button btn;
    private boolean isStarted;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        img1 = findViewById(R.id.im1);
        img2 = findViewById(R.id.im2);
        img3 = findViewById(R.id.im3);
        btn = findViewById(R.id.start_btn);
        msg = findViewById(R.id.textVeiw);

    }


    public void spin(View view) {
        if (isStarted) {
            wheel1.stopWheel();
            wheel2.stopWheel();
            wheel3.stopWheel();

            if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                msg.setText("You win the big prize");
            } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                    || wheel1.currentIndex == wheel3.currentIndex) {
                msg.setText("Little Prize");
            } else {
                msg.setText("You lose");
            }

            btn.setText("Start");
            isStarted = false;

        } else {

            wheel1 = new Wheel(new Wheel.WheelListener() {
                @Override
                public void newImage(final int img) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img1.setImageResource(img);
                        }
                    });
                }
            }, randomLong(0, 200));

            wheel1.start();

            wheel2 = new Wheel(new Wheel.WheelListener() {
                @Override
                public void newImage(final int img) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img2.setImageResource(img);
                        }
                    });
                }
            },  randomLong(150, 400));

            wheel2.start();

            wheel3 = new Wheel(new Wheel.WheelListener() {
                @Override
                public void newImage(final int img) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img3.setImageResource(img);
                        }
                    });
                }
            },  randomLong(150, 400));

            wheel3.start();

            btn.setText("Stop");
            msg.setText("");
            isStarted = true;
        }
    }
}


class Wheel extends Thread {

    interface WheelListener {
        void newImage(int img);
    }

    private static int[] imgs = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8};
    public int currentIndex;
    private final WheelListener wheelListener;
    private final long startIn;
    private boolean isStarted;

    public Wheel(WheelListener wheelListener, long startIn) {
        this.wheelListener = wheelListener;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;
    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == imgs.length) {
            currentIndex = 0;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
        }

        while (isStarted) {
            try {
                long frameDuration = 199;
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
            }

            nextImg();

            if (wheelListener != null) {
                wheelListener.newImage(imgs[currentIndex]);
            }
        }
    }

    public void stopWheel() {
        isStarted = false;
    }
}
