package app.callcenter.context.model;

import app.callcenter.context.model.call.CallContext;
import app.callcenter.request.exception.ContextNotImplementedException;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:45 PM.
 */
public class ContextFactory {

        public static Context getContext(String contextType) throws ContextNotImplementedException {

            if (contextType.equals("call")){
                return new CallContext();
            }else
                throw new ContextNotImplementedException("No existe implementacion para el tipo de contexto  " + contextType);




        }



}


