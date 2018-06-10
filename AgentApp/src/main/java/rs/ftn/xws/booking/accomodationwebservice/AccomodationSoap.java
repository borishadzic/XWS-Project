
package rs.ftn.xws.booking.accomodationwebservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accomodationSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accomodationSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://booking.xws.ftn.rs/accomodationWebService}locationSoap"/>
 *         &lt;element name="accomodationType" type="{http://booking.xws.ftn.rs/accomodationWebService}accomodationTypeSoap"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="additionalServices">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="service" type="{http://booking.xws.ftn.rs/accomodationWebService}additionalServiceSoap" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="terms">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="term" type="{http://booking.xws.ftn.rs/accomodationWebService}termSoap" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accomodationSoap", propOrder = {
    "location",
    "accomodationType",
    "description",
    "capacity",
    "additionalServices",
    "terms"
})
public class AccomodationSoap {

    @XmlElement(required = true)
    protected LocationSoap location;
    @XmlElement(required = true)
    protected AccomodationTypeSoap accomodationType;
    @XmlElement(required = true)
    protected String description;
    protected int capacity;
    @XmlElement(required = true)
    protected AccomodationSoap.AdditionalServices additionalServices;
    @XmlElement(required = true)
    protected AccomodationSoap.Terms terms;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationSoap }
     *     
     */
    public LocationSoap getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationSoap }
     *     
     */
    public void setLocation(LocationSoap value) {
        this.location = value;
    }

    /**
     * Gets the value of the accomodationType property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationTypeSoap }
     *     
     */
    public AccomodationTypeSoap getAccomodationType() {
        return accomodationType;
    }

    /**
     * Sets the value of the accomodationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationTypeSoap }
     *     
     */
    public void setAccomodationType(AccomodationTypeSoap value) {
        this.accomodationType = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     */
    public void setCapacity(int value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the additionalServices property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationSoap.AdditionalServices }
     *     
     */
    public AccomodationSoap.AdditionalServices getAdditionalServices() {
        return additionalServices;
    }

    /**
     * Sets the value of the additionalServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationSoap.AdditionalServices }
     *     
     */
    public void setAdditionalServices(AccomodationSoap.AdditionalServices value) {
        this.additionalServices = value;
    }

    /**
     * Gets the value of the terms property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationSoap.Terms }
     *     
     */
    public AccomodationSoap.Terms getTerms() {
        return terms;
    }

    /**
     * Sets the value of the terms property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationSoap.Terms }
     *     
     */
    public void setTerms(AccomodationSoap.Terms value) {
        this.terms = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="service" type="{http://booking.xws.ftn.rs/accomodationWebService}additionalServiceSoap" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "service"
    })
    public static class AdditionalServices {

        @XmlElement(required = true)
        protected List<AdditionalServiceSoap> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AdditionalServiceSoap }
         * 
         * 
         */
        public List<AdditionalServiceSoap> getService() {
            if (service == null) {
                service = new ArrayList<AdditionalServiceSoap>();
            }
            return this.service;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="term" type="{http://booking.xws.ftn.rs/accomodationWebService}termSoap" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "term"
    })
    public static class Terms {

        @XmlElement(required = true)
        protected List<TermSoap> term;

        /**
         * Gets the value of the term property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the term property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTerm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TermSoap }
         * 
         * 
         */
        public List<TermSoap> getTerm() {
            if (term == null) {
                term = new ArrayList<TermSoap>();
            }
            return this.term;
        }

    }

}
