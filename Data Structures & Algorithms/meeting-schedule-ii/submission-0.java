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

    pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

class Solution 
{
    public int minMeetingRooms(List<Interval> inter) 
    {
        ArrayList<pair> arr = new ArrayList<>();

        for(Interval in : inter)
        {
            arr.add(new pair(in.start, +1));
            arr.add(new pair(in.end, -1));
        }
        Collections.sort(arr, (x, y) -> {
            if(x.a == y.a)
                return x.b - y.b;
            return x.a - y.a;
        });

        int rooms = 0;
        int maxrooms = 0;

        for(pair p : arr)
        {
            rooms += p.b;
            maxrooms = Math.max(maxrooms, rooms);
        }

        return maxrooms;
    }
}
