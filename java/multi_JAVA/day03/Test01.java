package day03;

public class Test01 {

	public static void main(String[] args) {
		
		int i = 90,j=90, k=99;
		
		System.out.printf("%b,%b,%b  %n",i==j,i==k,i!=k);
		
		System.out.println("================================");
		
		String s1 = new String("java");
		String s2 = new String("java");
		
		
		String s3 = "java";
		String s4 = "java";
		
		System.out.printf("s1 = %s s2= %s %n",s1, s2);
		System.out.printf("s1==s2 %b %n",s1==s2);
		System.out.printf("s1.equals(s2) %b %n",s1.equals(s2));
		System.out.println("================================");
		System.out.printf("s3 = %s s4= %s %n",s3, s4);
		System.out.printf("s3==s4 %b %n",s3==s4);
		System.out.printf("s3.equals(s4) %b %n",s3.equals(s4));

	}

}
