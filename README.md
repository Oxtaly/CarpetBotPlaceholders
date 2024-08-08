# Carpet Bot Placeholders

## This is a pretty simple fabric mod that adds configurable prefixes for carpet bots and shadowed players

** **

## Placeholders

### It adds 3 placeholders that you can use along with other mods like [Styled Playerlist](https://github.com/Patbox/StyledPlayerList) and [Styled Chat](https://github.com/Patbox/StyledChat):
###### *Prefixes can be changed in the config (example provided below), each under the same name, `carpet_entity_prefix` being both placeholders merged does not have it's own config*
 - ###### `%carpetbotplaceholders:carpet_bot_prefix%` (Placeholder for carpet bot only, empty if not a bot)
 - ###### `%carpetbotplaceholders:shadowed_player_prefix%` (Placeholder for shadowed players only, empty if not shadowed)
 - ###### `%carpetbotplaceholders:carpet_entity_prefix%` (Placeholder that takes either the shadowed players prefix if shadowed player or bot prefix if bot, empty if neither)

** **

## Config
####  To reload the config in game, use the command `/carpetbotplaceholders reload`
*Example & default config, file located here: `./config/CarpetBotPlaceholders.json`*
```json
{
  "config_version_DO_NOT_TOUCH": "1.0.0",
  "carpet_bot_prefix": "<dark_gray>[<red>Bot</red>]</dark_gray> ",
  "shadowed_player_prefix": "<dark_gray>[<aqua>AFK</aqua>]</dark_gray> "
}
```
** **
## Permissions 

#### To use the command `/carpetbotplaceholders reload`, you either need LuckPerms and the permission `carpetbotplaceholders.command.carpetbotplaceholders.reload`, or you need to be oped (have permission level 4)