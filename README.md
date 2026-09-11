# Yeet

A PaperMC plugin that temp-bans players when they die. Simple hardcore-style death punishment.

## How it works

On `PlayerDeathEvent`, the player is name-banned for `ban-time` minutes with `ban-message`, then kicked. When the ban expires they can rejoin.

Bypass: OPs and anyone with `yeet.notme` skip the ban.

## Requirements

- Paper 1.21.11
- Java 21

## Install

1. Build: `mvn clean package` (or `bun run build`)
2. Copy `target/yeet-*-SNAPSHOT.jar` to your server's `plugins/` folder as `Yeet.jar`
3. Restart server

## Config (`config.yml`)

```yaml
# Time in minutes to ban the player for upon death
ban-time: 15

# Message shown to the player when they are banned
# {time} is replaced with ban-time
ban-message: "You died! You have been banned for {time} minutes."
```

## Permissions

| Permission | Effect | Default |
|---|---|---|
| `yeet.notme` | Bypass death-ban | `op` |

OPs bypass automatically even without the permission node explicitly set.

## Local dev

```powershell
bun run setup-server  # downloads Paper, accepts EULA
bun run dev           # builds + copies plugin + runs server
```

Server files live in `server/` (gitignored).
