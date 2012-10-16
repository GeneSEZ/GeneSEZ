//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.25 at 01:44:42 PM CET 
//


package org.genesez.mapping.type.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.genesez.platform.common.typemapping.types package. 
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

    private final static QName _MultiValuedType_QNAME = new QName("http://www.genesez.org/typemapping", "multiValuedType");
    private final static QName _TypeMapping_QNAME = new QName("http://www.genesez.org/typemapping", "typeMapping");
    private final static QName _Include_QNAME = new QName("http://www.genesez.org/typemapping", "include");
    private final static QName _MultiValuedTypes_QNAME = new QName("http://www.genesez.org/typemapping", "multiValuedTypes");
    private final static QName _To_QNAME = new QName("http://www.genesez.org/typemapping", "to");
    private final static QName _Type_QNAME = new QName("http://www.genesez.org/typemapping", "type");
    private final static QName _File_QNAME = new QName("http://www.genesez.org/typemapping", "file");
    private final static QName _Context_QNAME = new QName("http://www.genesez.org/typemapping", "context");
    private final static QName _Default_QNAME = new QName("http://www.genesez.org/typemapping", "default");
    private final static QName _PrimitiveTypes_QNAME = new QName("http://www.genesez.org/typemapping", "primitiveTypes");
    private final static QName _ExternalTypes_QNAME = new QName("http://www.genesez.org/typemapping", "externalTypes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.genesez.platform.common.typemapping.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultiValuedType }
     * 
     */
    public MultiValuedType createMultiValuedType() {
        return new MultiValuedType();
    }

    /**
     * Create an instance of {@link MappingBody }
     * 
     */
    public MappingBody createMappingBody() {
        return new MappingBody();
    }

    /**
     * Create an instance of {@link MultiValuedTypeContainer }
     * 
     */
    public MultiValuedTypeContainer createMultiValuedTypeContainer() {
        return new MultiValuedTypeContainer();
    }

    /**
     * Create an instance of {@link Context }
     * 
     */
    public Context createContext() {
        return new Context();
    }

    /**
     * Create an instance of {@link SingleValuedType }
     * 
     */
    public SingleValuedType createSingleValuedType() {
        return new SingleValuedType();
    }

    /**
     * Create an instance of {@link FileContainer }
     * 
     */
    public FileContainer createFileContainer() {
        return new FileContainer();
    }

    /**
     * Create an instance of {@link SingleValuedTypeContainer }
     * 
     */
    public SingleValuedTypeContainer createSingleValuedTypeContainer() {
        return new SingleValuedTypeContainer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiValuedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "multiValuedType")
    public JAXBElement<MultiValuedType> createMultiValuedType(MultiValuedType value) {
        return new JAXBElement<MultiValuedType>(_MultiValuedType_QNAME, MultiValuedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MappingBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "typeMapping")
    public JAXBElement<MappingBody> createTypeMapping(MappingBody value) {
        return new JAXBElement<MappingBody>(_TypeMapping_QNAME, MappingBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "include")
    public JAXBElement<FileContainer> createInclude(FileContainer value) {
        return new JAXBElement<FileContainer>(_Include_QNAME, FileContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiValuedTypeContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "multiValuedTypes")
    public JAXBElement<MultiValuedTypeContainer> createMultiValuedTypes(MultiValuedTypeContainer value) {
        return new JAXBElement<MultiValuedTypeContainer>(_MultiValuedTypes_QNAME, MultiValuedTypeContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "to")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createTo(String value) {
        return new JAXBElement<String>(_To_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleValuedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "type")
    public JAXBElement<SingleValuedType> createType(SingleValuedType value) {
        return new JAXBElement<SingleValuedType>(_Type_QNAME, SingleValuedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "file")
    public JAXBElement<String> createFile(String value) {
        return new JAXBElement<String>(_File_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "context")
    public JAXBElement<Context> createContext(Context value) {
        return new JAXBElement<Context>(_Context_QNAME, Context.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "default")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDefault(String value) {
        return new JAXBElement<String>(_Default_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleValuedTypeContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "primitiveTypes")
    public JAXBElement<SingleValuedTypeContainer> createPrimitiveTypes(SingleValuedTypeContainer value) {
        return new JAXBElement<SingleValuedTypeContainer>(_PrimitiveTypes_QNAME, SingleValuedTypeContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleValuedTypeContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.genesez.org/typemapping", name = "externalTypes")
    public JAXBElement<SingleValuedTypeContainer> createExternalTypes(SingleValuedTypeContainer value) {
        return new JAXBElement<SingleValuedTypeContainer>(_ExternalTypes_QNAME, SingleValuedTypeContainer.class, null, value);
    }

}
