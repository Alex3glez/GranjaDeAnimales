package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Clase abstracta que representa un Animal genérico de la granja.
 */
public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
     * Constructor de la clase Animal.
     * Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.
     * Realiza validaciones sobre los parámetros:
     * El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
     * El sexo debe ser 'M' (hembra) o 'H' (macho).
     * El peso debe ser un valor positivo mayor que cero.
     * La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido.
     * Si algún parámetro no cumple estas condiciones, se lanza una excepción IllegalArgumentException
     * * @param codigo el código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula
     * @param fechaNacimiento la fecha de nacimiento del animal en formato "yyyy-MM-dd"
     * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
     * @param peso el peso del animal en kilogramos, debe ser mayor que 0
     * @throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto, el peso no es positivo o la fecha no tiene un formato válido
     */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {
        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {
            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /**
     * Obtiene el código identificativo del animal.
     * * @return el código del animal
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código identificativo del animal.
     * * @param codigo el nuevo código de 5 caracteres alfanuméricos en minúscula
     * @throws IllegalArgumentException si el código no cumple el patrón establecido
     */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Obtiene la fecha de nacimiento del animal.
     * * @return la fecha de nacimiento en formato LocalDate
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del animal.
     * * @param fechaNacimiento la nueva fecha de nacimiento en formato "yyyy-MM-dd"
     * @throws IllegalArgumentException si la fecha no tiene un formato ISO-8601 válido
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }
        this.fechaNacimiento = fecha;
    }

    /**
     * Obtiene el sexo del animal.
     * * @return 'M' si es hembra, 'H' si es macho
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     * * @param sexo el nuevo sexo del animal ('M' o 'H')
     * @throws IllegalArgumentException si el carácter no es 'M' ni 'H'
     */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Obtiene el peso del animal.
     * * @return el peso actual en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del animal.
     * * @param peso el nuevo peso en kilogramos
     * @throws IllegalArgumentException si el peso proporcionado es menor o igual a cero
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
     * Genera un código hash para el objeto Animal basado en sus atributos.
     * * @return el código hash numérico
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
     * Compara este animal con otro objeto para verificar si son iguales.
     * * @param obj el objeto con el que se va a comparar
     * @return true si los objetos son iguales en todos sus atributos, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en formato de cadena de texto del objeto Animal.
     * * @return cadena con los valores de los atributos del animal
     */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    /**
     * Método abstracto que simula el sonido característico del animal.
     * * @return una cadena con el sonido del animal
     */
    public abstract String hacerSonido();

    /**
     * Método abstracto que simula la reacción del animal cuando se alegra.
     * * @return una cadena describiendo la acción de alegría
     */
    public abstract String alegrarse();

    /**
     * Método abstracto que simula la reacción del animal cuando se enfada.
     * * @return una cadena describiendo la acción de enfado
     */
    public abstract String enfadarse();

    /**
     * Método abstracto que identifica el tipo de animal.
     * * @return una cadena indicando la especie o tipo de animal
     */
    public abstract String queSoy();

}