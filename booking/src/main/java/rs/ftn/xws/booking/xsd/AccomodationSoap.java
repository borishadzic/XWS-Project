package rs.ftn.xws.booking.xsd;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Accomodation")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccomodationSoap {
	
	@XmlElement(name = "location", required = true)
	private LocationSoap location;
	
	@XmlElement(name = "accomodationType", required = true)
	private AccomodationTypeSoap accomodationType;
	
	@XmlElement(name = "description", required = true)
	private String description;
	
	@XmlElement(name = "capacity", required = true)
	private int capacity;
	
	@XmlElementWrapper(name = "additionalServices", required = true)
	@XmlElement(name = "service", required = true)
	private ArrayList<AdditionalServiceSoap> additionalServices;
	
	@XmlElementWrapper(name = "terms", required = true)
	@XmlElement(name = "term", required = true)
	private ArrayList<TermSoap> terms;

	public LocationSoap getLocation() {
		return location;
	}

	public void setLocation(LocationSoap location) {
		this.location = location;
	}

	public AccomodationTypeSoap getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(AccomodationTypeSoap accomodationType) {
		this.accomodationType = accomodationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<AdditionalServiceSoap> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<AdditionalServiceSoap> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ArrayList<TermSoap> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<TermSoap> terms) {
		this.terms = terms;
	}

}
