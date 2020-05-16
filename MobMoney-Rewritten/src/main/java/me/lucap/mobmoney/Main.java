package me.lucap.mobmoney;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public Economy eco;

    @Override
    public void onEnable() {
        System.out.println("MobMoney is starting up");

        getServer().getPluginManager().registerEvents(new MobKillEvent(this), this);


        if(!setupEconomy()) {
            System.out.println(ChatColor.RED + "You must have vault and an Economy plugin in your plugins folder. Mod will be disabled to prevent errors.");
            getServer().getPluginManager().disablePlugin(this);
        }


    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);

        if(economy != null)
            eco = economy.getProvider();
        return (eco != null);

    }


}
