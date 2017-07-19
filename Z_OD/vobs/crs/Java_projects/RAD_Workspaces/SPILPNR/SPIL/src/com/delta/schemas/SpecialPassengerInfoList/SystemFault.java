//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoList;

import javax.xml.ws.WebFault;

@WebFault(name = "SystemFault", targetNamespace = "http://schemas.delta.com/common/fault/v4")
public class SystemFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SystemFaultType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public SystemFault(String message, SystemFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param message
     * @param cause
     */
    public SystemFault(String message, SystemFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.delta.schemas.SpecialPassengerInfoList.SystemFaultType
     */
    public SystemFaultType getFaultInfo() {
        return faultInfo;
    }

}
