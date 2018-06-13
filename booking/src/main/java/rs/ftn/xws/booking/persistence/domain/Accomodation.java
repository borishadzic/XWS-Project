package rs.ftn.xws.booking.persistence.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Accomodation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank
	private String name;

	@Column
	@NotBlank
	private String country;

	@Column
	@NotBlank
	private String city;

	@Column
	@NotBlank
	private String address;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accomodation", cascade = CascadeType.ALL)
	private List<Term> terms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accomodation", cascade = CascadeType.ALL)
	private List<AccomodationImage> images;

	public Accomodation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccomodationImage> getImages() {
		return images;
	}

	public void setImages(List<AccomodationImage> images) {
		this.images = images;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
