
package rs.ftn.xws.booking.accomodationwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ftn.xws.booking.accomodationwebservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddAccomodationResponse_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "addAccomodationResponse");
    private final static QName _AddAccomodation_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "addAccomodation");
    private final static QName _AddLocation_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "addLocation");
    private final static QName _AddLocationResponse_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "addLocationResponse");
    private final static QName _ModifyAccomodationResponse_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "modifyAccomodationResponse");
    private final static QName _DeleteAccomodation_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "deleteAccomodation");
    private final static QName _DeleteAccomodationResponse_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "deleteAccomodationResponse");
    private final static QName _GetAll_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "getAll");
    private final static QName _GetAllResponse_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "getAllResponse");
    private final static QName _Accomodation_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "Accomodation");
    private final static QName _ModifyAccomodation_QNAME = new QName("http://booking.xws.ftn.rs/accomodationWebService", "modifyAccomodation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ftn.xws.booking.accomodationwebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccomodationSoap }
     * 
     */
    public AccomodationSoap createAccomodationSoap() {
        return new AccomodationSoap();
    }

    /**
     * Create an instance of {@link DeleteAccomodationResponse }
     * 
     */
    public DeleteAccomodationResponse createDeleteAccomodationResponse() {
        return new DeleteAccomodationResponse();
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link ModifyAccomodation }
     * 
     */
    public ModifyAccomodation createModifyAccomodation() {
        return new ModifyAccomodation();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link AddLocationResponse }
     * 
     */
    public AddLocationResponse createAddLocationResponse() {
        return new AddLocationResponse();
    }

    /**
     * Create an instance of {@link AddAccomodationResponse }
     * 
     */
    public AddAccomodationResponse createAddAccomodationResponse() {
        return new AddAccomodationResponse();
    }

    /**
     * Create an instance of {@link AddAccomodation }
     * 
     */
    public AddAccomodation createAddAccomodation() {
        return new AddAccomodation();
    }

    /**
     * Create an instance of {@link AddLocation }
     * 
     */
    public AddLocation createAddLocation() {
        return new AddLocation();
    }

    /**
     * Create an instance of {@link DeleteAccomodation }
     * 
     */
    public DeleteAccomodation createDeleteAccomodation() {
        return new DeleteAccomodation();
    }

    /**
     * Create an instance of {@link ModifyAccomodationResponse }
     * 
     */
    public ModifyAccomodationResponse createModifyAccomodationResponse() {
        return new ModifyAccomodationResponse();
    }

    /**
     * Create an instance of {@link AccomodationTypeSoap }
     * 
     */
    public AccomodationTypeSoap createAccomodationTypeSoap() {
        return new AccomodationTypeSoap();
    }

    /**
     * Create an instance of {@link AdditionalServiceSoap }
     * 
     */
    public AdditionalServiceSoap createAdditionalServiceSoap() {
        return new AdditionalServiceSoap();
    }

    /**
     * Create an instance of {@link LocationSoap }
     * 
     */
    public LocationSoap createLocationSoap() {
        return new LocationSoap();
    }

    /**
     * Create an instance of {@link TermSoap }
     * 
     */
    public TermSoap createTermSoap() {
        return new TermSoap();
    }

    /**
     * Create an instance of {@link AccomodationSoap.AdditionalServices }
     * 
     */
    public AccomodationSoap.AdditionalServices createAccomodationSoapAdditionalServices() {
        return new AccomodationSoap.AdditionalServices();
    }

    /**
     * Create an instance of {@link AccomodationSoap.Terms }
     * 
     */
    public AccomodationSoap.Terms createAccomodationSoapTerms() {
        return new AccomodationSoap.Terms();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccomodationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "addAccomodationResponse")
    public JAXBElement<AddAccomodationResponse> createAddAccomodationResponse(AddAccomodationResponse value) {
        return new JAXBElement<AddAccomodationResponse>(_AddAccomodationResponse_QNAME, AddAccomodationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccomodation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "addAccomodation")
    public JAXBElement<AddAccomodation> createAddAccomodation(AddAccomodation value) {
        return new JAXBElement<AddAccomodation>(_AddAccomodation_QNAME, AddAccomodation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "addLocation")
    public JAXBElement<AddLocation> createAddLocation(AddLocation value) {
        return new JAXBElement<AddLocation>(_AddLocation_QNAME, AddLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "addLocationResponse")
    public JAXBElement<AddLocationResponse> createAddLocationResponse(AddLocationResponse value) {
        return new JAXBElement<AddLocationResponse>(_AddLocationResponse_QNAME, AddLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyAccomodationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "modifyAccomodationResponse")
    public JAXBElement<ModifyAccomodationResponse> createModifyAccomodationResponse(ModifyAccomodationResponse value) {
        return new JAXBElement<ModifyAccomodationResponse>(_ModifyAccomodationResponse_QNAME, ModifyAccomodationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccomodation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "deleteAccomodation")
    public JAXBElement<DeleteAccomodation> createDeleteAccomodation(DeleteAccomodation value) {
        return new JAXBElement<DeleteAccomodation>(_DeleteAccomodation_QNAME, DeleteAccomodation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccomodationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "deleteAccomodationResponse")
    public JAXBElement<DeleteAccomodationResponse> createDeleteAccomodationResponse(DeleteAccomodationResponse value) {
        return new JAXBElement<DeleteAccomodationResponse>(_DeleteAccomodationResponse_QNAME, DeleteAccomodationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccomodationSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "Accomodation")
    public JAXBElement<AccomodationSoap> createAccomodation(AccomodationSoap value) {
        return new JAXBElement<AccomodationSoap>(_Accomodation_QNAME, AccomodationSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyAccomodation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/accomodationWebService", name = "modifyAccomodation")
    public JAXBElement<ModifyAccomodation> createModifyAccomodation(ModifyAccomodation value) {
        return new JAXBElement<ModifyAccomodation>(_ModifyAccomodation_QNAME, ModifyAccomodation.class, null, value);
    }

}
