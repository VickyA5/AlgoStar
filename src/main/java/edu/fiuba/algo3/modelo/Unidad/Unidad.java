package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;

public abstract class  Unidad implements Atacable, Atacante {
    protected HitPoints hp;
    private TipoSuperficie tipoSuperficie;
    private Ubicacion ubicacion;
    private int rango;
    private Ataque ataque;
    protected  int costoGas;
    protected  int costoMineral;
    protected int costoSuministro;
    protected int costoPoblacion;
    protected int turnosRestantesParaSerOperativo;
    protected int unidadesAsesinadas;

    public Unidad(HitPoints vida, int suministroNecesario){
        hp = vida;
        costoSuministro = suministroNecesario;
    }

    public void verificarUnidadOperativa() {
        if(turnosRestantesParaSerOperativo > 0 ){
            throw  new UnidadNoOperativaError();
        }
    }
    public Unidad(HitPoints vida, TipoSuperficie tipoSuperficie, Ataque ataque, int turnosRestantesParaSerOperativo, int costoPoblacion, int costoMineral, int costoGas){
        hp = vida;
        this.tipoSuperficie = tipoSuperficie;
        this.ataque = ataque;
        this.turnosRestantesParaSerOperativo = turnosRestantesParaSerOperativo;
        this.costoPoblacion = costoPoblacion;
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
        unidadesAsesinadas = 0;
    }

    public void atacar(Atacable atacable){
        verificarUnidadOperativa();
        try {
            atacable.recibirAtaque(ataque);
        } catch (UnidadMuertaError e){
            unidadesAsesinadas++;
        }
    }

    public void ejecutarTurno() {
        turnosRestantesParaSerOperativo--;
    }

    public void recibirAtaque(Ataque ataque){
        tipoSuperficie.recibirAtaque(ataque, hp);
    }

    public void asignarLugar(Ubicacion unLugar){
        ubicacion=unLugar;
    }

    public void atacarSobreUbicacion(Atacable atacable){
        if(ubicacion.distancia(atacable.ubicacion())> rango){
            throw new EnemigoFueraDeRangoError();
        }
        else {
            atacar(atacable);
        }
    }
    public Ubicacion ubicacion(){
        return ubicacion;
    }
    public void asignarRango(int Rango){
        rango = Rango;
    }

    public void volar(){
        verificarUnidadOperativa();
        tipoSuperficie.volar();
    }

    public void aumentarPoblacion(Raza raza) {
        raza.aumentarPoblacion(costoPoblacion);
    }

    public void disminuirPoblacion(Raza unaRaza){
        unaRaza.disminuirPoblacion(costoPoblacion);
        disminuirCapacidad(unaRaza);
    }
    protected void disminuirCapacidad(Raza unaRaza){
        unaRaza.disminuirCapacidad(0);
    }

    public void verificarConsumoRecurso(GestionRecurso mineral, GestionRecurso gas) {
        if(!mineral.puedeConsumir(costoMineral) || !gas.puedeConsumir(costoGas))
            throw new InsuficientesRecursosParaCrearUnidadError();
    }

    public void consumirGas(GestionRecurso gas) {
        gas.consumir(costoGas);
    }

    public void consumirMineral(GestionRecurso mineral) {
        mineral.consumir(costoMineral);
    }

    public GestionRecurso extraer(Recurso recurso) {
        return null;
    }

    public void moverseArriba(){
       Ubicacion actual = ubicacion;
       ubicacion.getArriba().asignarUnidad(this);
       actual.quitarUnidad();
    }

    public void moverseAbajo(){
        Ubicacion actual = ubicacion;
        ubicacion.getAbajo().asignarUnidad(this);
        actual.quitarUnidad();

    }

    public void moverseDerecha(){
        Ubicacion actual = ubicacion;
        ubicacion.getDerecha().asignarUnidad(this);
        actual.quitarUnidad();

    }

    public void moverseIzquierda(){
        Ubicacion actual = ubicacion;
        ubicacion.getIzquierda().asignarUnidad(this);
        actual.quitarUnidad();

    }
}