package com.pivotallabs.idea.cucumber;

import com.intellij.lexer.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.Reader;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 8:39:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureLexer extends FlexAdapter {


  public FeatureLexer(Project project, VirtualFile virtualFile) {
    super(new FeatureFlexLexer((Reader)null));
  }
}
