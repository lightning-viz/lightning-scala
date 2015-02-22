# Lightning scala client
Scala client for the Lightning data visualization server (WIP)

##installation
Build the project using `sbt` and the [assembly](https://github.com/sbt/sbt-assembly) plugin 
```
sbt assembly
```
To then use lightning in the scala REPL, just add the jar to your classpath
```
scala -classpath scala-lightning/target/scala-2.10/lightning-scala-assembly-0.1.0.jar
```

##usage

###creating a new session
```
import org.viz.lightning.Lightning

val lgn = new Lightning(host="http://my-lightning-instance.herokuapp.com")

lgn.createSession()
lgn.createSession(Some("provide an optional session name"))
```

###creating a visualization
Methods available for all the default visualization types included with Lightning
```
lgn.line(Array(1,1,2,3,9,20))
lgn.scatter(Array(0.1,0.2,0.3), Array(0.9,0.1,0.5))
```

###using a custom plot
For any other plot type, just specify by name, and provide the data as a `Map`
```
lgn.plot("line", Map("series" -> List(1,1,2,3,9,20)))
```