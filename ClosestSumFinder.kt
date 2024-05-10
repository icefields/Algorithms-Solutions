// Find three elements in an array whose sum is closest to an given number
fun ClosestSumFinder(arr: List<Int>, num: Int): Array<Int> {
	var wrap = SolutionWrapper<Int>(arr[0], arr[1], arr[2])
	var sum = wrap.sumOf3()
	if (sum == num) return wrap
	for (var i = 3; i< arr.length; i++) {
		// every number has 2 possible solutions
		// take the best every time
		var diff = num - sum
		wrap.copy(num1 = arr[i]).also {
			sumOf3().let { sumOf3 ->
				if (sumOf3 == num) return this.toArray()
				if (abs(num - sumOf3) < diff) { // TODO is abs necessary?
					wrap = this
					sum = sumOf3
				}
			}
		}
		
		wrap.copy(num2 = arr[i]).also {
			sumOf3().let {
				if (it == num) return this.toArray()
				if (num - it < diff) {
					wrap = this
					sum = it
				}
			}
			
		}
		
		wrap.copy(num3 = arr[i]).also {
			sumOf3().let {
				if (it == num) return this.toArray()
				if (num - it < diff) {
					wrap = this
					sum = it
				}
			}
		}
	}
	return wrap.toArray()
}

data class SolutionWrapper<T>(
	var num1: T? = null,
	var num2: T? = null,
	var num3: T? = null
) {
	fun sumOf3(): Int {
		if (num1 == null) return null
		if (num2 == null) return null
		if (num3 == null) return null
		return num1 + num2 + num3
	}
	
	fun toArray() = arrayOf(num1, num2, num3)	
}
