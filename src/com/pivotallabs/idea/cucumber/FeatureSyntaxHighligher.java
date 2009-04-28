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

    private final JFlexHighlighterLexer lexer;
    private final Map<IElementType, TextAttributesKey> colors = new HashMap<IElementType, TextAttributesKey>();
    private final Map<IElementType, TextAttributesKey> backgrounds = new HashMap<IElementType, TextAttributesKey>();

    public FeatureSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        lexer = new FeatureLexer(project, virtualFile);

        fillMap(colors, FeatureTokenTypes.BRACES, JFlexHighlighterColors.BRACES);
        fillMap(colors, FeatureTokenTypes.BRACKETS, JFlexHighlighterColors.BRACKETS);
        fillMap(colors, FeatureTokenTypes.PARENTHESES, JFlexHighlighterColors.PARENTHS);
        fillMap(colors, FeatureTokenTypes.ANGLE_BRACKETS, JFlexHighlighterColors.ANGLE_BRACKETS);

        fillMap(colors, FeatureTokenTypes.OPERATORS, JFlexHighlighterColors.OPERATION_SIGN);

        colors.put(FeatureTokenTypes.BAD_CHARACTER, JFlexHighlighterColors.BAD_CHARACTER);
        colors.put(FeatureTokenTypes.COMMENT, JFlexHighlighterColors.COMMENT);
        colors.put(FeatureTokenTypes.STRING_LITERAL, JFlexHighlighterColors.STRING);
        colors.put(FeatureTokenTypes.COMMA, JFlexHighlighterColors.COMMA);

        backgrounds.put(FeatureTokenTypes.JAVA_CODE, JFlexHighlighterColors.JAVA_CODE);

        colors.put(FeatureTokenTypes.MACROS, JFlexHighlighterColors.MACROS);
        colors.put(FeatureTokenTypes.MACROS_REF, JFlexHighlighterColors.MACROS_REF);



        colors.put(FeatureTokenTypes.STATE_REF, JFlexHighlighterColors.STATE_REF);

        fillMap(backgrounds, FeatureTokenTypes.REGEXP_SCOPE, JFlexHighlighterColors.REGEXP_BACKGROUND);
        colors.put(FeatureTokenTypes.REGEXP_SYMBOL, JFlexHighlighterColors.REGEXP_SYMBOL);
        colors.put(FeatureTokenTypes.REGEXP_CLASS_SYMBOL, JFlexHighlighterColors.REGEXP_CLASS_SYMBOL);

        fillMap(backgrounds, FeatureTokenTypes.OPTION_SCOPE, JFlexHighlighterColors.OPTION_BACKGROUND);
        fillMap(colors, FeatureTokenTypes.OPTION_KEYWORDS, JFlexHighlighterColors.OPTION_KEYWORD);
        colors.put(FeatureTokenTypes.OPTION_PARAMETER, JFlexHighlighterColors.OPTION_PARAMETER);
        colors.put(FeatureTokenTypes.OPTION_SIGN, JFlexHighlighterColors.OPTION_SIGN);

        colors.put(FeatureTokenTypes.SECTION_SIGN, JFlexHighlighterColors.SECTION_SIGN);
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
        if (attributes == null && tokenType instanceof JFlexElementType) {
            return map.get(((JFlexElementType)tokenType).getParsedType());
        }
        return map.get(tokenType);
    }
}

