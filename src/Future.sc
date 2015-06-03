import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Await

def longRunningFunction(add: Int) = for (i <- 1 to 1000000) yield add + i

val result: Future[Seq[Int]] = Future {
  longRunningFunction(200)
}

Await.result(result.map(numbers => numbers.take(50).filter(_ % 2 == 0)), 10.seconds)


def anotherLongRunningFunction(add: Int) = for (i <- 1 to 1000000) yield add * i


val firstResult: Future[Seq[Int]] = Future {
  longRunningFunction(200)
}

val secondResult: Future[Seq[Int]] = Future {
  anotherLongRunningFunction(200)
}

val futureWithMap = firstResult.flatMap(
  firstNumberList => secondResult
    .map(secondNumberList => (firstNumberList zip secondNumberList)
    .flatMap(tuple => Vector(tuple._1, tuple._2)))
)

Await.result(futureWithMap.map(numbers => numbers.take(50)), 10.seconds)

val futureWithFor = for {
  firstNumberList <- firstResult
  secondNumberList <- secondResult
} yield (firstNumberList zip secondNumberList).flatMap(tuple => Vector(tuple._1, tuple._2))

Await.result(futureWithFor.map(numbers => numbers.take(50)), 10.seconds)

