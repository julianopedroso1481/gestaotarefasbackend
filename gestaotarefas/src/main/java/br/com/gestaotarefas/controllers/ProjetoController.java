package br.com.gestaotarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gestaotarefas.dto.ResponseProjetoDTO;
import br.com.gestaotarefas.service.ProjetoService;

@RestController 
@RequestMapping(value = "/gestaotarefas")
public class ProjetoController {
	
	@Autowired
	ProjetoService projetoService;
	
	@GetMapping(path = "/listarprojetos", produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Object> getListarProjetos(){
		List<ResponseProjetoDTO> projetos = projetoService.findByAllProjeto();
		
		if(projetos == null || projetos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe projetos cadastradas.");
		}
		Gson gson = new Gson();
        String jsonArrayString = gson.toJson(projetos);
        
		return new ResponseEntity<Object>(jsonArrayString, HttpStatus.OK);
	}
}
