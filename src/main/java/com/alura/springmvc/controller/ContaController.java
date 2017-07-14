package com.alura.springmvc.controller;

import com.alura.springmvc.dao.ContaDAO;
import com.alura.springmvc.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by marcos.nami on 13/07/2017.
 */
@Controller
public class ContaController {

    private ContaDAO contaDAO;

    @Autowired
    public ContaController(ContaDAO dao) {
        this.contaDAO = dao;
    }

    @RequestMapping(value="/form")
    public String form() {
        return "conta/formulario";
    }

    @RequestMapping("/adicionaConta")
    public String adiciona(@Valid Conta conta, BindingResult result) {

        if (result.hasErrors()) {
            return "conta/formulario";
        }

        contaDAO.adiciona(conta);
        return "conta/adicionada";
    }

    @RequestMapping("/listaContas")
    public ModelAndView lista() {
        List<Conta> contas = contaDAO.lista();
        ModelAndView mv = new ModelAndView("conta/lista");
        mv.addObject("listaContas", contas);
        return mv;
    }

    @RequestMapping("/mostraConta")
    public String mostra(Long id, Model model) {
        model.addAttribute("conta", contaDAO.buscaPorId(id));
        return "conta/mostra";
    }

    @RequestMapping("/alteraConta")
    public String altera(Conta conta) {
        contaDAO.altera(conta);
        return "redirect:listaContas";
    }

    @RequestMapping("/removeConta")
    public String remove(Conta conta) {
        contaDAO.remove(conta);
        return "redirect:listaContas";
    }

    @RequestMapping("/pagaConta")
    public void paga(Long id, HttpServletResponse response) {
        contaDAO.paga(id);
        response.setStatus(200);
    }
}
