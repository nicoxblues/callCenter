package app.callcenter.request;

import app.callcenter.Dispatcher;
import app.callcenter.context.model.Context;
import app.callcenter.context.model.ContextFactory;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:43 PM.
 */
public class DataRequest implements CenterRequest {


    @Override
    public void prosessRequest(String req) {

        Context ctx = ContextFactory.getContext(req);

        Dispatcher dispatcher = new Dispatcher(ctx);
        dispatcher.dispatcherCall();



        // create context

    }
}
