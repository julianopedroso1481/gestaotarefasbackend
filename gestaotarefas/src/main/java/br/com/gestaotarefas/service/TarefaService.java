package br.com.gestaotarefas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaotarefas.dto.RequestTarefaDTO;
import br.com.gestaotarefas.dto.ResponseProjetoDTO;
import br.com.gestaotarefas.dto.ResponseTarefaDTO;
import br.com.gestaotarefas.model.ProjetoModel;
import br.com.gestaotarefas.model.TarefaModel;
import br.com.gestaotarefas.repositories.ProjetoRepository;
import br.com.gestaotarefas.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private final ModelMapper modelMapper;

	public TarefaService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public List<ResponseTarefaDTO> findByAllTarefa() {
		try {

			List<TarefaModel> listaTarefas = tarefaRepository.findAll();

			List<ResponseTarefaDTO> tarefaDTOs = listaTarefas.stream().map(tarefa -> {
	            ResponseTarefaDTO dto = new ResponseTarefaDTO();

	            dto.setId(tarefa.getId());
	            dto.setTitulo(tarefa.getTitulo());
	            dto.setDescricao(tarefa.getDescricao());
	            dto.setStatus(tarefa.getStatus());
	            dto.setDataCriacao(tarefa.getDataCriacao());

	            // Mapeando o projeto
	            if (tarefa.getProjeto() != null) {
	                ResponseProjetoDTO projetoDTO = new ResponseProjetoDTO();
	                projetoDTO.setId(tarefa.getProjeto().getId());
	                projetoDTO.setNome(tarefa.getProjeto().getNome());

	                dto.setProjeto(projetoDTO);
	            }

	            return dto;
	        }).collect(Collectors.toList());

	        return tarefaDTOs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResponseTarefaDTO findByIdTarefa(Long idTarefa) {
		return tarefaRepository.findById(idTarefa)
                .map(model -> modelMapper.map(model, ResponseTarefaDTO.class))
                .orElse(null);
	}

	public boolean deletarTarefaPorId(Long id) {
		if (tarefaRepository.existsById(id)) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean salvarTarefa(RequestTarefaDTO tarefaDTO) {
		try {

			TarefaModel model = new TarefaModel();
			model.setTitulo(tarefaDTO.getTitulo()); // 👈 este campo estava faltando!
			model.setDescricao(tarefaDTO.getDescricao());
			model.setStatus(tarefaDTO.getStatus());
			model.setDataCriacao(tarefaDTO.getDataCriacao());
			if(tarefaDTO.getProjeto() != null) {
				
				ProjetoModel projeto = projetoRepository.findByIdProjeto(tarefaDTO.getProjeto().getId());
				model.setProjeto(projeto);
			}
			TarefaModel savedEntity = (TarefaModel)tarefaRepository.save(model);

			if (savedEntity != null && savedEntity.getId() != null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ResponseTarefaDTO> findByAllTarefaPorNomeProjeto(String nomeProjeto) {
		try {

			List<TarefaModel> listaTarefas = tarefaRepository.findByTarefaPorNomeProjeto(nomeProjeto);

			List<ResponseTarefaDTO> tarefaDTOs = listaTarefas.stream().map(tarefa -> {
	            ResponseTarefaDTO dto = new ResponseTarefaDTO();

	            dto.setId(tarefa.getId());
	            dto.setTitulo(tarefa.getTitulo());
	            dto.setDescricao(tarefa.getDescricao());
	            dto.setStatus(tarefa.getStatus());
	            dto.setDataCriacao(tarefa.getDataCriacao());

	            // Mapeando o projeto
	            if (tarefa.getProjeto() != null) {
	                ResponseProjetoDTO projetoDTO = new ResponseProjetoDTO();
	                projetoDTO.setId(tarefa.getProjeto().getId());
	                projetoDTO.setNome(tarefa.getProjeto().getNome());

	                dto.setProjeto(projetoDTO);
	            }

	            return dto;
	        }).collect(Collectors.toList());

	        return tarefaDTOs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}