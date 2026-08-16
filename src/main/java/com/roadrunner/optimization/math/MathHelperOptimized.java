package com.roadrunner.optimization.math;

/**
 * Placeholder for fast math helpers that can be mixed into
 * net.minecraft.util.math.MathHelper or used by other optimizations.
 * Real Lithium-style implementations would go here.
 */
public final class MathHelperOptimized {

    private MathHelperOptimized() {}

    /**
     * Fast floor for positive values (common in Minecraft).
     */
    public static int fastFloor(double value) {
        int i = (int) value;
        return value < i ? i - 1 : i;
    }

    /**
     * Fast ceil.
     */
    public static int fastCeil(double value) {
        int i = (int) value;
        return value > i ? i + 1 : i;
    }

    /**
     * Clamp with fewer branches for common cases.
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
