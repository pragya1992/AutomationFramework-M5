package practice;

public class GenricMethod_Practice {
	
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;//When we want to return the data not here some where else than will use return in other class
		
	}
	
	public static void main(String[] args) 
	{
		int sum =add(20,30);
		System.out.println(sum);
	}

}
