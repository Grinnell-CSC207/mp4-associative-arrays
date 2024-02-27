package experiments;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.PrintWriter;
import java.math.BigInteger;

import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * Experiments with our AssociativeArray class.
 *
 * @author Candice Lu
 * @author Samuel A. Rebelsky
 */
public class AssociativeArrayExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run the experiments.
   */
  public static void main(String[] args) throws NullKeyException, KeyNotFoundException{
    PrintWriter pen = new PrintWriter(System.out, true);

    divider(pen);
    expreimentStringsToStrings(pen);
    divider(pen);
    experimentBigIntToBigInt(pen);
    divider(pen);
    toStringExperiment(pen);

    AssociativeArray<String, Integer> animals = new AssociativeArray<>();
    animals.set("Iguana", 5);
    animals.set("Raccoon", 9);
    animals.set("Scorpion", 1);
    animals.set("Tucan", 4);

    AssociativeArray<String, Integer> animalsClone = animals.clone();
    pen.println(animalsClone.toString());
    animals.remove("Raccoon");
    animals.remove("Scorpion");
    pen.println(animalsClone.toString());

    pen.println(animalsClone.get("Tucan")); // not removed in original
    pen.println(animalsClone.get("Raccoon")); // removed in original

    test0();
  } // main(String[])

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Our first experiment: Associative arrays with strings as both keys 
   * and values.
   */
  public static void expreimentStringsToStrings(PrintWriter pen) throws NullKeyException{
    AssociativeArray<String,String> s2s = 
      new ReportingAssociativeArray<String,String>("s2s", pen);
    s2s.size();
    s2s.set("a", "apple");
    s2s.set("A", "aardvark");
    s2s.size();
    s2s.hasKey("a");
    s2s.hasKey("A");
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("a");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("aardvark");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
  } // expreimentStringsToStrings

  /**
   * Our second experiment: Associative arrays with big integers as
   * keys and values.
   */
  public static void experimentBigIntToBigInt(PrintWriter pen) throws KeyNotFoundException, NullKeyException{
    AssociativeArray<BigInteger,BigInteger> b2b =
      new ReportingAssociativeArray<BigInteger,BigInteger>("b2b", pen);

    // Set some values
    for (int i = 0; i < 11; i++) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
    } // for

    // Then get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then remove some of them
    for (int i = 1; i < 11; i += 2) {
      b2b.remove(BigInteger.valueOf(i));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then reset or set some values
    for (int i = 0; i < 11; i += 3) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i + 10));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for
  } // experimentBigIntToBigInt

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Print a divider.
   */
  public static void divider(PrintWriter pen) {
    pen.println();
    pen.println("------------------------------------------------");
    pen.println();
  } // divider(PrintWriter)

  public static void toStringExperiment(PrintWriter pen) throws KeyNotFoundException, NullKeyException {
    ReportingAssociativeArray<String, Integer> animals = new ReportingAssociativeArray<String, Integer>("toString", pen);
    //PrintWriter pen = new PrintWriter(System.out, true);
    animals.set("fish", 17);
    animals.set("nemo", 16);
    animals.set("elephant", 15);
    animals.set("hippo", 14);
    animals.set("parrot", 13);
    animals.set("tucan", 12);
    animals.set("gorillas", 11);
    animals.set("giraffe", 10);
    animals.set("ant", 9);
    animals.set("racoon", 8);
    animals.set("deer", 7);
    animals.set("monkey", 6);
    animals.set("rattleSnake", 5);
    animals.set("spider", 4);
    animals.set("scorpions", 3);
    animals.set("sloth", 2);
    animals.set("tortuga", 1);
    animals.set("termite", 0);
    animals.hasKey("spider");
    animals.hasKey("polarBear");
    animals.remove("spider");
    animals.toString();
  }

  //public static void 

  public static void test0() throws NullKeyException, KeyNotFoundException{
    PrintWriter pen = new PrintWriter(System.out, true);
    ReportingAssociativeArray<String,Integer> si = new ReportingAssociativeArray<String,Integer>("name", pen);
    si.set("A",1);
    si.set("B",2);
    si.set("C",3);
    String result = si.toString();
    pen.println(result);
  }

} // AssociativeArrayExperiments
