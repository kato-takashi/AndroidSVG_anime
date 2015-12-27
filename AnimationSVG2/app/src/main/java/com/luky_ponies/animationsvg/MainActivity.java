package com.luky_ponies.animationsvg;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private AnimeLoopTask animeLoop = null;
    private Timer AnimeLoopTimer = null;
    private Handler AnimeLoopHandler = new Handler();

    private PathView pathView1;
    private PathView pathView2;
    private PathView pathView3;
    private PathView pathView4;
    private PathView pathView5;

    private DrawSVG drawSVG;
    private ArrayList<PathView> pathViewArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawSVG = new DrawSVG(getApplicationContext());

        Button stopBtn = (Button) findViewById(R.id.btn_stop);
        Button startBtn = (Button) findViewById(R.id.btn_start);
        pathView1 = (PathView) findViewById(R.id.pathView1);
        pathView2 = (PathView) findViewById(R.id.pathView2);
        pathView3 = (PathView) findViewById(R.id.pathView3);
        pathView4 = (PathView) findViewById(R.id.pathView4);
        pathView5 = (PathView) findViewById(R.id.pathView5);


        pathViewArrayList = new ArrayList<PathView>();
        //pathViewArrayListに追加
        pathViewArrayList.add(pathView1);
        pathViewArrayList.add(pathView2);
        pathViewArrayList.add(pathView3);
        pathViewArrayList.add(pathView4);
        pathViewArrayList.add(pathView5);
        Log.d("配列のサイズ", String.valueOf(pathViewArrayList.size()));

        //見た目を隠す
        hidePathView(pathViewArrayList);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 稼働中の場合は止める
                if(null != AnimeLoopTimer){
                    // タイマーをキャンセル
                    AnimeLoopTimer.cancel();
                    AnimeLoopTimer = null;
                }
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 稼働中の場合は止める
                if (null != AnimeLoopTimer) {
                    AnimeLoopTimer.cancel();
                    AnimeLoopTimer = null;
                }
                // タイマーインスタンスを作成
                AnimeLoopTimer = new Timer();
                // タイマータスクインスタンスを作成
                animeLoop = new AnimeLoopTask();
                // タイマースケジュールを設定
                AnimeLoopTimer.schedule(animeLoop, 1000, 2000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // タイマータスク用のクラス
    class AnimeLoopTask extends TimerTask{
        @Override
        public void run() {
            AnimeLoopHandler.post(new Runnable() {
                public void run() {
                    //Randomクラスのインスタンス化
                    Random rnd = new Random();
                    int ran = rnd.nextInt(pathViewArrayList.size());
                    Log.d("乱数", String.valueOf(ran));
                    pathViewArrayList.get(ran).setVisibility(View.VISIBLE);
                    drawSVG.startEfect(pathViewArrayList.get(ran));
                }
            });
        }
    }

    private void hidePathView(ArrayList<PathView> pathViews){
        for(int i = 0; i<pathViews.size(); i++){
            pathViews.get(i).setVisibility(View.INVISIBLE);
        }
    }

}


