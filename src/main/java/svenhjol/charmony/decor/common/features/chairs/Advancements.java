package svenhjol.charmony.decor.common.features.chairs;

import net.minecraft.world.entity.player.Player;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.helpers.AdvancementHelper;

public class Advancements extends Setup<Chairs> {
    public Advancements(Chairs feature) {
        super(feature);
    }

    public void satOnChair(Player player) {
        AdvancementHelper.trigger("sat_on_chair", player);
    }
}
