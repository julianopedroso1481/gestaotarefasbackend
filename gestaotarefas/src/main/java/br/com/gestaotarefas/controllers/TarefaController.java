package br.com.gestaotarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.gestaotarefas.dto.RequestTarefaDTO;
import br.com.gestaotarefas.dto.ResponseTarefaDTO;
import br.com.gestaotarefas.service.TarefaService;

@RestController 
@RequestMapping(value = "/gestaotarefas")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@GetMapping(path = "/listartarefas", produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Object> getListarTarefas(){
		List<ResponseTarefaDTO> tarefas = tarefaService.findByAllTarefa();
		
		if(tarefas == null || tarefas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe tarefas cadastradas.");
		}
		Gson gson = new Gson();
        String jsonArrayString = gson.toJson(tarefas);
        
		return new ResponseEntity<Object>(jsonArrayString, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")	
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        boolean deletado = tarefaService.deletarTarefaPorId(id);

        if (deletado) {
            return ResponseEntity.ok("Tarefa deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
    }
	
	@PostMapping(path = "/salvar", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)	
    public ResponseEntity<String> salvarTarefa(@RequestBody RequestTarefaDTO tarefaDTO) {
        boolean salvou = tarefaService.salvarTarefa(tarefaDTO);
        if (salvou) {
            return ResponseEntity.ok("Tarefa gravada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível salvar a Tarefa!");
        }
    }
	
	@GetMapping(path = "/buscartarefaporid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getBuscarTarefaPorID(@PathVariable Long id) {
	    ResponseTarefaDTO tarefa = tarefaService.findByIdTarefa(id);

	    if (tarefa == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
	    }

	    return ResponseEntity.ok(tarefa);
	}
}
