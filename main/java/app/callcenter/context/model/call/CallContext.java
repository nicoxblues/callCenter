package app.callcenter.context.model.call;

import app.callcenter.context.model.Context;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:46 PM.
 */


public class CallContext extends Context {



    @Override
    protected void initCommunication() {
        this.getContextOwnerEmploye();

    }

    @Override
    protected void executeAction() {

    }

    @Override
    public void doAction() {

        super.doAction();
    }
}
