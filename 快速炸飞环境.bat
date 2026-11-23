@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion

set SOURCE_DIR=.\_hj_jar

echo by sf. ovo

if not exist "%SOURCE_DIR%" (
    echo [错误] 源目录不存在
    pause
    exit /b 1
)

dir "%SOURCE_DIR%\*.jar" /b >nul 2>&1
if errorlevel 1 (
    echo [错误] 没有找到 jar 文件
    pause
    exit /b 1
)

echo 请选择gradle所在文件夹
for /f "usebackq delims=" %%i in (`powershell -NoProfile -Command "$OutputEncoding=[Console]::OutputEncoding=[Text.Encoding]::UTF8; Add-Type -AssemblyName System.Windows.Forms; $d=New-Object Windows.Forms.FolderBrowserDialog; $d.Description='请选择 .gradle 文件夹'; if($d.ShowDialog() -eq 'OK'){Write-Host $d.SelectedPath}"`) do set GRADLE_PATH=%%i

if "%GRADLE_PATH%"=="" (
    echo 未选择文件夹，操作取消
    pause
    exit /b 0
)

if "%GRADLE_PATH:~-1%"=="\" set GRADLE_PATH=%GRADLE_PATH:~0,-1%

echo.
echo 选择的文件夹: %GRADLE_PATH%

if not exist "%GRADLE_PATH%" (
    echo [错误] 路径不存在
    pause
    exit /b 1
)

set TARGET_DIR=%GRADLE_PATH%\caches\forge_gradle\maven_downloader\net\minecraftforge\forge\1.20.1-47.4.20
echo 目标目录: %TARGET_DIR%
echo.



if not exist "%TARGET_DIR%" (
    echo 目录不存在
    EXIT
)

copy /Y "%SOURCE_DIR%\*.jar" "%TARGET_DIR%\"
if errorlevel 1 (
    echo [错误] 复制失败
    pause
    exit /b 1
)

echo.
echo [成功] 复制完成！
dir "%TARGET_DIR%\*.jar" /b
echo.


echo 5喵后自动关闭
ping 127.0.0.1 -n 5 >nul
EXIT