/*
 * This file is a part of the NevaGames project
 * This code is absolutely confidential.
 * Copyright (c) 2018 /2018 @author FiddlerGun.
 * Created  on 27/2/2018
 * All rights reserved.
 */

package net.nevagames.hub.common.manager;

import com.google.gson.JsonObject;
import net.nevagames.hub.Hub;
import net.nevagames.hub.interaction.AbstractInteractionManager;
import net.nevagames.tools.configuration.JsonConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

public abstract class AbstractManager implements EntryPoints{
    protected final Hub hub;
    private String filename;

    public AbstractManager(Hub hub, String filename){
        this(hub);

        this.filename = filename;
    }

    public AbstractManager(Hub hub){
        this.hub = hub;

        if (!(this instanceof AbstractInteractionManager))
            this.hub.getEventBus().registerManager(this);
    }

    public void log(Level level, String message){
        this.hub.getLogger().log(level, "[" + this.getClass().getSimpleName() + "] " + message);
    }

    protected JsonObject reloadConfiguration(){
        File configuration = new File(this.hub.getDataFolder(), this.filename);

        if (!configuration.exists()){
            try(PrintWriter writer = new PrintWriter(configuration)){
                configuration.createNewFile();
                writer.println("{}");
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return new JsonConfiguration (configuration).load();
    }
}
