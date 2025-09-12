package br.com.gestaotarefas.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaotarefas.dto.RequestTarefaDTO;
import br.com.gestaotarefas.dto.ResponseTarefaDTO;
import br.com.gestaotarefas.model.TarefaModel;
import br.com.gestaotarefas.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private final ModelMapper modelMapper;

	public TarefaService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public List<ResponseTarefaDTO> findByAllTarefa() {
		try {

			List<TarefaModel> listaTarefas = tarefaRepository.findAll();

			modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE)
					.setMatchingStrategy(MatchingStrategies.STRICT);

			List<ResponseTarefaDTO> tarefaDTOs = modelMapper.map(listaTarefas,
					new TypeToken<List<ResponseTarefaDTO>>() {
					}.getType());
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
}