/*
 * This file is a part of the NevaGames project
 * This code is absolutely confidential.
 * Copyright (c) 2018 /2018 @author FiddlerGun.
 * Created  on 27/2/2018
 * All rights reserved.
 */

package net.nevagames.hub.listeners.protection;

import net.nevagames.hub.Hub;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class WorldEditionListener implements Listener{
    private final Hub hub;

    public WorldEditionListener(Hub hub)
    {
        this.hub = hub;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (!this.canDoAction(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBurn(BlockBurnEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockDamage(BlockDamageEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockFade(BlockFadeEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockForm(BlockFormEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockGrow(BlockGrowEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event){
        if (!this.canDoAction(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockMultiPlace(BlockMultiPlaceEvent event){
        if (!this.canDoAction(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (!this.canDoAction(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event){
        if (event.getEntity().getType() != EntityType.PLAYER || !this.canDoAction((Player) event.getEntity()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.TRAP_DOOR && !this.canDoAction(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChunkUnload(ChunkUnloadEvent event)
    {
        event.setCancelled(true);
    }

    private boolean canDoAction(Player player){
        return this.hub.getPlayerManagers().canBuild() && player != null && player.isOp();
    }
}
