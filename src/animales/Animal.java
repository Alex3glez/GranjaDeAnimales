/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

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

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    public abstract String hacerSonido();

    public abstract String alegrarse();

    public abstract String enfadarse();

    public abstract String queSoy();

}
