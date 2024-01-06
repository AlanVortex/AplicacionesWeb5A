package mx.edu.utez.ExamenDiagnostico.model.dao;

import mx.edu.utez.ExamenDiagnostico.model.entity.ClientesBean;
import org.springframework.data.repository.CrudRepository;

public interface ClientesDao extends CrudRepository<ClientesBean, Integer> {
}
