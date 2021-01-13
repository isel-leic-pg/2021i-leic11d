

data class Student(val name:String, val grade:Int)

data class Student2(val name:String, var grade:Int)


fun main() {
    var student = Student("Pedro",18)
    println(student)
    student = Student(student.name,20)
    println(student)
    //....
    val student2 = Student2("Pedro",18)
    println(student2)
    student2.grade = 20
    println(student2)

    var lst = listOf(1,2,3)
    println(lst)
    lst = lst + 4
    println(lst)
    //....
    val lst2 = mutableListOf(1,2,3)
    println(lst2)
    lst2.add(4)
    println(lst2)
}