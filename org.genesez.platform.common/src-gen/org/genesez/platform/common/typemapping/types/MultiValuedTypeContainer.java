//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.16 at 01:26:38 PM MESZ 
//


package org.genesez.platform.common.typemapping.types;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * former known as collectionTypes.
 * 
 * <p>Java class for multiValuedTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multiValuedTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.genesez.org/typemapping}multiValuedType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiValuedTypesType", propOrder = {
    "mappingList"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2012-10-16T01:26:38+02:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
public class MultiValuedTypeContainer {

    @XmlElement(name = "multiValuedType", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-10-16T01:26:38+02:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    protected List<MultiValuedType> mappingList;

    /**
     * Gets the value of the mappingList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mappingList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMappingList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultiValuedType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2012-10-16T01:26:38+02:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-646")
    public List<MultiValuedType> getMappingList() {
        if (mappingList == null) {
            mappingList = new ArrayList<MultiValuedType>();
        }
        return this.mappingList;
    }

}
