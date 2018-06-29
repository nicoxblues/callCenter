package app.callcenter;

import app.callcenter.context.model.Context;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:00 PM.
 */

public class Dispatcher {


    private Context dispatcherContext;


    public Dispatcher (Context DispatcherCtx ){

        this.dispatcherContext = DispatcherCtx;

    }


    public void dispatchCall() {
        TurnContextHandler.getInstance().assignContext(this.dispatcherContext);
        this.dispatcherContext.init();








    }

}