# Copy the built plugin to the server's plugins directory
$pluginJar = Get-ChildItem "target/yeet-*-SNAPSHOT.jar" | Select-Object -First 1
if ($null -eq $pluginJar) {
    Write-Error "Plugin JAR not found! Run 'bun run build' first."
    exit 1
}

Copy-Item -Path $pluginJar.FullName -Destination "server/plugins/Yeet.jar" -Force
Write-Host "Plugin copied to server/plugins/Yeet.jar"

# Start the server
cd server
java -Xmx2G -Xms2G -jar paper.jar nogui
