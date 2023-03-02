package org.arathok.wurmunlimited.mods.tyrfangsCustomCreatures;

import com.wurmonline.server.creatures.Communicator;
import org.gotti.wurmunlimited.modloader.interfaces.*;

public class SpellResistBegone implements WurmServerMod, PlayerMessageListener, ServerStartedListener, ItemTemplatesCreatedListener, ServerPollListener {
    @Override
    public void onItemTemplatesCreated() {

    }

    @Override
    public boolean onPlayerMessage(Communicator communicator, String s) {
        return false;
    }

    @Override
    public void onServerPoll() {

    }

    @Override
    public void onServerStarted() {

    }

    @Override
    public void init() {

    }

    @Override
    public void preInit() {

    }
}
