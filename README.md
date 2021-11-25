# Steel

![GitHub all releases](https://img.shields.io/github/downloads/realguyman/steel/total)

Create tougher, more durable equipment.

## Features

* Added steel nugget, ingot, block, sword, tools, and armor.
* Randomly enchanted steel swords, tools, and armor can be found in end city treasure chests.
* There's a rare chance you'll find non-enchanted steel tools, swords, and armor in treasure chests around your world.
* Steel nuggets and ingots can be sold to apprentice and journeyman armorers, toolsmiths, and weaponsmiths.
* Journeyman armorers, toolsmiths, and weaponsmiths can sell you enchanted steel tools and swords, and non-enchanted steel armor.

## Installation

Drop the appropriate `steel-*.jar` file into your mods folder.

### Requirements

* Java >= 8
* Minecraft 1.15.2
* Fabric Loader >= 0.11.7
* Fabric API

Although [Java 8](https://adoptium.net/?variant=openjdk8&jvmVariant=hotspot) is highly recommended, this mod should work with newer versions. You should install the latest stable version of [Fabric Loader](https://fabricmc.net/use) and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api).

### Downloads

The artifacts (`steel-*.jar` files) for Steel are officially available via [GitHub](https://github.com/realguyman/steel/releases) and [Modrinth](https://modrinth.com/mod/steel).

## For Developers

Be sure to [setup a development environment for Fabric](https://fabricmc.net/wiki/tutorial:setup), and [check out the rest of Fabric's wiki](https://fabricmc.net/wiki/doku.php).

### Building

Clone the Git repository or download the source code to your computer. Navigate to the root directory of the source code in your terminal.

You may need to run the Gradle `downloadAssets` and `genSources` tasks before you're able to properly build the project.

On Windows run:

```powershell
.\gradlew.bat build
```

On MacOS or Linux run:

```shell
./gradlew build
```

Alternatively you can use your preferred IDE's built-in Gradle functionality to build the project. The artifacts will be available in the `build/libs` folder.
