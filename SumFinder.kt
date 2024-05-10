// From a unsorted array, check whether there are any two numbers that will sum up to a given number
fun sumFinder(arr: List<Int>, sum: Int) = mutableSetOf<Int>().run {
	arr.forEach { cur ->
		val sub = sum - cur
		if (setDif.put(sub)) {
			return true
		}
	}
	false
}
