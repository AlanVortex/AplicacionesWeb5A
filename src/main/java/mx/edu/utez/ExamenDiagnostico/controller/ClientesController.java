package mx.edu.utez.ExamenDiagnostico.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.ExamenDiagnostico.model.dto.ClientesDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.ClientesBean;
import mx.edu.utez.ExamenDiagnostico.services.Impl.ClientesImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ClientesController {

    private final ClientesImpl clientesService;

    @PostMapping("/clientes")
    public ClientesDto create(@RequestBody ClientesDto clientesDto){
        ClientesBean clientesSave = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clientesSave.getId_cliente())
                .nombre(clientesSave.getNombre())
                .apellidos(clientesSave.getApellidos())
                .curp(clientesSave.getCurp())
                .fecha_nacimiento(clientesSave.getFecha_nacimiento())
                .build();
    }

    @PutMapping("clientes")
    public ClientesDto update (@RequestBody ClientesDto clientesDto){
        ClientesBean clientesUpdate = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clientesUpdate.getId_cliente())
                .nombre(clientesUpdate.getNombre())
                .apellidos(clientesUpdate.getApellidos())
                .curp(clientesUpdate.getCurp())
                .fecha_nacimiento(clientesUpdate.getFecha_nacimiento())
                .build();
    }

    @DeleteMapping("clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            ClientesBean cliente = clientesService.findById(id);
            clientesService.delete(cliente);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }catch (DataAccessException e){
            response.put("msj", e.getMessage());
            response.put("Person", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("clientes/{id}")
    public ClientesBean showById(@PathVariable Integer id){
        try{
            return clientesService.findById(id);
        }catch (DataAccessException dae){
            throw new RuntimeException("Error en la Base de Datos: ", dae);
        }catch (Exception ex){
            throw new RuntimeException("Error al obtener el cliente: ", ex);
        }
    }

    @GetMapping("/clientes")
    public List<ClientesBean> findAll(){
        try{
            return clientesService.findAll();
        }catch (DataAccessException dae){
            throw new RuntimeException("Error en la Base de Datos: ", dae);
        }catch (Exception ex){
            throw new RuntimeException("Error al obtener el cliente: ", ex);
        }
    }
}
