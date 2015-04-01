trait Teacher {
  def name: String
  def subject: String
}
class ComputerScienceTeacher(val name: String, val subject: String) extends Teacher
case class Employee(id: Int, name: String, title: String)
implicit def teacherToEmployee(teacher: Teacher): Employee = Employee(
  scala.util.Random.nextInt(100),
  teacher.name,
  s"${teacher.subject} Teacher"
)
val scalaTeacher = new ComputerScienceTeacher("Vidya", "Scala")
println(scalaTeacher.name)
println(scalaTeacher.subject)
println(scalaTeacher.title)