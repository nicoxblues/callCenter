package app.callcenter.model.employes;

import app.callcenter.model.employes.constantes.EmployeCTE;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:14 PM.
 */
public class Supervisor extends Employe {

    public Supervisor() {
        setPriorityHierarchy(EmployeCTE.EMPLOYE_JOB_TITLE_SUPRVISOR);
    }
}
