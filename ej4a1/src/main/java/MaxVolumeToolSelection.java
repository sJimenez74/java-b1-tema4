import java.util.*;

/**
 * ENUNCIADO:
 *
 * Una empresa de construcción está preparando un envío de herramientas a una obra en el extranjero.
 * El envío se realiza en un container marítimo con la siguiente restricción logística:
 *
 * - Peso máximo permitido: 500 kg
 *
 * En el almacén hay 10 herramientas distintas, cada una con un volumen y un peso específicos.
 * Solo se puede cargar una unidad de cada herramienta (no hay repeticiones).
 *
 * OBJETIVO:
 * Seleccionar el conjunto de herramientas que maximice el volumen total sin superar el peso máximo permitido.
 * La función findBestToolSet debe devolver una lista con los números de las herramientas seleccionadas (empezando desde 1).
 *
 * VARIABLES:
 * - volumes (List<Double>)  → lista con los volúmenes en litros
 * - weights (List<Double>)  → lista con los pesos en kg
 * - maxWeight (double)      → peso máximo del container
 *
 * TABLA DE HERRAMIENTAS:
 *
 * | Nº | Herramienta              | Volumen (L) | Peso (kg) |
 * |----|--------------------------|-------------|-----------|
 * | 1  | Taladro percutor         | 15          | 8         |
 * | 2  | Martillo demoledor       | 30          | 18        |
 * | 3  | Sierra circular          | 25          | 10        |
 * | 4  | Mezcladora de cemento    | 300         | 120       |
 * | 5  | Compresor portátil       | 100         | 75        |
 * | 6  | Generador eléctrico      | 200         | 150       |
 * | 7  | Lijadora industrial      | 40          | 12        |
 * | 8  | Escalera extensible      | 70          | 20        |
 * | 9  | Caja de herramientas     | 50          | 25        |
 * | 10 | Cortadora de pavimento   | 160         | 80        |
 *
 * ENTRADA:
 * volumes = [15, 30, 25, 300, 100, 200, 40, 70, 50, 160]
 * weights = [8, 18, 10, 120, 75, 150, 12, 20, 25, 80]
 * maxWeight = 500
 *
 * SALIDA:
 * Selected: [1, 3, 4, 5, 6, 7, 8, 9, 10]
 */
public class MaxVolumeToolSelection {

    /**
     * Devuelve una lista con los números (1-based) de las herramientas seleccionadas.
     */
    public static List<Integer> findBestToolSet(List<Double> volumes, List<Double> weights, double maxWeight) {
        int bestCombination = 0;
        int bestValue = 0;
        int totalCombinations = (int) Math.pow(2, weights.size());

        for (int i = 0; i < totalCombinations; i++) {
            int actualWeight = 0;
            int actualValue = 0;

            for (int j = 0; j < volumes.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    actualWeight += weights.get(j);
                    actualValue += volumes.get(j);
                }
            }

            if (actualWeight <= maxWeight && actualValue > bestValue) {
                bestCombination = i;
                bestValue = actualValue;
            }
        }

        List<Integer> bestSelection = new ArrayList<>();
        for (int j = 0; j < weights.size(); j++) {
            if ((bestCombination & (1 << j)) != 0) {
                bestSelection.add(j + 1);
            }
        }
        return bestSelection;
    }
	// -------------------------------------------------------------
    // Manual test using IDE
    // -------------------------------------------------------------
/*    public static void main(String[] args) {
        List<Double> volumes = Arrays.asList(15.0, 30.0, 25.0, 300.0, 100.0, 200.0, 40.0, 70.0, 50.0, 160.0);
        List<Double> weights = Arrays.asList(8.0, 18.0, 10.0, 120.0, 75.0, 150.0, 12.0, 20.0, 25.0, 80.0);
        double maxWeight = 500.0;

        List<Integer> bestSelection = findBestToolSet(volumes, weights, maxWeight);
        System.out.println("Selected: " + bestSelection);
    }*/
	// Torna a comentar aquest main quan vulguis executar els tests amb maven test
    // Vuelve a comentar este main cuando quieras ejecutar los tests con:
    // mvn test
	// -------------------------------------------------------------
}
