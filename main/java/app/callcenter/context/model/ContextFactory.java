package app.callcenter.context.model;

import app.callcenter.context.model.call.CallContext;
import app.callcenter.request.exception.ContextNotImplementedException;

import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:45 PM.
 */
public class ContextFactory {

        public static Context getContext(String contextType) throws ContextNotImplementedException {

            if (contextType.equals("call")){
                CallContext ctx = new CallContext();
                String uniqueID = UUID.randomUUID().toString();
                ctx.setContextID(uniqueID + String.valueOf(new Date().getTime()));
                return ctx;
            }else
                throw new ContextNotImplementedException("No existe implementacion para el tipo de contexto  " + contextType);




        }



}


