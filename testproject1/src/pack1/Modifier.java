package pack1;

/**
 * Created by Христя on 09.03.2020.
 */
public enum Modifier {
    A,
    C,
    B;

    Modifier() {
    }

    @Override
    public String toString() {
        return "Modifier{}";
    }

    void aaa() {
        for (Modifier modifier : Modifier.values()) {
            System.out.println(modifier);
        }
    }

}
