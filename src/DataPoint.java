/**
 * 
 * @author Revani Govender
 *
 * Create a DataPoint object with time, accelerometer and gyroscope data
 *
 */
public class DataPoint {
	private int time;
	private float ax;
	private float ay;
	private float az;
	private float wx;
	private float wy;
	private float wz;
	
	// each point is identified by time
	/**
	 * 
	 * @param time
	 * @param ax
	 * @param ay
	 * @param az
	 * @param wx
	 * @param wy
	 * @param wz
	 */
	public DataPoint(int time, float ax, float ay, float az,
								  float wx, float wy, float wz) {
		
			this.time = time;
			this.ax = ax;
			this.ay = ay;
			this.az = az;

			this.wx = wx;
			this.wy = wy;
			this.wz = wz;

	}

	public String toString() {
		return (time + ", " + ax + ", " + ay + ", " + az + 
				       ", " + wx + ", " + wy + ", " + wz);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public float getAx() {
		return ax;
	}

	public void setAx(float ax) {
		this.ax = ax;
	}

	public float getAy() {
		return ay;
	}

	public void setAy(float ay) {
		this.ay = ay;
	}

	public float getAz() {
		return az;
	}

	public void setAz(float az) {
		this.az = az;
	}

	public float getWx() {
		return wx;
	}

	public void setWx(float wx) {
		this.wx = wx;
	}

	public float getWy() {
		return wy;
	}

	public void setWy(float wy) {
		this.wy = wy;
	}

	public float getWz() {
		return wz;
	}

	public void setWz(float wz) {
		this.wz = wz;
	}
}
