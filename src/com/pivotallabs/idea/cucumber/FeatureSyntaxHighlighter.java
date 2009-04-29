package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 8:36:34 PM
 * To change this template use File | Settings | File Templates.
 */

public final class FeatureSyntaxHighlighter extends SyntaxHighlighterBase {

    private final FeatureLexer lexer;
    private final Map<IElementType, TextAttributesKey> colors = new HashMap<IElementType, TextAttributesKey>();
    private final Map<IElementType, TextAttributesKey> backgrounds = new HashMap<IElementType, TextAttributesKey>();

    public FeatureSyntaxHighlighter(Project project, VirtualFile virtualFile) {
      System.out.println("Instantiating 'FeatureSyntaxHighlighter': "+project+" "+virtualFile);

        lexer = new FeatureLexer(project, virtualFile);

        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.GIVEN);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.BACKGROUND);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.AND);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.BUT);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.EXAMPLES);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.SCENARIO);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.SCENARIO_OUTLINE);
        fillMap(colors, FeatureHighligherColors.KEYWORD, FeatureTokenTypes.THEN);
        fillMap(colors, FeatureHighligherColors.COMMENT, FeatureTokenTypes.COMMENT);
        fillMap(colors, FeatureHighligherColors.STRING, FeatureTokenTypes.STRING_LITERAL);
        fillMap(colors, FeatureHighligherColors.NUMBER, FeatureTokenTypes.INTEGER_LITERAL);
//        fillMap(colors, FeatureTokenTypes.BRACKETS, FeatureHighligherColors.BRACKETS);
//        fillMap(colors, FeatureTokenTypes.PARENTHESES, FeatureHighligherColors.PARENTHS);
//        fillMap(colors, FeatureTokenTypes.ANGLE_BRACKETS, FeatureHighligherColors.ANGLE_BRACKETS);
//
//        fillMap(colors, FeatureTokenTypes.OPERATORS, FeatureHighligherColors.OPERATION_SIGN);
//
//        colors.put(FeatureTokenTypes.BAD_CHARACTER, FeatureHighligherColors.BAD_CHARACTER);
//        colors.put(FeatureTokenTypes.COMMENT, FeatureHighligherColors.COMMENT);
//        colors.put(FeatureTokenTypes.STRING_LITERAL, FeatureHighligherColors.STRING);
//        colors.put(FeatureTokenTypes.COMMA, FeatureHighligherColors.COMMA);
//
//        backgrounds.put(FeatureTokenTypes.JAVA_CODE, FeatureHighligherColors.JAVA_CODE);
//
//        colors.put(FeatureTokenTypes.MACROS, FeatureHighligherColors.MACROS);
//        colors.put(FeatureTokenTypes.MACROS_REF, FeatureHighligherColors.MACROS_REF);
//
//
//
//        colors.put(FeatureTokenTypes.STATE_REF, FeatureHighligherColors.STATE_REF);
//
//        fillMap(backgrounds, FeatureTokenTypes.REGEXP_SCOPE, FeatureHighligherColors.REGEXP_BACKGROUND);
//        colors.put(FeatureTokenTypes.REGEXP_SYMBOL, FeatureHighligherColors.REGEXP_SYMBOL);
//        colors.put(FeatureTokenTypes.REGEXP_CLASS_SYMBOL, FeatureHighligherColors.REGEXP_CLASS_SYMBOL);
//
//        fillMap(backgrounds, FeatureTokenTypes.OPTION_SCOPE, FeatureHighligherColors.OPTION_BACKGROUND);
//        fillMap(colors, FeatureTokenTypes.OPTION_KEYWORDS, FeatureHighligherColors.OPTION_KEYWORD);
//        colors.put(FeatureTokenTypes.OPTION_PARAMETER, FeatureHighligherColors.OPTION_PARAMETER);
//        colors.put(FeatureTokenTypes.OPTION_SIGN, FeatureHighligherColors.OPTION_SIGN);
//
//        colors.put(FeatureTokenTypes.SECTION_SIGN, FeatureHighligherColors.SECTION_SIGN);
    }

    @NotNull
    public Lexer getHighlightingLexer() {
        return lexer;
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(getAttributeKeys(tokenType, backgrounds), getAttributeKeys(tokenType, colors));
    }

    private TextAttributesKey getAttributeKeys(IElementType tokenType, Map<IElementType, TextAttributesKey> map) {
        TextAttributesKey attributes = map.get(tokenType);
        if (attributes == null && tokenType instanceof FeatureElementType) {
            return map.get(((FeatureElementType)tokenType).getParsedType());
        }
        return map.get(tokenType);
    }
}

