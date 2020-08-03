package com.example.gradientview;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class GradientViewPackage implements ReactPackage {
   @Override
   public List<ViewManager> 
      createViewManagers(ReactApplicationContext reactContext) {
      
      return Arrays.<ViewManager>asList(
         new GradientManager()
      );
   }
   @Override
   public List<NativeModule> createNativeModules(
      ReactApplicationContext reactContext) {
      return new ArrayList<>(); // or list of modules
   }
}