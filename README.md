# Carpet Bot Placeholders

###### This mod is a pretty simple fabric mod that adds configurable prefixes for carpet bots and shadowed players

** **

### It adds 3 placeholders that you can use along with other mods like [Styled Playerlist](https://github.com/Patbox/StyledPlayerList) and [Styled Chat](https://github.com/Patbox/StyledChat):
 - ###### `carpet_bot_prefix` (Placeholder for carpet bot only, under the config option of the same name, returns empty if not a bot)
 - ###### `shadowed_player_prefix` (Placeholder for shadowed players only, under the config option of the same name, returns empty if not shadowed)
 - ###### `carpet_entity_prefix` (Placeholder that takes either the shadowed players prefix if shadowed player or bot prefix if bot, returns empty if neither )

** **

### To reload the config in game, use the command `/carpetbotplaceholders reload`
*Example config, file located here: `./config/CarpetBotPlaceholders.json`*
```json
{
  "config_version_DO_NOT_TOUCH": "1.0.0",
  "enable_mod": true,
  "carpet_bot_prefix": "<dark_gray>[<red>Bot</red>]</dark_gray> ",
  "shadowed_player_prefix": "<dark_gray>[<aqua>AFK</aqua>]</dark_gray> "
}
```
** **