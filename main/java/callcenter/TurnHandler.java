package callcenter;

import callcenter.model.employes.Employe;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:34 PM.
 */


class TurnHandler  {

    //private ArrayList activeEmployesList;
    private static TurnHandler turnHandler;

    static TurnHandler getInstance(){
        if (turnHandler != null){
            createInstance();
        }

        return turnHandler;

    }


    private static void createInstance (){
        turnHandler = new TurnHandler();

    }


    public Employe findIdleEmploye() {

        return null;
    }
}

