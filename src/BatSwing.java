import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * @author Revani Govender
 *
 */

public class BatSwing {

	public static void main(String[] args) throws IOException {
		ArrayList<DataPoint> swing = ProcessSwingData.readFile("src/latestSwing.csv");
		ArrayList<Integer> times = new ArrayList<Integer>();
		ArrayList<Float> ax = new ArrayList<Float>();
		ArrayList<Float> ay = new ArrayList<Float>();
		ArrayList<Float> az = new ArrayList<Float>();
		ArrayList<Float> wx = new ArrayList<Float>();
		ArrayList<Float> wy = new ArrayList<Float>();
		ArrayList<Float> wz = new ArrayList<Float>();

		for (DataPoint point : swing) {
			//System.out.println(point.toString());
			times.add(point.getTime());
			ax.add(point.getAx());
			ay.add(point.getAy());
			az.add(point.getAz());
			wx.add(point.getWx());
			wy.add(point.getWy());
			wz.add(point.getWz());
		}
		
		int continuousAboveValue = CalculateData.searchContinuityAboveValue(ax, 0, 1000, 3, 2);
		int backContinuity = CalculateData.backSearchContinuityWithinRange(ay, 1200, 500, 1, 5, 5);
		int continuityTwoSignals = CalculateData.searchContinuityAboveValueTwoSignals(ax, ay, 0, 1000, 2, 3, 2); 
		ArrayList<int[]> multi = CalculateData.searchMultiContinuityWithinRange(wx, 50, 1200, 3, 5, 3);
		//	System.out.println(times.toString());
		System.out.println(ax.toString());
//		System.out.println(ay.toString());
//		System.out.println(az.toString());
//		System.out.println(wx.toString());
//		System.out.println(wy.toString());
//		System.out.println(wz.toString());
		
		System.out.println(continuousAboveValue);
		System.out.println(backContinuity);
		System.out.println(continuityTwoSignals);
		for(int[] array : multi) {
		    System.out.println(Arrays.toString(array));
		}
		
	}
	

	

}
