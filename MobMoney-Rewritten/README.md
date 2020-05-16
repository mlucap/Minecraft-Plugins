# MobMoney ReWritten

This allows players to gain whatever currency the server is using by killing hostile mobs. 

## Requirements

You must have [Vault](https://dev.bukkit.org/projects/vault) and any economy plugin that works together with Vault as MobMoney uses the VaultAPI


# Configuration

Without changing the plugin's code it only gives currency when a hostile mob is killed. If you want to change that to a player gaining money if any entity is killed you need to change this

```java
@EventHandler
    public void onKill(EntityDeathEvent event) {
        if(event.getEntity() instanceof Monster) {
            Player player = event.getEntity().getKiller();
            if (player == null) return;

            Random r = new Random();
            int amount = r.nextInt(1000);
            plugin.eco.depositPlayer(player, amount);
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+ $" + amount);
        }
    }

```
Change the third line to say 
```java
if(event.getEntity()) instanceof Mob) {
```