public class Juego_De_Roles {
    public static void main(String[] args) {
        // Crear instancias de las subclases y usar sus metodos
        Guerrero guerrero = new Guerrero("Thor", 100, 1.0, 100, "Espada");
        Mago mago = new Mago("Gandalf", 80, 1.0, "Fuego", 80);
        Arquero arquero = new Arquero("Legolas", 90, 1.0, 90, "Arco Largo");

        // Ejemplo de configuracion y uso de metodos
        System.out.println(guerrero.nombrePersonaje + " ataca con " + guerrero.obtenerMelee() + " con una fuerza de " + guerrero.obtenerFuerza());
        System.out.println(guerrero.nombrePersonaje + " se defiende con una fuerza de " + guerrero.obtenerFuerza());

        System.out.println(mago.nombrePersonaje + " lanza un hechizo de " + mago.obtenerHechizos() + " con un poder magico de " + mago.obtenerPoderesMagicos());
        System.out.println(mago.nombrePersonaje + " se defiende con un hechizo de " + mago.obtenerHechizos());

        System.out.println(arquero.nombrePersonaje + " ataca con " + arquero.obtenerHabilidadesDistancia() + " con una precision de " + arquero.obtenerPrecision());
        System.out.println(arquero.nombrePersonaje + " se defiende con una precision de " + arquero.obtenerPrecision());

        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);

        // Combates
        double puntosAtaqueP1 = guerrero.ataque();
        double puntosDefensaP2 = mago.defensa();
        double puntosAtaqueP2 = mago.ataque();
        double puntosDefensaP1 = guerrero.defensa();

        System.out.println(guerrero.nombrePersonaje + " vs " + mago.nombrePersonaje);

        if (puntosAtaqueP1 > puntosDefensaP2) {
            System.out.println(guerrero.nombrePersonaje + " gana el combate contra " + mago.nombrePersonaje);
        } else if (puntosAtaqueP2 > puntosDefensaP1) {
            System.out.println(mago.nombrePersonaje + " gana el combate contra " + guerrero.nombrePersonaje);
        } else {
            System.out.println("El combate entre " + guerrero.nombrePersonaje + " y " + mago.nombrePersonaje + " termina en empate");
        }
    }

    public static abstract class Personajes {

        protected int puntosVida;
        protected double nivelExperiencia;
        protected String nombrePersonaje;

        public Personajes(String nombrePersonaje, int puntosVida, double nivelExperiencia) {
            this.puntosVida = puntosVida;
            this.nivelExperiencia = nivelExperiencia;
            this.nombrePersonaje = nombrePersonaje;
        }

        public abstract double ataque();

        public abstract double defensa();

        public void actualizarNivel() {
            // Implementacion para actualizar el nivel de experiencia
        }

        @Override
        public String toString() {
            return "Personaje: " + nombrePersonaje + ", Vida: " + puntosVida + ", Nivel de Experiencia: " + nivelExperiencia;
        }
    }

    public static class Guerrero extends Personajes {

        private int fuerza;
        private String melee;

        public Guerrero(String nombrePersonaje, int puntosVida, double nivelExperiencia, int fuerza, String melee) {
            super(nombrePersonaje, puntosVida, nivelExperiencia);
            this.fuerza = fuerza;
            this.melee = melee;
        }

        public void establecerFuerza(int fuerza) {
            this.fuerza = fuerza;
        }

        public int obtenerFuerza() {
            return fuerza;
        }

        public void establecerMelee(String melee) {
            this.melee = melee;
        }

        public String obtenerMelee() {
            return melee;
        }

        @Override
        public double ataque() {
            return fuerza;
        }

        @Override
        public double defensa() {
            return fuerza / 2.0;
        }
    }

    public static class Mago extends Personajes {

        private String hechizos;
        private int poderesMagicos;

        public Mago(String nombrePersonaje, int puntosVida, double nivelExperiencia, String hechizos, int poderesMagicos) {
            super(nombrePersonaje, puntosVida, nivelExperiencia);
            this.hechizos = hechizos;
            this.poderesMagicos = poderesMagicos;
        }

        public void establecerHechizos(String hechizos) {
            this.hechizos = hechizos;
        }

        public String obtenerHechizos() {
            return hechizos;
        }

        public void establecerPoderesMagicos(int poderesMagicos) {
            this.poderesMagicos = poderesMagicos;
        }

        public int obtenerPoderesMagicos() {
            return poderesMagicos;
        }

        @Override
        public double ataque() {
            return poderesMagicos;
        }

        @Override
        public double defensa() {
            return poderesMagicos / 2.0;
        }
    }

    public static class Arquero extends Personajes {

        private int precision;
        private String habilidadesDistancia;

        public Arquero(String nombrePersonaje, int puntosVida, double nivelExperiencia, int precision, String habilidadesDistancia) {
            super(nombrePersonaje, puntosVida, nivelExperiencia);
            this.precision = precision;
            this.habilidadesDistancia = habilidadesDistancia;
        }

        public void establecerPrecision(int precision) {
            this.precision = precision;
        }

        public int obtenerPrecision() {
            return precision;
        }

        public void establecerHabilidadesDistancia(String habilidadesDistancia) {
            this.habilidadesDistancia = habilidadesDistancia;
        }

        public String obtenerHabilidadesDistancia() {
            return habilidadesDistancia;
        }

        @Override
        public double ataque() {
            return precision;
        }

        @Override
        public double defensa() {
            return precision / 2.0;
        }
    }
}
