package app.callcenter.context.model;

import app.callcenter.context.model.call.CallContext;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:45 PM.
 */
public class ContextFactory {

        public static Context getContext(String contextType){

            if (contextType.equals("call")){
                return new CallContext();
            }


            return null;
        }



}


