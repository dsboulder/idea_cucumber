package com.pivotallabs.idea.cucumber;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.pivotallabs.idea.cucumber.FeatureTokenTypes;

%%

%class FeatureFlexLexer
%implements FlexLexer
%final
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

%{
    StringBuffer string = new StringBuffer();
    private int braceCounter = 0;
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {EndOfLineComment}

EndOfLineComment     = "#" {InputCharacter}* {LineTerminator}


DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING

%%

/* keywords */
<YYINITIAL> "Feature"           { return FeatureTokenTypes.FEATURE; }
<YYINITIAL> "Background"        { return FeatureTokenTypes.BACKGROUND; }
<YYINITIAL> "Scenario"          { return FeatureTokenTypes.SCENARIO; }
<YYINITIAL> "Scenario Outline"  { return FeatureTokenTypes.SCENARIO_OUTLINE; }
<YYINITIAL> "Examples"          { return FeatureTokenTypes.EXAMPLES; }
<YYINITIAL> "Scenarios"         { return FeatureTokenTypes.SCENARIOS; }
<YYINITIAL> "Given"             { return FeatureTokenTypes.GIVEN; }
<YYINITIAL> "Then"              { return FeatureTokenTypes.THEN; }
<YYINITIAL> "And"               { return FeatureTokenTypes.AND; }
<YYINITIAL> "But"               { return FeatureTokenTypes.BUT; }

<YYINITIAL> {
  /* literals */
  {DecIntegerLiteral}            { return FeatureTokenTypes.INTEGER_LITERAL; }
  \"                             { string.setLength(0); yybegin(STRING); }

  /* comments */
  {Comment}                      { /* ignore */ }
 
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   return FeatureTokenTypes.STRING_LITERAL; }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* error fallback */
.|\n                             { throw new Error("Illegal character <"+
                                                    yytext()+">"); }

