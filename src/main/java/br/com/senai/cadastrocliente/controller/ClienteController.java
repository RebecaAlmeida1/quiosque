package br.com.senai.cadastrocliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.senai.sp.cadastrocliente.dao.ClienteDao;
import br.com.senai.sp.cadastrocliente.model.Cliente;

@Controller
public class ClienteController {

	@RequestMapping("/")
	public String index(Model model) {

		return "cad_cliente";
	}

	@RequestMapping("cadCliente")
	public String form(Model model) {

		return "cad_cliente";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {

		System.out.println(cliente.getNome());
		System.out.println(cliente.getDataNascimento());
		System.out.println(cliente.getGenero());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getTelefone());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getProduto());
		ClienteDao dao = new ClienteDao();
		if (cliente.getId() == null) {
			dao.inserir(cliente);
		} else {
			dao.alterar(cliente);
		}

		return "redirect:listaCliente";
	}

	@RequestMapping("listaCliente")
	public String listar(Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.listar());
		return "listacliente";

	}

	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		ClienteDao dao = new ClienteDao();
		dao.excluir(idCliente);
		return "redirect:listacliente";
	}

	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.buscar(idCliente));

		return "forward:cadCliente";
	}
	
	//	@RequestMapping("estatistica")
	//	public String estat (long idCliente, Model model) {
		//	ClienteDao dao = new ClienteDao();
		//	model.addAttribute("cliente")
		//}
			
		
	
}
