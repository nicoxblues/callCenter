package app.callcenter.request;

import app.callcenter.Dispatcher;
import app.callcenter.context.model.Context;
import app.callcenter.context.model.ContextFactory;
import app.callcenter.request.exception.ContextNotImplementedException;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:43 PM.
 */
public class DataRequest implements CenterRequest {


    @Override
    public void prosessRequest(String req) {

        Context ctx;
        try {
            ctx = ContextFactory.getContext(req);


            Dispatcher dispatcher = new Dispatcher(ctx);
     //       dispatcher.dispatchCall();
            new Thread(() -> {
                try {
                    dispatcher.dispatchCall();
                }
                catch (Exception e){
                    System.err.println(e);
                }
            }).start();



        } catch (ContextNotImplementedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }


    }
}
