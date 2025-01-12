package de.RunZ64.unifiedExtender;

import de.RunZ64.unifiedExtender.collector.CollectorCollections;
import de.RunZ64.unifiedExtender.collector.collector;
import dev.cubxity.plugins.metrics.api.UnifiedMetrics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required."); //
            Bukkit.getPluginManager().disablePlugin(this);
        }

        RegisteredServiceProvider<UnifiedMetrics> registration = getServer().getServicesManager().getRegistration(UnifiedMetrics.class);
        if (registration != null) {
            UnifiedMetrics api = registration.getProvider();
            api.getMetricsManager().registerCollection(new CollectorCollections());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
