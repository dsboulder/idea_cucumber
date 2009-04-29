package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.options.colors.ColorSettingsPages;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: pivotal
 * Date: Apr 28, 2009
 * Time: 4:38:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureEditorColorsManager implements ApplicationComponent {
  public FeatureEditorColorsManager() {
  }

  public void initComponent() {
    ColorSettingsPages.getInstance().registerPage(new FeatureColorPage());
  }

  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @NotNull
  public String getComponentName() {
    return "FeatureEditorColorsManager";
  }
}
