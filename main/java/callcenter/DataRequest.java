package callcenter;

import callcenter.request.CenterRequest;
import callcenter.context.model.Context;
import callcenter.context.model.ContextFactory;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:11 PM.
 */


public class DataRequest implements CenterRequest {


    public void prosessRequest(String req){


        Context ctx = ContextFactory.getContext(req);

        Dispatcher dispatcher = new Dispatcher(ctx);
        dispatcher.dispatcherCall();



        // create context

    }





}
