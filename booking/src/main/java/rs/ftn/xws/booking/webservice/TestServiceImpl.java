package rs.ftn.xws.booking.webservice;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import rs.ftn.xws.booking.service.StorageService;

@Service
@MTOM(enabled = true)
@WebService(endpointInterface = "rs.ftn.xws.booking.webservice.TestService",
			serviceName = "TestService",
			portName = "TestServicePort",
			targetNamespace = "http://booking.xws.ftn.rs/test")
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@Resource
	private WebServiceContext webServiceContext;
	
	@Autowired
	@Qualifier("Azure")
	private StorageService storageService;

	@Override
	public void uploadMultiple(UploadModelXsd fileUploadServer)  {
		for (DataHandler data: fileUploadServer.getImages()) {
			try {
				String imageUrl = storageService.saveFile(data.getInputStream());
			} catch (IOException e) {
				logger.error(e.getMessage());
				throw new WebServiceException("An error has occured");
			}
		}
	}

}
