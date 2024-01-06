package mx.edu.utez.ExamenDiagnostico.services.Impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.ExamenDiagnostico.model.dao.ClientesDao;
import mx.edu.utez.ExamenDiagnostico.model.dto.ClientesDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.ClientesBean;
import mx.edu.utez.ExamenDiagnostico.services.IClientes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientesImpl implements IClientes {

    private final ClientesDao clientesDao;

    @Transactional
    @Override
    public ClientesBean save(ClientesDto clientesDto) {
        ClientesBean clientes = ClientesBean.builder()
                .id_cliente(clientesDto.getId_cliente())
                .nombre(clientesDto.getNombre())
                .apellidos(clientesDto.getApellidos())
                .curp(clientesDto.getCurp())
                .fecha_nacimiento(clientesDto.getFecha_nacimiento())
                .build();
                return clientesDao.save(clientes);
    }

    @Transactional(readOnly = true)
    @Override
    public ClientesBean findById(Integer id) {
        return clientesDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<ClientesBean> findAll() {
        return (List<ClientesBean>) clientesDao.findAll();
    }

    @Transactional
    @Override
    public void delete(ClientesBean clientes) {
        clientesDao.delete(clientes);
    }
}
