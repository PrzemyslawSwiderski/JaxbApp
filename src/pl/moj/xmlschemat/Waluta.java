//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.10 at 06:26:03 AM CET 
//


package pl.moj.xmlschemat;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waluta.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="waluta">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="złotych"/>
 *     &lt;enumeration value="dolarów"/>
 *     &lt;enumeration value="euro"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "waluta")
@XmlEnum
public enum Waluta {

    @XmlEnumValue("złotych")
    ZŁOTYCH("złotych"),
    @XmlEnumValue("dolarów")
    DOLARÓW("dolarów"),
    @XmlEnumValue("euro")
    EURO("euro");
    private final String value;

    Waluta(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Waluta fromValue(String v) {
        for (Waluta c: Waluta.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}