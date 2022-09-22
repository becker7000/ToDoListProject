package cic.diplojava.myapp.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value="frasesController")
@RequestScoped
public class FrasesController {

    private String[] frases = {
            "Escribir tus pendientes aumentará la probabilidad de hacerlos",
            "Recuerda tomar agua al despertar antes que un café",
            "Trotar 25 minutos aumentará tus niveles de energía",
            "Aplica el principio del mínimo esfuerzo, máxima eficacia"
    };

    private String fraseDelDia;

    @PostConstruct
    public void init(){
        int aleatorio = (int)(Math.random()*frases.length);
        fraseDelDia=frases[aleatorio];
    }

    public String getFraseDelDia() {
        return fraseDelDia;
    }

    public void setFraseDelDia(String fraseDelDia) {
        this.fraseDelDia = fraseDelDia;
    }
}
