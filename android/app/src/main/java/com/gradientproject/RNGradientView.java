package com.example.gradientview;
import android.app.Context;
import android.view.LinearLayout;
class RNGradientView extends LinearLayout {
   public RNGradientView(Context context) {
      super(context);
      int match= LinearLayout.LayoutParams.MATCH_PARENT; 
      LinearLayout.LayoutParams params = 
                new LinearLayout.LayoutParams(match, match);
      setLayoutParams(params); 
   }
}