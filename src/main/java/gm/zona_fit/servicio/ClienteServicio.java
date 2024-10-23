package gm.zona_fit.servicio;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.respositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"gm.zona_fit.servicio"})
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        Cliente cliente = new Cliente();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);

    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
}
