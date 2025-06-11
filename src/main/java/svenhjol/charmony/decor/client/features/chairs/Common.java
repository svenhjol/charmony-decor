package svenhjol.charmony.decor.client.features.chairs;

import svenhjol.charmony.decor.common.features.chairs.Chairs;
import svenhjol.charmony.decor.common.features.chairs.Registers;

public class Common {
    public final Registers registers;

    public Common() {
        var common = Chairs.feature();
        registers = common.registers;
    }
}
