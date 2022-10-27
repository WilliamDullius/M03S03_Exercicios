package com.futurodev.agendaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futurodev.agendaapi.models.ContatoModel;
import com.futurodev.agendaapi.repository.ContatoRepository;

@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@GetMapping("/nome")
	public String nome() {
		return "William Daniel";
	}
	
	@Autowired
	private ContatoRepository contatoRepository;

	@PostMapping("/criar")
	public ResponseEntity<ContatoModel> cadastrarContato(@RequestBody ContatoModel novoContato){
		contatoRepository.save(novoContato);
		return new ResponseEntity<ContatoModel>(novoContato, HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<ContatoModel> atualizarContato(@RequestBody ContatoModel updateContato){
		contatoRepository.save(updateContato);
		return new ResponseEntity<ContatoModel>(updateContato, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletarContato(@RequestParam Long idContato){
		contatoRepository.deleteById(idContato);
		return new ResponseEntity<String>("Contato Deletado com Sucesso!", HttpStatus.OK);	
	}
	
	@GetMapping("/{idContato}")
	public ResponseEntity<ContatoModel> buscaContatoById(@PathVariable("idContato") Long idContato){
		ContatoModel retorno = contatoRepository.findById(idContato).get();
		return new ResponseEntity<ContatoModel>(retorno, HttpStatus.OK);
		
	}
	
	@GetMapping("/buscarPorNome")
	public ResponseEntity<List<ContatoModel>> buscaContatoByName (@RequestParam (name = "nome") String nome){
		List<ContatoModel> retorno = contatoRepository.getContatoByName(nome);
		return new ResponseEntity<List<ContatoModel>>(retorno, HttpStatus.OK);
	}
	
}

