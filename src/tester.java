class tester{
  public static void main(String[] args){
    BSTNode root = new BSTNode(7);
    root.insert(3);
    root.insert(4);
    root.insert(5);
    root.insert(6);
    root.insert(9);
    root.insert(10);
    root.print();
    System.out.println("Find min odd " + root.findMinOdd());
    System.out.println("Find max odd " + root.findMaxOdd());
    System.out.println("Find min even " + root.findMinEven());
    System.out.println("Find max even " + root.findMaxEven());
    root.removeMinEven();
    root.print();
    root.removeMaxEven();
    root.print();
    root.removeMaxEven();
    root.print();
    root.removeMinOdd();
    root.print();
    root.removeMinOdd();
    root.print();
    root.removeMinOdd();
    root.print();

    root.removeMinOdd();
    root.print();
  }
}
