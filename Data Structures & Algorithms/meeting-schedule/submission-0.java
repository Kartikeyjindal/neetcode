/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class pair
{
    int a, b;
    pair(int a,int b)
    {
        this.a= a;
        this.b= b;
    }
}
class Solution 
{
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        ArrayList<pair> adj=new ArrayList<>();

        for(Interval i:intervals)
        {
            adj.add(new pair(i.start,+1));
            adj.add(new pair(i.end,-1));
        } 

        Collections.sort(adj,(x,y)->{
            if(x.a==y.a)
            {
                return x.b-y.b;
            }
            return x.a-y.a;
        });

        int rooms=0;

        for(pair i:adj)
        {
            rooms+=i.b;
            if(rooms>1)
            {
                return false;
            }
        }
        return true;
    }
}
