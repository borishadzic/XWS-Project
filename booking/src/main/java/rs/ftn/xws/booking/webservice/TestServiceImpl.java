package rs.ftn.xws.booking.webservice;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service
@WebService(endpointInterface = "rs.ftn.xws.booking.webservice.TestService",
			serviceName = "TestService",
			portName = "TestServicePort",
			targetNamespace = "http://booking.xws.ftn.rs/test")
public class TestServiceImpl implements TestService {

	@Override
	public String testMethodOne() {
		return "SERVER: testMethodOne";
	}

	@Override
	public String testMethodTwo(String testString) {
		return "SERVER: " + testString;
	}

}
