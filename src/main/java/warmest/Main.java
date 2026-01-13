// Part A
package warmest;

public class Main {

    public static void main(String[] args) {

        WarmestDataStructure ds = new WarmestDataStructure();

        System.out.println(ds.getWarmest()); // null
        System.out.println(ds.put("a", 100)); // null
        System.out.println(ds.getWarmest());  // a
        System.out.println(ds.put("a", 101)); // 100
        System.out.println(ds.put("a", 101)); // 101
        System.out.println(ds.get("a"));      // 101
        System.out.println(ds.getWarmest());  // a
        System.out.println(ds.remove("a"));   // 101
        System.out.println(ds.remove("a"));   // null
        System.out.println(ds.getWarmest());  // null
        System.out.println(ds.put("a", 100)); // null
        System.out.println(ds.put("b", 200)); // null
        System.out.println(ds.put("c", 300)); // null
        System.out.println(ds.getWarmest());  // c
        System.out.println(ds.remove("b"));   // 200
        System.out.println(ds.getWarmest());  // c
        System.out.println(ds.remove("c"));   // 300
        System.out.println(ds.getWarmest());  // a
        System.out.println(ds.remove("a"));   // 100
        System.out.println(ds.getWarmest());  // null
        System.out.println(ds.remove("a"));   // null
    }
}