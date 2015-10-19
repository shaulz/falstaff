grammar All;
@lexer::members {public String language;}

dummy : '' ;

DigitSequence
    :   Digit+
    ;
    
fragment
Digit
    :   [0-9]
    ;

AlphaSequence
    :   Alpha+
    ;
        
fragment
Alpha
    :   [a-zA-Z]
    ;    
        
SignSequence
    :   Sign+
    ;
        
fragment
Sign
    :   [\!\@\#\$\%\\\^\&\*\(\)\-\_\+\=\~\`\[\]\{\}\|\:\;\"\'\,\.\<\>\/\?]
    ;
    
HexadecimalDigitSequence
    :   HexadecimalDigit+
    ;

fragment
HexadecimalDigit
    :   [0-9a-fA-F]
    ;
    
Whitespace
    :   [ \t]+
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
    ;
	
Other
	: ~([\r\n \t!@#$%\\^&*()\-_+=~`\[\]{}|:;\"\',.<>/?] | [0-9a-zA-Z]) {System.out.println("!!!!!!!!!!!!!!!!!!!unknown character " + getText());}
	-> skip
    ;

BlockComment
    :   '/*' .*? '*/'
    {language.equals("c") || language.equals("java")}?
	-> skip
    ;

LineComment
    :   '//' ~[\r\n]*
    {language.equals("c") || language.equals("java")}?
    -> skip
    ;
   