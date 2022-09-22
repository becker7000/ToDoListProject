package cic.diplojava.myapp.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="calculadoraIMCController")
@RequestScoped
public class CalculadoraIMCController {

    private static final Logger logger =
            Logger.getLogger(CalculadoraIMCController.class.getName());
    private double masa;
    private double estatura;
    private double imc;
    private String mensaje;

    @PostConstruct
    void init(){
        masa=0;
        estatura=0;
        imc=0;
        mensaje="";
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc() {
        return Double.parseDouble(String.format("%.3f",imc));
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void calcularIMC(){

        if(estatura>0.0){
            imc = masa / Math.pow(estatura, 2);
            if(imc>0 && imc<16){
                mensaje="Tienes delgadez severa";
            }else if(imc>=16 && imc<17){
                mensaje="Tienes delgadez moderada";
            }else if(imc>=17 && imc<18.5){
                mensaje="Tienes delgadez leve";
            }else if(imc>=18.5 && imc<25){
                mensaje="Felicidades, tienes un índice de masa corporal normal";
            }else if(imc>=25 && imc<30){
                mensaje="Tienes preobesidad";
            }else if(imc>=30 && imc<35){
                mensaje="Tienes obesidad leve";
            }else if(imc>=35 && imc<40){
                mensaje="Tienes obesidad media";
            }else{
                mensaje="Tienes obesidad severa";
            }
        }else{
            logger.log(Level.INFO, "Division por cero");
            FacesMessage error =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Division por cero", "La estatura debe ser mayor a cero");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }

    }

}
