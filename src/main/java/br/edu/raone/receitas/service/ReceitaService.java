package br.edu.raone.receitas.service;

import br.edu.raone.receitas.model.Receita;
import br.edu.raone.receitas.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodos() {
        return receitaRepository.findAll();
    }

    public Receita buscarPorId(Long id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Receita nao encontrada."));
    }

    public void excluir(Long id) {
        receitaRepository.delete(buscarPorId(id));
    }
}
