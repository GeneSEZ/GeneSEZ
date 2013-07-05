//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.02 at 04:28:19 PM MEZ 
//


package org.genesez.mapping.type.types;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for multiValuedTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multiValuedTypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.genesez.org/typemapping}default"/>
 *         &lt;sequence>
 *           &lt;element ref="{http://www.genesez.org/typemapping}context" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.genesez.org/typemapping}multiValuedAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiValuedTypeType", propOrder = {
    "destinationMapping",
    "contextMap"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
public class MultiValuedType {

    @XmlElement(name = "default", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected String destinationMapping;
    @XmlElement(name = "context")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected List<Context> contextMap;
    @XmlAttribute
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected Boolean unique;
    @XmlAttribute
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected Boolean ordered;

    /**
     * Gets the value of the destinationMapping property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public String getDestinationMapping() {
        return destinationMapping;
    }

    /**
     * Sets the value of the destinationMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setDestinationMapping(String value) {
        this.destinationMapping = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public boolean isSetDestinationMapping() {
        return (this.destinationMapping!= null);
    }

    /**
     * Gets the value of the contextMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContextMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Context }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public List<Context> getContextMap() {
        if (contextMap == null) {
            contextMap = new ArrayList<Context>();
        }
        return this.contextMap;
    }

    /**
     * Gets the value of the unique property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public boolean getUnique() {
        if (unique == null) {
            return true;
        } else {
            return unique;
        }
    }

    /**
     * Sets the value of the unique property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setUnique(Boolean value) {
        this.unique = value;
    }

    /**
     * Gets the value of the ordered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public boolean getOrdered() {
        if (ordered == null) {
            return false;
        } else {
            return ordered;
        }
    }

    /**
     * Sets the value of the ordered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setOrdered(Boolean value) {
        this.ordered = value;
    }

}
