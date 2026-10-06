public class IntegerArrayList implements IntegerList{
    private Integer[] values;
    private int size;

    public IntegerArrayList(){
        values = new Integer[10];
        size = 0;
    }

    private void resize(){
        if (size == values.length){
            Integer[] newArray = new Integer[values.length*2];
            for(int i =0; i<values.length; i++){
                newArray[i]=values[i];
            }
            values = newArray;
        }
    }

    public void add(Integer val){
        resize();
        values[size]=val;
        size++;
    }

    public void add(int index, Integer val){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("invalidPositiveIndex");
        }
            resize();
        for(int i=size;i>index;i--){
            values[i]=values[i-1];
        }
        values[index]=val;
        size++;
    }

    public int size(){
        return size;
    }

    public void set(int index, Integer val){
        if(index <size) {
            values[index] = val;
        }
        else{
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public void clear(){
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public String toString(){
        String result = "[";
        for (int i = 0; i<size-1; i++){
            result+=values[i] + ", ";
        }
        result+= values[size-1] + "]";
        return result;
    }

    public int indexOf(Integer val){
        for (int i=0; i<values.length; i++){
            if (values[i]==val){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Integer val){
        if(indexOf(val)==-1){
            return false;
        }
        return true;
    }

    public Integer get(int index){
        if (index<0 || index>=size()){
            throw new IndexOutOfBoundsException("invalidPositiveIndex");
        }
        return values[index];
    }

    public boolean equals(List<Integer> other){
        if(other.size() != values.length){
            return false;
        }
        for(int i=0; i<values.length;i++){
            if(other.get(i)!=values[i]){
                return false;
            }
        }
        return true;
    }
    public Integer remove(int index){
        if(index<0 || index>=values.length){
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        Integer removedVal=values[index];
        for(int i=index; i<values.length; i++){
            values[i]=values[i+1];
        }
        return removedVal;
    }

}
