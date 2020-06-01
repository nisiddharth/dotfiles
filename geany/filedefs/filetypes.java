[build-menu]
FT_00_LB=_Compile
FT_00_CM=javac --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web "%f"
FT_00_WD=
FT_01_LB=
FT_01_CM=
FT_01_WD=
FT_02_LB=
FT_02_CM=
FT_02_WD=
EX_00_LB=_Execute
EX_00_CM=javac --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web "%f" && time java --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web "%e" < input.txt
EX_00_WD=
