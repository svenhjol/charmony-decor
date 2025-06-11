package svenhjol.charmony.decor.client.features.chairs;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import svenhjol.charmony.decor.common.features.chairs.Chair;

class ChairRenderer extends EntityRenderer<Chair, ChairRenderState> {
    public ChairRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ChairRenderState createRenderState() {
        return new ChairRenderState();
    }
}
