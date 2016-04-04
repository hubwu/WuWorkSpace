package testjava;

public class TZTest {

	public static void main(String[] args) 
	{
		 int month=12;//月份

		 int num1=2;

		 int num2=2;
		 
		  for(int loop=3;loop<month;loop++){
			  int tzNum;
			    tzNum=num1+num2;
			    num1=num2;
				num2=tzNum;
				System.out.println("month>>>>"+tzNum);
			}
	}
}
