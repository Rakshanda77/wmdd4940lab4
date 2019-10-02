package com.example.diceout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DieView extends android.support.v7.widget.AppCompatImageView {
    String[] names = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    String[] category = {"diamonds", "hearts", "spades", "clubs"};

    int name;
    int categories;
    Random rand;


    private Context context;

    public DieView(Context context) {
        super(context);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setImageResource(R.drawable.black_joker);
        this.context = context;
    }

    public void roll() {
        name = (int) (Math.random() * 13);
        categories = (int) (Math.random() * 4);

        try {
            InputStream stream = context.getAssets().open(names[name] + "_of_" + category[categories] + ".png");
            Drawable d = Drawable.createFromStream(stream, null);
            setImageDrawable(d);

        } catch (IOException e) {
                  e.printStackTrace();
                }

       }
       public int getValue() {
        return name;
    }
}
