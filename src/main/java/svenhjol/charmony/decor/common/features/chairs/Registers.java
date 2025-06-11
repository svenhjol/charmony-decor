package svenhjol.charmony.decor.common.features.chairs;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;

import java.util.function.Supplier;

public class Registers extends Setup<Chairs> {
    public final Supplier<EntityType<Chair>> entity;

    public Registers(Chairs feature) {
        super(feature);
        var registry = CommonRegistry.forFeature(feature);

        entity = registry.entity("chair", () -> EntityType.Builder
            .<Chair>of(Chair::new, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .clientTrackingRange(1)
            .updateInterval(1));
    }

    @Override
    public Runnable boot() {
        return () -> {
            UseBlockCallback.EVENT.register(feature().handlers::blockUse);
        };
    }
}
