package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Historico;


public interface IConversor extends Remote {
    double conversorMoedas(String nome, double valorInicial, String moedaFinal) throws RemoteException;
    List<Historico> getHistoricoConversao(String usuario) throws RemoteException;
}
