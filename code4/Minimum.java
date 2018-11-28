import java.util.Arrays;
public class Minimum{
	public static int arrayMin(int[] inputArray){
		if(inputArray.length == 0) {
			return Integer.MAX_VALUE;
		}
		else {
			return arrayMin(inputArray, 0, inputArray.length - 1);
		}
	}
	public static int arrayMin(int[] inputArray, int startIdx, int endIdx){
		if(startIdx < endIdx) {
			if (inputArray[startIdx] < inputArray[startIdx + 1])
				inputArray[startIdx + 1] = inputArray[startIdx];
			return arrayMin(inputArray, startIdx + 1, endIdx);
		}
		else{
			return inputArray[startIdx];
		}
		}
}
