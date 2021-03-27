package edu.ucalgary.ensf409;
public class analyzeData{

    public <T extends Comparable<? super T>>int partition(LinkedList<T> storedData, int start,int end){
        T last=storedData.get(end);
        int i=start-1;
        for(int j=start;j<end;j++){
            if(compare(storedData.get(j),last)<=0){  //sort ascending
                i++;
                T temp1=storedData.get(i);
                storedData.set(i,storedData.get(j));
                storedData.set(j,temp1);
            }
        }
        T temp3=storedData.get(end);
        storedData.set(end,storedData.get(i+1));
        storedData.set(i+1,temp3);
        return i+1;
    }

    public <T extends Comparable<? super T>>void sort(LinkedList<T>storedData,int start,int end){
        if(start<end){
            int q=partition(storedData,start,end);
            sort(storedData,start,q-1);
            sort(storedData,q+1,end);
        }

    }
    public int compare(T object,T lastObject) {
        return Integer.compare(object.getPrice(), lastObject.getPrice());
    }/////

    public static LinkedList<Lamp> findCheapestFurniture(LinkedList<Lamp>results){

        sort(results,0,results.size()-1);


       if(results!=null){
            for(int i=0;i<results.size();i++){
                for(int j=i;j<results.size();i++){

                }
            }
       }


    }
}