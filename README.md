<p align="center">
  <b><a>Welcome to BetterRTP's repository!</a></b>
</p>

## Where's the Lang files?/Want to Contribute translating?  
All language files are located [here](src/main/resources/lang)
feel free to fork one of the language files and help translate!

## Libraries
BetterRTP uses and is compiled with the following libraries:

- [PaperLib](https://github.com/PaperMC/PaperLib) (included) - Library for interfacing with PaperMC specific APIs, used for async chunk loading.
- [FoliaLib](https://github.com/TechnicallyCoded/FoliaLib) (included) - Library for interfacing with Folia specific APIs, used for cross-platform timers.

## Build instructions on Ubuntu

```bash
mvn clean install
```

BetterRTP now targets Java 17 bytecode by default so that you can build the
plugin with either a Java 17 or Java 21 toolchain.  If you would prefer to
generate Java 21 class files, pass `-Dmaven.compiler.release=21` to the Maven
command above.  Either artifact will run fine on Purpur 1.21's Java 21 runtime.

The built JAR will be placed in the `target/` directory.

## Where's the Wiki?  
The wiki is available [here](../../wiki)!
    
<p align="center">
  <b>Chat with us on Discord</b><br/>
  <a href="https://discord.gg/8Kt4wKm"><img src="https://img.shields.io/discord/182633513474850818.svg?longCache=true&style=flat-square&label=Discord" alt="Discord" /></a><br/>
  <b>Have a Suggestion? Make an issue!</b><br/>
  <a href="../../issues"><img src="https://img.shields.io/github/issues-raw/SuperRonanCraft/BetterRTP.svg?longCache=true&style=flat-square&label=Issues" alt="GitHub issues" /></a><br/>
  <br/>
  <a href="https://www.spigotmc.org/resources/36081/">Thank you for viewing the Wiki for BetterRTP!</a><br/>
  <i><a>Did this wiki help you out? Please give it a <b>Star</b> so I know it's getting use!</a></i><br/>
  <br/>
  <b><i><a href="https://www.spigotmc.org/resources/authors/superronancraft.13025/">Check out my other plugins!</a></i></b>
</p>
