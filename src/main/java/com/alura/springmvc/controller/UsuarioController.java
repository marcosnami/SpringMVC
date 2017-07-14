package com.alura.springmvc.controller;

import com.alura.springmvc.dao.UsuarioDAO;
import com.alura.springmvc.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by MarcosNami on 7/13/2017.
 */
@Controller
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "usuario/login";
    }

    @RequestMapping("/efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) {
        if(usuarioDAO.existeUsuario(usuario)) {
            // usuario existe, guardaremos ele na session
            session.setAttribute("usuarioLogado", usuario);
            return "usuario/menu";
        }
        // ele errou a senha, voltou para o formulario
        return "usuario/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
}
