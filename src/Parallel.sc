val numbers = for (i <- 1 to 2000) yield scala.util.Random.nextInt(99) + 1

val parallelCollection = numbers.par
val tripledNumbers = parallelCollection.map(_ * 3)
val evenNumbers = parallelCollection.filter(_ % 2 == 0)

println(s"There are ${evenNumbers.length} even numbers in the list")