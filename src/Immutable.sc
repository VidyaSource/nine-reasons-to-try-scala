val initialVal = 5

initialVal = 4

lazy val randomNumbers = for (i <- 1 to 100) yield i * 2

println("Let's use randomNumbers now")
randomNumbers.foreach(println)

