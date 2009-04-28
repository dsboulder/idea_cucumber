package com.pivotallabs.idea.cucumber;

import com.intellij.psi.tree.IElementType;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 9:48:58 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FeatureTokenTypes {
  IElementType STRING_LITERAL = new FeatureElementType("STRING_LITERAL");
  IElementType INTEGER_LITERAL = new FeatureElementType("INTEGER_LITERAL");
  IElementType SCENARIO_OUTLINE = new FeatureElementType("SCENARIO_OUTLINE");
  IElementType SCENARIO = new FeatureElementType("SCENARIO");
  IElementType FEATURE = new FeatureElementType("FEATURE");
  IElementType BACKGROUND = new FeatureElementType("BACKGROUND");
  IElementType SCENARIOS = new FeatureElementType("SCENARIOS");
  IElementType EXAMPLES = new FeatureElementType("EXAMPLES");
  IElementType GIVEN = new FeatureElementType("GIVEN");
  IElementType THEN = new FeatureElementType("THEN");
  IElementType AND = new FeatureElementType("AND");
  IElementType BUT = new FeatureElementType("BUT");

}
