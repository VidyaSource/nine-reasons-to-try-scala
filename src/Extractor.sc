case class Superhero(name: String, company: String, fromEarth: Boolean = true)

val superheroes = Vector(
  Superhero("IronMan", "Marvel"),
  Superhero("Batman", "DC Comics"),
  Superhero("Captain America", "Marvel"),
  Superhero("Superman", "DC Comics", fromEarth = false),
  Superhero("Thor", "Marvel", fromEarth = false),
  Superhero("Hulk", "Marvel"),
  Superhero("Wonder Woman", "DC Comics"),
  Superhero("Aquaman", "DC Comics")
)

for (i <- 1 to 10) {
  val randomIndex = scala.util.Random.nextInt(superheroes.length)
  superheroes(randomIndex) match {
    case Superhero(name, company, _) => println(s"The superhero $name belongs to $company")
  }
}
for (i <- 1 to 10) {
  val shuffledSuperheroes = scala.util.Random.shuffle(superheroes)
  shuffledSuperheroes match {
    case Vector(Superhero(name, "Marvel", _), _*) => println(s"First superhero is $name with Marvel.")
    case Vector(Superhero(name, "DC Comics", _), _*) => println(s"First superhero is $name with DC.")
    case _ => println("First superhero is with a different company altogether.")
  }
}

