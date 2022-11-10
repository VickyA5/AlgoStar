package edu.fiuba.algo3.modelo;

public class NexoMineral extends Edificio{

    public NexoMineral(HitPoints HP){
        hp = HP;
        cantTurnosParaSerOperativo = 0;
    }

    public NexoMineral(int cantTurnosParaSerOperativo){
        this.cantTurnosParaSerOperativo = cantTurnosParaSerOperativo;
    }

    public void ejecutarTurno() {
        cantTurnosParaSerOperativo--;
    }

    public void recolectar(){
        this.tirarEdificioNoOperativoError();
    }

}
