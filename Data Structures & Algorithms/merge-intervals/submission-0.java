class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length;
        ArrayList<int []>arr=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])
            {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        arr.add(intervals[0]);
        int k=0;

        for(int i=1;i<n;i++)
        {
            int arrs=arr.get(k)[0];
            int arre=arr.get(k)[1];

            if(arre<intervals[i][0])
            {
                arr.add(intervals[i]);
                k++;
            }

            else if(arre>=intervals[i][0])
            {
                arr.get(k)[1] = Math.max(arre, intervals[i][1]);
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
}
