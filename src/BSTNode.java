public class BSTNode {
  // class variables
  BSTNode left;
  BSTNode right;
  int value;
  
  BSTNode(int inVal){
    value = inVal;
  }

  public boolean find(int inValue) {
    if(inValue == value) {
      return true;
    }
    
    if(left != null && inValue < value) {
      return left.find(inValue);
    }else if(right != null && inValue > value){
      return right.find(inValue);
    }
    return false;
  }
  
  // Inserts a given integer into a given binary search tree.
  void insert(int inValue){
    // refuse to insert a duplicate
    if(find(inValue)) return;
    
    // recursive calls 
    if(inValue < value) {
      // insert on the left
      if(left != null) {
        left.insert(inValue);
      }else {
        left = new BSTNode(inValue);
      }
    }else {
      //insert on the right
      if(right != null) {
        right.insert(inValue);
      }else {
        right = new BSTNode(inValue);
      }
    }
  }

  // Removes a given integer from a tree (assuming it exists).
  void remove(int inValue){
    // base case: is the value in our tree?
    if(!find(inValue)) return;
    
    BSTNode current = this;
    BSTNode parent = null;
    
    while(current.value != inValue) {
      parent = current;
      if(inValue < current.value) current = current.left;
      else current = current.right;
    }
    
    // found the node, and it's parent
    
    // if its a leaf, remove it
    if(current.left==null && current.right==null) {
      // if root is a leaf... can't remove it
      if(parent==null) return;
      
      // make the parent not point to it, don't know if its left or right
      if(current == parent.left) {
        parent.left = null;
      }else {
        parent.right = null;
      }
    }
    
    // if it has one child, re-link
    else if(current.left==null || current.right==null) {
      if(parent==null) {
        // replace the root.....
        if(current.left==null) {
          current.value = current.right.value;
          current.left = current.right.left;
          current.right = current.right.right;
        }else {
          current.value = current.left.value;
          current.right = current.left.right;
          current.left = current.left.left;
        }
      }
      
      // has a right child only
      else if(current.left==null) {
        if(current == parent.left) {
          parent.left = current.right;
        }else {
          parent.right = current.right;
        }
      }else {
        if(current == parent.left) {
          parent.left = current.left;
        }else {
          parent.right = current.left;
        }
      }
    }
    
    // now we know that it has two children
    else {
      // find the smallest on the right & remove it
      BSTNode min_right = current.right.findMin();
      remove(min_right.value);
      
      if(parent == null) {
        // replace the root....
        current.value = min_right.value;
      }else {
        // replace the current node with that minimum
        min_right.left = current.left;
        min_right.right = current.right;
        if(current == parent.left) {
          parent.left = min_right;
        }else {
          parent.right = min_right;
        }
      }
      
    }
  }
  
  // Removes the node that is labeled with the minimum odd number contained in the tree. 
  // If no odd numbers are in the tree, do nothing.
  void removeMinOdd(){
    
    BSTNode temp = findMinOdd();
    if(temp != null)
      remove(temp.value);
    
  }
  
  // Removes the node that is labeled with the minimum even number contained in the tree. 
  // If no even numbers are in the tree, do nothing.
  void removeMinEven(){

    BSTNode temp = findMinEven();
    if(temp != null)
      remove(temp.value);
    
  }
  
  // Removes the node that is labeled with the maximum odd number contained in the tree. 
  // If no odd numbers are in the tree, do nothing.
  void removeMaxOdd(){
    
    BSTNode temp = findMaxOdd();
    if(temp != null)
      remove(temp.value);
    
  }
  
  // Removes the node that is labeled with the maximum even number contained in the tree. 
  // If no even numbers are in the tree, do nothing.
  void removeMaxEven(){
    
    BSTNode temp = findMaxEven();
    if(temp != null)
      remove(temp.value);
    
  }

  // Searches the tree to find the (pointer to) the node with the minimum value in the subtree.
  BSTNode findMin(){
    BSTNode current = this;
    while(current.left!=null){
      current = current.left;
    }
    return current;
  }
  
  // Searches the tree to find the (pointer to) the node with the minimum odd value in the subtree. 
  // If no odd numbers are in the tree, return null.
  BSTNode findMinOdd(){
    // if theres no odd numbers, can't return anything
    if(countOdd() == 0) return null;
    
    BSTNode current = this;
    while(true){
      
      // if there is an odd to the left thats where the min would be
      if(current.left!=null && current.left.countOdd()>0) 
        current = current.left;
      
      // if we got here, we were to the left, but theres no odds to the left
      else if(current.value%2==0 && current.right!=null && current.right.countOdd()>0)
        current = current.right;
      
      // there's no evens in the children, so I must be even
      else 
        return current;
    }
  }
  
  // Searches the tree to find the (pointer to) the node with the minimum even value in the subtree.
  // If no even numbers are in the tree, return null.
  BSTNode findMinEven(){
    // if theres no even numbers, can't return anything
    if(countEven() == 0) return null;
    
    BSTNode current = this;
    while(true){
      
      // if there is an odd to the left thats where the min would be
      if(current.left!=null && current.left.countEven()>0) 
        current = current.left;
      
      // if we got here, we were to the left, but theres no odds to the left
      else if(current.value%2==1 && current.right!=null && current.right.countEven()>0)
        current = current.right;
      
      // there's no evens in the children, so I must be even
      else 
        return current;
    }
  }
  
  // Searches the tree to find the (pointer to) the node with the maximum odd value in the subtree. 
  // If no odd numbers are in the tree, return null.
  BSTNode findMaxOdd(){
    // if theres no odd numbers, can't return anything
    if(countOdd() == 0) return null;
    
    BSTNode current = this;
    while(true){
      
      // if there is an odd to the left thats where the min would be
      if(current.right!=null && current.right.countOdd()>0) 
        current = current.right;
      
      // if we got here, we were to the left, but theres no odds to the left
      else if(current.value%2==0 && current.left!=null && current.left.countOdd()>0)
        current = current.left;
      
      // there's no evens in the children, so I must be even
      else 
        return current;
    }
  }
  
  // Searches the tree to find the (pointer to) the node with the maximum even value in the subtree. 
  // If no even numbers are in the tree, return null.
  BSTNode findMaxEven(){
    // if theres no even numbers, can't return anything
    if(countEven() == 0) return null;
    
    BSTNode current = this;
    while(true){
      
      // if there is an odd to the left thats where the min would be
      if(current.right!=null && current.right.countEven()>0) 
        current = current.right;
      
      // if we got here, we were to the left, but theres no odds to the left
      else if(current.value%2==1 && current.left!=null && current.left.countEven()>0)
        current = current.left;
      
      // there's no evens in the children, so I must be even
      else 
        return current;
    }
  }
  
  // Counts the number of nodes in the (sub)tree that are labeled with an odd number.
  int countOdd(){
    int rtn = ((value%2)==1)?1:0;
    if(left != null) rtn += left.countOdd();
    if(right != null) rtn += right.countOdd();
    return rtn;
  }
  
  // Counts the number of nodes in the (sub)tree that are labeled with an even number.
  int countEven(){
    int rtn = ((value%2)==0)?1:0;
    if(left != null) rtn += left.countEven();
    if(right != null) rtn += right.countEven();
    return rtn;
  }
  
  public String toString() {
    return String.valueOf(value);
  }
 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + this);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    else if(right != null) System.out.println(prefix + "\u251C " + "\u2400");
    if(right != null) right.print(prefix + "\u2514 ");
    else if(left != null) System.out.println(prefix + "\u2514 " + "\u2400");
  }
}
