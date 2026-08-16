package com.roadrunner.optimization.gpu;

import com.roadrunner.RoadRunner;
import com.roadrunner.config.RoadRunnerConfig;

/**
 * Stub for future GPU offload experiments (inspired by GPU-Load mod).
 * On 1.12.2 this is deliberately disabled by default and does nothing
 * useful yet – modern compute-shader approaches require significant
 * extra native/OpenGL work that is outside the scope of a first compile.
 */
public final class GpuOffloadStub {

    private static boolean initialized = false;

    private GpuOffloadStub() {}

    public static void init() {
        if (initialized) return;
        initialized = true;

        if (RoadRunnerConfig.isGpuOptimizationEnabled()) {
            RoadRunner.logger.warn("GPU offload rule is enabled, but no implementation is present for 1.12.2 yet.");
        } else {
            RoadRunner.logger.info("GPU offload is disabled (recommended on 1.12.2).");
        }
    }

    public static boolean isAvailable() {
        return false;
    }
}
