package IpLocationService.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.lvmama.phppid.ip.service.IpLocationService;
import com.lvmama.phppid.vo.ResultHandleT;

import java.util.Map;

public class GetDistrictIdByIpTest {
	
	public IpLocationService ipLocationService;
	
	public void init(){//从dubbo注册中心获取实例
		ApplicationConfig application = new ApplicationConfig();
		application.setName("PHP_DUBBO");
		
		RegistryConfig registryconfig = new RegistryConfig();
		registryconfig.setAddress("192.168.0.208:2181");//设置注册地址
		registryconfig.setProtocol("zookeeper");//设置通信协议
		
		ReferenceConfig<IpLocationService> reference = new ReferenceConfig<IpLocationService>();
		reference.setApplication(application);
		reference.setRegistry(registryconfig);
		reference.setInterface(IpLocationService.class);//注册响应实例
		
		ipLocationService=reference.get();//获取实例
		
	}
	
	public ResultHandleT<Map<String, Object>> action(String ip, String type){
		
		ResultHandleT<Map<String, Object>> result = new ResultHandleT<Map<String, Object>>();
		result=ipLocationService.getDistrictIdByIp(ip, type);
		
		System.out.println(result.getReturnContent());
		
		return result;
	}

}
