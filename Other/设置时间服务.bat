@echo off 时间服务修改注册表，by kk
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\W32Time\TimeProviders\NtpServer" /v "Enabled" /t REG_DWORD /d 1 /f
reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\services\W32Time\Config" /v "AnnounceFlags" /t REG_DWORD /d 5 /f
netsh advfirewall firewall add rule name="时间服务器" dir=in action=allow protocol=UDP localport="123"
net stop w32time
net start w32time
pause