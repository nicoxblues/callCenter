package app.callcenter.context.model.state;


/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:33 PM.
 */


public class ContextFinishState implements State {


    public void doAction() {
        System.out.println("contexto finalizado");
        //Context ctxOnHold = Dispatcher.onHoldQuote.pop()


    }
}
