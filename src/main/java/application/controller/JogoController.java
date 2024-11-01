package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.JogoDTO;
import application.service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @PostMapping
    public JogoDTO insert(@RequestBody JogoDTO jogo) {
        return jogoService.addJogo(jogo);
    }

    @GetMapping 
    public Iterable<JogoDTO> list() {
        return jogoService.getAll();
    }

    @GetMapping("/{id}")
    public JogoDTO get(@PathVariable long id) {
        return jogoService.getOne(id);
    }
}
