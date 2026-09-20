package br.edu.raone.receitas.controller;

import br.edu.raone.receitas.model.Receita;
import br.edu.raone.receitas.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("receitas", receitaService.listarTodos());
        return "lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("receita", new Receita());
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Receita receita, BindingResult resultado,
                         RedirectAttributes atributos) {
        if (resultado.hasErrors()) {
            return "formulario";
        }
        boolean novaReceita = receita.getId() == null;
        receitaService.salvar(receita);
        atributos.addFlashAttribute("sucesso", novaReceita
                ? "Receita cadastrada com sucesso!"
                : "Receita atualizada com sucesso!");
        return "redirect:/receitas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("receita", receitaService.buscarPorId(id));
        return "formulario";
    }

    @GetMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable Long id, Model model) {
        model.addAttribute("receita", receitaService.buscarPorId(id));
        return "confirmar-exclusao";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes atributos) {
        receitaService.excluir(id);
        atributos.addFlashAttribute("sucesso", "Receita excluida com sucesso!");
        return "redirect:/receitas";
    }
}
