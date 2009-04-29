package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 8:20:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CucumberSupportLoader implements ApplicationComponent {
  public static final FeatureFileType CUCUMBER_FEATURE = new FeatureFileType();

  public CucumberSupportLoader() {
    
  }

  public static CucumberSupportLoader getInstance() {
      return ApplicationManager.getApplication().getComponent(CucumberSupportLoader.class);
  }

  public FeatureFileType getFileType() {
    return CUCUMBER_FEATURE;
  }


  public void initComponent() {
    ApplicationManager.getApplication().runWriteAction(
      new Runnable() {
        public void run() {
          FileTypeManager.getInstance().registerFileType(CUCUMBER_FEATURE, new String[]{"feature"});
          System.out.println("Registered file type");
        }
      }
    );
  }

  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @NotNull
  public String getComponentName() {
    return "com.pivotallabs.idea.cucumber.CucumberSupportLoader";
  }
}
