# RoadRunner 1.12.2 (skeleton port)

Minimal compiling Forge 1.12.2 + Mixin project inspired by Lithium / RoadRunner + GPU-Load ideas.

## Requirements
- JDK 8 (required for ForgeGradle 3 + 1.12.2)
- Internet (first build downloads Forge, MCP, Mixin, etc.)

## Build
```bash
export JAVA_HOME=/path/to/jdk8
./gradlew build
```
Output jar will be in `build/libs/`.

## Structure
- `com.roadrunner.RoadRunner` – main mod class
- `com.roadrunner.config.RoadRunnerConfig` – simple rules.properties system
- `com.roadrunner.mixin.*` – example mixins (smoke tests)
- `com.roadrunner.optimization.*` – placeholders for hopper / math / AI / collision / GPU

GPU offload is deliberately a no-op stub. Real compute-shader work is not practical on 1.12.2 without significant extra native/OpenGL effort.

## Notes
- Mixins use `require = 0` so missing method mappings do not hard-crash the build.
- For production use you will want MixinBooter or similar and far more careful SRG targeting.
