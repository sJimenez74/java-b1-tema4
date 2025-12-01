import java.util.*;

/**
 * ENUNCIADO:
 *
 * Una empresa de transportes tiene una flota de camiones.
 * Cada camión dispone de un depósito con una capacidad específica de litros de combustible
 * y puede recorrer una cantidad concreta de kilómetros con ese combustible.
 *
 * Debido a una crisis de abastecimiento, solo se dispone de una cantidad limitada de combustible.
 * El objetivo es seleccionar qué camiones pueden salir a hacer repartos,
 * maximizando la distancia total recorrida sin superar el combustible total disponible.
 *
 * El criterio es seleccionar primero los camiones más eficientes, es decir,
 * aquellos que recorren más kilómetros por litro (eficiencia = km / litros).
 *
 * VARIABLES DE ENTRADA:
 * - kilometers[] → kilómetros que recorre cada camión con su depósito lleno
 * - tankLiters[] → capacidad del depósito de cada camión (litros)
 * - totalFuel    → litros de combustible disponibles
 *
 * TABLA DE CAMIONES:
 *
 * | Nº | Kilómetros (km) | Combustible (L) |
 * |----|------------------|-----------------|
 * | 1  | 400              | 100             |
 * | 2  | 600              | 100             |
 * | 3  | 1200             | 300             |
 * | 4  | 1000             | 500             |
 *
 * ENTRADA:
 * kilometers = {400, 600, 1200, 1000}
 * tankLiters = {100, 100, 300, 500}
 * totalFuel = 500
 *
 * SALIDA:
 * Selected: [2, 1, 3]
 */
public class TruckSelectionGreedy {

    public static List<Integer> selectTrucksGreedy(int[] kilometers, int[] tankLiters, int totalFuel) {
        int n = kilometers.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < indices.length; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) ->  {
           double efficiencyA = kilometers[a] / tankLiters[a];
           double efficiencyB = kilometers[b] / tankLiters[b];
           return Double.compare(efficiencyB, efficiencyA);
        });

        List<Integer> selectedValues = new ArrayList<>();
        double capacidadRestante = totalFuel;
        int i = 0;
        while ((i < n) && (capacidadRestante >= tankLiters[indices[i]])) {
            selectedValues.add(indices[i] + 1);

            capacidadRestante -= tankLiters[indices[i]];
            i++;
        }
        return selectedValues;
    }

/*    public static void main(String[] args) {
        int[] kilometers = {400, 600, 1200, 1000};
        int[] tankLiters = {100, 100, 300, 500};
        int totalFuel = 500;

        List<Integer> selected = selectTrucksGreedy(kilometers, tankLiters, totalFuel);
        System.out.println("Selected: " + selected);
    }*/
}
