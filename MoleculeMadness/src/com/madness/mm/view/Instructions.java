package com.madness.mm.view;

import com.madness.mm.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Alex Kahn on 10/20/13.
 */
public class Instructions extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        System.out.println("Instructions that need to be added");
    }
}