I use JavaFX with IntelliJ Ultimate 
Project User register 

To open the application need to install 21 JDK link:
https://www.oracle.com/java/technologies/downloads/?er=221886#java11-windows

if you can not open the application check uninstall JDK are you use it and then install 21 JDK and open the application. 

## Database configuration
Credentials are read from environment variables (never hardcoded):

| Variable | Default | Description |
| :--- | :--- | :--- |
| `DB_USER` | `root` | MySQL user |
| `DB_PASSWORD` | (required) | MySQL password |

Windows (PowerShell), then restart IntelliJ:
```powershell
[Environment]::SetEnvironmentVariable("DB_PASSWORD", "<your_password>", "User")
```

