import javax.swing.JFrame;

public class Adapter extends JFrame{
public	static Long Phone_val;
	public static int val;

	public static int getVal() {
		return val;
	}

	public static void setVal(int val) {
		Adapter.val = val;
	}

	public void setPhone_val(int phone_val) {
		Phone_val = (long) phone_val;
	}

	public Long getPhone_val() {
		return Phone_val;
	}
	

}
