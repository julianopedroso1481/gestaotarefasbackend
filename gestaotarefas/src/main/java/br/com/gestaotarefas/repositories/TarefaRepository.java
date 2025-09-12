package br.com.gestaotarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gestaotarefas.model.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long>{
	
	@Query("SELECT t FROM TarefaModel t WHERE t.id = :idTarefa")
    List<TarefaModel> findByIdTarefa(Long idTarefa);
	
	@Query("SELECT t FROM TarefaModel t WHERE UPPER(t.titulo) = UPPER(:tituloTarefa)")
	List<TarefaModel> findByTituloTarefa(String tituloTarefa);	
	 
	@Query("SELECT t FROM TarefaModel t WHERE UPPER(t.projeto.nome) = UPPER(:nomeProjeto)")
	List<TarefaModel> findByTarefaPorNomeProjeto(String nomeProjeto);	
	 
}
