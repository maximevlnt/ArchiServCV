package fr.insa.soap.wsdltojava;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2024-10-18T16:47:32.807+02:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "http://soap.insa.fr/", name = "AnalyserChainesWS")
@XmlSeeAlso({ObjectFactory.class})
public interface AnalyserChainesWS {

    @WebMethod
    @Action(input = "http://soap.insa.fr/AnalyserChainesWS/compareRequest", output = "http://soap.insa.fr/AnalyserChainesWS/compareResponse")
    @RequestWrapper(localName = "compare", targetNamespace = "http://soap.insa.fr/", className = "fr.insa.soap.wsdltojava.Compare")
    @ResponseWrapper(localName = "compareResponse", targetNamespace = "http://soap.insa.fr/", className = "fr.insa.soap.wsdltojava.CompareResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int compare(

        @WebParam(name = "chain", targetNamespace = "")
        java.lang.String chain
    );
}
