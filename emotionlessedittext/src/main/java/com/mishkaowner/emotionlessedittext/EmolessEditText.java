package com.mishkaowner.emotionlessedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.vdurmont.emoji.EmojiParser;

/**
 * Created by jhkim on 17. 6. 14.
 */

public class EmolessEditText extends AppCompatEditText {
    public EmolessEditText(Context context) {
        super(context);
        init();
    }

    public EmolessEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmolessEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence source, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String orig = s.toString();
                String newStr = EmojiParser.removeAllEmojis(orig);
                if(orig.compareTo(newStr) != 0) {
                    setText(newStr);
                    setSelection(newStr.length());
                }
            }
        });
    }
}
