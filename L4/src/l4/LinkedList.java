package l4;

import java.util.Arrays;

public class LinkedList {
  // содержимое текущего элемента списка
  // указатель на следующий элемент списка
  private int element;
  private LinkedList next;

  public LinkedList() {
      this.element = 0;
      this.next = null;
  }
  
  public LinkedList(int elem){
      this.element = elem;
      this.next = null;
  }
  
  public LinkedList(int[] elem){
      this.element = elem[0];
      
      if(elem.length == 2) {
        this.next = new LinkedList(elem[1]);
      } else {
          this.next = new LinkedList(Arrays.copyOfRange(elem, 1, elem.length));
      }
  }
  
  public LinkedList(LinkedList elem){
      this.element = elem.getElement();
      this.next = elem.getNext();
  }
  
  public void setElement(int e){
    this.element = e;
  }
  
  public void setElement(LinkedList elem, int index){
      if(index == 0) {
        elem.next = this.next;
        this.next = elem;
      }
      else if(this.next != null) {
          this.next.setElement(elem, index-1);
      }
  }
  
  public void delElement(int index){
      if(index==0) {
          this.next = this.next.getNext();
      } else if(this.next != null){
          this.next.delElement(index-1);
      }
  }
  
  public int getElement(){      
    return this.element;
  }
  
  public void setNext(LinkedList n) {
    if (this.next == null){
        this.next = n;
    } else {
        this.next.setNext(n);
    }
  }
  
  public LinkedList getNext() {
    return this.next;
  } 
}
