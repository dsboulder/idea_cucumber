package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import java.awt.*;

/**
 * JFlex highlighter colors.
 *
 * @author Alexey Efimov
 */
public interface FeatureHighligherColors {
    TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
            "FEATURE.COMMENT", SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes()
    );
    TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
            "FEATURE.STRING", SyntaxHighlighterColors.STRING.getDefaultAttributes()
    );
    TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
            "FEATURE.NUMBER", SyntaxHighlighterColors.NUMBER.getDefaultAttributes()
    );
    TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(
            "JFLEX.OPTION_KEYWORD", SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    TextAttributesKey WORD = TextAttributesKey.createTextAttributesKey(
            "JFLEX.OPTION_KEYWORD", SyntaxHighlighterColors.JAVA_SEMICOLON.getDefaultAttributes()
    );
    TextAttributesKey BAD_CHARACTER = HighlighterColors.BAD_CHARACTER;
}
