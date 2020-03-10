package galgeleg;

import java.rmi.Naming;

public class GalgeServer {

    public static void main(String[] args) throws Exception {
        /*
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        GalgelegInterface glI = new Galgelogik();
        Naming.rebind("rmi://localhost:1099/galgeservice",glI);
        System.out.println("Galgeservice registreret.");

         */

        System.setProperty("java.rmi.server.hostname", "dist.saluton.dk");
        java.rmi.registry.LocateRegistry.createRegistry(23011);
        GalgelegInterface glI = new Galgelogik();
        Naming.rebind("rmi://dist.saluton.dk:23011/galgeleg", glI);
        System.out.println("Galgeservice registreret. hej2");
    }
}