class Solution {
    public static boolean isPrime(int num) {
        switch (num) {
            case 2:
                return true;
            case 3:
                return true;
            case 5:
                return true;
            case 7:
                return true;
            case 11:
                return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] constructRectangle(int area) {
        int arr[] = new int[2];
        if (isPrime(area)) {
            arr[0] = area;
            arr[1] = 1;
            return arr;
        }else if (area == 4) {
            arr[0] = 2;
            arr[1] = 2;
            return arr;
        }
        int num = 2;
        ArrayList<Integer> factors = new ArrayList<>();
        while (num < area) {
            if (area % num == 0) {
                factors.add(num);
            }
            num++;
        }
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < factors.size(); i++) {
            int curr = factors.get(i);
            val = area / curr;
            if (min > Math.abs(val - curr)) {
                if (val < curr) {
                    arr[0] = curr;
                    arr[1] = val;
                }else {
                    arr[0] = val;
                    arr[1] = curr;
                }
                min = Math.abs(val - curr);
            }
        }
        return arr;
    }
}