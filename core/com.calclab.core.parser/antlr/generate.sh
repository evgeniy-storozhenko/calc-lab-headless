ANTLR_LOC=$HOME/antlr
TARGET=../src/com/calclab/core/parser/internal/
java -cp `ls -1 $ANTLR_LOC/*.jar | tr "\\n" ":"` org.antlr.Tool CalcLab.g

mv CalcLab.tokens $TARGET/
mv CalcLabLexer.java $TARGET/
mv CalcLabParser.java $TARGET/
