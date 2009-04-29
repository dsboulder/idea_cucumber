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
    StringBuffer fragment = new StringBuffer();
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
%state SPACES

%%
#.*\n                           { return FeatureTokenTypes.COMMENT; }
[A-Za-z0-9]+            { return FeatureTokenTypes.WORD; }
{WhiteSpace}             { return FeatureTokenTypes.WORD; }
.              { return FeatureTokenTypes.WORD; }


/* keywords */
/*
<SPACES> "Feature"                     { return FeatureTokenTypes.FEATURE; }
<SPACES> "Background"                  { return FeatureTokenTypes.BACKGROUND; }
<SPACES> "Scenario"                    { return FeatureTokenTypes.SCENARIO; }
<SPACES> "Scenario Outline"            { return FeatureTokenTypes.SCENARIO_OUTLINE; }
<SPACES> "Examples"                    { return FeatureTokenTypes.EXAMPLES; }
<SPACES> "Scenarios"                   { return FeatureTokenTypes.SCENARIOS; }
<SPACES> "Given"                       { return FeatureTokenTypes.GIVEN; }
<SPACES> "Then"                        { return FeatureTokenTypes.THEN; }
<SPACES> "And"                         { return FeatureTokenTypes.AND; }
<SPACES> "But"                         { return FeatureTokenTypes.BUT; }

\w+                                    { return FeatureTokenTypes.WORD; }
\n                                     { return FeatureTokenTypes.NEWLINE; }
\"                                     { string.setLength(0); yybegin(STRING); }

<SPACES> {
  \s*                         {}
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

. { /* ignored */ }
*/

