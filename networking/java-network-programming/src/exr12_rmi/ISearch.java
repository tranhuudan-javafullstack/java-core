package exr12_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISearch extends Remote {
    String findById(String id) throws RemoteException;

    String findByName(String partName) throws RemoteException;
}
