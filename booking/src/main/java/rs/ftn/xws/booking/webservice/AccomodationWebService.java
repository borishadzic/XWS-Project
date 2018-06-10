package rs.ftn.xws.booking.webservice;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;

import rs.ftn.xws.booking.xsd.AccomodationSoap;
import rs.ftn.xws.booking.xsd.LocationSoap;

@WebService(name = "AccomodationWebServiceSoap", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService")
@SchemaValidation(type = SchemaValidationType.REQUEST)
public interface AccomodationWebService {
	
	//proba
	Long addLocation(LocationSoap location);

	//prevodi jaxb model u model koji se cuva u bazu i vraca id iz baze
	Long addAccomodation(AccomodationSoap accomodation);
	
	Long modifyAccomodation(AccomodationSoap accomodation);
	
	Long deleteAccomodation(Long accomodationId);
	
	List<AccomodationSoap> getAll();
	
}
