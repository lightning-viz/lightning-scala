# Lightning scala client
Scala client for the Lightning data visualization server (WIP)

##installation
Build the project using `sbt` and the [assembly](https://github.com/sbt/sbt-assembly) plugin 
```
sbt assembly
```
To then use lightning in the scala REPL, just add the jar to your classpath (here we are assuming you launch from inside `lightning-scala`)
```
scala -classpath target/scala-2.10/lightning-scala-assembly-0.1.0.jar
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
Methods available for most the default visualization types included with Lightning
```
lgn.line(Array(1.0,1.0,2.0,3.0,9.0,20.0))
lgn.scatter(Array(0.1,0.2,0.3), Array(0.9,0.1,0.5))
```

###updating a visualization
Once created, visualizations can be updated or appended with new data
```
val viz = lgn.scatter(Array(0.1,0.2,0.3), Array(0.9,0.1,0.5))
viz.append(Array(0.5), Array(0.5))
viz.update(Array(0.5, 0.6), Array(0.5, 0.6))
```

###using a custom plot
For any other plot type, just specify by name, and provide the data as a `Map`
```
lgn.plot("line", Map("series" -> List(1,1,2,3,9,20)))
```

##todo
The following pieces of functionality still need to be added
- Add ability to post images
- Finish methods for remaining basic plot types (graph, matrix, adjacency, linestacked, map)
- Add methods for image visualizations (image, gallery)
- Add methods for 3D visualizations (scatter3, volume)
- Add methods for streaming visualizations (scatter, line)
- Add methods for links plots (scatterline)
