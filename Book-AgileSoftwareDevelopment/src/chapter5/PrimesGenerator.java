package chapter5;

public class PrimesGenerator {
	static boolean[] isCrossed;
	static int[] result;

	public static int[] generatePrimes(int maxValue) {

		if (maxValue < 2)
			return new int[0];
		else {
			initializeArrayOfIntegers(maxValue);
			crossOutMultiples();
			putUncrossedIntegersIntoResult();
			return result;
		}
	}

	private static void initializeArrayOfIntegers(int maxValue) {
		isCrossed = new boolean[maxValue + 1];
		isCrossed[0] = isCrossed[1] = true;
		for(int i = 2; i < isCrossed.length; i++)
			isCrossed[i] = false;
	}

	private static void crossOutMultiples() {
		int i;
		int j;
		for(i = 2; i < Math.sqrt(isCrossed.length) + 1; i++) {
			if (!isCrossed[i]) {
				for (j = 2 * i; j < isCrossed.length; j += i)
					isCrossed[j] = true;
			}
		}
	}
	
	private static void putUncrossedIntegersIntoResult() {
		int j;
		int i;
		
		int count = 0;
		for(i = 0; i < isCrossed.length; i++) {
			if (!isCrossed[i])
				count++;
		}
		
		result = new int[count];
		for (i = 0,j = 0;i < isCrossed.length; i++) {
			if (!isCrossed[i])
				result[j++] = i;
		}
	}
}
