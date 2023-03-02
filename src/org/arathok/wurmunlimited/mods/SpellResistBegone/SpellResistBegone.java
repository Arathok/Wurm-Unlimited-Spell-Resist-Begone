package org.arathok.wurmunlimited.mods.SpellResistBegone;

import com.wurmonline.server.creatures.Communicator;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SpellResistBegone implements WurmServerMod, PlayerMessageListener, ServerStartedListener, ItemTemplatesCreatedListener, ServerPollListener {
    Logger logger = Logger.getLogger("SpellResistBegone");
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

        try {
            ClassPool classPool = HookManager.getInstance().getClassPool();
            CtClass ctCreature = classPool.getCtClass("com.wurmonline.server.spells.SpellResist");
            ctCreature.getMethod("addSpellResistance", "(Lcom/wurmonline/server/creatures/Creature;ID)V")
                    .insertBefore("org.arathok.wurmunlimited.mods.SpellResistBegone.Hook.inject($2);");


        } catch (NotFoundException e) {
            logger.log(Level.SEVERE,"Class not found!");
            throw new RuntimeException(e);
        } catch (CannotCompileException e) {
            logger.log(Level.SEVERE,"Could not Compile hook!");
            throw new RuntimeException(e);
        }
    }
    }
