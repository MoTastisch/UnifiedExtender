package de.RunZ64.unifiedExtender.collector;

import dev.cubxity.plugins.metrics.api.metric.collector.Collector;
import dev.cubxity.plugins.metrics.api.metric.data.GaugeMetric;
import dev.cubxity.plugins.metrics.api.metric.data.Metric;
import dev.cubxity.plugins.metrics.api.metric.data.MetricType;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class collector implements Collector {
    private final Map<String, String> EMPTY_LABELS = new HashMap<>();

    @NotNull
    @Override
    public List<Metric> collect() {
        int count = 0;
        for (World world : Bukkit.getWorlds()) {
            count += world.getEntitiesByClass(Zombie.class).size();
        }
        GaugeMetric metric = new GaugeMetric("minecraft_zombies_count", EMPTY_LABELS, count);
        return Collections.singletonList(metric);
    }
}