package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import interfaces.IConversor;
import model.Historico;

public class ServiceConversor extends UnicastRemoteObject implements IConversor{    
    HistoricoHandle registro = new HistoricoHandle();

    public ServiceConversor() throws RemoteException {

    }

    @Override
    public double conversorMoedas(String nome, double valorInicial, String moedaFinal) throws RemoteException {
        Conversor conversor = new Conversor();
        double valorFinal = conversor.conversorMoedas(nome, valorInicial, moedaFinal);

        registro.adicionarRegistro(new Historico(nome, valorInicial, moedaFinal, valorFinal));
        
        return valorFinal;
    }
    
    @Override
    public List<Historico> getHistoricoConversao(String usuario) throws RemoteException {       
        return registro.getRegistroConversao(usuario);
    }
}
