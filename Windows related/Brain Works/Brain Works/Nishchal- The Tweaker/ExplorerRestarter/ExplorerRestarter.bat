@echo off
title Explorer Restarter by Nishchal
choice /M "Do you really want to restart explorer?"
IF errorlevel 2 (exit)
IF errorlevel 1 (echo Stopping explorer.exe
				echo .
				echo .
				taskkill /F /IM explorer.exe
				echo Starting explorer.exe
				echo .
				start explorer.exe)
echo .
echo .
echo Done!
echo You may now exit this terminal! Thank you!
pause >nul