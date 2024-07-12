class Solution {
    public static String getNumVal(HashMap<Integer, String> symbols, int num) {
		if (symbols.get(num) == null) {
			StringBuilder result = new StringBuilder();
			int temp = num;
			if (temp < 10) {
				String one = symbols.get(1);
				String five = symbols.get(5);
				String ten = symbols.get(10);
				if (temp < 5) {
					if (temp == 4) {
						return one + five;
					}
					for (int i = 0; i < temp; i++) {
						result.append(one);
					}
				}else{
					if (temp == 9) {
						return one + ten;
					}
					result.append(five);
					for (int i = 5; i < temp; i++) {
						result.append(one);
					}
				}
			}else{
				String thousand = symbols.get(1000);
				if (temp < 100) {
					String ten = symbols.get(10);
					String fifty = symbols.get(50);
					String hundred = symbols.get(100);
					if (temp < 50) {
						if (temp == 40) {
							return ten + fifty;
						}
						for (int i = 10; i <= temp; i+=10) {
							result.append(ten);
						}
					}else{
						if (temp == 90) {
							return ten + hundred;
						}
						result.append(fifty);
						for (int i = 50; i < temp; i+=10) {
							result.append(ten);
						}
					}
				}else if (temp < 1000) {
					String hundred = symbols.get(100);
					String fivehundred = symbols.get(500);
					if (temp < 500) {
						if (temp == 400) {
							return hundred + fivehundred;
						}
						for (int i = 100; i <= temp; i+=100) {
							result.append(hundred);
						}
					}else{
						if (temp == 900) {
							return hundred + thousand;
						}
						result.append(fivehundred);
						for (int i = 500; i < temp; i+=100) {
							result.append(hundred);
						}
					}					
				}else{
					result.append(thousand);
					for (int i = 1000; i < temp; i+=1000) {
						result.append(thousand);
					}
				}
			}
			return result.toString();
		}
		return symbols.get(num);
	}
	
	public static String intToRoman(int num) {
		HashMap<Integer, String> symbols = new HashMap<>();
		symbols.put(1, "I");
		symbols.put(5, "V");
		symbols.put(10, "X");
		symbols.put(50, "L");
		symbols.put(100, "C");
		symbols.put(500, "D");
		symbols.put(1000, "M");
		ArrayList<String> li = new ArrayList<>();
		if (symbols.get(num) == null) {
			int temp = num / 10;
			int reminder = num % 10;
			int multiply = 10;
			li.add(getNumVal(symbols, reminder));
			while (temp > 0) {
				reminder = temp % 10;
				temp = temp / 10;
				li.add(getNumVal(symbols, reminder * multiply));
				multiply *= 10;
			}
			StringBuilder result = new StringBuilder();
			for (int i = li.size()-1; i >= 0; i--) {
				result.append(li.get(i));
			}
			return result.toString();
		}
		return symbols.get(num);
    }
}