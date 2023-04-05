package services;

import java.util.ArrayList;
import java.util.List;

import model.Historico;

public class HistoricoHandle{
    private List<Historico> historicos = new ArrayList<Historico>();

    public HistoricoHandle(){

    }

    public void adicionarRegistro(Historico registro) {
        try{
            historicos.add(registro);
            System.out.println("Registro salvo com sucesso.");
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Argumentos invalidos.");
        }
    }
    
    public List<Historico> getRegistroConversao(String usuario) {   
        List<Historico> historicoUsuario = new ArrayList<Historico>();        
        System.out.println("Tamanho da lista de históricos: " + historicos.size());
        for(Historico historico : historicos){
            if (historico.getUsuario().equals(usuario)) {
                historicoUsuario.add(historico);
            }
        }
        return historicoUsuario;
    }

}
