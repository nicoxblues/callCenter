package callcenter.model.employes;

import callcenter.model.employes.constantes.EmployeCTE;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 4:12 PM.
 *
 */


public class Operario extends Employe  {

    public Operario() {
        this.setPriorityHierarchy(EmployeCTE.EMPLOYE_JOB_TITLE_OPERADOR);
    }
}