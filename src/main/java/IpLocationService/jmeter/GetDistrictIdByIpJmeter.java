package IpLocationService.jmeter;

import com.lvmama.php_dubbo.IpLocationService.impl.GetDistrictIdByIpTest;
import com.lvmama.phppid.vo.ResultHandleT;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Map;

public class GetDistrictIdByIpJmeter extends AbstractJavaSamplerClient{
	
	private String ip;
	private String type;
	private String Samplelabel = "GetDistrictIdByIP";
	GetDistrictIdByIpTest getDistrictIdByIP;
	ResultHandleT<Map<String, Object>> result;
	Arguments params;
	
	public void setupTest (JavaSamplerContext context){
		
		getDistrictIdByIP =new GetDistrictIdByIpTest();
		getDistrictIdByIP.init();
		
	}
	
	public Arguments getDefaultParameters(){
		params =new Arguments();
		params.addArgument("ip", "");
		params.addArgument("type", "");		
		return params;
	}
	
	public SampleResult runTest(JavaSamplerContext arg0){
		SampleResult results = new SampleResult();
		
		ip=arg0.getParameter("ip");
		type=arg0.getParameter("type");
		ip = arg0.getParameter("ip");
		type = arg0.getParameter("type");			
		results.setSampleLabel(Samplelabel);	        	  //jmeter结果对象
		
		results.sampleStart();                                //jmeter 开始统计响应时间标记
	    result = getDistrictIdByIP.action(ip,type);
	    if(result.isSuccess()==true){
	    	results.setSuccessful(true);
	        results.setResponseMessage("执行成功");            //设置检查点
	    }else{
	    	results.setSuccessful(false);
		    results.setResponseMessage(result.getErrorCode());
	    }
	    
		results.sampleEnd();                                  //jmeter 结束统计响应时间标记
		
		return results;
	}
}
