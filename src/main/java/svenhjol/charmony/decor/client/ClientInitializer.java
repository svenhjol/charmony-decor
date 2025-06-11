package svenhjol.charmony.decor.client;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.decor.DecorMod;
import svenhjol.charmony.decor.client.features.chairs.Chairs;
import svenhjol.charmony.api.core.Side;

public final class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.client.ClientInitializer.init();

        // Prepare and run the mod.
        var mod = DecorMod.instance();
        mod.addSidedFeature(Chairs.class);
        mod.run(Side.Client);
    }
}
