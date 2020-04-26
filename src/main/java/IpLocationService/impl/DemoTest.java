package IpLocationService.impl;

public class DemoTest {

	public static void main(String[] args) {
		String ip="59.107.0.0";
		String type="";
		
		GetDistrictIdByIpTest getbyip =new GetDistrictIdByIpTest();
		getbyip.init();
		getbyip.action(ip, type);

	}

}
