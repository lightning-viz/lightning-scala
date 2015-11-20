# Lightning scala client
Scala client for the Lightning data visualization server (WIP)
[![Build Status](https://travis-ci.org/lightning-viz/lightning-scala.svg?branch=master)](https://travis-ci.org/lightning-viz/lightning-scala)

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
import org.viz.lightning._

val lgn = Lightning(host="http://my-lightning-instance.herokuapp.com")

lgn.createSession()
lgn.createSession("provide an optional session name")
```

###creating a visualization
Methods are available for the default visualization types included with Lightning
```
lgn.line(Array(Array(1.0,1.0,2.0,3.0,9.0,20.0)))
lgn.scatter(Array(1.0,2.0,3.0), Array(1.0,1.5,5.0))
```

###setting options
Visualizations can be customized through optional parameters
```
lgn.line(Array(Array(1.0,1.0,2.0),Array(3.0,9.0,20.0)), label=Array(1,2))
lgn.scatter(Array(1.0,2.0,3.0), Array(1.0,1.5,5.0), label=Array(1,2,3))
```

###using a custom plot
For any other plot type, just specify by name, and provide the data as a `Map`
```
lgn.plot("line", Map("series" -> List(1,1,2,3,9,20)))
```
This is especially useful when working with custom plot types

##tests
Run the unit tests using `sbt` by calling

```
sbt test
```

You can specify a name to run a subset of the tests

```
sbt "test-only *LightningPlotsSuite*"
```

The tests require that a local lightning server is running on `http://localhost:3000`

##todo
The following components need to be added
- Add updating and appending
- Add ability to post images
- Add image-related visualizations (image, gallery, volume)
- Add streaming visualizations (scatter, line)
