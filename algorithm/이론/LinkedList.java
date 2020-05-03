
public class LinkedList{
     private Node header;
     private int size;

     public LinkedList(){
         header = new Node(null);
         size = 0;
     }

     private class Node{
         private Object data;
         private Node nexNode;

         Node(Object data){
             this.data = data;
             this.nexNode = null;
         }
     }

     public Object get(int index){
         return getNode(index).data;
     }

     private Node getNode(int index){
         if(index<0 || index >=size){
             throw new IndexOutOfBoundsException("index : "+index+", size : "+size);
         }

         Node node = header.nexNode;
         for(int i = 0; i<index; i++){
             node = node.nexNode;
         }

         return node;

     }
     public Object getFirst(){
         return get(0);
     }

     public int getNodeIndex(Object obj){
         if(size <=0) return -1;
         int index = 0;
         Node node = header.nexNode;
         Object nodeData = node.data;

         while(!obj.equals(nodeData)){
            node = node.nexNode;

            if(node ==null) return -1;

            nodeData = node.data;
            index++;

         }
         return index;

     }

     public void addFirst(Object data){
         Node newNode = new Node(data);
         newNode.nexNode = header.nexNode;
         header.nexNode = newNode;
         size++;
     }

     public void add(int index, Object data){

        if(index==0){
            addFirst(data);
            return;
        }

        Node previous = getNode(index-1);
        Node next = previous.nexNode;

        Node newNode = new Node(data);
        previous.nexNode = newNode;
        newNode.nexNode = next;
        size++;
     }

     public void addLast(Object data){
         add(size, data);
     }

     public void add(Object data){
         addLast(data);
     }

     public Object removeFirst(){
         Node firstNode = getNode(0);
         header.nexNode = firstNode.nexNode;
         size--;
         return firstNode.data;
     }

     public Object remove(int index){
         if(index<0|| index>=size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
         }
         else if(index ==0) return removeFirst();

         Node previous = getNode(index-1);
         Node removeNode = previous.nexNode;
         Node next = removeNode.nexNode;
         previous.nexNode = next;
         size--;

         return removeNode.data;

     }

     public boolean remove(Object data){
        int nodeIndex = getNodeIndex(data);

        if(nodeIndex ==-1) return false;
        else{
            remove(nodeIndex);
            return true;
        }

     }

     public Object removeLast(){
         return remove(size-1);
     }

     public int size(){
         return size;
     }
     public String toString(){
         StringBuffer  result = new StringBuffer("[");
         Node node = header.nexNode;

         if(node!=null){
             result.append(node.data);
             node = node.nexNode;
             while(node!=null){
                 result.append(", ");
                 result.append(node.data);
                 node = node.nexNode;
             }
         }
         result.append("]");
         return result.toString();
     }
    

}

class LinkdedListTest {
    
    public static void main(String[] args){
        
        LinkedList list = new LinkedList();
        
        list.add(100);
        list.add(200);
        list.add(400);
        list.add(500);
        System.out.println(list);
        
        list.add(2, 300);
        list.addFirst(50);
        System.out.println(list);
        
        System.out.println(list.get(4));
        
        list.remove(2);
        list.remove(new Integer(400));
        System.out.println(list);
        
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        
        System.out.println("크기 " + list.size());
        
    }

}

