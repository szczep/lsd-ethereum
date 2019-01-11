call cfg git 2.18.0

set SOLC_ROOT=%TOOLS_HOME%\solc\0.5.2
if not exist %SOLC_ROOT% call %TOOLSETUP_HOME%\bin\cfg\error

set PATH=%SOLC_ROOT%;%PATH%

set WEB3J_ROOT=%TOOLS_HOME%\web3j\4.0.1
if not exist %WEB3J_ROOT% call %TOOLSETUP_HOME%\bin\cfg\error

set PATH=%WEB3J_ROOT%\bin;%PATH%