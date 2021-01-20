
fun main(args :Array<String>) {
  
  if (args.size != 0) {
      /*
	  var total = 0
	  for( s in args ) {
	    total = total + s.toInt()
	  }
	  */
	  val total = args.map{ it.toInt() }.sum()
	  println("total = $total")
  
  } else {

	  print("Valor? ")
	  val value1 = readLine()!!.toInt()

	  print("Valor? ")
	  val value2 = readLine()!!.toInt()
	  
	  println("$value1 + $value2 = ${value1 + value2}")
  }
}