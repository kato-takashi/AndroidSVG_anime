package com.luky_ponies.animationsvg;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;

/**
 * Created by katoTakashi on 15/12/27.
 */
public class DrawSVG {
    private Context context;
    private static int DRAW_SPEED = 800;
    private static int FEED_SPEED = 500;

    public DrawSVG(Context context) {
        this.context = context;
    }

    public void startEfect(final PathView drawline, final PathView eraseline) {
        drawline.getPathAnimator().
                delay(0).
                duration(DRAW_SPEED).
                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {
//                        Toast.makeText(context, "スタート", Toast.LENGTH_SHORT).show();
                        drawline.setVisibility(View.VISIBLE);
                    }
                }).
                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        //Toast.makeText(MainActivity.this, "エンド", Toast.LENGTH_SHORT).show();
                        //フェードアウトアニメーション"feedout"を宣言
                        //ちなみに(1,0)を(0,1)に変更するとフェードインになるよ！
                        AlphaAnimation feedout = new AlphaAnimation(1, 0);
                        // アニメーションリスナの登録
                        feedout.setAnimationListener(new Animation.AnimationListener() {
                                                         @Override
                                                         public void onAnimationStart(Animation animation) {

                                                         }

                                                         @Override
                                                         public void onAnimationEnd(Animation animation) {
                                                            drawline.setVisibility(View.INVISIBLE);
                                                         }

                                                         @Override
                                                         public void onAnimationRepeat(Animation animation) {

                                                         }
                                                     }
                            );
                        //フェードアウトするまでの時間。単位はmsec。
                        feedout.setDuration(FEED_SPEED);
                        //imv2にフェードアウトアニメーションを適用する
                        drawline.startAnimation(feedout);
                    }
                }).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();

//        eraseline.getPathAnimator().
//                //pathView.getSequentialPathAnimator().
//                        delay(1000).
//                duration(2000).
//                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
//                    @Override
//                    public void onAnimationStart() {
//                        //Toast.makeText(MainActivity.this, "スタート", Toast.LENGTH_SHORT).show();
//                        eraseline.setVisibility(View.VISIBLE);
//                    }
//                }).
//                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
//                    @Override
//                    public void onAnimationEnd() {
//                        Toast.makeText(context, "ストップ", Toast.LENGTH_SHORT).show();
//                        drawline.setVisibility(View.GONE);
//                        eraseline.setVisibility(View.GONE);
//
//                    }
//                }).
//                interpolator(new AccelerateDecelerateInterpolator()).
//                start();
    }
}
