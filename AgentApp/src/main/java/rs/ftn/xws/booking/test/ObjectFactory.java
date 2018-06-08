
package rs.ftn.xws.booking.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ftn.xws.booking.test package. 
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

    private final static QName _TestMethodOne_QNAME = new QName("http://booking.xws.ftn.rs/test", "testMethodOne");
    private final static QName _TestMethodOneResponse_QNAME = new QName("http://booking.xws.ftn.rs/test", "testMethodOneResponse");
    private final static QName _TestMethodTwoResponse_QNAME = new QName("http://booking.xws.ftn.rs/test", "testMethodTwoResponse");
    private final static QName _TestMethodTwo_QNAME = new QName("http://booking.xws.ftn.rs/test", "testMethodTwo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ftn.xws.booking.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestMethodTwo }
     * 
     */
    public TestMethodTwo createTestMethodTwo() {
        return new TestMethodTwo();
    }

    /**
     * Create an instance of {@link TestMethodOne }
     * 
     */
    public TestMethodOne createTestMethodOne() {
        return new TestMethodOne();
    }

    /**
     * Create an instance of {@link TestMethodOneResponse }
     * 
     */
    public TestMethodOneResponse createTestMethodOneResponse() {
        return new TestMethodOneResponse();
    }

    /**
     * Create an instance of {@link TestMethodTwoResponse }
     * 
     */
    public TestMethodTwoResponse createTestMethodTwoResponse() {
        return new TestMethodTwoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMethodOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/test", name = "testMethodOne")
    public JAXBElement<TestMethodOne> createTestMethodOne(TestMethodOne value) {
        return new JAXBElement<TestMethodOne>(_TestMethodOne_QNAME, TestMethodOne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMethodOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/test", name = "testMethodOneResponse")
    public JAXBElement<TestMethodOneResponse> createTestMethodOneResponse(TestMethodOneResponse value) {
        return new JAXBElement<TestMethodOneResponse>(_TestMethodOneResponse_QNAME, TestMethodOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMethodTwoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/test", name = "testMethodTwoResponse")
    public JAXBElement<TestMethodTwoResponse> createTestMethodTwoResponse(TestMethodTwoResponse value) {
        return new JAXBElement<TestMethodTwoResponse>(_TestMethodTwoResponse_QNAME, TestMethodTwoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMethodTwo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://booking.xws.ftn.rs/test", name = "testMethodTwo")
    public JAXBElement<TestMethodTwo> createTestMethodTwo(TestMethodTwo value) {
        return new JAXBElement<TestMethodTwo>(_TestMethodTwo_QNAME, TestMethodTwo.class, null, value);
    }

}
