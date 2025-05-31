package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.service.EmprestimoService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import br.com.bpkedu.library_spring_webmvc.service.LivroService; // ADICIONAR ESTA LINHA
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final UsuarioService usuarioService;
    private final LivroService livroService;

    public EmprestimoController(EmprestimoService emprestimoService, UsuarioService usuarioService, LivroService livroService) {
        this.emprestimoService = emprestimoService;
        this.usuarioService = usuarioService;
        this.livroService = livroService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimoService.listarTodos());
        return "emprestimo/listar";
    }

    @GetMapping("/novo")
    public String formularioNovoEmprestimo(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("livros", livroService.listarTodos());
        return "emprestimo/novo";
    }

    @PostMapping
    public String salvar(@ModelAttribute Emprestimo emprestimo) {
        emprestimoService.salvar(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return "redirect:/emprestimos";
    }
}