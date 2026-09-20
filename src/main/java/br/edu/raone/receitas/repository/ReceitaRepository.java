package br.edu.raone.receitas.repository;

import br.edu.raone.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
