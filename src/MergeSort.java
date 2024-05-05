public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del arreglo
            int mid = (left + right) / 2;

            // Ordena recursivamente la mitad izquierda
            mergeSort(arr, left, mid);
            // Ordena recursivamente la mitad derecha
            mergeSort(arr, mid + 1, right);

            // Combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Tamaños de los subarreglos a fusionar
        int sizeleft = mid - left + 1;
        int sizeright = right - mid;

        // Arreglos temporales para almacenar subarreglos
        int[] tempLeft = new int[sizeleft];
        int[] tempRight = new int[sizeright];
        // Copia datos a los arreglos temporales
        for (int i = 0; i < sizeleft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeright; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }
        // Fusiona los subarreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; // Índice inicial para el arreglo fusionado

        while (i < sizeleft && j < sizeright) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }
        // Copia elementos restantes de tempLeft[] si los hay
        while (i < sizeleft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }
          // Copia elementos restantes de tempRight[] si los hay
        while (j < sizeright) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;

        mergeSort(arr, 0, n - 1); // Llamada al método

        System.out.println("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
