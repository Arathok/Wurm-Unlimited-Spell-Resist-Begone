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
    public static final Logger logger = Logger.getLogger("SpellResistBegone");
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
        long myTime=System.currentTimeMillis();
        logger.log(Level.INFO,"injecting spell resist stop...");
        try {
            ClassPool classPool = HookManager.getInstance().getClassPool();
            CtClass ctCreature = classPool.getCtClass("com.wurmonline.server.spells.SpellResist");
            ctCreature.getMethod("addSpellResistance", "(Lcom/wurmonline/server/creatures/Creature;ID)V")
                    .insertBefore("org.arathok.wurmunlimited.mods.SpellResistBegone.Hook.inject($2);"); // get the Hook and load parameter #2 into the inject functino


        } catch (NotFoundException e) {
            logger.log(Level.SEVERE,"Class not found!");
            throw new RuntimeException(e);
        } catch (CannotCompileException e) {
            logger.log(Level.SEVERE,"Could not Compile hook!");
            throw new RuntimeException(e);
        }
        myTime=System.currentTimeMillis()-myTime;
        logger.log(Level.INFO,"Successfull! This took: "+myTime+ " millis");
    }
}
