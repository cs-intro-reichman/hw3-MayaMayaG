public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4    
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6   = 0
   		System.out.println(sqrt(36)); //6
		System.out.println(sqrt(263169)); // 513
   		System.out.println(sqrt(76123)); // 275
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int add = 0;
		for( int i=0 ; i< x2+1; i++)
		{
			add = x1++;
		}
		return add;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sub = 0;
		for(int i=0; i<x2+1; i++)
			{
				sub = x1--;
			}
		return sub;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mul = 0;
		for(int i=0; i<x2; i++)
		{
			 mul = plus (mul, x1);
		}
		
		return mul;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for (int i = 0; i<n; i++)
		{
			pow = times(pow, x);
		}
		
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) {
			return -1;
		}
		int div = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);  // הפחתת x2 כל פעם
			div++;  // כל פעם שהפחתת, הגדל את הספירה
		}
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod = x1;
		if (x2==0)
		{
			throw new ArithmeticException("Modulo by zero is not allowed");
		}
		while (mod>=x2)
		{
			if(mod >= x2)
				{
					mod = minus(mod, x2);
				}
		}
		return mod;
	}	

	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sqrt = 0;
		if(x==0)
		{
			return -1;
		}
		while (x!=0)
		{
			x=div(x,2);
			sqrt++;
		}
		
		return sqrt;
	}	  	  

}