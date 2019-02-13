public class mydriver{
  public static void main(String[] args){
    KnightBoard test;

    try{
      test = new KnightBoard(-1,0);
      System.out.println("It didn't work :(");
    }
    catch(IllegalArgumentException e){
      System.out.println(e);
      System.out.println("It worked!");
    }

    try{
      test = new KnightBoard(0,-1);
      System.out.println("It didn't work :(");
    }
    catch(IllegalArgumentException e){
      System.out.println(e);
      System.out.println("It worked!");
    }

    try{
      test = new KnightBoard(-1,-1);
      System.out.println("It didn't work :(");
    }
    catch(IllegalArgumentException e){
      System.out.println(e);
      System.out.println("It worked!");
    }


    test = new KnightBoard(5,5);
    System.out.println(test);
    test = new KnightBoard(3,5);
    System.out.println(test);

    System.out.println();
    test = new KnightBoard(8,8);
    test.solve(3,3);
    System.out.println();
    test.solve(0,0);
    System.out.println();
  }
}
