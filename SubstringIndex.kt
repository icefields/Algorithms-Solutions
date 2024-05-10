fun subStringFinder(str: String, subStr: String) {
	var idx = 0
	var j = 0

	for(i = 0; i<str.length; i++) {
		if(str[i] == subStr[j])
			j++;
		else
			j = 0;
      
		//check starting point or a match   
		if(j == 0)
			idx = i;
		else if (j == subStr.length)
			return idx;
	}
	return -1;
}
