# Tinylog ColoredConsole
**A [Tinylog](http://www.tinylog.org) console writer extension colored log levels and arbitrary data through custom tags.**


## Features
Tinylog ColoredConsole extends Tinylog with the `coloredconsole` console writer to enable colorized log outputs as shown hereafter. The colorization is done using ASCII codes provided in the tinylog config file.

Note that you can already colorize the default tinylog console output by manually adding ASCII codes to the .format field (see [Tinylog Logging Format](http://www.tinylog.org/configuration#format) for general formatting), e.g. for timestamp or code reference (see example code of this project).

### Log-level coloring
**Colorize the log-level (e.g. info, warn) by defining pre-/post level tags** that are provided in the tinylog .format element. Strings in the pre/post<level> (e.g. preInfo) parameter will replace the corresponding tag. For example, the listing below defines the "[[preLevelTag]]", which is used in the .format parameter, and replaced by "\u001B[32m" (green foreground color). In this example, the postInfo tag resets the color (with "\u001B[0m") to the light gray foreground color.

```  
DEFINITION:
   tinylog.writer                         = coloredconsole
   tinylog.writerColConsole.format        = <log format - see tinylog documentation>  
   tinylog.writerColConsole.preLevelTag   = <pre level custom tag>
   tinylog.writerColConsole.postLevelTag  = <post level custom tag>
   tinylog.writerColConsole.preInfo       = <pre level custom tag replacement>
   tinylog.writerColConsole.postInfo      = <post level custom tag replacement>
   
EXAMPLE:    
   tinylog.writer                         = coloredconsole
   tinylog.writerColConsole.format        = [[preLevelTag]] {{level}|min-size=7} [[postLevelTag]]  
   tinylog.writerColConsole.preLevelTag   = [[preLevelTag]]
   tinylog.writerColConsole.postLevelTag  = [[postLevelTag]]
   tinylog.writerColConsole.preInfo       = \u001B[32m
   tinylog.writerColConsole.postInfo      = \u001B[0m
``` 

### Custom tag coloring
The Tinylog ColoredConsole enables you to **define up to 5 custom tags (pre- and post, respectively)**. This allows more flexible coloring of individual source code generated outputs (init phases, shutdown, uncaught exception, etc.). All custom tags can be individualized to adapt to your code.

The following listing demonstrates how to colorize the tags as well as the content (here in green), quite nice for status changes such as init phases. It uses "<====" as pre-tag (and "====>" as post-tag respectively). The tags as well as the content are colored green here (pre-/post-tags are distinguished via first/last character, which is replaced with '=' for output).

```  
DEFINITION:
   tinylog.writer                          = coloredconsole
   tinylog.writerColConsole.preCustomTag4  = <====
   tinylog.writerColConsole.preCustom4     = \u001B[32m=====
   tinylog.writerColConsole.postCustomTag4 = ====>
   tinylog.writerColConsole.postCustom4    = \u001B[32m=====\u001B[37m
   
EXAMPLE:    
   tinylog.writer                          = coloredconsole
   tinylog.writerColConsole.preCustomTag4  = <====
   tinylog.writerColConsole.preCustom4     = \u001B[32m=====
   tinylog.writerColConsole.postCustomTag4 = ====>
   tinylog.writerColConsole.postCustom4    = \u001B[32m=====\u001B[37m
```

## Examples
### Example 1: log-level coloring
As kind of default use case, the log-level itself is colorized. Note that the postTag is not needed

![](https://github.com/tobiasrm/tinylog-singlelevel-cw/blob/master/files/screenshot_coloring_default.png?raw=true) 

### Example 2: log-level coloring with decorators
The log-level has some "decorators" to visually highlight the information. In the example, the log-level tags are 'misused' in the log-content itself. Although possible, the custom tags are made for this.

![](https://github.com/tobiasrm/tinylog-singlelevel-cw/blob/master/files/screenshot_coloring_decorators.png?raw=true) 

### Example 3: custom tag coloring
Five custom tags are available as shown below with five example logs. NOTE that the replacement is done sequentially (tag 1 to 5). Thus, the custom tag 1 can insert strings that contain tags that are processed afterwards.

![](https://github.com/tobiasrm/tinylog-singlelevel-cw/blob/master/files/screenshot_coloring_custom_tags.png?raw=true) 

## Try it out
You can reproduce the colored log demo by running  `mvn clean install`  and then  `java -jar target/tinylog-coloredconsole-1.3.1-executable.jar` 

Uncomment the desired logging of the main method and corresponding [tinylog.properties](https://github.com/tobiasrm/tinylog-coloredconsole/blob/master/src/main/resources/tinylog.properties) config for any of the listes examples. 
 
## Maven artifact
*In preparation*


## Comments
- **Versioning**. The tinylog-coloredconsole versioning uses the original Tinylog versions for clarity about the underlying libary, e.g. tinylog-coloredconsole in version 1.3.1 uses Tinylog v1.3.1 (see [pom.xml](https://github.com/tobiasrm/tinylog-coloredconsole/blob/master/pom.xml)). If needed, you may simply exclude it and use another Tinylog version.
- **Remove custom tags for file writing**. Your source-code generated custom tags are processed for the console but are still written to file. In order to remove those tags, see the corresponding [tinylog-tagging-filewriter](https://github.com/tobiasrm/tinylog-taggingfilewriter) and [tinylog-tagging-rollingfilewriter](https://github.com/tobiasrm/tinylog-tagging-rollingfilewriter). They allow you to define 10 custom tags and replacements (e.g. the five pre-/custom tags of used by tinylog-coloredconsole).


## Other Tinylog writer extensions
See also my other Tinylog writer extension projects:

- [tinylog-tagging-filewriter](https://github.com/tobiasrm/tinylog-tagging-filewriter) extension to remove custom strings (e.g. the tinylog-coloredconsole custom tags) before writing to file (based on filewriter)
- [tinylog-tagging-rollingfilewriter](https://github.com/tobiasrm/tinylog-tagging-rollingfilewriter) extension to remove custom strings (e.g. the tinylog-coloredconsole custom tags) before writing to file (based on rollingfilewriter)
-  [tinylog-singlelevel-cw](https://github.com/tobiasrm/tinylog-singlelevel-cw) for console writers being restricted to their levels as debugging support (e.g. only print trace, warn and error) 

