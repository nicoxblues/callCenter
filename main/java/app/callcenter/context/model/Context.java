package app.callcenter.context.model;

import app.callcenter.TurnContextHandler;
import app.callcenter.context.model.state.State;
import app.callcenter.model.employes.Employe;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:05 PM.
 */


/**
 *
 *
 * encapsula la comunicacion con un empleado dentro de un contexto, ya sea mediante una call,un chat o hasta en persona;
 * quien implemente la clase abstracta implementara la manera de trabajar con ese tipo de contexo.
 * ejemplo ,una call {@link  app.callcenter.context.model.call.CallContext}
 *
 *
 *
 */

public abstract class Context implements State {

    private State callState;

    private Employe contextOwnerEmploye;

    protected TurnContextHandler handler;


    protected abstract void executeAction();

    protected abstract void initCommunication();


    public void setEmploye(Employe employe){
        this.contextOwnerEmploye = employe;
    }

    public Employe getContextOwnerEmploye() {
        return contextOwnerEmploye;
    }

    public void setState(State state) {
        this.callState = state;
    }

    public State getState() {
        return this.callState;
    }




    @Override
    public void doAction() {
        this.executeAction();

        this.callState.doAction();
    }

    public TurnContextHandler getHandler() {
        return handler;
    }

    public void setHandler(TurnContextHandler turnContextHandler) {
        this.handler = turnContextHandler;


    }

    public void start(){
        this.handler.startContext(this);
        this.initCommunication();
    }

    public void finish() {
        this.handler.finishContext(this);
    }
}
