package br.com.bpkedu.library_spring_webmvc.service;

import br.com.bpkedu.library_spring_webmvc.domain.Usuarios;
import br.com.bpkedu.library_spring_webmvc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public  List<Usuarios> listarUsuarios() {
        return  usuarioRepository.findAll();
    }

    public Usuarios salvarUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuarios buscarUsuarioPorId(Long id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public void deletarUsuario (Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuarios> listarTodos() {
        return listarUsuarios();
    }


}
