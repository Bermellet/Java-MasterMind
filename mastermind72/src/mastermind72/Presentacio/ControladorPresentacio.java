package mastermind72.Presentacio;
import java.util.List;
import mastermind72.Classes.ControladorPartida;
import mastermind72.Classes.ControladorRanking;
import mastermind72.Classes.Pair;


public class ControladorPresentacio {
    ControladorPartida cPartida;
    ControladorRanking cRanking;
    VistaMenuPrincipal vistaMenuPrincipal;
    VistaNovaPartida    vistaNovaPartida = null;
    VistaIntroMaker     vistaIntroMaker  = null;
    VistaPartida        vistaPartida     = null;
    VistaMenuGuardar    vistaMenuGuardar = null;
    VistaIntroGuardar   vistaIntroGuardar = null;
    VistaCarregarPartida vistaCarregarPartida = null;
    VistaRankings       vistaRankings    = null;
    
    VistaAjuda          vistaAjuda      = null;
    VistaBolaAjuda      vistaBolaAjuda  = null;
    public ControladorPresentacio(){
        cPartida = new ControladorPartida();
        cRanking = new ControladorRanking();
        vistaMenuPrincipal = new VistaMenuPrincipal(this);
    }
    
    public void inicialitzarPresentacio(){
        vistaMenuPrincipal.ferVisible();
    }
    
