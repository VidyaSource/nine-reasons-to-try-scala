trait SchoolPerson {
  def name: String
  def salary: Double
}
trait Student extends SchoolPerson {
  override def salary = 0
}
trait Teacher extends SchoolPerson {
  override def salary = 30000
}
trait Sluggable {
  def slug: String
  protected def slugify(text: String) = text.toLowerCase.replace(" ", "-")
}
class TeachingAssistant(val name: String)
  extends Student with Teacher with Sluggable {
  def title = "Teaching Assistant"
  override def slug = slugify(s"$title $name")
}
val ta = new TeachingAssistant("Vidya")
println(ta.name)
println(ta.title)
println(ta.salary)
println(ta.slug)
trait GradingSystemUser {
  this: Teacher =>
  def login: String
}
class ComputerScienceTeacher(val name: String) extends Teacher with GradingSystemUser with Sluggable {

  override def login: String = slugify(name)
  override def slug: String = slugify(name)
}

/*class ComputerScienceStudent(val name: String) extends Student with GradingSystemUser {
  override def login: String = ???

  override def name: String = ???
}*/


trait Coach {
  this: {def sports: Vector[String]} =>

}
class FootballCoach(val name: String) extends Teacher with Coach {
  def sports = Vector("Football")
}

/*class RandomPerson(name: String) extends Coach with Sluggable {
  override def slug: String = slugify(name)
}*/




