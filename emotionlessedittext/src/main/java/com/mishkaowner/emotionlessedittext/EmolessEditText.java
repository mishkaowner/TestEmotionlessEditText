package com.mishkaowner.emotionlessedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Toast;

import com.vdurmont.emoji.EmojiParser;

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
        addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence source, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence source, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(final Editable s) {
            String orig = s.toString();
            String newStr = EmojiParser.removeAllEmojis(orig);
            if (orig.length() != newStr.length()) {
                Toast.makeText(getContext(), "Emoji is not Allowed...", Toast.LENGTH_SHORT).show();
                setText(newStr);
                setSelection(newStr.length());
            }
        }
    };
}
