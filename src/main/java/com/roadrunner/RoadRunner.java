package com.roadrunner;

import com.roadrunner.config.RoadRunnerConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = RoadRunner.MODID,
    name = RoadRunner.NAME,
    version = RoadRunner.VERSION,
    acceptableRemoteVersions = "*",
    acceptedMinecraftVersions = "[1.12.2]"
)
public class RoadRunner {

    public static final String MODID = "roadrunner";
    public static final String NAME = "RoadRunner";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("RoadRunner {} loading for Minecraft 1.12.2", VERSION);

        // Load configuration / rule overrides
        RoadRunnerConfig.init(event.getSuggestedConfigurationFile().getParentFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("RoadRunner initialized. Active optimizations will be applied via Mixin.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("RoadRunner post-init complete.");
    }
}
