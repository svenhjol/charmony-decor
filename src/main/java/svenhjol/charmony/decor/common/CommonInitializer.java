package svenhjol.charmony.decor.common;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.decor.DecorMod;
import svenhjol.charmony.decor.common.features.chairs.Chairs;
import svenhjol.charmony.api.core.Side;

public final class CommonInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.common.CommonInitializer.init();

        // Prepare and run the mod.
        var mod = DecorMod.instance();
        mod.addSidedFeature(Chairs.class);
        mod.run(Side.Common);
    }
}
