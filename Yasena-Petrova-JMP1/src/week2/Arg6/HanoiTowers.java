package week2.Arg6;
public class HanoiTowers {
    public static void main(String[] args) {
        int n = 3; // Брой дискове
        moveDisks(n, 'A', 'B', 'C'); // Извикване на метода за преместване на дисковете
    }

    /**
     * Метод за преместване на дискове
     * @param n брой дискове за преместване
     * @param from начална колона
     * @param to целева колона
     * @param aux промеждутъчна колона
     */
    public static void moveDisks(int n, char from, char to, char aux) {
        if (n == 1) {
            // Ако има само един диск, просто го преместете от началната към целевата колона
            System.out.println("Преместете диск 1 от колона " + from + " към колона " + to);
            return;
        }
        // Рекурсивно преместете n-1 дискове от началната към промеждутъчната колона
        moveDisks(n - 1, from, aux, to);
        // Преместете най-големия диск към целевата колона
        System.out.println("Преместете диск " + n + " от колона " + from + " към колона " + to);
        // Рекурсивно преместете n-1 дискове от промеждутъчната колона към целевата
        moveDisks(n - 1, aux, to, from);
    }
}
