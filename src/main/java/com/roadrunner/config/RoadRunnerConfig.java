package com.roadrunner.config;

import com.roadrunner.RoadRunner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Simple properties-based rule system inspired by Lithium / RoadRunner.
 * Users can force-enable or force-disable individual mixin modules via
 * config/roadrunner/rules.properties
 */
public class RoadRunnerConfig {

    private static final Properties rules = new Properties();
    private static File rulesFile;

    public static void init(File configDir) {
        File roadrunnerDir = new File(configDir, "roadrunner");
        if (!roadrunnerDir.exists()) {
            roadrunnerDir.mkdirs();
        }

        rulesFile = new File(roadrunnerDir, "rules.properties");

        // Defaults (all stable modules enabled)
        rules.setProperty("mixin.optimization.hopper", "true");
        rules.setProperty("mixin.optimization.math", "true");
        rules.setProperty("mixin.optimization.collision", "true");
        rules.setProperty("mixin.optimization.ai", "true");
        rules.setProperty("mixin.optimization.gpu", "false"); // GPU offload disabled by default on 1.12.2

        if (rulesFile.exists()) {
            try (FileInputStream fis = new FileInputStream(rulesFile)) {
                rules.load(fis);
                RoadRunner.logger.info("Loaded RoadRunner rules from {}", rulesFile.getAbsolutePath());
            } catch (IOException e) {
                RoadRunner.logger.warn("Failed to load rules.properties, using defaults", e);
            }
        } else {
            saveDefaults();
        }
    }

    private static void saveDefaults() {
        try (FileOutputStream fos = new FileOutputStream(rulesFile)) {
            rules.store(fos, "RoadRunner rule overrides\n" +
                    "# true = enable, false = disable\n" +
                    "# Changing these requires a restart");
            RoadRunner.logger.info("Created default rules.properties at {}", rulesFile.getAbsolutePath());
        } catch (IOException e) {
            RoadRunner.logger.warn("Could not write default rules.properties", e);
        }
    }

    public static boolean isEnabled(String rule) {
        return Boolean.parseBoolean(rules.getProperty(rule, "true"));
    }

    public static boolean isHopperOptimizationEnabled() {
        return isEnabled("mixin.optimization.hopper");
    }

    public static boolean isMathOptimizationEnabled() {
        return isEnabled("mixin.optimization.math");
    }

    public static boolean isCollisionOptimizationEnabled() {
        return isEnabled("mixin.optimization.collision");
    }

    public static boolean isAiOptimizationEnabled() {
        return isEnabled("mixin.optimization.ai");
    }

    public static boolean isGpuOptimizationEnabled() {
        return isEnabled("mixin.optimization.gpu");
    }
}
