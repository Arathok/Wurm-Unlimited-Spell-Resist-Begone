package org.arathok.wurmunlimited.mods.SpellResistBegone;

import com.wurmonline.server.spells.SpellResist;


public class Hook {

    public static void inject(int spellNumber) {

        if (SpellResist.getSpellGroup(spellNumber)!=0)
            return;

    }

}




