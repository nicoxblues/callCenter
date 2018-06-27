package app.callcenter.context.model.state;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:33 PM.
 */



public class ContextOnHoldState implements State {

    @Override
    public void doAction() {
        System.out.println("llamada en espera");
    }
}
