//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.02 at 04:28:19 PM MEZ 
//


package org.genesez.mapping.type.types;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Root element of the typemapping file
 * 
 * <p>Java class for typeMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeMappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.genesez.org/typemapping}include" minOccurs="0"/>
 *         &lt;element ref="{http://www.genesez.org/typemapping}multiValuedTypes" minOccurs="0"/>
 *         &lt;element ref="{http://www.genesez.org/typemapping}externalTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeMappingType", propOrder = {
    "includedFiles",
    "multiValuedTypes",
    "externalTypes"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
public class MappingBody {

    @XmlElement(name = "include")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected FileContainer includedFiles;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected MultiValuedTypeContainer multiValuedTypes;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected SingleValuedTypeContainer externalTypes;

    /**
     * Gets the value of the includedFiles property.
     * 
     * @return
     *     possible object is
     *     {@link FileContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public FileContainer getIncludedFiles() {
        return includedFiles;
    }

    /**
     * Sets the value of the includedFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setIncludedFiles(FileContainer value) {
        this.includedFiles = value;
    }

    /**
     * Gets the value of the multiValuedTypes property.
     * 
     * @return
     *     possible object is
     *     {@link MultiValuedTypeContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public MultiValuedTypeContainer getMultiValuedTypes() {
        return multiValuedTypes;
    }

    /**
     * Sets the value of the multiValuedTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiValuedTypeContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setMultiValuedTypes(MultiValuedTypeContainer value) {
        this.multiValuedTypes = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public boolean isSetMultiValuedTypes() {
        return (this.multiValuedTypes!= null);
    }

    /**
     * Gets the value of the externalTypes property.
     * 
     * @return
     *     possible object is
     *     {@link SingleValuedTypeContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public SingleValuedTypeContainer getExternalTypes() {
        return externalTypes;
    }

    /**
     * Sets the value of the externalTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleValuedTypeContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public void setExternalTypes(SingleValuedTypeContainer value) {
        this.externalTypes = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-02-02T04:28:19+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public boolean isSetExternalTypes() {
        return (this.externalTypes!= null);
    }

}
