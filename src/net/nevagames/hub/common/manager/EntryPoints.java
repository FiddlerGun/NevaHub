/*
 * This file is a part of the NevaGames project
 * This code is absolutely confidential.
 * Copyright (c) 2018 /2018 @author FiddlerGun.
 * Created  on 27/2/2018
 * All rights reserved.
 */

package net.nevagames.hub.common.manager;

import org.bukkit.entity.Player;

interface EntryPoints{
    void onDisable();
    void onLogin(Player player);
    void onLogout(Player player);
}
