package com.roadrunner.mixin;

import com.roadrunner.RoadRunner;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Smoke-test mixin to verify the Mixin pipeline works on 1.12.2.
 */
@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Inject(method = "tick", at = @At("HEAD"), require = 0)
    private void roadrunner$onTick(CallbackInfo ci) {
        // Intentionally empty / debug only. Real optimisations go elsewhere.
        // require=0 prevents hard failure if the method signature differs slightly.
    }
}