    public void sincroMenuPrincipal_a_NovaPartida(){
        vistaMenuPrincipal.desactivar();
        vistaMenuPrincipal.ferInvisible();
        if (vistaNovaPartida == null) vistaNovaPartida = new VistaNovaPartida(this);
        vistaNovaPartida.activar();
        vistaNovaPartida.ferVisible();
    }
    public void sincroMenuPrincipal_a_Ajuda(){
        vistaMenuPrincipal.desactivar();
        if (vistaAjuda == null) vistaAjuda = new VistaAjuda(this);
        vistaAjuda.activar();
        vistaAjuda.ferVisible();
    }
    public void sincroAjuda_a_MenuPrincipal(){
        vistaAjuda.desactivar();
        vistaAjuda.ferInvisible();
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroNovaPartida_a_MenuPrincipal(){
        vistaNovaPartida.desactivar();
        vistaNovaPartida.ferInvisible();
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroNovaPartida_a_Partida(String dif){
        vistaNovaPartida.desactivar();
        vistaNovaPartida.ferInvisible();
        if (vistaPartida == null) vistaPartida = new VistaPartida(this, dif, "CB");
        vistaNovaPartida = null;
        vistaPartida.ferVisible();
        vistaPartida.activar();
    }
    public void sincroNovaPartida_a_IntroMaker(String dif){
        vistaNovaPartida.desactivar(); // dejamos nova partida visible
        if (vistaIntroMaker == null) vistaIntroMaker = new VistaIntroMaker(this, dif);
        vistaIntroMaker.ferVisible();
        vistaIntroMaker.activar();
    }
    public void sincroIntroMaker_a_NovaPartida(){
        vistaIntroMaker.ferInvisible();
        vistaIntroMaker.desactivar();
        vistaNovaPartida.ferVisible();
        vistaIntroMaker = null; // eliminar el que teniem guardat
        vistaNovaPartida.activar();
    }
    public void sincroIntroMaker_a_Partida(String dif){
        vistaIntroMaker.ferInvisible();
        vistaIntroMaker.desactivar();
        if (vistaPartida == null) vistaPartida = new VistaPartida(this, dif, "CM");
        vistaIntroMaker = null; // eliminar el que teniem guardat
        vistaNovaPartida.ferInvisible();
        vistaNovaPartida.desactivar();
        vistaNovaPartida = null;
        
        vistaPartida.activar();
        vistaPartida.ferVisible();
    }
    public void sincroMenuPrincipal_a_CarregarPartida(){
        if (vistaCarregarPartida == null) vistaCarregarPartida = new VistaCarregarPartida(this);
        vistaCarregarPartida.activar();
        vistaCarregarPartida.ferVisible();
        
        vistaMenuPrincipal.desactivar();
        vistaMenuPrincipal.ferInvisible();
    }
    public void sincroCarregarPartida_a_MenuPrincipal(){
        vistaCarregarPartida.desactivar();
        vistaCarregarPartida.ferInvisible();
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroMenuPrincipal_a_Rankings(){
        vistaMenuPrincipal.desactivar();
        vistaMenuPrincipal.ferInvisible();
        if (vistaRankings == null) vistaRankings = new VistaRankings(this);
        vistaRankings.activar();
        vistaRankings.ferVisible();
    }
    public void sincroRankings_a_MenuPrincipal(){
        vistaRankings.desactivar();
        vistaRankings.ferInvisible();
        vistaRankings = null;
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    
    public void sincroPartida_a_BolaAjuda(int bola){
        vistaPartida.desactivar(); //Dejamos vistaPartida visible
        if (vistaBolaAjuda == null) vistaBolaAjuda = new VistaBolaAjuda(this, bola);
        vistaBolaAjuda.ferVisible();
        vistaBolaAjuda.activar();
    }
    public void sincroBolaAjuda_a_Partida(){
        vistaPartida.activar();
        vistaBolaAjuda.desactivar();
        vistaBolaAjuda.ferInvisible();
    }
    public void sincroPartida_a_MenuGuardar(){
        vistaPartida.desactivar(); //Dejamos vistaPartida visible
        if (vistaMenuGuardar == null) vistaMenuGuardar = new VistaMenuGuardar(this);
        vistaMenuGuardar.ferVisible();
        vistaMenuGuardar.activar();
    }
    public void sincroPartida_a_MenuPrincipal(){
        vistaPartida.desactivar();
        vistaPartida.ferInvisible();
        vistaPartida = null;
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroMenuGuardar_a_Partida(){ //Boton cancelar del menu
        vistaPartida.activar();
        vistaMenuGuardar.desactivar();
        vistaMenuGuardar.ferInvisible();
    }
    public void sincroMenuGuardar_a_IntroGuardar(){ //Sí quiere guardar la partida
        vistaPartida.ferVisible(); //Meramente estético, para que al pasar no se esconda
        vistaMenuGuardar.desactivar();
        vistaMenuGuardar.ferInvisible();
        if (vistaIntroGuardar == null) vistaIntroGuardar = new VistaIntroGuardar(this);
        vistaIntroGuardar.activar();
        vistaIntroGuardar.ferVisible();
    }
    public void sincroMenuGuardar_a_MenuPrincipal(){ //No quiere guardar la partida
        vistaPartida.ferInvisible();
        vistaPartida = null;
        vistaBolaAjuda = null;
        vistaMenuGuardar.desactivar();
        vistaMenuGuardar.ferInvisible();
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroIntroGuardar_a_Partida(){
        vistaPartida.activar();
        vistaIntroGuardar.desactivar();
        vistaIntroGuardar.ferInvisible();
        vistaIntroGuardar = null; //Borramos lo que ya está escrito
    }
    public void sincroIntroGuardar_a_MenuPrincipal(String nom){
        vistaPartida.ferInvisible();
        vistaIntroGuardar.desactivar();
        vistaIntroGuardar.ferInvisible();
        cPartida.guardarPartida(nom);
        vistaPartida = null;
        vistaBolaAjuda = null;
        vistaMenuPrincipal.activar();
        vistaMenuPrincipal.ferVisible();
    }
    public void sincroCarregarPartida_a_Partida(String dif){
        vistaCarregarPartida.desactivar();
        vistaCarregarPartida.ferInvisible();
        if (vistaPartida == null) vistaPartida = new VistaPartida(this, dif, "CB");
        vistaCarregarPartida = null;
        vistaPartida.ferVisible();
        vistaPartida.activar();
    }
    
    public void cridaControladorPartida_CrearPartida(String dificultat, String mode, List<Integer> solucio){
        cPartida.crearPartida(mode, dificultat, solucio);
    }
    public Pair<Integer,Integer> cridaControladorPartida_IntroduirJugada(List<Integer> in){
        return cPartida.introduirJugada(in);
    }
    public List<Pair<String,String>> cridaControladorPartida_consultarllistaPartidesGuardades(){
        return cPartida.consultarllistaPartidesGuardades();
    }
    public String cridaControladorPartida_CarregarPartida(String nom){
        return cPartida.carregarPartida(nom);
    }
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> cridaControladorPartida_JugarPartidaCM(List<Integer> solucio){
        return cPartida.jugarPartidaCM(solucio);
    }
    public List<Pair<List<Integer>,Pair<Integer,Integer>>> cridaControladorPartida_getJugades(){
        return cPartida.getJugades();
    }
    public List<Integer> cridaControladorPartida_getSolucio(){
        return cPartida.getSolucio();
    }
    public int cridaControladorPartida_getBolaAmbAjuda(){
        return cPartida.getBolaAmbAjuda();
    }
    public List<Pair<String,Integer>> cridaControladorRanking_GetRankings(String dificultat){
        return cRanking.getRanking(dificultat).getListRanking();
    }
    
    public void cridaControladorDomini_IntroduirRecord(String name, String dificultat){
        cRanking.addRanking(dificultat, new Pair<> (name,cPartida.getPuntuacio()) );
    }
    
    public void cridaControladorDomini_guardarDades(){
        cPartida.guardarDades();
    }
}