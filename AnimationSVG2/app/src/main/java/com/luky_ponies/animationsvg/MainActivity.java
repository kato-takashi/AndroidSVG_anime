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

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private MyTimerTask timerTask = null;
    private Timer timer = null;
    private Handler handler = new Handler();

    private PathView pathView;
    private PathView pathView2;


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


        Button stopBtn = (Button) findViewById(R.id.btn_stop);
        Button startBtn = (Button) findViewById(R.id.btn_start);
        pathView = (PathView) findViewById(R.id.pathView);
        pathView2 = (PathView) findViewById(R.id.pathView2);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 稼働中の場合は止める
                if(null != timer){
                    // タイマーをキャンセル
                    timer.cancel();
                    timer = null;
                }
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 稼働中の場合は止める
                if(null != timer){
                    timer.cancel();
                    timer = null;
                }

                // タイマーインスタンスを作成
                timer = new Timer();

                // タイマータスクインスタンスを作成
                timerTask = new MyTimerTask();

                // タイマースケジュールを設定
                timer.schedule(timerTask, 1000, 2000);

            }
        });
////        pathView2.setVisibility(View.GONE);
//
//
//
////        pathView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                pathView.getPathAnimator().
////                        //pathView.getSequentialPathAnimator().
////                                delay(100).
////                        duration(1500).
////                        interpolator(new AccelerateDecelerateInterpolator()).
////                        start();
////            }
////        });
//        pathView.getPathAnimator().
//                //pathView.getSequentialPathAnimator().
//                        delay(0).
//                duration(1000).
//                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
//                    @Override
//                    public void onAnimationStart() {
//                        Toast.makeText(MainActivity.this, "スタート", Toast.LENGTH_SHORT).show();
//                    }
//                }).
//                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
//                    @Override
//                    public void onAnimationEnd() {
//                        Toast.makeText(MainActivity.this, "ストップ", Toast.LENGTH_SHORT).show();
////                        final AlphaAnimation alpha = new AlphaAnimation(1, 0.0f); // 透明度を1から0.1に変化させる
////                        alpha.setDuration(1000); // 3000msかけてアニメーションする
////                        pathView.startAnimation(alpha); // アニメーション適用
////                        pathView2.setVisibility(View.VISIBLE);
////                        pathView2.getPathAnimator().
////                                //pathView.getSequentialPathAnimator().
////                                        delay(100).
////                                duration(1500).
////                                interpolator(new AccelerateDecelerateInterpolator()).
////                                start();
//
//                    }
//                }).
//                interpolator(new AccelerateDecelerateInterpolator()).
//                start();
//
//        pathView2.getPathAnimator().
//                //pathView.getSequentialPathAnimator().
//                        delay(1000).
//                duration(3000).
//                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
//                    @Override
//                    public void onAnimationStart() {
//                        Toast.makeText(MainActivity.this, "スタート", Toast.LENGTH_SHORT).show();
//                    }
//                }).
//                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
//                    @Override
//                    public void onAnimationEnd() {
//                        Toast.makeText(MainActivity.this, "ストップ", Toast.LENGTH_SHORT).show();
////                        pathView.setVisibility(View.GONE);
////                        pathView2.setVisibility(View.GONE);
//
//                    }
//                }).
//                interpolator(new AccelerateDecelerateInterpolator()).
//                start();
//
////        pathView.getSequentialPathAnimator().
////                        delay(100).
////                duration(1500).
////
////                interpolator(new AccelerateDecelerateInterpolator()).
////                start();
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

    private void startEfect(PathView drawline, PathView eraseline){
        drawline.getPathAnimator().
                //pathView.getSequentialPathAnimator().
                        delay(0).
                duration(1000).
                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {
//                        Toast.makeText(MainActivity.this, "スタート", Toast.LENGTH_SHORT).show();
                    }
                }).
                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
//                        Toast.makeText(MainActivity.this, "ストップ", Toast.LENGTH_SHORT).show();
//                        final AlphaAnimation alpha = new AlphaAnimation(1, 0.0f); // 透明度を1から0.1に変化させる
//                        alpha.setDuration(1000); // 3000msかけてアニメーションする
//                        pathView.startAnimation(alpha); // アニメーション適用
//                        pathView2.setVisibility(View.VISIBLE);
//                        pathView2.getPathAnimator().
//                                //pathView.getSequentialPathAnimator().
//                                        delay(100).
//                                duration(1500).
//                                interpolator(new AccelerateDecelerateInterpolator()).
//                                start();

                    }
                }).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();

        eraseline.getPathAnimator().
                //pathView.getSequentialPathAnimator().
                        delay(1000).
                duration(2000).
                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {
                        Toast.makeText(MainActivity.this, "スタート", Toast.LENGTH_SHORT).show();
                    }
                }).
                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        Toast.makeText(MainActivity.this, "ストップ", Toast.LENGTH_SHORT).show();
//                        pathView.setVisibility(View.GONE);
//                        pathView2.setVisibility(View.GONE);

                    }
                }).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();

//        pathView.getSequentialPathAnimator().
//                        delay(100).
//                duration(1500).
//
//                interpolator(new AccelerateDecelerateInterpolator()).
//                start();
    }

    // タイマータスク用のクラス
    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {

                    startEfect(pathView, pathView2);
                }
            });
        }
    }

}


