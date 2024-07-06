
import java.util.ArrayList;
import java.util.List;
// Clase principal para pruebas

public class Gestion_Restaurant {

    public static void main(String[] args) {
        Menu menu1 = new MenuCarta("Bife a lo pobre", 20.0, 5.0, 3.0, 10.0);
        Menu menu2 = new MenuDelDia("Ensalada Cesar", 10.0, 2.0, 1.5);
        Menu menu3 = new MenuNinos("Hamburguesa", 8.0, 1.5, 2.0);
        Menu menu4 = new MenuEconomico("Pizza", 15.0, 20.0);

        Cuenta cuenta = new Cuenta("Juan Perez");
        cuenta.agregarMenu(menu1);
        cuenta.agregarMenu(menu2);
        cuenta.agregarMenu(menu3);
        cuenta.agregarMenu(menu4);

        cuenta.calcularTotal();
        System.out.println("Menu Solicitado:");
        for (Menu menu : cuenta.obtenerMenus()) {
            System.out.println(menu);
        }
        System.out.print("\n");
        System.out.println(cuenta + "\n");

    }
}
// Clase base Menu

abstract class Menu {

    protected String nombrePlato;
    protected double valorInicial;
    protected double valorMenu;

    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }

    public abstract void calcularValor();

    @Override
    public String toString() {
        return String.format("%s: $%.2f", nombrePlato, valorMenu);
    }
}

// Menú a la carta
class MenuCarta extends Menu {

    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorInicial, double valorGuarnicion, double valorBebida, double porcentajeServicio) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
    }

    @Override
    public void calcularValor() {
        valorMenu = valorInicial + valorGuarnicion + valorBebida + (valorInicial * porcentajeServicio / 100);
    }
}

// Menú del día
class MenuDelDia extends Menu {

    private double valorPostre;
    private double valorBebida;

    public MenuDelDia(String nombrePlato, double valorInicial, double valorPostre, double valorBebida) {
        super(nombrePlato, valorInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    @Override
    public void calcularValor() {
        valorMenu = valorInicial + valorPostre + valorBebida;
    }
}

// Menú de niños
class MenuNinos extends Menu {

    private double valorHelado;
    private double valorPastel;

    public MenuNinos(String nombrePlato, double valorInicial, double valorHelado, double valorPastel) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }

    @Override
    public void calcularValor() {
        valorMenu = valorInicial + valorHelado + valorPastel;
    }
}

// Menú económico
class MenuEconomico extends Menu {

    private double porcentajeDescuento;

    public MenuEconomico(String nombrePlato, double valorInicial, double porcentajeDescuento) {
        super(nombrePlato, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void calcularValor() {
        valorMenu = valorInicial - (valorInicial * porcentajeDescuento / 100);
    }
}

// Clase Cuenta
class Cuenta {

    private String nombreCliente;
    private List<Menu> menus;
    private double subtotal;
    private double iva;
    private double total;

    public Cuenta(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.menus = new ArrayList<>();
    }

    public List<Menu> obtenerMenus() {
        return menus;
    }

    public void agregarMenu(Menu menu) {
        menu.calcularValor();
        menus.add(menu);
        subtotal += menu.valorMenu;
    }

    public void calcularTotal() {
        iva = subtotal * 0.12;
        total = subtotal + iva;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s\n" + "Subtotal: $%.2f\n"
                + "IVA (12%%): $%.2f\n" + "Total: $%.2f\n", nombreCliente,
                subtotal,
                iva, total);

    }
}
