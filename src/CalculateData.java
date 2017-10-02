import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Revani Govender
 *
 */
public class CalculateData {
	
	/**
	 * from indexBegin to indexEnd, search data for values that are higher than threshold. 
	 * Return the first index where data has values that meet this criteria for at least winLength samples.
	 * @param data
	 * @param indexBegin
	 * @param indexEnd
	 * @param threshold
	 * @param winLength
	 * @return
	 */
	public static int searchContinuityAboveValue(ArrayList<Float> data, int indexBegin, int indexEnd, 
											float threshold, int winLength) {

		ArrayList<Integer> window = new ArrayList<Integer>();
		for (int index = indexBegin; index <= indexEnd; index ++){
			if (data.get(index) > threshold){
				window.add(index); //collect items in winLength		
				if (window.size() == winLength){
					return window.get(0); //return first index in win
				} 
			} else {
				window.clear(); //clear the list if item not winLenth 
			}
		}
		
		if (window.size() < winLength) {
			return -1; //return non true value (could maybe throw exception here)
		}
		
		return window.get(0);
	}
	
	/**
	 *  from indexBegin to indexEnd (where indexBegin is larger than indexEnd),
	 *  search data for values that are higher than thresholdLo and lower than thresholdHi. 
	 *  Return the first index where data has values that meet this criteria for at least winLength samples
	 * @param data
	 * @param indexBegin
	 * @param indexEnd
	 * @param thresholdLo
	 * @param thresholdHi
	 * @param winLength
	 * @return
	 */
	public static int backSearchContinuityWithinRange(ArrayList<Float> data, int indexBegin, int indexEnd, 
											float thresholdLo, float thresholdHi, int winLength) {
		
		ArrayList<Integer> window = new ArrayList<Integer>();
		for (int index = indexBegin; index >= indexEnd; index --){
			if (data.get(index) > thresholdLo && data.get(index) < thresholdHi){
				window.add(index); //collect items in winLength		
				if (window.size() == winLength){
					return window.get(0); //return first index in win
				} 
			}else {
				window.clear(); //clear the list if item not winLenth 
			}
		}
		
		if (window.size() < winLength) {
			return -1; //return non true value (could maybe throw exception here)
		}
		
		return window.get(0);
	}
	
	/**
	 * from indexBegin to indexEnd, search data1 for values that are higher than threshold1 
	 * and also search data2 for values that are higher than threshold2. 
	 * Return the first index where both data1 and data2 have values that meet 
	 * these criteria for at least winLength samples.
	 * @param data1
	 * @param data2
	 * @param indexBegin
	 * @param indexEnd
	 * @param threshold1
	 * @param threshold2
	 * @param winLength
	 * @return
	 */
	public static int searchContinuityAboveValueTwoSignals(ArrayList<Float> data1, ArrayList<Float> data2, 
										int indexBegin, int indexEnd, float threshold1, 
										float threshold2, int winLength){
		ArrayList<Integer> window = new ArrayList<Integer>();
		for (int index = indexBegin; index <= indexEnd; index ++){
			if (data1.get(index) > threshold1 && data1.get(index) > threshold2){
				window.add(index); //collect items in winLength		
				if (window.size() == winLength){
					return window.get(0); //return first index in win
				} 
			}else {
				window.clear(); //clear the list if item not winLenth 
			}
		}
		
		if (window.size() < winLength) {
			return -1; //return non true value (could maybe throw exception here)
		}
		
		return window.get(0);
	}
	
	/**
	 *  from indexBegin to indexEnd, search data for values that are higher than thresholdLo 
	 *  and lower than thresholdHi. 
	 *  Return the the starting index and ending index of all continuous samples 
	 *  that meet this criteria for at least winLength data points
	 * @param data
	 * @param indexBegin
	 * @param indexEnd
	 * @param thresholdLo
	 * @param thresholdHi
	 * @param winLength
	 * @return
	 */
	public static ArrayList<int[]> searchMultiContinuityWithinRange(ArrayList<Float> data, int indexBegin, int indexEnd, 
			 			float thresholdLo, float thresholdHi, int winLength) {
		ArrayList<Integer> window = new ArrayList<Integer>();
		ArrayList<int[]> continuousSegments = new ArrayList<int[]>();
		
		for (int index = indexBegin; index <= indexEnd; index ++){
			if (data.get(index) > thresholdLo && data.get(index) < thresholdHi){
				window.add(index); //collect items in winLength		
				if (window.size() == winLength){
					int range []= {window.get(0), window.get(window.size()-1)};
					continuousSegments.add(range);
				} 
			}else {
				window.clear(); //clear the list if item not winLenth 
			}
		}
		if (continuousSegments.size() < 1) {
			int range []= {-1, -1}; //return non true value (could maybe throw exception here)
			continuousSegments.add(range);
		}
		
		return continuousSegments;
	}
}
