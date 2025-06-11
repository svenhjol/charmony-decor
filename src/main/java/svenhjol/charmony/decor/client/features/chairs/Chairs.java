package svenhjol.charmony.decor.client.features.chairs;

import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

import java.util.function.Supplier;

@FeatureDefinition(side = Side.Client, canBeDisabledInConfig = false)
public final class Chairs extends SidedFeature {
    public final Supplier<Common> common;
    public final Registers registers;

    public Chairs(Mod mod) {
        super(mod);
        common = Common::new;
        registers = new Registers(this);
    }
}
