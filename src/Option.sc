case class Employee(id: Int, name: String, title: String)
val employees = Vector(
  Employee(1, "Lisa", "CEO"),
  Employee(2, "James", "CFO"),
  Employee(3, "Juan", "CTO"),
  Employee(4, "Caroline", "COO"),
  Employee(5, "Chen", "CIO")
)
def findEmployeeById(id: Int): Option[Employee] = employees.find(_.id == id)
for (i <- 1 to 5) {
  val randomId = scala.util.Random.nextInt(10)
  val employeeOption = findEmployeeById(randomId)
  println(employeeOption match {
    case Some(employee) => s"You found ${employee.name}, ${employee.title} of the company"
    case None => s"There is no employee with id $randomId"
  })
}
for (i <- 1 to 5) {
  val randomId = scala.util.Random.nextInt(10)
  val employeeOption = findEmployeeById(randomId)
  println(employeeOption
    .map(employee => s"You found ${employee.name}, ${employee.title} of the company")
    .getOrElse(s"There is no employee with id $randomId"))
}
val testStrings = Vector(Some("Vidya"), None, Some(""))
for (i <- 1 to 5) {
  val randomIndex = scala.util.Random.nextInt(3)
  val stringOption = testStrings(randomIndex)
  println(stringOption
    .filter(_.trim.nonEmpty)
    .map(string => s"You found a meaningful string $string")
    .getOrElse("You got None or a meaningless empty/whitespace string."))
}

