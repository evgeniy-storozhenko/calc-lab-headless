@echo off
set filename=%0
for %%F in ("%filename%") do set dirname=%%~dpF

for %%a in (%dirname%plugins\org.eclipse.equinox.launcher_*.jar) do (
	set file=%%~fa
)

java -jar %file%
@echo on