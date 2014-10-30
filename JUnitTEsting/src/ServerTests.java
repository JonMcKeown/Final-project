import java.util.Random;

import org.junit.Test;


public class ServerTests {
	private static Soap soap = new Soap();
	
		@Test
		public static void main(String[]args)
		{
			soap = new Soap();
			try{
				for(int i = 1004;i<1007;i++)
					soap.createDeleteUSerRequest(i);
				//soap.createLoginRequest(getRandomNumber(5), getRandomNumber(5));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		public static String getRandomNumber(int digCount) 
		{
			Random rnd = new Random();
		    StringBuilder sb = new StringBuilder(digCount);
		    for(int i=0; i < digCount; i++)
		        sb.append((char)('0' + rnd.nextInt(10)));
		    return sb.toString();
		}
}
