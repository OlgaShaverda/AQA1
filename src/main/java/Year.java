public class Year {

    public int enterYear;

    public static void main(String[] args) {
        returnInfo(1992);
        returnInfo(1800);
        returnInfo(2000);
    }

    public static void returnInfo(int enterYear) {
        if ((enterYear % 4 == 0 && enterYear % 100 != 0) || enterYear % 400 == 0) {
            System.out.println("This " + enterYear + " is vysokosniy");
        } else {
            System.out.println("This " + enterYear + " is not vysokosniy");
        }
    }
}
