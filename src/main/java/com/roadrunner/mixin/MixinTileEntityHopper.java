package com.roadrunner.mixin;

import com.roadrunner.config.RoadRunnerConfig;
import net.minecraft.tileentity.TileEntityHopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Example hopper mixin. Conservative – only demonstrates wiring.
 * Full Lithium-style hopper logic would be substantially larger.
 */
@Mixin(TileEntityHopper.class)
public abstract class MixinTileEntityHopper {

    @Inject(method = "updateHopper", at = @At("HEAD"), cancellable = true, require = 0)
    private void roadrunner$onUpdateHopper(CallbackInfoReturnable<Boolean> cir) {
        if (!RoadRunnerConfig.isHopperOptimizationEnabled()) {
            return;
        }
        // Placeholder for future fast-path transfer logic
    }
}
