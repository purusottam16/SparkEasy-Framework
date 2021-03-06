//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.11 at 06:50:12 PM IST 
//


package org.sparkeasy.web.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sparkeasy-config complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sparkeasy-config">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="global-forwards" type="{http://www.sparkeasy.org/web/config}global-forwards"/>
 *         &lt;element name="command-mappings" type="{http://www.sparkeasy.org/web/config}command-mappings" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sparkeasy-config", propOrder = {
    "globalForwards",
    "commandMappings"
})
public class SparkeasyConfig {

    @XmlElement(name = "global-forwards", required = true)
    protected GlobalForwards globalForwards;
    @XmlElement(name = "command-mappings")
    protected CommandMappings commandMappings;

    /**
     * Gets the value of the globalForwards property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalForwards }
     *     
     */
    public GlobalForwards getGlobalForwards() {
        return globalForwards;
    }

    /**
     * Sets the value of the globalForwards property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalForwards }
     *     
     */
    public void setGlobalForwards(GlobalForwards value) {
        this.globalForwards = value;
    }

    /**
     * Gets the value of the commandMappings property.
     * 
     * @return
     *     possible object is
     *     {@link CommandMappings }
     *     
     */
    public CommandMappings getCommandMappings() {
        return commandMappings;
    }

    /**
     * Sets the value of the commandMappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandMappings }
     *     
     */
    public void setCommandMappings(CommandMappings value) {
        this.commandMappings = value;
    }

}
