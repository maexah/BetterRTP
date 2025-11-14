<p align="center">
  <b><a>Welcome to BetterRTP's repository!</a></b>
</p>

> **Personal build notice**
>
> This repo now tracks **BetterRTP v3.7.0-alexahmae**, a Purpur 1.21.10 build that
> I (AlexahMae) maintain solely for my own server. Please don't file bug reports
> or feature requests—if you need support, feel free to fork the project and take
> it over yourself.

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

By default the project compiles with the classic `-source`/`-target` flags so it
works on whichever JDK you already have installed (even ones that do not support
the `--release` option).  If you want to emit a specific bytecode level, pass a
release flag such as `-Dmaven.compiler.release=17` or
`-Dmaven.compiler.release=21` to the Maven command above.

The built JAR will be placed in the `target/` directory.

## Where's the Wiki?  
The wiki is available [here](../../wiki)!
    
<p align="center">
  <b>Chat with us on Discord</b><br/>
  <a href="https://discord.gg/8Kt4wKm"><img src="https://img.shields.io/discord/182633513474850818.svg?longCache=true&style=flat-square&label=Discord" alt="Discord" /></a><br/>
  <b>This fork is unsupported.</b><br/>
  <i>If you want to maintain BetterRTP, please fork it and take over.</i><br/>
  <br/>
  <a href="https://www.spigotmc.org/resources/36081/">Thanks for checking out BetterRTP!</a><br/>
  <i><a>This build exists purely for AlexahMae's server.</a></i><br/>
</p>
