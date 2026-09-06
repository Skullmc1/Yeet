# Create server directory if it doesn't exist
if (!(Test-Path -Path "server")) {
    New-Item -ItemType Directory -Path "server"
}

# Download Paper 1.21.11
$paperUrl = "https://api.papermc.io/v2/projects/paper/versions/1.21.11/builds/69/downloads/paper-1.21.11-69.jar"
$outPath = "server/paper.jar"

if (!(Test-Path -Path $outPath)) {
    Write-Host "Downloading Paper 1.21.1..."
    Invoke-WebRequest -Uri $paperUrl -OutFile $outPath
}

# Accept EULA
Set-Content -Path "server/eula.txt" -Value "eula=true"

# Create plugins folder
if (!(Test-Path -Path "server/plugins")) {
    New-Item -ItemType Directory -Path "server/plugins"
}

Write-Host "Server setup complete."
