
package rs.ftn.xws.booking.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for testMethodTwo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="testMethodTwo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "testMethodTwo", propOrder = {
    "testString"
})
public class TestMethodTwo {

    protected String testString;

    /**
     * Gets the value of the testString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestString() {
        return testString;
    }

    /**
     * Sets the value of the testString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestString(String value) {
        this.testString = value;
    }

}
