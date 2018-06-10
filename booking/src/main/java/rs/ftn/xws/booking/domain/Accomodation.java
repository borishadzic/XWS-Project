package rs.ftn.xws.booking.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Accomodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	@NotBlank
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "typeId")
	@NotBlank
	private AccomodationType accomodationType;
	
	@Column
	@NotBlank
	private String description;
	
	@Column
	@NotBlank
	private int capacity;
	
	@ManyToMany
	private Set<AdditionalService> additionalServices;
	
	@ManyToMany
	private Set<Term> terms;
	
	public Accomodation() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public AccomodationType getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(AccomodationType accomodationType) {
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

	public Set<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(Set<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public Set<Term> getTerms() {
		return terms;
	}

	public void setTerms(Set<Term> terms) {
		this.terms = terms;
	}
	
}
