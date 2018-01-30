package chapter4.testOfPackage;

import static java.lang.System.out;

class testCompetence {
    public static void publicPrint() {
        out.println("default public print");
    }

    private static void privatePrint() {
        out.println("default private print");
    }

    static void defaultPrint() {
        out.println("default default print");
    }
}
