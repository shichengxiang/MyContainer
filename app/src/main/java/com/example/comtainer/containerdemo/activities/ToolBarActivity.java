package com.example.comtainer.containerdemo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.comtainer.containerdemo.R;

public class ToolBarActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_tool_bar);
          Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
          setSupportActionBar (toolbar);
          FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
          fab.setOnClickListener (new View.OnClickListener () {
               @Override
               public void onClick(View view) {
                    Snackbar.make (view, "can you see the error ?", Snackbar.LENGTH_LONG)
                            .setActionTextColor (Color.parseColor ("#f9f900")).show ();
               }
          });
     }
}
