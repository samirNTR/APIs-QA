
public class Test12334 {

	public static void main(String[] args) {
		
	String str=	"THIS is A car";
	
	
	String reverse=" ";
	
	
	for(int i=str.length()-1; i>=0; i--)
	{
		
		reverse=reverse+str.charAt(i);
	}
	
	System.out.println(reverse);
	}

}
