public class StopWatch {
    long startime;
    long timeDifferent;
    public void StartWatch(){
        this.startime = System.currentTimeMillis();      
    }

    public void EndWatch(){
        long Endtime = System.currentTimeMillis();
        this.timeDifferent = (Endtime - startime);
    }

    public long GetTime(){
        return this.timeDifferent;
    }
}
