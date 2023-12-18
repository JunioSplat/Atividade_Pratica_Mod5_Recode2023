package br.org.com.recode.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.com.recode.model.Cliente;
import br.org.com.recode.repository.ClienteRepository;
import jakarta.transaction.Transactional;

	@Service
	public class ClienteService{
		
		@Autowired
		private ClienteRepository clienteRepository;

		public List<Cliente> getAllClientes() {
			return clienteRepository.findAll();
			}

		@Transactional
		public Cliente getClienteById(Long id) {
			return clienteRepository.findById(id).orElse(null);
		}

		@Transactional
		public Cliente saveCliente(Cliente cliente) {
			return clienteRepository.save(cliente);
		}
		public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
			Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
			if (clienteExistente != null) { 
				clienteExistente.setEnderecoCliente(clienteAtualizado.getEnderecoCliente());
				clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
				clienteExistente.setEmailCliente(clienteAtualizado.getEmailCliente());
				clienteExistente.setCepCliente(clienteAtualizado.getCepCliente());
				return clienteRepository.save(clienteExistente);
			} else { 
				throw new RuntimeException("Cliente com o ID" + id + "não encontrado.");
			}
		}

		public void deleteCliente(Long id) {
			clienteRepository.deleteById(id);
		}
}

