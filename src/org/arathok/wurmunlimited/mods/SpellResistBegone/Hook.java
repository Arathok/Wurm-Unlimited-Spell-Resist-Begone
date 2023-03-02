package org.arathok.wurmunlimited.mods.SpellResistBegone;

import com.wurmonline.server.spells.SpellResist;


public class Hook {

    public static void inject(int spellNumber) {

        if (SpellResist.getSpellGroup(spellNumber)!=0) // if the spell is anything but a heal spell cancel the addition of spell resist.
            return;

    }

}




