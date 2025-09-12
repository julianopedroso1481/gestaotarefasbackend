package br.com.gestaotarefas.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaotarefas.dto.ResponseProjetoDTO;
import br.com.gestaotarefas.dto.ResponseTarefaDTO;
import br.com.gestaotarefas.model.ProjetoModel;
import br.com.gestaotarefas.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private final ModelMapper modelMapper;

	public ProjetoService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public List<ResponseProjetoDTO> findByAllProjeto() {
		try {

			List<ProjetoModel> listaProjetos = projetoRepository.findAll();

			modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE)
					.setMatchingStrategy(MatchingStrategies.STRICT);

			List<ResponseProjetoDTO> projetoDTOs = modelMapper.map(listaProjetos,
					new TypeToken<List<ResponseProjetoDTO>>() {
					}.getType());
			return projetoDTOs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ProjetoModel findByIdProjeto(Long idProjeto) {
		return projetoRepository.findByIdProjeto(idProjeto);
	}

}
