
public class NetPay {
	
	public static double netPayRate(double hourlyPayRate, double tipRate){
    	double netPayRate=(hourlyPayRate*tipRate)+hourlyPayRate;

        return netPayRate*40;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
