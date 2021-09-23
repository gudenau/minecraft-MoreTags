# More Tags

Adds a bunch of tags to Minecraft for mod authors and data pack authors to use!

---

### Currently added block tags

* bookshelves <br> Affects what enchanting tables view as bookshelves.
* glass
* redstone_rails
* bricks
* glass_panes
* skulls
* chests
* glazed_terracotta
* slime_blocks <br> Affects what pistons view as slime blocks.
* concrete
* honey_blocks <br> Affects what pistons view as honey blocks.
* sticky_blocks
* concrete_powder
* infested
* stripped_bark
* dressed_bark
* ores
* stripped_logs
* dressed_logs
* pistons
* stripped_wood
* dressed_wood
* redstone_devices
* terracotta_blocks
* floor_skulls
* redstone_gates
* terracotta
* glass_blocks
* redstone
* wall_skulls
* farmland <br> Affects where plants can grow
* moist_farmland <br> Affects how fast plants grow

### Currently added item tags

* skulls

---

### For mod authors

To use this mod add this to your `build.gradle`:
```gradle
repositories {
    maven {
        name = 'gudenau\'s maven'
        url = 'https://maven.gudenau.net'
    }
}

dependencies {
    modImplementation include("net.gudenau.minecraft:MoreTags:${project.moreTagsVersion}"){
        transitive = false
    }
}
```
and add this to your `gradle.properties`, replacing `[version]` with the version you want to use:
```gradle
moreTagsVersion=[version]
```

---

### For datapack authors

Just use the tags like any other Minecraft tag, they are in the namespace 'moretags'.

For example if you want to make it so bookshelves do not increase enchanting table power while stone does, place this 
into a file called `bookshelves.json` in `Datapack/data/moretags/tags/blocks`:
```json
{
  "replace": true,
  "values": [
    "minecraft:stone"
  ]
}
```
