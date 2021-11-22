# Steel

![GitHub](https://img.shields.io/github/license/realguyman/steel) ![GitHub all releases](https://img.shields.io/github/downloads/realguyman/steel/total)

Create tougher, more durable equipment. Take note that it's _unlikely_ this mod will conflict with other mods or otherwise cause issues.

## Usage

Steel nuggets and ingots can be found in treasure chests around your Minecraft world. If you want to make steel you'll need a blast furnace (regular furnaces don't get hot enough), iron, and a lot of fuel to keep the fires burning (4 pieces of coal for iron ingots and 4 blocks of coal to smelt an iron block). Steel can be created from iron nuggets, ingots, and even blocks. As expected you can craft steel nuggets, ingots, and blocks like the vanilla shaped recipes.

## Requirements

- Java >= 8
- Minecraft 1.15.2
- Fabric Loader >= 0.11.7
- Fabric API

Although [Java 8](https://adoptium.net/?variant=openjdk8&jvmVariant=hotspot) is highly recommended, this mod should work with newer versions. You should install the latest stable version of [Fabric Loader](https://fabricmc.net/use) and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api).

## Installation

Download the appropriate `steel-x.x.x+mc.x.x.x.jar` file from [GitHub releases](https://github.com/realguyman/steel/releases) and drop it into your mods folder.

## For Developers

### Building

Clone the Git repository or download the source code to your computer. Navigate to the root directory of the source code in your terminal.

On Windows run:

```powershell
.\gradlew.bat build
```

On MacOS or Linux run:

```shell
./gradlew build
```

Alternatively you can use your preferred IDE's built-in Gradle functionality to build the project. The artifacts will be available in the `build/libs` folder.
