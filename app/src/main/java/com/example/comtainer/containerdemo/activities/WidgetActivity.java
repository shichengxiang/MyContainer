package com.example.comtainer.containerdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.comtainer.containerdemo.BaseActivity;
import com.example.comtainer.containerdemo.R;
import com.example.comtainer.containerdemo.utils.Snacky;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class WidgetActivity extends AppCompatActivity {

     Snacky.Builder snack;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_widget);
          ButterKnife.bind (this);
          snack= Snacky.builder ().setActivity (this);
     }
     @OnClick({R.id.btn_snackBar_action,R.id.btn_snackBar_err,R.id.btn_snackBar_info,R.id.btn_snackBar_success})
     public void onClick(View view){
          switch (view.getId ()){
               case R.id.btn_snackBar_err:
                    snack.error ().show ();
                    break;
               case R.id.btn_snackBar_info:
                    snack.info ().show ();
                    break;
               case R.id.btn_snackBar_success:
                    snack.setText ("测试一下").info ().show ();
                    break;
               case R.id.btn_snackBar_action:
                    break;
          }
     }

}
