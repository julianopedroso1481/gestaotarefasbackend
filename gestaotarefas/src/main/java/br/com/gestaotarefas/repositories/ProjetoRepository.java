package br.com.gestaotarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gestaotarefas.model.ProjetoModel;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long>{
	
	@Query("SELECT p FROM ProjetoModel p WHERE p.id = :idProjeto")
    ProjetoModel findByIdProjeto(Long idProjeto);
	
}
