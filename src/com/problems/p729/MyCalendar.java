class MyCalendar {
    private List<Interval> bookList = new LinkedList();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if(bookList.size()==0){
            bookList.add(new Interval(start,end));
            //bookList.stream().forEach(System.out::println);
            return true;
        }

        int left=0;
        int right = bookList.size();
        int lastMiddle = -1;
        //二分插入
        while(true){
            int middle = (left+right)/2;
            Interval middleInterval = bookList.get(middle);
            if(middleInterval.start==start)return false;

            if(middleInterval.start>start){
                right=middle;
                if(lastMiddle == middle ){
                    if(middleInterval.start<end)return false;
                    if(middle>0){
                        Interval preInterval = bookList.get(middle-1);
                        if(preInterval.end>start)return false;
                    }

                    bookList.add(middle,new Interval(start,end));
                    return true;
                }
            }

            if(middleInterval.start<start){
                left=middle;
                if(lastMiddle == middle){
                    if(middleInterval.end>start)return false;
                    if(middle<bookList.size()-1){
                        Interval nextInterval = bookList.get(middle+1);
                        if(end>nextInterval.start)return false;
                    }
                    bookList.add(middle+1,new Interval(start,end));
                    return true;

                }
            }

            lastMiddle = middle;

        }
    }
}

class Interval{
    public int  start;
    public int end;
    public Interval(int start,int end){this.start=start;this.end=end;}
    public Interval(){this(0,0);}

    public String toString(){return start+"-"+end;}

}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
