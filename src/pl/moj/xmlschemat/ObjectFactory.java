//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.10 at 06:26:03 AM CET 
//


package pl.moj.xmlschemat;

import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.moj.xmlschemat package. 
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

    private final static QName _LiczbaSztuk_QNAME = new QName("http://moj.pl/xmlschemat", "liczbaSztuk");
    private final static QName _Płytoteka_QNAME = new QName("http://moj.pl/xmlschemat", "p\u0142ytoteka");
    private final static QName _AutorzyAutor_QNAME = new QName("http://moj.pl/xmlschemat", "autor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.moj.xmlschemat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Płyta }
     * 
     */
    public Płyta createPłyta() {
        return new Płyta();
    }

    /**
     * Create an instance of {@link Płytoteka }
     * 
     */
    public Płytoteka createPłytoteka() {
        return new Płytoteka();
    }

    /**
     * Create an instance of {@link Wykonawca }
     * 
     */
    public Wykonawca createWykonawca() {
        return new Wykonawca();
    }

    /**
     * Create an instance of {@link DataZałożenia }
     * 
     */
    public DataZałożenia createDataZałożenia() {
        return new DataZałożenia();
    }

    /**
     * Create an instance of {@link DataWydania }
     * 
     */
    public DataWydania createDataWydania() {
        return new DataWydania();
    }

    /**
     * Create an instance of {@link Wydawca }
     * 
     */
    public Wydawca createWydawca() {
        return new Wydawca();
    }

    /**
     * Create an instance of {@link Autorzy }
     * 
     */
    public Autorzy createAutorzy() {
        return new Autorzy();
    }

    /**
     * Create an instance of {@link Cena }
     * 
     */
    public Cena createCena() {
        return new Cena();
    }

    /**
     * Create an instance of {@link Płyta.WydawcaPłyty }
     * 
     */
    public Płyta.WydawcaPłyty createPłytaWydawcaPłyty() {
        return new Płyta.WydawcaPłyty();
    }

    /**
     * Create an instance of {@link Płyta.Gatunek }
     * 
     */
    public Płyta.Gatunek createPłytaGatunek() {
        return new Płyta.Gatunek();
    }

    /**
     * Create an instance of {@link Płytoteka.Info }
     * 
     */
    public Płytoteka.Info createPłytotekaInfo() {
        return new Płytoteka.Info();
    }

    /**
     * Create an instance of {@link Płytoteka.KatalogPłyt }
     * 
     */
    public Płytoteka.KatalogPłyt createPłytotekaKatalogPłyt() {
        return new Płytoteka.KatalogPłyt();
    }

    /**
     * Create an instance of {@link Płytoteka.Wydawcy }
     * 
     */
    public Płytoteka.Wydawcy createPłytotekaWydawcy() {
        return new Płytoteka.Wydawcy();
    }

    /**
     * Create an instance of {@link Płytoteka.Wykonawcy }
     * 
     */
    public Płytoteka.Wykonawcy createPłytotekaWykonawcy() {
        return new Płytoteka.Wykonawcy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://moj.pl/xmlschemat", name = "liczbaSztuk")
    public JAXBElement<BigInteger> createLiczbaSztuk(BigInteger value) {
        return new JAXBElement<BigInteger>(_LiczbaSztuk_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Płytoteka }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://moj.pl/xmlschemat", name = "p\u0142ytoteka")
    public JAXBElement<Płytoteka> createPłytoteka(Płytoteka value) {
        return new JAXBElement<Płytoteka>(_Płytoteka_QNAME, Płytoteka.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://moj.pl/xmlschemat", name = "autor", scope = Autorzy.class)
    public JAXBElement<List<String>> createAutorzyAutor(List<String> value) {
        return new JAXBElement<List<String>>(_AutorzyAutor_QNAME, ((Class) List.class), Autorzy.class, ((List<String> ) value));
    }

}
