# Lightning scala client
Scala client for the Lightning data visualization server (WIP)

##installation
Build the project using `sbt` 
```
sbt assembly
```
To then use in the scala REPL, add the jar to your classpath
```
scala -classpath lightning-scala-assembly-0.1.0.jar
```

##usage

###creating a new session
```
import org.viz.lightning.Lightning

val lgn = new Lightning(host="http://my-lightning-instance.herokuapp.com")
lgn.createSession(Some("provide an optional session name"))
