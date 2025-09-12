package br.com.gestaotarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestaotarefas.model.ProjetoModel;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long>{

}
