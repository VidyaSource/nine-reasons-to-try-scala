case class Superhero(name: String, company: String, fromEarth: Boolean = true)

object Superhero {
  //Compiler gives us def apply(name: String, company: String, fromEarth: Boolean = true)
  def apply(name: String): Superhero = Superhero(name, "Unknown", fromEarth = false)
}

val spiderman = Superhero("Spider-Man", "Marvel")
//Like saying val spiderman = Superhero.apply("Spider-Man", "Marvel")

val spiderman2 = Superhero("Spider-Man", "Marvel")

val batman = Superhero("Batman", "DC Comics")

spiderman == spiderman2

batman == spiderman

batman.name = "Superman"

val superman = batman.copy(name = "Superman")


















