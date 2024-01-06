package mx.edu.utez.ExamenDiagnostico.services;

import mx.edu.utez.ExamenDiagnostico.model.dto.ClientesDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.ClientesBean;

import java.util.List;

public interface IClientes {
    ClientesBean save(ClientesDto clientesDto);
    ClientesBean findById(Integer id);
    List<ClientesBean> findAll();
    void delete(ClientesBean clientesBean);
}
