package logiccodes;

public final class P46 {
    private P46() {
    }

    protected static Boolean or(final Boolean a, final Boolean b) {
        return a || b;
    }

    protected static Boolean and(final Boolean a, final Boolean b) {
        return a && b;
    }

    protected static Boolean equ(final Boolean a, final Boolean b) {
        return or(and(a, b), and(!(a), !(b)));
    }

    protected static Boolean xor(final Boolean a, final Boolean b) {
        return !(equ(a, b));
    }

    protected static Boolean nand(final Boolean a, final Boolean b) {
        return !(and(a, b));
    }

    protected static Boolean nor(final Boolean a, final Boolean b) {
        return !(or(a, b));
    }

    protected static Boolean impl(final Boolean a, final Boolean b) {
        return or(!a, b);
    }
}
