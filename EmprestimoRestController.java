package br.com.bpkedu.library_spring_webmvc.controller.api;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoRestController {

    private final EmprestimoService emprestimoService;

    public EmprestimoRestController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<Emprestimo> listar() {
        return emprestimoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscar(@PathVariable Long id) {
        return emprestimoService.buscarPorId(id);
    }

    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.salvar(emprestimo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
    }
}
