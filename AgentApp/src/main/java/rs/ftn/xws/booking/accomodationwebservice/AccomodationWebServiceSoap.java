
package rs.ftn.xws.booking.accomodationwebservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AccomodationWebServiceSoap", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AccomodationWebServiceSoap {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addAccomodation", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.AddAccomodation")
    @ResponseWrapper(localName = "addAccomodationResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.AddAccomodationResponse")
    public Long addAccomodation(
        @WebParam(name = "arg0", targetNamespace = "")
        AccomodationSoap arg0);

    /**
     * 
     * @return
     *     returns java.util.List<rs.ftn.xws.booking.accomodationwebservice.AccomodationTypeSoap>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllAccomodationTypes", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllAccomodationTypes")
    @ResponseWrapper(localName = "getAllAccomodationTypesResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllAccomodationTypesResponse")
    public List<AccomodationTypeSoap> getAllAccomodationTypes();

    /**
     * 
     * @return
     *     returns java.util.List<rs.ftn.xws.booking.accomodationwebservice.CategorySoap>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCategories", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllCategories")
    @ResponseWrapper(localName = "getAllCategoriesResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllCategoriesResponse")
    public List<CategorySoap> getAllCategories();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteAccomodation", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.DeleteAccomodation")
    @ResponseWrapper(localName = "deleteAccomodationResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.DeleteAccomodationResponse")
    public Long deleteAccomodation(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<rs.ftn.xws.booking.accomodationwebservice.AccomodationSoap>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllResponse")
    public List<AccomodationSoap> getAll();

    /**
     * 
     * @return
     *     returns java.util.List<rs.ftn.xws.booking.accomodationwebservice.AdditionalServiceSoap>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllAdditionalServices", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllAdditionalServices")
    @ResponseWrapper(localName = "getAllAdditionalServicesResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.GetAllAdditionalServicesResponse")
    public List<AdditionalServiceSoap> getAllAdditionalServices();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "creatingTerm", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.CreatingTerm")
    @ResponseWrapper(localName = "creatingTermResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.CreatingTermResponse")
    public Long creatingTerm(
        @WebParam(name = "arg0", targetNamespace = "")
        TermSoap arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modifyAccomodation", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.ModifyAccomodation")
    @ResponseWrapper(localName = "modifyAccomodationResponse", targetNamespace = "http://booking.xws.ftn.rs/accomodationWebService", className = "rs.ftn.xws.booking.accomodationwebservice.ModifyAccomodationResponse")
    public Long modifyAccomodation(
        @WebParam(name = "arg0", targetNamespace = "")
        AccomodationSoap arg0);

}