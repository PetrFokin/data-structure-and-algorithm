public class WrongHashCodeTest {

    private int i;

    public WrongHashCodeTest(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return 99;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrongHashCodeTest that = (WrongHashCodeTest) o;
        return i == that.i;
    }
}
