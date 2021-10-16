import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		int sum = a + b;
		if(a > 0 & b > 0) {
			System.out.println(sum);
		} 
		if ((a <= 0)||(b <= 0))
			throw new IllegalArgumentException("Both parameters must be positive!");

		return sum;
	}
	
	public int randomNumberSquared() {
	int Num = getRandomInt();
	int squareRoot = (int) Math.pow(Num, 2);
	return squareRoot;
	}
	
    int getRandomInt() {
		  Random random = new Random();
		  return random.nextInt(10) + 1;
		}
 
}