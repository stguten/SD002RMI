package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import services.ServiceConversor;

public class Application {
    public static void main(String[] args) {
        try {
            ServiceConversor cambio = new ServiceConversor();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/cambio", cambio);
            
            System.out.println("Servidor Online!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }    
}