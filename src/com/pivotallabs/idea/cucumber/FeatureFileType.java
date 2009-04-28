package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 8:22:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureFileType extends LanguageFileType {
  protected FeatureFileType() {
    super(new CucumberFeatureLanguage());
  }

  @NotNull
  public String getName() {
    return "Cucumber Feature";
  }

  @NotNull
  public String getDescription() {
    return "A plaintext cucumber feature file.";
  }

  @NotNull
  public String getDefaultExtension() {
    return "feature";
  }

  public Icon getIcon() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
