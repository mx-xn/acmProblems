import java.util.*;

public class RedRover {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			String str = in.next();
			int minCharacter = str.length();
			for(int i = 0; i < str.length(); i++) {
				int count = findMin(str, i);
				if (count < minCharacter)
					minCharacter = count;
			}
			System.out.println(minCharacter);
		}

	}

	public static int findMin(String str, int i) {
		int chunkLength = 2;
		int minChar = str.length();
		while(chunkLength <= (str.length()-i)/2) {
			//check with different length of combo
			int totalChar = str.length() - chunkLength + 1;
			int j = i + chunkLength;
			while (j <= str.length() - chunkLength) {
				//start with the first index after the chunk
				int chunkIndex = 0;
				while (chunkIndex < chunkLength && 
					str.charAt(j+chunkIndex) == str.charAt(i+chunkIndex)) {
					chunkIndex++;
				}
				if (chunkIndex == chunkLength) {
					totalChar = totalChar - chunkIndex + 1;
					j += chunkLength;
				}
				else
					j++;
			}
			totalChar += chunkLength;
			if (totalChar < minChar)
				minChar = totalChar;
			chunkLength++;
		}
		return minChar;
	}
}