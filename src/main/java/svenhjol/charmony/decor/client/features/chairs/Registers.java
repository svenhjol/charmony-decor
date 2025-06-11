package svenhjol.charmony.decor.client.features.chairs;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import svenhjol.charmony.core.base.Setup;

public class Registers extends Setup<Chairs> {
    public Registers(Chairs feature) {
        super(feature);
        EntityRendererRegistry.register(feature.common.get().registers.entity.get(), ChairRenderer::new);
    }
}
