package com.example.gradientview;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableArray;
import android.view.ViewGroup;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class GradientManager extends ViewGroupManager<RNGradientView> {
@Override
public String getName() {
   return "RNGradient";
}
@Override
protected RNGradientView createViewInstance(ThemedReactContext reactContext) { 
   return new RNGradientView(reactContext);
}
@ReactProp(name = "colors")
public void setColors(RNGradientView view, ReadableArray colors) { 
   int size = colors.size();
   int[] colorArray = new int[size];
   for (int i = 0; i < size; i++) {
      colorArray[i] = Color.parseColor(colors.getString(i));
   } 
   GradientDrawable drawable= new GradientDrawable();
   drawable.setColors(colorArray); 
   view.setBackground(drawable); 
 }
// check by defining the props in the JS side in different orders ******************************************
// because the background may not be ready to set the shape if shape is defined first *********************
@ReactProp(name = "shape")
public void setShape(RNGradientView view, String shape) { 
   GradientDrawable drawable = 
               (GradientDrawable)view.getBackground();
   switch (shape) { 
      case "Oval": {
         drawable.setShape(GradientDrawable.OVAL);
         break;
      }
      case "Line": {
         drawable.setShape(GradientDrawable.LINE);
         break;
      }
      default: {
         drawable.setShape(GradientDrawable.RECTANGLE);
         break;
      }
   } 
}
@ReactProp(name = "direction")
public void setDirection(RNGradientView view, String direction) { 
   GradientDrawable drawable = 
                        (GradientDrawable) view.getBackground();
   switch (direction) {      
      case "LEFT_RIGHT": {
         drawable.setOrientation(
            GradientDrawable.Orientation.LEFT_RIGHT
         );
         break;
      }
      case "BL_TR": {
         drawable.setOrientation(
            GradientDrawable.Orientation.BL_TR
         );
         break;
      }
      case "TL_BR": {
         drawable.setOrientation(
            GradientDrawable.Orientation.TL_BR
         );
         break;
      }
      default: {
         drawable.setOrientation(
            GradientDrawable.Orientation.TOP_BOTTOM
         ); 
         break;
      }
   }
}
}