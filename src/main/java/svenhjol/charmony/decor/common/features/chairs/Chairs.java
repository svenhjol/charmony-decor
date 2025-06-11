package svenhjol.charmony.decor.common.features.chairs;

import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

/**
 * Inspired by Quark's SitInStairs module.
 */
@FeatureDefinition(side = Side.Common, description = """
    Right-click (with empty hand) on any stairs block to sit down.""")
public final class Chairs extends SidedFeature {
    public final Advancements advancements;
    public final Registers registers;
    public final Handlers handlers;

    public Chairs(Mod mod) {
        super(mod);

        registers = new Registers(this);
        handlers = new Handlers(this);
        advancements = new Advancements(this);
    }

    public static Chairs feature() {
        return Mod.getSidedFeature(Chairs.class);
    }
}