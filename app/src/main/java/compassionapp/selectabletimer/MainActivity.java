package compassionapp.selectabletimer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class MainActivity extends Activity {

    Button btnStart, btnStop, btnAddMin;
    TextView textViewTime;
    EditText timerTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnAddMin =(Button) findViewById(R.id.btnAddMin);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        timerTime = (EditText) findViewById(R.id.timerTime);
        long lTime;
//        String $Time = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(lTime),
//                TimeUnit.MILLISECONDS.toMinutes(lTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(lTime)),
//                TimeUnit.MILLISECONDS.toSeconds(lTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(lTime)));


        textViewTime.setText("00:30:00");



        lTime=3000;
        CounterClass timer = new CounterClass(lTime,1000);
        btnStart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Countertimer.start();
            }
        });

        btnStop.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                timer.cancel();
            }
        });


        btnAddMin.setOnClickListener((v) -> {
            lTime += 10000;
        });
    }

    @TargetApi(Build.VERSION_CODES. GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            textViewTime.setText("Completed.");
        }



    }
}
