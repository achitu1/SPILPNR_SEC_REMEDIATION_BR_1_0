// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.ibm.ejs.container;

import com.ibm.websphere.csi.CSIServant;
import com.ibm.websphere.csi.TransactionalObject;
import java.lang.String;
import java.lang.Throwable;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ServantObject;

public class _EJSRemoteWrapper_Stub extends Stub implements CSIServant,
TransactionalObject {
    
    private static final String[] _type_ids = {
        "RMI:com.ibm.ejs.container.EJSRemoteWrapper:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public String[] _ids() { 
        return (String [] )  _type_ids.clone();
    }
    
    public boolean wlmable() throws RemoteException {
        while(true) {
            if (!Util.isLocal(this)) {
                InputStream in = null;
                try {
                    try {
                        OutputStream out = _request("wlmable", true);
                        in = _invoke(out);
                        return in.read_boolean();
                    } catch (ApplicationException ex) {
                        in = ex.getInputStream();
                        String id = in.read_string();
                        throw new UnexpectedException(id);
                    } catch (RemarshalException ex) {
                        continue;
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                } finally {
                    _releaseReply(in);
                }
            } else {
                ServantObject so = _servant_preinvoke("wlmable",com.ibm.websphere.csi.CSIServant.class);
                if (so == null) {
                    continue;
                }
                try {
                    return ((com.ibm.websphere.csi.CSIServant)so.servant).wlmable();
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
    }
}
