package org.divier.spring.ms.usuarios.services;

import org.divier.spring.ms.usuarios.clients.CursoClientRest;
import org.divier.spring.ms.usuarios.models.entity.Usuario;
import org.divier.spring.ms.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoClientRest cursoClientRest;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {

        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {

        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        usuarioRepository.deleteById(id);
        cursoClientRest.eliminarCursoUsuarioPorId(id);
    }

    @Override
    public Optional<Usuario> porEmail(String email) {

        return usuarioRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarPorIds(Iterable<Long> ids) {

        return (List<Usuario>) usuarioRepository.findAllById(ids);
    }
}
