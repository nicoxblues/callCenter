package app.callcenter.request;

import app.callcenter.Dispatcher;
import app.callcenter.context.model.Context;
import app.callcenter.context.model.ContextFactory;
import app.callcenter.request.exception.ContextNotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:43 PM.
 */
public class DataRequest implements CenterRequest {
    private final static int NTHREAD = 1;

    private static int numCurrentThread = 0;

    private static ExecutorService pool = Executors.newFixedThreadPool(NTHREAD);


    @Override
    public void prosessRequest(String req) {

        Context ctx;
        try {
            ctx = ContextFactory.getContext(req);


            Dispatcher dispatcher = new Dispatcher(ctx);


            new Thread(() -> {
                try {
                    dispatcher.dispatchCall();

                } catch (Exception e) {
                    System.err.println(e);
                }
            }).start();








        } catch (ContextNotImplementedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }catch(RejectedExecutionException exRejectTh){
            System.out.println("Limite de llamadas entrantes ".concat(exRejectTh.getMessage()) );
        }


    }
}
