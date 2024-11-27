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
		int newX = x2;
		if(x2 == 0)
		{
			return x1;
		}
		if (x2 < 0)
		{
			newX = 0;
			int n=0;
			while(n > x2)
			{
				newX++;
				n--;
			}
			x2 = newX;
		}
		for( int i=0 ; i< x2+1; i++)
			{
				add = x1++;
			}

		return add;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sub = 0;
		int newX = x2;
		if(x2 == 0)
		{
			return x1;
		}
		if (x2 < 0)
		{
			newX = 0;
			int n=0;
			while(n > x2)
			{
				newX++;
				n--;
			}
			x2 = newX;
		}
		for(int i=0; i<x2+1; i++)
			{
				sub = x1--;
			}
		return sub;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mul = 0;
		int newX = x2;
		if (x2 == 0 || x1 == 0)
		{
			return 0;
		}
		
		if(x2 > 0)
		{
			for(int i=0; i<x2; i++)
			{
				mul = plus (mul, x1);
			}
		}
		
		else
		{
			for(int i=0; i<x2; i++)
			{
				mul = minus(mul, x1);
			}	
		}
		
		return mul;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		if(n == 0)
		{
			return 1;
		}
		if(x == 0)
		{
			return 0;
		}
	
		for (int i = 0; i<n; i++)
		{
			pow = times(pow, x);
		}
		
		return pow;
	}
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int div = 0;
		int newX = x2;

		if (x2 == 0) 
		{
			return 0;
		}
		if(x1 >= 0 && x2 > 0)
		{
			while (x1 >= x2)
			{
				div++;
				x1 = minus(x1, x2);	
			}

			return div;
		}
		if((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0))
		{
			if (x2 < 0)
			{
				newX = 0;
				int n=0;
				while(n > x2)
				{
					newX++;
					n--;
				}
				x2 = newX;
			}
			if (x1 < 0)
			{
				newX = 0;
				int n=0;
				while(n > x1)
				{
					newX++;
					n--;
				}
				x1 = newX;
			}
			
			while (x1 >= x2) 
			{
				div--;
				x1=minus(x1, x2);	
			}

			return div;
		}

		if(x1 < 0 && x2 < 0)
		{
			while (x1 >= x2)
			{
				div++;
				x1=minus(x1, x2);	
			}

			return div;
		}
		
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod = x1;
		int newX = x2;
		if (x2==0)
		{
			return 0;
		}
		else if (x2 < 0)
		{
			newX = 0;
			int n=0;
			while(n > x2)
			{
				newX++;
				n--;
			}
			x2 = newX;
		}
		while (mod>=x2)
		{
			mod = minus(mod, x2);

		}
		return mod;
	}	

	
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int n = 0;
        int sqrt = 0;
		
        while (sqrt < x) {
            n++;
            sqrt = times(n, n);
        }
        if (sqrt > x) {
            n--;
            return n;
        }

        return n;
	}	  	  

}