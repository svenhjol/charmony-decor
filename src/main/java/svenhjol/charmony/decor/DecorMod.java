package svenhjol.charmony.decor;

import svenhjol.charmony.api.core.ModDefinition;
import svenhjol.charmony.api.core.Side;
import svenhjol.charmony.core.base.Mod;

@ModDefinition(
    id = DecorMod.ID,
    sides = {Side.Client, Side.Common},
    name = "Decor",
    description = "Decoration (tbc) and sitting on stair blocks..")
public final class DecorMod extends Mod {
    public static final String ID = "charmony-decor";
    private static DecorMod instance;

    private DecorMod() {}

    public static DecorMod instance() {
        if (instance == null) {
            instance = new DecorMod();
        }
        return instance;
    }
}